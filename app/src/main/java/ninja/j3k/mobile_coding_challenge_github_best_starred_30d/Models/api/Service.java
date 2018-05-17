package ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Models.api;

import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Models.gitResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface Service {
    @GET
    Call<gitResponse> getItems(@Url String URL);
//    Call<gitResponse> getItems(@Path("mDate") String mDate);
//    @GET("/search/repositories?q=created:>{mDate}&sort=stars&order=desc")
}
