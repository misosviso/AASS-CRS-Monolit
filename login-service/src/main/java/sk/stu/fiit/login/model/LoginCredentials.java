package sk.stu.fiit.login.model;

public class LoginCredentials {

    private String userName;
    private String role;

    public LoginCredentials() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
