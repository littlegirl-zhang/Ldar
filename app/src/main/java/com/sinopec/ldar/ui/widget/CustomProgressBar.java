package com.sinopec.ldar.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

import com.sinopec.ldar.R;


public class CustomProgressBar extends Dialog {
    private static CustomProgressBar customProgressDialog;

    public CustomProgressBar(Context context) {
        super(context);
    }

    public CustomProgressBar(Context context, int theme) {
        super(context, theme);
    }

    public static synchronized CustomProgressBar createProDialog(Context context) {
//        if (customProgressDialog != null) {
//            customProgressDialog = null;
//        }
//        customProgressDialog = new CustomProgressBar(context, R.style.style_dialog_transparent);
//        customProgressDialog.setContentView(R.layout.layout_dialog_progressbar);
//        customProgressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
//        customProgressDialog.setCancelable(false);
//        customProgressDialog.setCanceledOnTouchOutside(false);
        return customProgressDialog;
    }


    public CustomProgressBar setMessage(String strMessage) {
//        TextView tvMsg = (TextView) customProgressDialog.findViewById(R.id.dialog_tv_msg);
//        if (tvMsg != null) {
//            tvMsg.setText(strMessage);
//        }
        return customProgressDialog;
    }

}
