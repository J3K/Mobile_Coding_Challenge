package ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Models.api.Client;
import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Models.api.Service;
import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Models.gitRepo;
import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Models.gitResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by J3K on 16.05.2018.
 */



public class SplashActivity extends AppCompatActivity {

    static public ArrayList<gitRepo> gitReposElements = new ArrayList<gitRepo>();

    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);

        LoadJSON();
//        finish();
    }


    private void LoadJSON(){
        try{

            Toast.makeText(mContext, "loading JSON...", Toast.LENGTH_SHORT).show();
            Client Client = new Client();
            Service apiService =
                    Client.getClient().create(Service.class);
            Call<gitResponse> call = apiService.getItems("created:>2018-04-17","stars","desc",1);

            call.enqueue(new Callback<gitResponse>() {
                @Override
                public void onResponse(Call<gitResponse> call, Response<gitResponse> response) {
                    gitReposElements.addAll(response.body().getItems());
                    Intent intent = new Intent(mContext, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(Call<gitResponse> call, Throwable t) {
                    Log.v("LoadJSONError", t.getMessage());
                }
            });

        }catch (Exception e){
            Log.v("LoadJSONError", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
