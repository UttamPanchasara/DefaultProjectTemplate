package defaulttemplate.defaulttemplateproject.network;

import io.realm.RealmObject;

public class RealmString extends RealmObject {
    public static final String VAL = "val";

    private String val;

    public RealmString() {
    }

    public RealmString setVal(String val) {
        this.val = val;
        return this;
    }

    public String getVal() {
        return this.val;
    }
}
