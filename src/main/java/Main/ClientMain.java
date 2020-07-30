package Main;



import controller.Client;
import controller.Controller;
import view.gui.panels.logInPage.LogInPage;
import view.gui.panels.myMainFrame.MyMainFrame;

import javax.swing.*;

public class ClientMain {

    private static MyMainFrame myMainFrame =new MyMainFrame();


    public static void main(String[] args) {
        JTextField portField = new JTextField();
        JTextField ipField = new JTextField();
        Object[] message = {
                "Port:", portField,
                "Ip:", ipField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        Client client =new Client(portField.getText(),Integer.parseInt(ipField.getText()));
        Controller.setCurrentClient(client);
        myMainFrame.setContentPane(new LogInPage());

    }


    public static MyMainFrame getMyMainFrame() {
        return myMainFrame;
    }

    public static void setMyMainFrame(MyMainFrame myMainFrame) {
        ClientMain.myMainFrame = myMainFrame;
    }
}
