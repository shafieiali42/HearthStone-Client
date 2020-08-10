package controller.response;

import Main.ClientMain;
import controller.controllers.Controller;
import view.gui.panels.RankPage;

import java.util.ArrayList;

public class ShowRankResponse extends Response {

    private ArrayList<String> nameOfPlayers;
    private ArrayList<String> numOfCups;

    private String myRank;
    private String typeOfRank;


    public ShowRankResponse(ArrayList<String> nameOfPlayers, ArrayList<String> numOfCups,String typeOfRank,String myRank) {
        setResponseType("ShowRankResponse");
        this.nameOfPlayers = nameOfPlayers;
        this.numOfCups = numOfCups;
        this.typeOfRank=typeOfRank;
        this.myRank=myRank;
    }


    @Override
    public void execute() {
        Controller.setRankedNames(nameOfPlayers);
        Controller.setRankedCups(numOfCups);
        Controller.setTypeOfRank(typeOfRank);
        Controller.setMyRank(myRank);
        ClientMain.getMyMainFrame().setContentPane(new RankPage());
    }

    public ArrayList<String> getNameOfPlayers() {
        return nameOfPlayers;
    }

    public void setNameOfPlayers(ArrayList<String> nameOfPlayers) {
        this.nameOfPlayers = nameOfPlayers;
    }

    public ArrayList<String> getNumOfCups() {
        return numOfCups;
    }

    public void setNumOfCups(ArrayList<String> numOfCups) {
        this.numOfCups = numOfCups;
    }

    public String getMyRank() {
        return myRank;
    }

    public void setMyRank(String myRank) {
        this.myRank = myRank;
    }

    public String getTypeOfRank() {
        return typeOfRank;
    }

    public void setTypeOfRank(String typeOfRank) {
        this.typeOfRank = typeOfRank;
    }
}
