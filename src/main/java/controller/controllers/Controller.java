package controller.controllers;

import controller.Client;

public class Controller {

    private static Client currentClient;
    private static String currentPlayerUserName;


    //getter and setters
    //*********************

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

}
