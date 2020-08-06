package controller.response;

import utility.constant.Constant;
import view.gui.panels.GamePage.PlayPanel;

import javax.swing.*;

public class ShowJOptionPaneResponse extends Response {



    private String message;


    public ShowJOptionPaneResponse(String message) {
        this.message = message;
    }

    @Override
    public void execute() {
        JOptionPane.showMessageDialog(null, message);
        if (message.equalsIgnoreCase("Its Not Your Turn:))")){
            PlayPanel playPanel=(PlayPanel) Constant.getPanels().get("PLayPanel");
            playPanel.setNeedsToRepaint(true);
        }
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
