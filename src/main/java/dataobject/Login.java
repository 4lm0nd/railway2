package dataobject;

public class Login {

    public Login(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getEmail(String email) {
        return this.email;
    }

    public String getPass(String password) {
        return pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private String email;
    private String pass;
}



