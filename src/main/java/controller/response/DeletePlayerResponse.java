package controller.response;

import Main.ClientMain;
import controller.Controller;

import javax.swing.*;

public class DeletePlayerResponse extends Response {


    boolean successful;

    public DeletePlayerResponse(boolean successful) {
        setResponseType("DeletePlayerResponse");
        this.successful = successful;
    }


    @Override
    public void execute() {
        if (successful) {
            Controller.setCurrentPlayerUserName(null);
            Controller.setCurrentClient(null);
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(ClientMain.getMyMainFrame(), "Wrong Password!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }


    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
