import java.util.ArrayList;
import java.util.HashMap;

public class User {
    
    private String username;
    private String password;
    private String profile_name;
    private String description;
    private static User instance = null;
    HashMap<String,Credential> credentials_list = new HashMap<>();
    ArrayList<String> credential_names = new ArrayList<>();

    User(){
        this.username = "default";
        this.password = "default";
        this.profile_name = "default";
        this.description = "default";
        AppData.get_instance().add_user(this);
        instance = this;
    }

    User(String username, String password){
        this.username = username;
        this.password = password;
        this.profile_name = "default";
        this.description = "default";
        AppData.get_instance().add_user(this);
        instance = this;
    }

    User(String username, String password, String profile_name){
        this.username = username;
        this.password = password;
        this.profile_name = profile_name;
        this.description = "default";
        AppData.get_instance().add_user(this);
        instance = this;
    }

    User(String username, String password, String profile_name, String description){
        this.username = username;
        this.password = password;
        this.profile_name = profile_name;
        this.description = description;
        AppData.get_instance().add_user(this);
        instance = this;
    }

    public static User get_instance(){
        if(instance == null){
            instance = new User();
        }
        return instance;
    }

    void set_password(String password){
        this.password = password;
    }

    void set_profile_name(String profile_name){
        this.profile_name = profile_name;
    }

    void set_description(String description){
        this.description = description;
    }

    String get_username(){
        return username;
    }

    String get_password(){
        return password;
    }

    String get_profile_name(){
        return profile_name;
    }

    String get_description(){
        return description;
    }

    void update_user(){
        AppData.get_instance().update_user(this);
    }

    boolean new_credential(String name, String username, String password, String description){
        if(credentials_list.get(name) == null){
            credentials_list.put(name, new Credential(name, username, password, description));
            credential_names.add(name);
            return true;
        }else{
            return false;
        }
    }

    void remove_credential(String name){
        credentials_list.remove(name);
        credential_names.remove(name);
    }

    boolean check_if_cred_exists(String name){
        if(credentials_list.get(name) == null){
            return false;
        }else{
            return true;
        }
    }

}
