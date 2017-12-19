package defaulttemplate.defaulttemplateproject.activity;

import android.content.Intent;
import android.os.Handler;

import defaulttemplate.defaulttemplateproject.R;

public class SplashActivity extends BaseActivity {
    @Override
    protected boolean showToolbar() {
        return false;
    }

    @Override
    protected String title() {
        return null;
    }

    @Override
    protected boolean showTitleEnabled() {
        return false;
    }

    @Override
    protected boolean showHomeEnabled() {
        return false;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onApplyLogic() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 2000);
    }
}
