package defaulttemplate.defaulttemplateproject.network;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class RealmInt extends RealmObject {
    public static final String VAL = "val";

    @SerializedName("")
    private int val;

    public RealmInt() {
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }
}