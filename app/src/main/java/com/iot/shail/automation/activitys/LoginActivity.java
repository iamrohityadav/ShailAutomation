package com.iot.shail.automation.activitys;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.iot.shail.automation.R;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText passwordTextInputEditText;
    Button loginButton,registerButton;
    TextView forgotPasswordLinkTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //******* set action bar full screen **********
        assert getSupportActionBar() != null;
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //******* init view **********
        passwordTextInputEditText=findViewById(R.id.passwordTextInputEditText);
        passwordTextInputEditText.setTransformationMethod(new PasswordTransformationMethod());

        loginButton=findViewById(R.id.login_to_account_button);
        registerButton=findViewById(R.id.create_account_button);

        forgotPasswordLinkTextView=findViewById(R.id.forget_password_link);

        //******* login click event **********
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHomeActivity = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(goToHomeActivity);
            }
        });

        //******* register click event **********
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRegisterActivity = new Intent(LoginActivity.this, RegisterStepOneActivity.class);
                startActivity(goToRegisterActivity);
            }
        });

        //******* forgot password click event **********
        forgotPasswordLinkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToForgotPasswordActivity = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(goToForgotPasswordActivity);
            }
        });
    }
}
