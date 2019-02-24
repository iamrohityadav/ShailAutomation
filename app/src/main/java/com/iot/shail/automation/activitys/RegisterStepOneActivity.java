package com.iot.shail.automation.activitys;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.iot.shail.automation.R;

public class RegisterStepOneActivity extends AppCompatActivity {

    private ActionBar actionbar;

    TextInputLayout masterPasswordTextInputLayout;
    TextInputEditText masterPasswordTextInputEditText,confirmMasterPasswordTextInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_step_one);

        //******* set action bar full screen **********
        actionbar = getSupportActionBar();
        assert actionbar != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle("Registration Step 1");

        //******* init view **********
        masterPasswordTextInputEditText= findViewById(R.id.masterPasswordTextInputEditText);
        masterPasswordTextInputEditText.setTransformationMethod(new PasswordTransformationMethod());
        confirmMasterPasswordTextInputEditText= findViewById(R.id.confirmMasterPasswordTextInputEditText);
        confirmMasterPasswordTextInputEditText.setTransformationMethod(new PasswordTransformationMethod());

        //******* reset click event **********
        findViewById(R.id.reset_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //******* next click event **********
        findViewById(R.id.next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTermsConditionDialog();
            }
        });
    }

    //******* menu bar created **********
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_icon:
                Intent loginActivity = new Intent(RegisterStepOneActivity.this, LoginActivity.class);
                startActivity(loginActivity);
                RegisterStepOneActivity.this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    //******* menu bar end **********

    //******* terms and condition alert dialog created **********
    private void showTermsConditionDialog() {

        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.terms_condition_alrt_dialog_box, viewGroup, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        builder.setCancelable(false);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        ImageView close = dialogView.findViewById(R.id.close_button);

        Button agree =dialogView.findViewById(R.id.agree_button);
        Button disagree = dialogView.findViewById(R.id.disagree_button);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                showOtpDialog();
            }
        });

        disagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
    //******* terms and condition alert dialog end **********

    //******* otp alert dialog created **********
    private void showOtpDialog() {

        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.otp_alrt_dialog_box, viewGroup, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        builder.setCancelable(false);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button submitOtp = dialogView.findViewById(R.id.verify_button);

        ImageView close = dialogView.findViewById(R.id.close_button);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        submitOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Intent  registerStepTwoActivity = new Intent(RegisterStepOneActivity.this, RegisterStepTwoActivity.class);
                startActivity(registerStepTwoActivity);
                RegisterStepOneActivity.this.finish();
            }
        });
    }
    //******* otp alert dialog end **********
}