package Main;


import controller.Client;
import controller.controllers.Controller;
import controller.controllers.Status;
import utility.constant.Constant;
import view.gui.panels.logInPage.LogInPage;
import view.gui.panels.myMainFrame.MyMainFrame;

import javax.swing.*;

public class ClientMain {

    static {
        String[] array=new String[0];
        Constant.main(array);
    }

    private static MyMainFrame myMainFrame = new MyMainFrame();
    private static Status currentPage;

    public static void main(String[] args) {

        JTextField portField = new JTextField();
        JTextField ipField = new JTextField();
        Object[] message = {
                "Port:", portField,
                "Ip:", ipField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        Client client = new Client(portField.getText(), Integer.parseInt(ipField.getText()));
        Controller.setCurrentClient(client);
        myMainFrame.setContentPane(new LogInPage());

    }


    public static MyMainFrame getMyMainFrame() {
        return myMainFrame;
    }

    public static void setMyMainFrame(MyMainFrame myMainFrame) {
        ClientMain.myMainFrame = myMainFrame;
    }


    public static Status getCurrentPage() {
        return currentPage;
    }

    public static void setCurrentPage(Status currentPage) {
        ClientMain.currentPage = currentPage;
    }
}
