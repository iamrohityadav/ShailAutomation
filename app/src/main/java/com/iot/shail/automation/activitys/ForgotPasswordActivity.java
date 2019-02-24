package com.iot.shail.automation.activitys;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.iot.shail.automation.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    ActionBar actionbar;

    CheckBox emailCheckBOx,mobileCheckBox;
    TextInputLayout emailTextInputLayout,mobileTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        //******* set action bar full screen **********
        actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.setTitle("Forgot Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //******* init view **********
        emailCheckBOx=findViewById(R.id.checkBoxEmail);
        mobileCheckBox=findViewById(R.id.checkBoxMobile);
        emailTextInputLayout= findViewById(R.id.emailTextInputLayout);
        mobileTextInputLayout= findViewById(R.id.mobileTextInputLayout);

        //******* email check box click event **********
        emailCheckBOx.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(emailCheckBOx.isChecked())
                {
                    mobileCheckBox.setChecked(false);
                    emailTextInputLayout.setVisibility(View.VISIBLE);
                    mobileTextInputLayout.setVisibility(View.GONE);
                }
                else
                {
                    emailTextInputLayout.setVisibility(View.GONE);
                }
            }
        });

        //******* mobile check box click event **********
        mobileCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if( mobileCheckBox.isChecked())
                {
                    emailCheckBOx.setChecked(false);
                    mobileTextInputLayout.setVisibility(View.VISIBLE);
                    emailTextInputLayout.setVisibility(View.GONE);
                }
                else
                {
                    mobileTextInputLayout.setVisibility(View.GONE);
                }
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
                Intent loginActivity = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                startActivity(loginActivity);
                ForgotPasswordActivity.this.finish();
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
}
