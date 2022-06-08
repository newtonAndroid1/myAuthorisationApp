package ge.newton.myauthorisationappnewtonge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // here
        EditText emailEditText = findViewById(R.id.emailAddressID);
        EditText passwordEditText = findViewById(R.id.passwordID);

        Button logInButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (email.isEmpty()) {
                    emailEditText.setError("Email is Empty");
                }
                if (!email.contains("@")) {
                    emailEditText.setError("invalid email");
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), RegisterActivity.class));
            }
        });
    }
}