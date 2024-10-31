import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class AppData {
    
    private HashMap<String, User> user_list = new HashMap<>();
    private ArrayList<String> user_names = new ArrayList<>();
    private static AppData instance = null;

    AppData(){
        
    }

    public static AppData get_instance(){
        if(instance == null){
            instance = new AppData();
        }
        return instance;
    }

    //Add User object to user_list HashMap
    void add_user(User user){
        user_list.put(user.get_username(), user);
        user_names.add(user.get_username());
    }

    //Upade user data after changes have been made
    void update_user(User user){
        user_list.get(user.get_username()).set_password(user.get_password());
        user_list.get(user.get_username()).set_profile_name(user.get_profile_name());
        user_list.get(user.get_username()).set_description(user.get_description());
    }

    //For debug purpouses
    void check_user(User user){
        System.out.println();
        System.out.println("Username:");
        System.out.println(user_list.get(user.get_username()).get_username());
        System.out.println();
        System.out.println("Password:");
        System.out.println(user_list.get(user.get_username()).get_password());
        System.out.println();
        System.out.println("Profile Name:");
        System.out.println(user_list.get(user.get_username()).get_profile_name());
        System.out.println();
        System.out.println("Description:");
        System.out.println(user_list.get(user.get_username()).get_description());
        System.out.println();
    }

    //Check if user already exists
    boolean check_if_exists(String username){

        boolean exists = false;

        for(int i = 0; i < user_names.size(); i++){
            if(username.equals(user_names.get(i))){
                exists = true;
            }
        }
        return exists;
    }

    //Check user password
    String check_password(String username){
        return user_list.get(username).get_password();
    }

    //Encrypt any given String
    String encrypt_data(String data){
        String s = data;
        ArrayList<Character> chars = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            chars.add(c);
        }

        StringBuilder result = new StringBuilder(chars.size());
        for (int i = 0; i < chars.size(); i++) {
            result.append(chars.get(i));
        }

        String encrypted = result.toString();

        return encrypted;
    }

    //Decrypt ecnrypted String
    String decrypt_data(String data){
        String s = data;
        ArrayList<Character> chars = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            chars.add(c);
        }

        StringBuilder result = new StringBuilder(chars.size());
        for (int i = 0; i < chars.size(); i++) {
            result.append(chars.get(i));
        }

        String decrypted = result.toString();

        return decrypted;
    }

    //Export UserData to file
    void export_data(boolean encryption) throws IOException{
        if(User.get_instance().get_username().equals("default")){

        }else{
            //Create a new file or select already existing file;
            File file = new File("lib/" + User.get_instance().get_username() + ".txt");

            //Create FileOutputStream and BufferedWriter to read data from scoreboard and write it line by line to selected file
            FileOutputStream fos = new FileOutputStream(file);;    
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            //Write data to file
            if(encryption){
                //Encrypt data
                bw.write("ENCRYPTED");
                bw.newLine();
                bw.write("PROFILE DATA");
                bw.newLine();
                bw.write(encrypt_data(User.get_instance().get_username()));
                bw.newLine();
                bw.write(encrypt_data(User.get_instance().get_password()));
                bw.newLine();
                bw.write(encrypt_data(User.get_instance().get_profile_name()));
                bw.newLine();
                bw.write(encrypt_data(User.get_instance().get_description()));
                bw.newLine();
                bw.write("CREDENTIALS");
                bw.newLine();
                for(int i = 0; i < User.get_instance().credentials_list.size(); i++){
                        bw.write(encrypt_data(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getName()));
                        bw.newLine();
                        bw.write(encrypt_data(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getUsername()));
                        bw.newLine();
                        bw.write(encrypt_data(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getPassword()));
                        bw.newLine();
                        bw.write(encrypt_data(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getDescription()));
                        bw.newLine();
                }
            }else{
                //Dont encrypt data
                bw.write("UNENCRYPTED");
                bw.newLine();
                bw.write("PROFILE DATA");
                bw.newLine();
                bw.write(User.get_instance().get_username());
                bw.newLine();
                bw.write(User.get_instance().get_password());
                bw.newLine();
                bw.write(User.get_instance().get_profile_name());
                bw.newLine();
                bw.write(User.get_instance().get_description());
                bw.newLine();
                bw.write("CREDENTIALS");
                bw.newLine();
                for(int i = 0; i < User.get_instance().credentials_list.size(); i++){
                        bw.write(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getName());
                        bw.newLine();
                        bw.write(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getUsername());
                        bw.newLine();
                        bw.write(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getPassword());
                        bw.newLine();
                        bw.write(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getDescription());
                        bw.newLine();
                }
            }
            bw.close();
        }
    }

    //Manual data export
    void manual_export_data(boolean encryption) throws IOException{
        if(User.get_instance().get_username().equals("default")){

        }else{
            //Create a new file or select already existing file;
            File file = new File("lib/manual_export_file.txt");

            //Create FileOutputStream and BufferedWriter to read data from scoreboard and write it line by line to selected file
            FileOutputStream fos = new FileOutputStream(file);;    
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            //Write data to file
            if(encryption){
                //Encrypt data
                bw.write("ENCRYPTED");
                bw.newLine();
                bw.write("PROFILE DATA");
                bw.newLine();
                bw.write(encrypt_data(User.get_instance().get_username()));
                bw.newLine();
                bw.write(encrypt_data(User.get_instance().get_password()));
                bw.newLine();
                bw.write(encrypt_data(User.get_instance().get_profile_name()));
                bw.newLine();
                bw.write(encrypt_data(User.get_instance().get_description()));
                bw.newLine();
                bw.write("CREDENTIALS");
                bw.newLine();
                for(int i = 0; i < User.get_instance().credentials_list.size(); i++){
                        bw.write(encrypt_data(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getName()));
                        bw.newLine();
                        bw.write(encrypt_data(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getUsername()));
                        bw.newLine();
                        bw.write(encrypt_data(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getPassword()));
                        bw.newLine();
                        bw.write(encrypt_data(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getDescription()));
                        bw.newLine();
                }
            }else{
                //Dont encrypt data
                bw.write("UNENCRYPTED");
                bw.newLine();
                bw.write("PROFILE DATA");
                bw.newLine();
                bw.write(User.get_instance().get_username());
                bw.newLine();
                bw.write(User.get_instance().get_password());
                bw.newLine();
                bw.write(User.get_instance().get_profile_name());
                bw.newLine();
                bw.write(User.get_instance().get_description());
                bw.newLine();
                bw.write("CREDENTIALS");
                bw.newLine();
                for(int i = 0; i < User.get_instance().credentials_list.size(); i++){
                        bw.write(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getName());
                        bw.newLine();
                        bw.write(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getUsername());
                        bw.newLine();
                        bw.write(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getPassword());
                        bw.newLine();
                        bw.write(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)).getDescription());
                        bw.newLine();
                }
            }
            bw.close();
        }
    }

    //Import User data
    void import_data(String username){
        //Create BufferedReader to read data from file
        BufferedReader reader;
        boolean encryption;
        
        try {
            reader = new BufferedReader(new FileReader("lib/" + username + ".txt"));

            //Create string to evaluate encryption;
            String line = reader.readLine();
            reader.readLine();
            
            if(line.equals("ENCRYPTED")){
                encryption = true;
            }else{
                encryption = false;
            }
            String temp_profile_username;
            String temp_profile_password;
            String temp_profile_name;
            String temp_profile_description;
            String temp_cred_name;
            String temp_cred_username;
            String temp_cred_password;
            String temp_cred_description;
            
            if(!encryption){
                //If not encrypted, read data, create user, add creds
                temp_profile_username = reader.readLine();
                temp_profile_password = reader.readLine();
                temp_profile_name = reader.readLine();
                temp_profile_description = reader.readLine();
                new User(temp_profile_username, temp_profile_password, temp_profile_name, temp_profile_description);
                line = reader.readLine();
                line = reader.readLine();
                while((line != null)){
                    temp_cred_name = line;
                    line = reader.readLine();
                    temp_cred_username = line;
                    line = reader.readLine();
                    temp_cred_password = line;
                    line = reader.readLine();
                    temp_cred_description = line;
                    
                    User.get_instance().new_credential(temp_cred_name, temp_cred_username, temp_cred_password, temp_cred_description);

                    line = reader.readLine();
                }

            }else{
                //If encrypted, read data, decrypt, create user, add creds
                temp_profile_username = decrypt_data(reader.readLine());
                temp_profile_password = decrypt_data(reader.readLine());
                temp_profile_name = decrypt_data(reader.readLine());
                temp_profile_description = decrypt_data(reader.readLine());
                new User(temp_profile_username, temp_profile_password, temp_profile_name, temp_profile_description);
                line = reader.readLine();
                line = reader.readLine();
                while((line != null)){
                    temp_cred_name = decrypt_data(line);
                    line = reader.readLine();
                    temp_cred_username = decrypt_data(line);
                    line = reader.readLine();
                    temp_cred_password = decrypt_data(line);
                    line = reader.readLine();
                    temp_cred_description = decrypt_data(line);

                    User.get_instance().new_credential(temp_cred_name, temp_cred_username, temp_cred_password, temp_cred_description);

                    line = reader.readLine();
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

        
        
    

