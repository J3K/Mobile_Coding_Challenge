package ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this, "SplashScreen", Toast.LENGTH_SHORT).show();
    }
}
