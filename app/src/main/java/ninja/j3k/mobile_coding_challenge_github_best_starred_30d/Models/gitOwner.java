package ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by J3K on 17.05.2018.
 */

public class gitOwner {


    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("avatar_url")
    @Expose
    private String avatar_url;


    public gitOwner(int id, String login, String avatar_url) {
        this.id = id;
        this.login = login;
        this.avatar_url = avatar_url;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
