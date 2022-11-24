package dataobject;

public class Register {
    public String getEmail(String email) {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(String password) {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword(String confirmPassword) {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPID(String PID) {
        return this.PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public Register(String email, String password, String confirmPassword, String PID) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.PID = PID;
    }

    private String email;
    private String password;
    private String confirmPassword;
    private String PID;
}


