package com.example.mobilprogramlamafinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText mail , pass;
    Button login;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail=(EditText) findViewById(R.id.EmailAddressLogin);
        pass=(EditText) findViewById(R.id.PasswordLogin);
        login=(Button) findViewById(R.id.Login);

        firebaseAuth=FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginClick();
            }
        });
    }
    private void loginClick() {
        String EmailAddressLogin = mail.getText().toString();
        String PasswordLogin = pass.getText().toString();

        if(EmailAddressLogin.isEmpty()){
            Toast.makeText(this, "E-posta kısmı boş olamaz!", Toast.LENGTH_SHORT).show();
        }
        if(PasswordLogin.isEmpty()){
            Toast.makeText(this, "Şifre kısmı boş olamaz!", Toast.LENGTH_SHORT).show();
        }

        firebaseAuth.signInWithEmailAndPassword(EmailAddressLogin,PasswordLogin).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Hoşgeldiniz!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this , MainActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "Giriş Başarısız!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void SignUpClick(View view) {
        startActivity(new Intent(LoginActivity.this , RegisterActivity.class));
    }
}