package com.rahman.dialog.Utilities;

import android.content.Context;
import android.graphics.Typeface;

import com.rahman.dialog.Activity.SmartDialog;
import com.rahman.dialog.ListenerCallBack.SmartDialogClickListener;

public class SmartDialogBuilder {

    private Typeface titleTf, subTitleTf;
    private boolean isCancelable;
    private int backgroundColor = android.R.color.white;
    private String title, subtitle, okButtonLable, cancelButtonLable, neutralButtonLabel;
    private Context context;
    private SmartDialogClickListener okListener;
    private SmartDialogClickListener cancelListener;
    private SmartDialogClickListener nutralBtnListener;
    private boolean isNegativeBtnHide;
    private boolean hasNeutralBtn = false;

    public SmartDialogBuilder(Context context) {
        this.context = context;
    }

    public SmartDialogBuilder setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public SmartDialogBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public SmartDialogBuilder setSubTitle(String subTitle) {
        this.subtitle = subTitle;
        return this;
    }

    public SmartDialogBuilder setTitleFont(Typeface titleFont) {
        this.titleTf = titleFont;
        return this;
    }

    public SmartDialogBuilder setSubTitleFont(Typeface subTFont) {
        this.subTitleTf = subTFont;
        return this;
    }

    public SmartDialogBuilder setPositiveButton(String lable, SmartDialogClickListener listener) {
        this.okListener = listener;
        this.okButtonLable = lable;
        return this;
    }

    public SmartDialogBuilder setNegativeButton(String lable, SmartDialogClickListener listener) {
        this.cancelListener = listener;
        this.cancelButtonLable = lable;
        return this;
    }

    public SmartDialogBuilder setNeutralButton(String label, SmartDialogClickListener listener) {
        this.nutralBtnListener = listener;
        this.neutralButtonLabel = label;
        return this;
    }

    public SmartDialogBuilder setCancalable(boolean isCancelable) {
        this.isCancelable = isCancelable;
        return this;
    }

    public SmartDialogBuilder setNegativeButtonHide(boolean isHide) {
        this.isNegativeBtnHide = isHide;
        return this;
    }

    public SmartDialogBuilder useNeutralButton(boolean use) {
        this.hasNeutralBtn = use;
        return this;
    }

    public SmartDialog build() {
        SmartDialog dialog = new SmartDialog(context, backgroundColor, title, subtitle, titleTf, subTitleTf, isCancelable, isNegativeBtnHide, hasNeutralBtn);
        dialog.setNegative(cancelButtonLable, cancelListener);
        dialog.setPositive(okButtonLable, okListener);
        dialog.setNeutral(neutralButtonLabel, nutralBtnListener);
        return dialog;
    }
}
