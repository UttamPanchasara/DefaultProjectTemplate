package defaulttemplate.defaulttemplateproject.activity;

import android.os.Handler;

import defaulttemplate.defaulttemplateproject.R;

public class MainActivity extends BaseActivity {

    @Override
    protected boolean showToolbar() {
        return true;
    }

    @Override
    protected String title() {
        return "Your Title";
    }

    @Override
    protected boolean showTitleEnabled() {
        return true;
    }

    @Override
    protected boolean showHomeEnabled() {
        return false;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onApplyLogic() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toastMsg("Toast From Activity");
            }
        }, 2000);
    }
}
