package sk.stu.fiit.register.model;

public class RegistrationCredentials {

    private String userName;
    private String role;

    public RegistrationCredentials() {
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
