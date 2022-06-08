package ge.newton.myauthorisationappnewtonge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sharedPreferences = getSharedPreferences("usernames", MODE_PRIVATE);
        database = new Database(sharedPreferences);

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

                registerUser(email, password);
            }
        } );
    }

    private void registerUser(String email, String password) {
        UserModel user = new UserModel(email, password);
        if (!database.checkIfEmailExists(user)) {
            database.saveUser(user);
        } else {
            Toast.makeText(getApplicationContext(), "this email is already exists", Toast.LENGTH_SHORT).show();
        }
    }
}