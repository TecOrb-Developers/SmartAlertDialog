package com.rahman.smartdialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.rahman.dialog.Activity.SmartDialog;
import com.rahman.dialog.ListenerCallBack.SmartDialogClickListener;
import com.rahman.dialog.Utilities.SmartDialogBuilder;
import com.rahman.smartdialog.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private ActivityMainBinding binding;
    private Typeface tfBold;
    private Typeface tfRegular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        context = this;

        binding.button.setOnClickListener(this);
        tfBold = Typeface.createFromAsset(context.getAssets(), "ptsanswebbold.ttf");
        tfRegular = Typeface.createFromAsset(context.getAssets(), "ptsanswebregular.ttf");
    }

    private void openDialog(){

        new SmartDialogBuilder(context)
                .setTitle(getString(R.string.txt_smart_dialog))
                .setSubTitle(getString(R.string.txt_alert))
                .setCancalable(false)
                .setCustomIcon(R.drawable.icon)
                .setTitleColor(getResources().getColor(R.color.colorPrimaryDark))
                .setSubTitleColor(getResources().getColor(R.color.colorPrimaryDark))
                .setTitleFont(tfBold)
                .setSubTitleFont(tfRegular)
                .setNegativeButtonHide(false)
                .useNeutralButton(true)
                .setPositiveButton(getString(R.string.txt_ok), new SmartDialogClickListener() {
                    @Override
                    public void onClick(SmartDialog smartDialog) {
                        smartDialog.dismiss();
                    }
                })
                .setNegativeButton(getString(R.string.txt_cancel), new SmartDialogClickListener() {
                    @Override
                    public void onClick(SmartDialog smartDialog) {
                        smartDialog.dismiss();

                    }
                })
                .setNeutralButton(getString(R.string.txt_later), new SmartDialogClickListener() {
                    @Override
                    public void onClick(SmartDialog smartDialog) {
                        smartDialog.dismiss();
                    }
                })
                .build().show();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button:
                openDialog();
                break;
        }
    }
}
