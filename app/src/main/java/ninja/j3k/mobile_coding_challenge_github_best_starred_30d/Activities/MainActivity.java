package ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Fragments.NewsFragment;
import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Fragments.SettingsFragment;
import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.R;

/**
 * Created by J3K on 16.05.2018.
 */

public class MainActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.bottom_navigation_item1:
                                selectedFragment = NewsFragment.newInstance();
                                break;
                            case R.id.bottom_navigation_item2:
                                selectedFragment = SettingsFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, NewsFragment.newInstance());
        transaction.commit();
    }
}