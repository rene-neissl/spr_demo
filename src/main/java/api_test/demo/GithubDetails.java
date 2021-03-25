package api_test.demo;

public class GithubDetails {
    private String _login;
    private Integer _followers;

    public GithubDetails() {
        _followers = 0;
        _login = "";
    }

    public void setFollowers(Integer srcFollowers) {
        _followers = srcFollowers;
    }

    public void set_login(String _login) {
        this._login = _login;
    }

    public Integer getFollowers() {
        return _followers;
    }

    public String get_login() {
        return _login;
    }
}
