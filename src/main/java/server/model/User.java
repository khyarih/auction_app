package server.model;

import server.annotation.TargetFile;

@TargetFile(fileName = "user.json")
public class User extends Person{

    private String login;
    private String password;

    public User(String firstName, String lastName, String login, String password) {
        super(firstName, lastName);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
