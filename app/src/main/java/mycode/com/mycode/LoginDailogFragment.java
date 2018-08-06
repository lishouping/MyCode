package mycode.com.mycode;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * LoginDailogFragment
 * (c)2018 AIR Times Inc. All rights reserved.
 *
 * @author Lishp
 * @version 1.0
 * @date 2018/8/1 15:15
 * @see
 */
public class LoginDailogFragment extends DialogFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        final Window window = getDialog().getWindow();
        View view = inflater.inflate(R.layout.dialog_login,  ((ViewGroup) window.findViewById(android.R.id.content)), false);//需要用android.R.id.content这个view
        WindowManager.LayoutParams wp = window.getAttributes();
        wp.gravity = Gravity.BOTTOM;
        wp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(wp);
        return view;
    }
}
