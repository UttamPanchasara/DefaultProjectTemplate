package defaulttemplate.defaulttemplateproject.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import defaulttemplate.defaulttemplateproject.R;


public class FragmentUtil {
    /**
     * Add new fragment in the initial activity with custom container ID
     *
     * @param mActivity
     * @param mFragment
     * @param addToBackStack
     */
    public static void addFragment(AppCompatActivity mActivity, Fragment mFragment, boolean addToBackStack, int containerID) {
        // Get fragment TAG
        String TAG = mFragment.getClass().getSimpleName();
        // Perform fragment transaction
        FragmentTransaction fragmentTransaction = mActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.setCustomAnimations(R.anim.anim_fade_in, R.anim.anim_fade_out);
        fragmentTransaction.add(containerID, mFragment, TAG);
        // Add fragment to back stack
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(TAG);
        }
        // Commit the changes
        fragmentTransaction.commit();
    }

    /**
     * Add new child fragment in the initial activity with custom container ID
     *
     * @param mActivity
     * @param mFragment
     * @param addToBackStack
     */
    public static void addFragment(AppCompatActivity mActivity, Fragment mFragment, boolean addToBackStack, int containerID, String mBreadCrumbTag) {
        // Get fragment TAG
        String TAG = mFragment.getClass().getSimpleName();
        // Perform fragment transaction

        FragmentTransaction fragmentTransaction = mActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setBreadCrumbTitle(mBreadCrumbTag);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.add(containerID, mFragment, TAG);
        // Add fragment to back stack
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(TAG);
        }
        // Commit the changes
        fragmentTransaction.commit();
    }

    /**
     * Replace new fragment with current one in the initial activity with custom
     * container ID
     *
     * @param mActivity
     * @param mFragment
     * @param addToBackStack
     */
    public static void replaceFragment(AppCompatActivity mActivity, Fragment mFragment, boolean addToBackStack, int containerID) {
        // Get fragment TAG
        String TAG = mFragment.getClass().getSimpleName();
        // Perform fragment transaction
        FragmentTransaction fragmentTransaction = mActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.setCustomAnimations(R.anim.anim_fade_in, R.anim.anim_fade_out);
        fragmentTransaction.replace(containerID, mFragment, TAG);
        // Add fragment to back stack
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(TAG);
        }
        // Commit the changes
        fragmentTransaction.commit();
    }

    public static void replaceFragment(AppCompatActivity mActivity, Fragment mFragment, boolean addToBackStack, int containerID, String mBreadCrumbTitle) {
        // Get fragment TAG
        String TAG = mFragment.getClass().getSimpleName();
        // Perform fragment transaction
        FragmentTransaction fragmentTransaction = mActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setBreadCrumbTitle(mBreadCrumbTitle);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.replace(containerID, mFragment, TAG);
        // Add fragment to back stack
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(TAG);
        }
        // Commit the changes
        fragmentTransaction.commit();
    }
}