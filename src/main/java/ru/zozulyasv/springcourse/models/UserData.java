package ru.zozulyasv.springcourse.models;

/**
 * todo Document type UserData
 */
public class UserData {

    private long id;
    private String email;
    private String login;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UserData(long id, String email, String login) {

        this.id = id;
        this.email = email;

        this.login = login;
    }

    public UserData() {}
}
