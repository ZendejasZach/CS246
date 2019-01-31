package zendejas;

public class User {
    // Variables
    private String password;
    private String hashedPassword;
    private String salt;
    private String hash;

    // Constructor
    public User(String userPassword){
        password = userPassword;
    }

    // Setters
    public void setPassword(String newPassword){
        password = newPassword;
    }

    public void setSalt(String newSalt){
        salt = newSalt;
    }

    public void setHashedPassword(String newHash){
        hashedPassword = newHash;
    }

    // Getters
    public String getPassword(){
        return password;
    }

    public String getHashedPassword(){
        return hashedPassword;
    }

    public String getSalt(){
        return salt;
    }

    public String getHash(){
        return hash;
    }

}
