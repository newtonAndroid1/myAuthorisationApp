package ge.newton.myauthorisationappnewtonge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

        EditText emailEditText = findViewById(R.id.emailAddressID);
        EditText passwordEditText = findViewById(R.id.passwordID);

        Button logInButton = findViewById(R.id.loginButton);

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.isEmpty()) {
                    emailEditText.setError("Email is Empty");
                }
                if (!email.contains("@")) {
                    emailEditText.setError("invalid email");
                }
            }
        });
    }
}