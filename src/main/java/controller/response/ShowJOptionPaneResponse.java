package controller.response;

import javax.swing.*;

public class ShowJOptionPaneResponse extends Response {



    private String message;


    public ShowJOptionPaneResponse(String message) {
        this.message = message;
    }

    @Override
    public void execute() {
        JOptionPane.showMessageDialog(null, message);
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
