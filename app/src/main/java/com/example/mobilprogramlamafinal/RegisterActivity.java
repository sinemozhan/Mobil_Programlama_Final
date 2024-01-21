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

public class RegisterActivity extends AppCompatActivity {

    EditText name , surname , emailaddress , password;
    Button kayıtol;

    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=(EditText) findViewById(R.id.Name);
        surname=(EditText) findViewById(R.id.Surname);
        emailaddress=(EditText) findViewById(R.id.EmailAddress);
        password=(EditText) findViewById(R.id.Password);
        kayıtol=(Button) findViewById(R.id.Signup);

        firebaseAuth=FirebaseAuth.getInstance();

        kayıtol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kayıtolClick();
            }
        });
    }

    private void kayıtolClick() {
        String Name = name.getText().toString();
        String Surname = surname.getText().toString();
        String EmailAddress = emailaddress.getText().toString();
        String Password = password.getText().toString();

        if(Name.isEmpty()){
            Toast.makeText(this, "İsim kısmı boş olamaz!", Toast.LENGTH_SHORT).show();
        }
        if(Surname.isEmpty()){
            Toast.makeText(this, "Soyisim kısmı boş olamaz!", Toast.LENGTH_SHORT).show();
        }
        if(EmailAddress.isEmpty()){
            Toast.makeText(this, "E-posta kısmı boş olamaz!", Toast.LENGTH_SHORT).show();
        }
        if(Password.isEmpty()){
            Toast.makeText(this, "Şifre kısmı boş olamaz!", Toast.LENGTH_SHORT).show();
        }

        firebaseAuth.createUserWithEmailAndPassword(EmailAddress,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Kayıt Başarılı!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this , SplashScreen.class));
                }else{
                    Toast.makeText(RegisterActivity.this, "Kayıt Başarısız!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void LoginClick(View view){
        startActivity(new Intent(RegisterActivity.this , LoginActivity.class));
    }
}