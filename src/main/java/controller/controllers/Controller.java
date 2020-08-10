package controller.controllers;

import controller.Client;

import java.util.ArrayList;

public class Controller {

    private static Client currentClient;
    private static String currentPlayerUserName;

    private static ArrayList<String> rankedNames=new ArrayList<>();
    private static ArrayList<String> rankedCups=new ArrayList<>();
    private static String typeOfRank="";
    private static String myRank="";

    //getter and setters
    //*********************


    public static String getTypeOfRank() {
        return typeOfRank;
    }

    public static void setTypeOfRank(String typeOfRank) {
        Controller.typeOfRank = typeOfRank;
    }

    public static String getMyRank() {
        return myRank;
    }

    public static void setMyRank(String myRank) {
        Controller.myRank = myRank;
    }

    public static Client getCurrentClient() {
        return currentClient;
    }
    public static void setCurrentClient(Client currentClient) {
        Controller.currentClient = currentClient;
    }
    public static String getCurrentPlayerUserName() {
        return currentPlayerUserName;
    }
    public static void setCurrentPlayerUserName(String currentPlayerUserName) {
        Controller.currentPlayerUserName = currentPlayerUserName;
    }
    public static ArrayList<String> getRankedNames() {
        return rankedNames;
    }
    public static void setRankedNames(ArrayList<String> rankedNames) {
        Controller.rankedNames = rankedNames;
    }
    public static ArrayList<String> getRankedCups() {
        return rankedCups;
    }
    public static void setRankedCups(ArrayList<String> rankedCups) {
        Controller.rankedCups = rankedCups;
    }
}
