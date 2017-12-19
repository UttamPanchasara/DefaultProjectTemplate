package defaulttemplate.defaulttemplateproject.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import defaulttemplate.defaulttemplateproject.R;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract boolean showToolbar();

    protected abstract String title();

    protected abstract boolean showTitleEnabled();

    protected abstract boolean showHomeEnabled();

    protected abstract int getLayoutResourceId();

    protected abstract void onApplyLogic();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // view init start
        if (getLayoutResourceId() != 0) {
            setContentView(getLayoutResourceId());
        } else {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }
        initToolbar();
        onApplyLogic();
    }

    private void initToolbar() {
        final View toolBarView = findViewById(R.id.toolbar);
        if (toolBarView != null) {
            setSupportActionBar((Toolbar) toolBarView);
            if (showToolbar()) {
                if (getSupportActionBar() != null) {
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().setDisplayShowHomeEnabled(showHomeEnabled());
                        getSupportActionBar().setDisplayHomeAsUpEnabled(showHomeEnabled());
                        getSupportActionBar().setDisplayShowTitleEnabled(showTitleEnabled());
                        getSupportActionBar().setTitle(title());
                    }
                }
            } else {
                if (getSupportActionBar() != null) {
                    getSupportActionBar().hide();
                }
            }
        }
    }

    // to show toast from any activity
    public void toastMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void showError(String errMessage) {
        View view = findViewById(android.R.id.content);

        if (view != null) {
            Snackbar snackbar = Snackbar.make(view, errMessage, Snackbar.LENGTH_LONG);
            ViewGroup group = (ViewGroup) snackbar.getView();
            group.setBackgroundColor(Color.RED);
            snackbar.show();
        }
    }

    /**
     * Overrides the pending Activity transition by performing the "Enter" animation.
     */
    protected void overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    protected void overridePendingTransitionExit() {
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
