package defaulttemplate.defaulttemplateproject.network;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.internal.IOException;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiSeviceClient {

    private static final String BASE_URL_IN_USE = ApiConstant.API_BASE_URL;


    // A static newInstance
    private static Gson sGson;

    // A public method is created, and grant access to it's public methods
    public static ApiServices getApiService() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder().retryOnConnectionFailure(true);
        httpClient.readTimeout(1, TimeUnit.MINUTES);
        httpClient.connectTimeout(1, TimeUnit.MINUTES);
        httpClient.addInterceptor(logging);

        initGson();

        // A new Retrofit object is created
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_IN_USE)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(sGson)) // a deserializer is specified
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // we associate rdxAndroid to handle the callback
                .build();

        return retrofit.create(ApiServices.class);
    }

    private static void initGson() {
        Type tokenInt = new TypeToken<RealmList<RealmInt>>() {
        }.getType();

        Type tokenString = new TypeToken<RealmList<RealmString>>() {
        }.getType();

        sGson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .registerTypeAdapter(tokenInt, new TypeAdapter<RealmList<RealmInt>>() {
                    @Override
                    public void write(JsonWriter out, RealmList<RealmInt> value) throws IOException {
                    }

                    @Override
                    public RealmList<RealmInt> read(JsonReader in) throws IOException {
                        RealmList<RealmInt> list = new RealmList<>();
                        try {
                            in.beginArray();
                            while (in.hasNext()) {
                                RealmInt ri = new RealmInt();
                                ri.setVal(in.nextInt());
                                list.add(ri);
                            }
                            in.endArray();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                        return list;
                    }
                })
                .registerTypeAdapter(tokenString, new TypeAdapter<RealmList<RealmString>>() {
                    @Override
                    public void write(JsonWriter out, RealmList<RealmString> value) throws IOException {
                    }

                    @Override
                    public RealmList<RealmString> read(JsonReader in) throws IOException {
                        RealmList<RealmString> list = new RealmList<>();
                        try {
                            if (in.peek() == JsonToken.NULL) {
                                in.nextNull();
                                return list;
                            } else {
                                in.beginArray();
                                while (in.hasNext()) {
                                    RealmString rs = new RealmString();
                                    rs.setVal(in.nextString());
                                    list.add(rs);
                                }
                                in.endArray();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return list;
                    }
                })
                .create();
    }
}
