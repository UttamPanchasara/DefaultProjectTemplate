package defaulttemplate.defaulttemplateproject.fragment;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class BaseFragment extends Fragment {

    private View view;

    public void toastMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    public void setSnackBarView(View view) {
        this.view = view;
    }

    public void showError(String errMessage) {
        if (view != null) {
            Snackbar snackbar = Snackbar.make(view, errMessage, Snackbar.LENGTH_LONG);
            ViewGroup group = (ViewGroup) snackbar.getView();
            group.setBackgroundColor(Color.RED);
            snackbar.show();
        }
    }

    public void clearAllBackStack() {
        // Clear all back stack.
        int backStackCount = getFragmentManager().getBackStackEntryCount();

        for (int i = 0; i < backStackCount; i++) {

            // Get the back stack fragment id.
            int backStackId = getFragmentManager().getBackStackEntryAt(i).getId();

            getFragmentManager().popBackStack(backStackId, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

}
