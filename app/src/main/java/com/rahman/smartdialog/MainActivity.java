package com.rahman.smartdialog;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.rahman.dialog.Activity.SmartDialog;
import com.rahman.dialog.ListenerCallBack.SmartDialogClickListener;
import com.rahman.dialog.Utilities.SmartDialogBuilder;

public class MainActivity extends AppCompatActivity {

    Context context;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        final Typeface face = Typeface.createFromAsset(context.getAssets(), "ptsanswebbold.ttf");
        final Typeface face2 = Typeface.createFromAsset(context.getAssets(), "ptsanswebregular.ttf");

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new SmartDialogBuilder(context)
                        //.setBackgroundColor(R.color.colorPrimary) set background color of the dialog
                        .setTitle("Smart Dialog")
                        .setSubTitle("This is the alert dialog to showing alert to user")
                        .setCancalable(false)
                        .setTitleFont(face)
                        .setSubTitleFont(face2)
                        .setNegativeButtonHide(false)
                        .useNeutralButton(true)
                        .setPositiveButton("OK", new SmartDialogClickListener() {
                            @Override
                            public void onClick(SmartDialog smartDialog) {
                                smartDialog.dismiss();
                            }
                        })
                        .setNegativeButton("Cancel", new SmartDialogClickListener() {
                            @Override
                            public void onClick(SmartDialog smartDialog) {
                                smartDialog.dismiss();

                            }
                        })
                        .setNeutralButton("Later", new SmartDialogClickListener() {
                            @Override
                            public void onClick(SmartDialog smartDialog) {
                                smartDialog.dismiss();
                            }
                        })
                        .build().show();
            }
        });


    }
}
