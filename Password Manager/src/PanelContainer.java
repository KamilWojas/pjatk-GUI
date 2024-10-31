import javax.swing.JPanel;
import java.awt.*;

public class PanelContainer extends JPanel {
    
    private static PanelContainer instance = null;
    LoginScreen login_screen = new LoginScreen();
    RegisterScreen register_screen = new RegisterScreen();
    AppScreen app_screen = new AppScreen();

    //Set CardLayout as Layout
    CardLayout cl = new CardLayout();

    PanelContainer(){
        this.setLayout(cl);
        this.add(login_screen, "login");
        this.add(register_screen, "register");
        this.add(app_screen, "app");

        instance = this;
    }

    public static PanelContainer get_instance(){
        if(instance == null){
            instance = new PanelContainer();
        }
        return instance;
    }

    

    //Switch displayed Screen
    void show_screen(String name){
        cl.show(this, name);
    }
}
