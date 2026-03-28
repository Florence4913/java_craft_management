import java.util.HashMap;
import java.util.Map;

public class Authentication {
    private boolean loginStatus;
    private Map<String, String>u;

    public Authentication() {
        this.loginStatus = false;
        this.u = new HashMap<>();
    }

    public boolean isLogin(){
        return loginStatus;
    }

    public boolean getloginStatus(){
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus){
        this.loginStatus = loginStatus;
    }

    public boolean loginStatus(String username, String password, User u){
            if (u.getUsername().equals(username)&& u.getPassword().equals(password)){
                setLoginStatus(true);
                return true;
            }
        
        return false;
    }

    public void registerUser(String username, String password){
        u.put(username, password);
    }

}