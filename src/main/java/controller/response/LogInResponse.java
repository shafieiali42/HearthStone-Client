package controller.response;


import Main.ClientMain;
import controller.controllers.Administer;
import controller.controllers.Controller;
import controller.controllers.GamePartController;
import view.gui.panels.MenuPanel.MainMenuPage;

import javax.swing.*;
import java.util.ArrayList;

public class LogInResponse extends Response {


    private boolean successful;
    private String answer;
    private ArrayList<String> allCardsNames;

    public LogInResponse(boolean successful, String answer,ArrayList<String> allCardsNames) {
        this.successful = successful;
        this.answer = answer;
        this.allCardsNames=allCardsNames;
    }

    @Override
    public void execute() {
        System.out.println(" IN loginRESPONSE");
        if (successful){
            Controller.getCurrentClient().setAuthToken(this.getResponseReceiversToken());
            Controller.setCurrentPlayerUserName(answer);
            Administer.playMainSound("src/main/resources/Sounds/FirstAudio.wav");
            ClientMain.getMyMainFrame().setContentPane(new MainMenuPage());
            System.out.println("set menu for content pane");
            GamePartController.setAllCardsOfPlayerNames(allCardsNames);
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

    public ArrayList<String> getAllCardsNames() {
        return allCardsNames;
    }

    public void setAllCardsNames(ArrayList<String> allCardsNames) {
        this.allCardsNames = allCardsNames;
    }
}