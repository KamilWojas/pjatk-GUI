import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JPanel{

    private static LoginScreen instance = null;
    JLabel message = new JLabel();
    
    LoginScreen(){
        
        //Set window parameters
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.DARK_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();

        //Create necessary fields
        JLabel username_label = new JLabel("Username");
        JLabel password_label = new JLabel("Password");

        JTextField username_field = new JTextField("");
        JTextField password_field = new JTextField("");

        JButton login_button = new JButton("Log-In");
        JButton register_button = new JButton("Register");

        //Place buttons and text fields

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(10, 50, 0, 50);

        this.add(username_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(0, 50, 10, 50);

        this.add(username_field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(10, 50, 0, 50);

        this.add(password_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(0, 50, 10, 50);

        this.add(password_field, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.weightx = 0.3;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(15, 50, 15, 50);

        this.add(login_button, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.weightx = 0.3;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(15, 50, 15, 50);

        this.add(register_button, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.CENTER;
        
        gbc.insets = new Insets(0, 50, 10, 50);

        this.add(message, gbc);

        //Add actions to buttons

        login_button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AppData.get_instance().import_data(username_field.getText());
                    if(AppData.get_instance().check_if_exists(username_field.getText())){
                        if(AppData.get_instance().check_password(username_field.getText()).equals(password_field.getText())){
                            set_up_menu_bar();
                            PanelContainer.get_instance().show_screen("app");
                            AppFrame.get_instance().setTitle("Password Manager by S20661");
                            AppScreen.get_instance().refresh_list();
                            username_field.setText("");
                            password_field.setText("");
                            message.setText("");
                        }else{
                            password_field.setText("Incorrect Password");
                        }
                    }else{
                        username_field.setText("User does not exits");
                    }
                } catch (Exception ex) {
                    
                }
            }
        });
        
        register_button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                PanelContainer.get_instance().show_screen("register");
                AppFrame.get_instance().setTitle("Register new User");
                username_field.setText("");
                password_field.setText("");
            }

        });

        instance = this;

    }

    public static LoginScreen get_instance(){
        if(instance == null){
            instance = new LoginScreen();
        }
        return instance;
    }

    //Remake the menu_bar
    void set_up_menu_bar(){
        //Remove exisiting elements
        AppFrame.get_instance().file.remove(AppFrame.get_instance().close);

        //Set up menu_bar
        AppFrame.get_instance().add_sub_menu.add(AppFrame.get_instance().add_cred);
        AppFrame.get_instance().file.add(AppFrame.get_instance().add_sub_menu);

        AppFrame.get_instance().export_sub_menu.add(AppFrame.get_instance().export);
        AppFrame.get_instance().export_sub_menu.add(AppFrame.get_instance().export_enc);
        AppFrame.get_instance().file.add(AppFrame.get_instance().export_sub_menu);

        AppFrame.get_instance().file.add(AppFrame.get_instance().log_out);

        AppFrame.get_instance().file.add(AppFrame.get_instance().close);

        AppFrame.get_instance().edit.add(AppFrame.get_instance().edit_profile);
        AppFrame.get_instance().menu_bar.add(AppFrame.get_instance().edit);
    }
}
