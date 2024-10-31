import java.awt.Dimension;
import java.io.IOException;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class AppFrame extends JFrame{

    private static AppFrame instance = null;
    JMenuBar menu_bar = new JMenuBar();

    JMenu file = new JMenu("File");
    JMenu add_sub_menu = new JMenu("Add");
    JMenuItem add_cred = new JMenuItem("Credential");
    JMenu export_sub_menu = new JMenu("Export");
    JMenuItem export = new JMenuItem("Unencrypted");
    JMenuItem export_enc = new JMenuItem("Encrypted");
    JMenuItem log_out = new JMenuItem("Log-Out");
    JMenuItem close = new JMenuItem("Close");

    JMenu edit = new JMenu("Edit");
    JMenuItem edit_profile = new JMenuItem("Profile");

    AppFrame(){

        //Set window properties
        file.add(close);
        menu_bar.add(file);
        this.setTitle("Login");
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setMinimumSize(new Dimension(800,800));
        this.setMaximumSize(new Dimension(800,800));
        this.setPreferredSize(new Dimension(800,800));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(new PanelContainer());
        this.setJMenuBar(menu_bar);
        this.setVisible(true);
        instance = this;

        //Add listeners
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(AppFrame.get_instance(), 
                    "Are you sure you want to close this window?", "Close Window?", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                        try {
                            AppData.get_instance().export_data(true);
                            System.exit(0);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else{
                        
                    }
            }
        });

        close.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                try {
                    AppData.get_instance().export_data(true);
                    System.exit(0);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        });


        add_cred.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
                AppScreen.get_instance().add_cred();

            }

        });

        export.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
                if (JOptionPane.showConfirmDialog(AppFrame.get_instance(), 
                    "Are you sure you want to export unecrypted data?", "Export unencrypted?", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                        try {
                            AppData.get_instance().manual_export_data(false);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }else{
                        
                    }

            }

        });

        export_enc.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
                if (JOptionPane.showConfirmDialog(AppFrame.get_instance(), 
                    "Are you sure you want to export ecrypted data?", "Export encrypted?", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                        try {
                            AppData.get_instance().manual_export_data(true);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }else{
                        
                    }

            }

        });

        edit_profile.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
                AppScreen.get_instance().edit_profile();

            }

        });

        log_out.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
                file.removeAll();
                edit.removeAll();
                menu_bar.remove(edit);
                file.add(close);

                menu_bar.updateUI();

                PanelContainer.get_instance().show_screen("login");

            }

        });
        
    }


    public static AppFrame get_instance(){
        if(instance == null){
            instance = new AppFrame();
        }
        return instance;
    }
}
