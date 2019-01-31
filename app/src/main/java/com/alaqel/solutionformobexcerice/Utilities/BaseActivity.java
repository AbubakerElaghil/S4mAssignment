package com.alaqel.solutionformobexcerice.Utilities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public static ProgressDialog progressDialog;



   public Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = BaseActivity.this;
    }



    public static void ShowProgress(String Title, String Message, Context context) {
        if (progressDialog != null) {
            if (!progressDialog.isShowing()) {
                progressDialog = ProgressDialog.show(context, Title,
                        Message, true);
            }
        } else {
            progressDialog = ProgressDialog.show(context, Title,
                    Message, true);
        }


    }



    public static void HideProgress() {
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

    }


}
