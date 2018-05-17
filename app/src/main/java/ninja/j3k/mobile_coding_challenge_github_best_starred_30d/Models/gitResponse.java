package ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by J3K on 17.05.2018.
 */

public class gitResponse {


    @SerializedName("total_count")
    @Expose
    public int totalCount;

    @SerializedName("incomplete_results")
    @Expose
    public boolean incompleteResults;

    @SerializedName("items")
    @Expose
    public List<gitRepo> items = null;


    public gitResponse(int totalCount, boolean incompleteResults, List<gitRepo> items) {
        this.totalCount = totalCount;
        this.incompleteResults = incompleteResults;
        this.items = items;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<gitRepo> getItems() {
        return items;
    }

    public void setItems(List<gitRepo> items) {
        this.items = items;
    }
}

