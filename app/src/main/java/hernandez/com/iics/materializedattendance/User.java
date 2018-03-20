package hernandez.com.iics.materializedattendance;

/**
 * Created by Biancake on 3/5/2018.
 */

class User {
    String username;
    String password;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(){

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
