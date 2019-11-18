package tr.com.mertkolgu.parseinstagramclone.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import tr.com.mertkolgu.parseinstagramclone.R;
import tr.com.mertkolgu.parseinstagramclone.adapter.Post;

public class FeedActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> userNameFromParse;
    ArrayList<String> userCommentFromParse;
    ArrayList<Bitmap> userImageFromParse;
    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        listView = findViewById(R.id.listView);

        userNameFromParse = new ArrayList<>();
        userCommentFromParse = new ArrayList<>();
        userImageFromParse = new ArrayList<>();

        post = new Post(userNameFromParse, userCommentFromParse, userImageFromParse, this);

        listView.setAdapter(post);

        download();
    }

    public void download() {
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("Posts");
        parseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e != null) {
                    Toast.makeText(FeedActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                } else {
                    if (objects.size() > 0) {
                        for (final ParseObject parseObject : objects) {
                            ParseFile parseFile = (ParseFile) parseObject.get("image");
                            parseFile.getDataInBackground(new GetDataCallback() {
                                @Override
                                public void done(byte[] data, ParseException e) {
                                    if (e == null && data != null) {
                                        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                                        userImageFromParse.add(bitmap);
                                        userNameFromParse.add(parseObject.getString("username"));
                                        userCommentFromParse.add(parseObject.getString("comment"));
                                        post.notifyDataSetChanged();
                                    }
                                }
                            });
                        }
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.addPost) {
            Intent intent = new Intent(FeedActivity.this, UploadActivity.class);
            startActivity(intent);
            finish();
        } else if (item.getItemId() == R.id.signOut) {
            ParseUser.logOutInBackground(new LogOutCallback() {
                @Override
                public void done(ParseException e) {
                    if (e != null) {
                        Toast.makeText(FeedActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent = new Intent(FeedActivity.this, LogInActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }
}
