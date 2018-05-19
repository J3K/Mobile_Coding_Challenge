package ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Models.api;

import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Models.gitResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Service {
//    @GET
//    Call<gitResponse> getItems(@Url String URL);
@GET("/search/repositories")
    Call<gitResponse> getItems(@Query("q") String mDate, @Query("sort") String sort, @Query("order") String order, @Query("page") int page);
}
