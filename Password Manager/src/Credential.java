public class Credential {
    
    private String name;
    private String username;
    private String password;
    private String description;
    private static Credential instance = null;

    Credential(){
        instance = this;
    }
    
    Credential(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
        this.description = "   ";
        instance = this;
    }

    Credential(String name, String username, String password, String description){
        this.name = name;
        this.username = username;
        this.password = password;
        this.description = description;
        instance = this;
    }

    public static Credential get_instance(){
        if(instance == null){
            instance = new Credential();
        }
        return instance;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return name;
    }
    
}
