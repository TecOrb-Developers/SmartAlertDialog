package com.rahman.dialog.Activity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rahman.dialog.ListenerCallBack.SmartDialogClickListener;
import com.rahman.dialog.R;

public class SmartDialog {
    private Dialog dialog;
    private LinearLayout container;
    private TextView titleTV, subTitleTv, tvOK, tvNeutral, tvCancel;
    private LinearLayout okButtonTv, cancelButtonTV, neutralButtonTv;
    //private View separator;
    private SmartDialogClickListener okButtonClickListener;
    private SmartDialogClickListener cancelButtonClickListener;
    private SmartDialogClickListener neutralButtonClickListener;
    private boolean isNegativeBtnHide;
    private boolean hasNeutralBtn;


    public SmartDialog(Context context, int backgroundColor, String title, String subTitle, Typeface titleFont,
                       Typeface subtitleFont, boolean isCancelable, boolean isNegativeBtnHide, boolean hasNeutralBtn) {

        this.isNegativeBtnHide = isNegativeBtnHide;
        this.hasNeutralBtn = hasNeutralBtn;
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_dialog);
        dialog.setCancelable(isCancelable);

        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        initDialogViw();
        setBackgroundColor(context, backgroundColor);
        setTitle(title);
        setSubtitle(subTitle);
        setSubTitleFont(subtitleFont);
        setTitleFont(titleFont);
        initClickEvents();

    }

    public void setPositive(String okLabel, SmartDialogClickListener listener) {
        this.okButtonClickListener = listener;
        this.dismiss();
        setPositiveLabel(okLabel);
    }

    public void setNegative(String cancelLabel, SmartDialogClickListener listener) {
        if (listener != null) {
            this.cancelButtonClickListener = listener;
            this.dismiss();
            setNegativeLabel(cancelLabel);
        }
    }

    public void setNeutral(String neutralBtnLabel, SmartDialogClickListener listener) {
        if (listener != null) {
            this.neutralButtonClickListener = listener;
            this.dismiss();
            setNeutralBtnLabel(neutralBtnLabel);
        }
    }

    public void show() {
        if (isNegativeBtnHide) {
            cancelButtonTV.setVisibility(View.GONE);
        }
        if (!hasNeutralBtn) {
            neutralButtonTv.setVisibility(View.GONE);
        }
        dialog.show();
    }

    public void setBackgroundColor(Context context, int color) {
        Drawable background = container.getBackground();
        GradientDrawable shapeDrawable = (GradientDrawable) background;
        shapeDrawable.setColor(ContextCompat.getColor(context, color));
    }

    public void setTitle(String title) {
        titleTV.setText(title);
    }

    public void setSubtitle(String subtitle) {
        subTitleTv.setText(subtitle);
    }

    private void setPositiveLabel(String positive) {
        tvOK.setText(positive);
    }

    private void setNegativeLabel(String negative) {
        tvCancel.setText(negative);
    }

    private void setNeutralBtnLabel(String neutralBtnLabel) {
        tvNeutral.setText(neutralBtnLabel);
    }

    private void setSubTitleFont(Typeface appleFont) {
        if (appleFont != null) {
            //title_lbl.setTypeface(appleFont);
            subTitleTv.setTypeface(appleFont);
            tvOK.setTypeface(appleFont);
            tvNeutral.setTypeface(appleFont);
            tvCancel.setTypeface(appleFont);
        }
    }

    private void setTitleFont(Typeface appleFont) {
        if (appleFont != null) {
            titleTV.setTypeface(appleFont);
        }
    }

    public void dismiss() {
        dialog.dismiss();
    }

    //positive and negative button initialise here
    private void initClickEvents() {
        okButtonTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (okButtonClickListener != null) {
                    okButtonClickListener.onClick(SmartDialog.this);
                }
            }
        });
        cancelButtonTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cancelButtonClickListener != null) {
                    cancelButtonClickListener.onClick(SmartDialog.this);
                }
            }
        });
        neutralButtonTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (neutralButtonClickListener != null) {
                    neutralButtonClickListener.onClick(SmartDialog.this);
                }
            }
        });
    }

    //init all view here
    private void initDialogViw() {
        container = dialog.findViewById(R.id.container);
        titleTV = dialog.findViewById(R.id.tv1);
        subTitleTv = dialog.findViewById(R.id.tv2);
        okButtonTv = dialog.findViewById(R.id.btnDialogOk);
        cancelButtonTV = dialog.findViewById(R.id.btnDialogCancel);
        neutralButtonTv = dialog.findViewById(R.id.btnDialogNeutral);
        //separator = dialog.findViewById(R.id.separatorView);
        tvOK = dialog.findViewById(R.id.tvok);
        tvNeutral = dialog.findViewById(R.id.tvNeutral);
        tvCancel = dialog.findViewById(R.id.tvCan);
    }
}
