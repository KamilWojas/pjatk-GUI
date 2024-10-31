import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.*;


public class RegisterScreen extends JPanel{

    JTextField password_field = new JTextField("");
    JLabel pass_strength = new JLabel();
    
    RegisterScreen(){
        
        //Set window parameters
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        //Create necessary fields
        JLabel username_label = new JLabel("Username");
        JLabel password_label = new JLabel("Password");
        JLabel confirm_password_label = new JLabel("Confirm Password");

        JTextField username_field = new JTextField("");
        JTextField confirm_password_field = new JTextField("");

        JButton register_button = new JButton("Register");
        JButton back_button = new JButton("Back");

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
        
        gbc.insets = new Insets(0, 50, 0, 50);

        this.add(password_field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 50, 10, 50);

        this.add(pass_strength, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(10, 50, 0, 50);

        this.add(confirm_password_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(0, 50, 10, 50);

        this.add(confirm_password_field, gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.weightx = 0.3;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(15, 50, 15, 50);

        this.add(register_button, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.weightx = 0.3;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(15, 50, 15, 50);

        this.add(back_button, gbc);

        //Add actions to buttons

        register_button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    AppData.get_instance().import_data(username_field.getText());
                    if(AppData.get_instance().check_if_exists(username_field.getText())){
                        username_field.setText("Username is already taken");
                    }else{
                        if(password_field.getText().equals(confirm_password_field.getText())){
                            new User(username_field.getText(), password_field.getText());
                            PanelContainer.get_instance().show_screen("login");
                            AppFrame.get_instance().setTitle("Login");
                            username_field.setText("");
                            password_field.setText("");
                            confirm_password_field.setText("");
                            LoginScreen.get_instance().message.setText("User created succesfully!");
                        }else{
                            confirm_password_field.setText("Passwords do not match");
                        }
                    }
                } catch (Exception ex) {
                    
                }
            }

        });

        back_button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                PanelContainer.get_instance().show_screen("login");
                AppFrame.get_instance().setTitle("Login");
                username_field.setText("");
                password_field.setText("");
                confirm_password_field.setText("");
            }

        });

        password_field.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                check_pass_strength();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                check_pass_strength();
                
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                check_pass_strength();
            }
            
        });
    }

    //Password strength checker
    int check_pass_strength(){
        int StrengthScore = 0;

        if( password_field.getText().length() < 8 )
            StrengthScore = 0;
        else if( password_field.getText().length() >= 10 )
            StrengthScore += 2;
        else 
            StrengthScore += 1;
            
        //if it contains one digit, add 2 to total score
        if( password_field.getText().matches("(?=.*[0-9]).*") )
            StrengthScore += 2;
            
        //if it contains one lower case letter, add 2 to total score
        if( password_field.getText().matches("(?=.*[a-z]).*") )
            StrengthScore += 2;
            
        //if it contains one upper case letter, add 2 to total score
        if( password_field.getText().matches("(?=.*[A-Z]).*") )
            StrengthScore += 2;    
            
        //if it contains one special character, add 2 to total score
        if( password_field.getText().matches("(?=.*[~!@#$%^&*()_-]).*") )
            StrengthScore += 2;

        if(StrengthScore < 8){
            pass_strength.setText("Weak");
        }else if(StrengthScore < 10){
            pass_strength.setText("Moderate");
        }else{
            pass_strength.setText("Strong");
        }

        return StrengthScore;
    }
}
