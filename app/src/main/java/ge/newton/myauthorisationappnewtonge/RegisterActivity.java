package ge.newton.myauthorisationappnewtonge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText emailEditText = findViewById(R.id.emailAddressID);
        EditText passwordEditText = findViewById(R.id.passwordID);
        EditText repeatPasswordEditText = findViewById(R.id.repeatPasswordID);

        Button registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String repeatPassword = repeatPasswordEditText.getText().toString();
                if (email.isEmpty()) {
                    emailEditText.setError("Email is Empty");
                }
                if (!email.contains("@")) {
                    emailEditText.setError("invalid email");
                }

                if (password.isEmpty()) {
                    passwordEditText.setError("password is Empty");
                }
                if (password.length() < 8) {
                    passwordEditText.setError("pasword is invalid. password must contain at leas 8 characters");
                }
                if (password.equals(repeatPassword)) {
                    passwordEditText.setError("pasword and repeatPassword is not the same");
                    repeatPasswordEditText.setError("pasword and repeatPassword is not the same");
                }
            }
        } );
    }
}