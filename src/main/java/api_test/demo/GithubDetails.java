package api_test.demo;

public class GithubDetails {
    private String _login;
    private Integer _followers;

    public GithubDetails() {
        _followers = 0;
        _login = "";
    }

    public void setFollowers(Integer _followers) {
        this._followers = _followers;
    }

    public void setLogin(String _login) { this._login = _login; }

    public Integer getFollowers() {
        return _followers;
    }

    public String getLogin() { return _login; }

    @Override
    public String toString() {
        return "GithubDetails{" +
                "_login='" + _login + '\'' +
                ", _followers=" + _followers +
                '}';
    }
}
