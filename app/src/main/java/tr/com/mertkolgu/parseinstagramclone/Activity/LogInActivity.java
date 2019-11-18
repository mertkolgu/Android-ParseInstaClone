package tr.com.mertkolgu.parseinstagramclone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import tr.com.mertkolgu.parseinstagramclone.R;

public class LogInActivity extends AppCompatActivity {

    EditText userNameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        userNameText = findViewById(R.id.editTextUserName);
        passwordText = findViewById(R.id.editTextPassword);

        ParseUser parseUser = ParseUser.getCurrentUser();

        if (parseUser != null) {
            Intent intent = new Intent(LogInActivity.this, FeedActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void signUp(View view) {
        ParseUser parseUser = new ParseUser();
        parseUser.setUsername(userNameText.getText().toString());
        parseUser.setPassword(passwordText.getText().toString());

        parseUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Toast.makeText(LogInActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LogInActivity.this, "User Created!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LogInActivity.this, FeedActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    public void signIn(View view) {
        ParseUser.logInInBackground(userNameText.getText().toString(), passwordText.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Toast.makeText(LogInActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LogInActivity.this, "Welcome " + user.getUsername(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LogInActivity.this, FeedActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
