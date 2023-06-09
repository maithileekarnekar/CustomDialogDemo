package com.androidwavelength.customdialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginDialog extends Dialog {

    private EditText edtUsername, edtPassword;
    private Button btnSignIn;

    public interface OnLoginListener{
        void onSuccess();
        void onFailure();
    }

    private OnLoginListener onLoginListener;

    public void setOnLoginListener(OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }

    //private MainActivity.MyOnLoginListener myOnLoginListener;


    public LoginDialog(Context context) {
        super(context);
        setContentView(R.layout.login_dialog);

        initViews();
        setupListeners();
    }

    private void initViews() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
    }

    private void setupListeners() {
        btnSignIn.setOnClickListener(new
                BtnSignInClickListener());
    }
    /*public void SetOnLoginListener(MainActivity.MyOnLoginListener myOnLoginListener) {
        this.myOnLoginListener = myOnLoginListener;
    }*/

    private class BtnSignInClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (edtUsername.getText().toString().equals("bitcode")
                    && edtPassword.getText().toString().equals("bitcode")) {
                dismiss();

               /* if(myOnLoginListener != null) {
                    myOnLoginListener.onSuccess();
                }*/
                if(onLoginListener != null) {
                    onLoginListener.onSuccess();
                }

                /*if(myOnLoginListener != null) {
                    myOnLoginListener.onSuccess();
                }*/
                /*mt(view.getContext(), "Login Successful");
                //start home activity */
            }
            else {
            //mt(view.getContext(), "Login failed");
            /*if(myOnLoginListener != null) {
                myOnLoginListener.onFailure();
            }*/

                if(onLoginListener != null) {
                    onLoginListener.onFailure();
                }
        }
    }
}
    private void mt(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
