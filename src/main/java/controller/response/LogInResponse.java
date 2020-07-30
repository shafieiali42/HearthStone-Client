package controller.response;


import Main.ClientMain;
import controller.Administer;
import controller.Controller;
import view.gui.panels.MenuPanel.MainMenuPage;

import javax.swing.*;

public class LogInResponse extends Response {


    private boolean successful;
    private String answer;

    public LogInResponse(boolean successful, String answer) {
        this.successful = successful;
        this.answer = answer;
    }

    @Override
    public void execute() {
        if (successful){
            Controller.setCurrentPlayerUserName(answer);
            Administer.playMainSound("src/main/resources/Sounds/FirstAudio.wav");
            ClientMain.getMyMainFrame().setContentPane(new MainMenuPage());
        }else{
            JOptionPane.showMessageDialog(ClientMain.getMyMainFrame(),answer,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }


    //getter and setters
    //********************

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}