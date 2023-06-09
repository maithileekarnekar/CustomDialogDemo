package com.androidwavelength.customdialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupListeners();
    }

    private void setupListeners() {
        btnLogin.setOnClickListener(new
                BtnLoginClickListener());
    }

    private void initViews() {
        btnLogin = findViewById(R.id.btnLogin);
    }

    private class BtnLoginClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            LoginDialog loginDialog = new LoginDialog(MainActivity.this);
            //loginDialog.setOnLoginListener(new MyOnLoginListener());
            loginDialog.setOnLoginListener(new MyCustomLoginListener());
            loginDialog.show();
        }
    }

   class MyCustomLoginListener implements LoginDialog.OnLoginListener {
        @Override
        public void onSuccess() {
            mt("My Success Action");
        }

        @Override
        public void onFailure() {
            mt("My failed action");
        }
    }


    class MyOnLoginListener {
        public void onSuccess() {
            mt("Custom success action");
        }
        public void onFailure() {
            mt("Custom failed action");
        }
    }

    /*private class BtnLoginClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Dialog loginDialog = new Dialog(MainActivity.this);
            loginDialog.setTitle("Bitcode");
            loginDialog.setContentView(R.layout.login_dialog);

            EditText edtUsername = loginDialog.findViewById(R.id.edtUsername);
            EditText edtPassword = loginDialog.findViewById((R.id.edtPassword);
            EditText btnSignIn = loginDialog.findViewById(R.id.btnSignIn);

            btnSignIn.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(edtUsername.getText().toString().equals("bitcode")
                            && edtPassword.getText().toString().equals("bitcode")) {
                                loginDialog.dismiss();
                                mt("Login Successful");
                            }
                            else {
                                mt("Login failed");
                            }
                        }
                    }
            );
            loginDialog.show();
        }
    }*/
    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}