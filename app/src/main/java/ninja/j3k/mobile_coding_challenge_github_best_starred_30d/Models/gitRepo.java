package ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by J3K on 17.05.2018.
 */

public class gitRepo {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("stargazers_count")
    @Expose
    private String stargazers_count;

    @SerializedName("owner")
    @Expose
    private gitOwner owner;

    public gitRepo(int id, String name, String description, String stargazers_count, gitOwner owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stargazers_count = stargazers_count;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(String stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public gitOwner getOwner() {
        return owner;
    }

    public void setOwner(gitOwner owner) {
        this.owner = owner;
    }
}
