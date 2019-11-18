package tr.com.mertkolgu.parseinstagramclone.model;

import android.app.Application;

import com.parse.Parse;

public class ParseStarter extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // set log level
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("your_key")
                .clientKey("your_key")
                .server("your_server")
                .build()
        );
    }
}
