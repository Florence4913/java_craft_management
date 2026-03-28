public abstract class User {
    private String username;
    private String password;
    private Authentication auth;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.auth = new Authentication();
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String verifyLogin(String loginName, String loginPassword) {
        if (username.equals(loginName)&&password.equals(loginPassword)) {
            auth.setLoginStatus(true);
            return "Login Success!";
        }else{
            return "Unsuccessful Login!";
        }
    }

}
