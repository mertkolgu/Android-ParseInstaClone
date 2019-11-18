package tr.com.mertkolgu.parseinstagramclone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.List;

import tr.com.mertkolgu.parseinstagramclone.R;

public class ParseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_detail);

        /*  DATABASE

        // veri tabanına bilgi ekleme
        ParseObject parseObject = new ParseObject("Fruits");

        parseObject.put("name", "apple");
        parseObject.put("calories", 100);

        parseObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    e.printStackTrace();
                } else {
                    System.out.println("Saved Success");
                }
            }
        });

        // veri tabanındanındaki istenilen veriyi okuma
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("Fruits");
        parseQuery.getInBackground("sn32HkH7T3", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e != null) {
                    e.printStackTrace();
                } else {
                    String objectName = object.getString("name");
                    int objectCalories = object.getInt("calories");

                    System.out.println("Object Name : " + objectName);
                    System.out.println("Object Calorie : " + objectCalories);
                }
            }
        });

        // veri tabanındaki bütün verileri okuma
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("Fruits");

        // filtreleme
        // parseQuery.whereEqualTo("name", "banana");
        // parseQuery.whereLessThan("calories", 130);

        parseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e != null) {
                    e.printStackTrace();
                } else {
                    if (objects.size() > 0) {
                        for (ParseObject object : objects) {
                            String objectName = object.getString("name");
                            int objectCalories = object.getInt("calories");

                            System.out.println("Object Name : " + objectName);
                            System.out.println("Object Calorie : " + objectCalories);
                        }
                    }
                }
            }
        });

        // USER

        // kullanıcı oluşturma
        ParseUser parseUser = new ParseUser();
        parseUser.setUsername("mertkolgu");
        parseUser.setPassword("123456");

        parseUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    e.printStackTrace();
                } else {
                    Toast.makeText(ParseDetailActivity.this, "Signed Up!", Toast.LENGTH_LONG).show();
                }
            }
        })

        // kullanıcı ile giriş yapma
        ParseUser.logInInBackground("mertkolgu", "123456", new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    e.printStackTrace();
                } else {
                    Toast.makeText(ParseDetailActivity.this, "Welcome " + user.getUsername(), Toast.LENGTH_LONG).show();
                }
            }
        });
         */
    }
}
