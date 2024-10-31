import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;

public class AppScreen extends JPanel{

    private static AppScreen instance = null;
    JSplitPane split_pane = new JSplitPane();
    DefaultListModel<Credential> model = new DefaultListModel<>();
    Credential credential_chosen;
    JList<Credential> list = new JList<>();
    JTextField password_field = new JTextField();
    JLabel pass_strength = new JLabel("");
    
    AppScreen(){

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.DARK_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();

        //Get Clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        //Create necessary fields and controls

        JScrollPane left_panel = new JScrollPane();
        JPanel right_panel = new JPanel();

        JLabel name_label = new JLabel("Name:");
        JLabel username_label = new JLabel("Username:");
        JLabel password_label = new JLabel("Password:");
        JLabel note_label = new JLabel("Note:");

        JTextField name_field = new JTextField();
        JTextField username_field = new JTextField();
        JTextField note_field = new JTextField();

        name_field.setEditable(false);

        split_pane.setDividerSize(1);

        right_panel.setLayout(new GridBagLayout());
        right_panel.setBackground(Color.DARK_GRAY);

        list.setBackground(Color.GRAY);
        list.setModel(model);

        split_pane.setSize(800,800);
        split_pane.setMinimumSize(new Dimension(800,800));

        //Place all necessary fields and controls

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 0, 10);

        right_panel.add(name_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 10, 10);

        right_panel.add(name_field, gbc);  

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 0, 10);

        right_panel.add(username_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 10, 10);

        right_panel.add(username_field, gbc);

        JButton copy_username = new JButton("Copy to clipboard");

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 10, 10);

        right_panel.add(copy_username, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 0, 10);

        right_panel.add(password_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 0, 10);

        right_panel.add(password_field, gbc);

        JButton copy_password = new JButton("Copy to clipboard");

        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 0, 10);

        right_panel.add(copy_password, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 10, 10);

        right_panel.add(pass_strength, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 0, 10);

        right_panel.add(note_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 10, 10);

        right_panel.add(note_field, gbc);

        JButton save_changes = new JButton("Save Changes");

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 0, 10);

        right_panel.add(save_changes, gbc);

        JButton remove_cred = new JButton("Remove");

        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 0, 10);

        right_panel.add(remove_cred, gbc);

        JLabel message = new JLabel();

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 10, 10, 10);

        right_panel.add(message, gbc);

        split_pane.setRightComponent(right_panel);
        split_pane.setLeftComponent(left_panel.add(list));
        split_pane.setDividerLocation(240);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 0);

        this.add(split_pane,gbc);

        //Add actions to buttons etc.

        list.getSelectionModel().addListSelectionListener(e -> {
            
            credential_chosen = list.getSelectedValue();

            message.setText("");
            check_pass_strength();

            if(credential_chosen == null){

            }else{
                name_field.setText(credential_chosen.getName());
                username_field.setText(credential_chosen.getUsername());
                password_field.setText(credential_chosen.getPassword());
                note_field.setText(credential_chosen.getDescription());
            }

        });

        copy_username.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                clipboard.setContents(new StringSelection(username_field.getText()), null);
            }

        });

        copy_password.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                clipboard.setContents(new StringSelection(password_field.getText()), null);
            }

        });

        save_changes.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                credential_chosen.setUsername(username_field.getText());
                credential_chosen.setPassword(password_field.getText());
                credential_chosen.setDescription(note_field.getText());

                left_panel.updateUI();
                split_pane.grabFocus();

                message.setText("Changes saved succesfully!");                
            }

        });

        remove_cred.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                remove_cred();
                
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

        instance = this;

    }

    public static AppScreen get_instance(){
        if(instance == null){
            instance = new AppScreen();
        }
        return instance;
    }

    //Refresh credential list (and show first list element)
    void refresh_list(){
        model.removeAllElements();
        model.trimToSize();
        
        for(int i = 0; i < User.get_instance().credential_names.size(); i++){
            model.addElement(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)));
        }

        split_pane.updateUI();
        split_pane.grabFocus();

        model.trimToSize();
        credential_chosen = model.lastElement();
        list.setSelectedValue(model.firstElement(), true);
    }

    //Refresh credential list (and show last list element)
    void refresh_list2(){
        model.removeAllElements();
        model.trimToSize();
        
        for(int i = 0; i < User.get_instance().credential_names.size(); i++){
            model.addElement(User.get_instance().credentials_list.get(User.get_instance().credential_names.get(i)));
        }

        split_pane.updateUI();
        split_pane.grabFocus();

        model.trimToSize();
        credential_chosen = model.lastElement();
        list.setSelectedValue(model.lastElement(), true);
    }

    //Remove credential from list
    void remove_cred(){
        User.get_instance().credentials_list.remove(credential_chosen.getName());
        model.removeElement(credential_chosen);
        list.clearSelection();
        refresh_list();
    }

    //Add credential to list
    void add_cred(){
        //Set up window
        JFrame frame = new JFrame("ADD CRED DEBUG");
        frame.setSize(400,400);
        frame.setMinimumSize(new Dimension(400,400));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(AppFrame.get_instance());
        frame.setResizable(false);
        frame.setVisible(true);

        JPanel panel = new JPanel();

        frame.add(panel);

        JLabel name_label = new JLabel("Name");
        JLabel username_label = new JLabel("Username");
        JLabel password_label = new JLabel("Password");
        JLabel note_label = new JLabel("Note");

        JTextField name = new JTextField("");
        JTextField username = new JTextField("");
        JTextField password = new JTextField("");
        JTextField note = new JTextField("");

        //Set window parameters
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.DARK_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(10, 10, 3, 10);

        panel.add(name_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(0, 10, 10, 10);

        panel.add(name, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(10, 10, 3, 10);

        panel.add(username_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(0, 10, 10, 10);

        panel.add(username, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(10, 10, 3, 10);

        panel.add(password_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(0, 10, 10, 10);

        panel.add(password, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(10, 10, 3, 10);

        panel.add(note_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(0, 10, 10, 10);

        panel.add(note, gbc);

        JButton add_cred = new JButton("Add");
        JButton back = new JButton("Back");

        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.weightx = 0.3;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(15, 50, 15, 50);

        panel.add(add_cred, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.weightx = 0.3;
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.insets = new Insets(15, 50, 15, 50);

        panel.add(back, gbc);

        add_cred.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String temp_name = "empty";
                String temp_username = "empty";
                String temp_password = "empty";
                String temp_note = "empty";
                
                if(!(User.get_instance().check_if_cred_exists(name.getText()))){
                    if(name.getText().isEmpty()){
                        name.setText("NAME CANNOT BE EMPTY");
                    }else{
                        temp_name = name.getText();
                        if(username.getText().isEmpty()){

                        }else{
                            temp_username = username.getText();
                        }
                        if(password.getText().isEmpty()){

                        }else{
                            temp_password = password.getText();
                        }
                        if(note.getText().isEmpty()){
                            
                        }else{
                            temp_note = note.getText();
                        }
                        
                        User.get_instance().new_credential(temp_name, temp_username, temp_password, temp_note);
                        list.clearSelection();
                        refresh_list2();

                        frame.dispose();
                    } 
                }else{
                    name.setText("CREDENTIAL WITH THIS NAME ALREADY EXISTS");
                }
            }
        });

        back.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }

        });
    }

    void edit_profile(){
        //Set up window
        JFrame profile_window = new JFrame("EDIT PRFOILE DEBUG");
        profile_window.setSize(200,400);
        profile_window.setMinimumSize(new Dimension(600,600));
        profile_window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profile_window.setLocationRelativeTo(AppFrame.get_instance());
        profile_window.setResizable(false);
        profile_window.setVisible(true);

        //Create JPanel, set card layout, create 2 cards, add them to container;
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        CardLayout cl = new CardLayout();
        panel.setLayout(cl);
        
        JPanel profile = new JPanel();
        profile.setLayout(new GridBagLayout());
        JPanel password = new JPanel();
        password.setLayout(new GridBagLayout());

        panel.add(profile, "profile");
        panel.add(password, "password");

        profile_window.add(panel);

        JLabel username_label = new JLabel("Username");
        JLabel profile_name_label = new JLabel("Profile Name");
        JLabel description_label = new JLabel("Description");

        JTextField username_field = new JTextField(User.get_instance().get_username());
        username_field.setEditable(false);
        JTextField profile_name_field = new JTextField(User.get_instance().get_profile_name());
        JTextField description_field = new JTextField(User.get_instance().get_description());

        JButton save_changes = new JButton("Save Changes");
        JButton change_password = new JButton("Change Password");

        JLabel current_password_label = new JLabel("Current Password");
        JLabel new_password_label = new JLabel("New Password");
        JLabel confirm_new_password_label = new JLabel("Confirm New Password");

        JTextField current_password_field = new JTextField("");
        JTextField new_password_field = new JTextField("");
        JTextField confirm_new_password_field = new JTextField("");

        JButton save_password = new JButton("Apply");
        JButton back_button = new JButton("Back");
        
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 0, 10);

        profile.add(username_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 10, 10);

        profile.add(username_field, gbc);  

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 0, 10);

        profile.add(profile_name_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 10, 10);

        profile.add(profile_name_field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 0, 10);

        profile.add(description_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 10, 10);

        profile.add(description_field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 0, 10);

        profile.add(save_changes, gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 0, 10);

        profile.add(change_password, gbc);

        JLabel message = new JLabel();

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 10, 10, 10);

        profile.add(message, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 0, 10);

        password.add(current_password_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 10, 10);

        password.add(current_password_field, gbc);  

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 0, 10);

        password.add(new_password_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 10, 10);

        password.add(new_password_field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 0, 10);

        password.add(confirm_new_password_label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 10, 10);

        password.add(confirm_new_password_field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 0, 10);

        password.add(save_password, gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 0, 10);

        password.add(back_button, gbc);

        JLabel message2 = new JLabel();

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 10, 10, 10);

        password.add(message2, gbc);

        message.setText("");
        message2.setText("");
        
        //Add actions to buttons etc.
        save_changes.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String temp_profile_name = "empty";
                String temp_description = "empty";

                if(!profile_name_field.getText().isEmpty()){
                    temp_profile_name = profile_name_field.getText();
                }
                if(!description_field.getText().isEmpty()){
                    temp_description = description_field.getText();
                }

                User.get_instance().set_profile_name(temp_profile_name);
                User.get_instance().set_description(temp_description);
                User.get_instance().update_user();

                message.setText("Changes saved succesfully!");

            }

        });

        change_password.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                cl.show(panel, "password");
                message.setText("");
                
            }

        });

        save_password.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(current_password_field.getText().equals(User.get_instance().get_password())){
                    if(new_password_field.getText().isEmpty()){
                        new_password_field.setText("THIS FIELD IS REQUIRED");
                    }else{
                        if(new_password_field.getText().equals(confirm_new_password_field.getText())){
                            User.get_instance().set_password(new_password_field.getText());
                            User.get_instance().update_user();
                            message2.setText("Changes saved succesfully!");
                        }else{
                            confirm_new_password_field.setText("PASSWORDS DO NOT MATCH");
                        }
                    }
                }else{
                    current_password_field.setText("INCORRECT PASSWORD");
                }
            }

        });

        back_button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                cl.show(panel, "profile");
                message2.setText("");
                
            }

        });

        new_password_field.getDocument().addDocumentListener(new DocumentListener(){

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
