package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword, editTextPassword2;
    TextView textViewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonConfirm = findViewById(R.id.button);

        editTextEmail = findViewById(R.id.editTextTextEmailAddress4);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        editTextPassword2 = findViewById(R.id.editTextTextPassword2);

        textViewOutput = findViewById(R.id.textViewOutput);
        textViewOutput.setText("Autor 00000000000");
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email =  checkEmail(editTextEmail.getText().toString());
                boolean isPasswordRight =  checkPasswordCohesion(editTextPassword.getText().toString(), editTextPassword2.getText().toString());
                displayInfo(Email, isPasswordRight);
            }
        });
    }

    private String checkEmail(String email){
        if (email.contains("@"))
            return email;
        return "";
    }

    private boolean checkPasswordCohesion(String password, String repeatedPassword){
        if (password.equals(repeatedPassword))
            return true;
        return false;

    }

    private void displayInfo(String Email, boolean isPasswordRight){
        if (Email.length() == 0) {
            textViewOutput.setText("Nieprawidłowy asdres e-mail");
            return;
        }

        if (!isPasswordRight) {
            textViewOutput.setText("Hasła się różnią");
            return;
        }

        textViewOutput.setText("Witaj "+ Email);
    }
}