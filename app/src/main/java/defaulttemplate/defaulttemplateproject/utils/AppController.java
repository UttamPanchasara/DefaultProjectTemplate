package defaulttemplate.defaulttemplateproject.utils;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;

public class AppController extends Application {

    public static AppController instance = new AppController();
    private static Context mContext;

    public static AppController getInstance() {
        return instance;
    }

    public AppController() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
        Realm.init(this);
    }

    public static Context getContext() {
        return mContext;
    }
}
