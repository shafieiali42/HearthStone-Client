package controller;

import com.google.gson.Gson;
import controller.controllers.Controller;
import controller.request.*;
import controller.response.Response;
import utility.constant.Constant;
import utility.json.JsonDeSerializerForResponse;
import view.gui.panels.GamePage.FirstThreeCardsPage;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Client extends Thread {

    private String serverIp;
    private int serverPort;
    private Socket socket;
    private ArrayList<Response> responses;
    private String authToken;


    public Client(String serverIp, int serverPort) {
        try {
            this.socket = new Socket(serverIp, serverPort);
            this.responses = new ArrayList<>();
            this.authToken = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        int counter = 0;
        try {
            Scanner myScanner = new Scanner(socket.getInputStream());
            String authtoken = "";
            String responseName = "";
            String message = "";
            while (true) {
                while (myScanner.hasNextLine()) {
                    String text = myScanner.nextLine();
                    switch (counter % 3) {
                        case 0:
                            authtoken = text;
                            break;
                        case 1:
                            responseName = text;
                            break;
                        case 2:
                            message = text;
                            System.out.println(authtoken);
                            System.out.println(responseName);
                            System.out.println(message);
                            Response response = JsonDeSerializerForResponse.deSerializeResponse(authtoken, responseName, message);
                            this.responses.add(response);
                            executeResponse();
                            break;
                    }
                    counter++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void executeResponse() {
        Iterator<Response> itr = responses.iterator();
        while (itr.hasNext()) {
            Response response = itr.next();
            response.execute();
            itr.remove();
        }
    }


    private void sendRequest(String authToken, String requestName, String request) {
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(socket.getOutputStream());
            printStream.println(authToken);
            printStream.println(requestName);
            printStream.println(request);
            printStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendShowRankRequest(String typeOfRank) {
        Request request = new ShowRankRequest(Controller.getCurrentPlayerUserName(), typeOfRank);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "ShowRankRequest", message);
    }


    public void sendLogInRequest(String userName, String password, String mode) {
        Request request = new LogInRequest(authToken, userName, password, mode);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "LogInRequest", message);
    }


    public void sendDeletePlayerRequest(String userName, String passWord) {
        Request request = new DeletePlayerRequest(authToken, userName, passWord);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "DeletePlayerRequest", message);
    }

    public void sendLogOutRequest(String userName, boolean exit) {
        Request request = new LogOutRequest(authToken, userName, exit);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "LogOutRequest", message);
    }


    public void sendShowPlayPanelRequest(){
        Request request=new ShowPlayPanelRequest(Controller.getCurrentPlayerUserName(),"");
        String message =new Gson().toJson(request);
        sendRequest(authToken,"ShowPlayPanelRequest",message);
    }

    public void sendMouseReleasedRequest(String cardName, String xCoordinateOfReleased,
                                         String yCoordinateOfReleased) {
        System.out.println("send mouse Released Request");
        Request request = new MouseReleasedRequest(Controller.getCurrentPlayerUserName(), cardName,
                xCoordinateOfReleased, yCoordinateOfReleased);

        String message =new Gson().toJson(request);
        sendRequest(authToken,"MouseReleasedRequest",message);
    }


    public void sendTextRequest(String text) {
        Request request = new SendTextRequest(Controller.getCurrentPlayerUserName(), text);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "SendTextRequest", message);
    }


    public void sendQuitGameRequest() {
        Request request =new QuitGameRequest(Controller.getCurrentPlayerUserName());
        String message =new Gson().toJson(request);
        sendRequest(authToken,"QuitGameRequest",message);
    }


    public void sendOkButtonDiscoverPageRequest() {
        Request request = new OkButtonDiscoverPageRequest(Controller.getCurrentPlayerUserName());
        String message = new Gson().toJson(request);
        sendRequest(authToken, "OkButtonDiscoverPageRequest", message);
    }

    public void sendGoToPageRequest(String userName, String pageName) {
        System.out.println("send go to setting page request");
        Request request = new GoToPageRequest(authToken, userName, pageName);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "GoToPageRequest", message);
    }


    public void sendBuyOrSellRequest(String cardName) {
        Request request = new BuyOrSellRequest(Controller.getCurrentPlayerUserName(), cardName);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "BuyOrSellRequest", message);
    }


    public void sendMousePressRequest(String cardName) {
        FirstThreeCardsPage firstThreeCardsPage = (FirstThreeCardsPage) Constant.getPanels().get("FirstThreeCardsPage");
        Request request = new MousePressRequest(Controller.getCurrentPlayerUserName(), cardName,
                firstThreeCardsPage.getFirstCard(), firstThreeCardsPage.getSecondCard(), firstThreeCardsPage.getThirdCard(),
                firstThreeCardsPage.getCanChangeFirstCard(), firstThreeCardsPage.getCanChangeSecondCard(),
                firstThreeCardsPage.getCanChangeThirdCard());
        String meesage = new Gson().toJson(request);
        sendRequest(authToken, "MousePressRequest", meesage);
    }


    public void sendOkButtonOnFirstThreeCardsPageRequest() {
        Request request = new OkButtonOnFirstThreeCardsPageRequest(Controller.getCurrentPlayerUserName());
        String message = new Gson().toJson(request);
        sendRequest(authToken, "OkButtonOnFirstThreeCardsPageRequest", message);
    }


    public void sendSetPlayerInfoPassiveRequest(int infoPassiveIndex) {
        Request request = new SetPlayerInfoPassiveRequest(Controller.getCurrentPlayerUserName(), infoPassiveIndex);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "SetPlayerInfoPassiveRequest", message);
    }


    public void sendEndTurnRequest() {
        Request request = new EndTurnRequest(Controller.getCurrentPlayerUserName());
        String message = new Gson().toJson(request);
        sendRequest(authToken, "EndTurnRequest", message);
    }


    public void sendShowGameModesRequest() {
        Request request = new ShowGameModesRequest(Controller.getCurrentPlayerUserName());
        String message = new Gson().toJson(request);
        sendRequest(authToken, "ShowGameModesRequest", message);
    }


    public void sendPlayGameRequest(String gameMode) {
        Request request = new PlayGameRequest(Controller.getCurrentPlayerUserName(), gameMode);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "PlayGameRequest", message);
    }


    public void sendShowSearchCardsRequest(String searchTextField) {
        Request request = new ShowSearchCardsRequest(Controller.getCurrentPlayerUserName(), searchTextField);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "ShowSearchCardsRequest", message);
    }


    public void sendShowCardsFilteredByManaRequest(int mana) {
        Request request = new ShowCardsFilteredByManaRequest(Controller.getCurrentPlayerUserName(), mana);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "ShowCardsFilteredByManaRequest", message);
    }


    public void sendGoBackFromCollectionPages() {
        Request request = new GoBackFromCollectionPages(Controller.getCurrentPlayerUserName());
        String message = new Gson().toJson(request);
        sendRequest(authToken, "GoBackFromCollectionPages", message);
    }


    public void sendShowDeckRequest(String deckName) {
        Request request = new ShowDeckRequest(Controller.getCurrentPlayerUserName(), deckName);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "ShowDeckRequest", message);
    }

    public void sendShowDeckButtonsRequest() {
        Request request = new ShowDeckButtonsRequest(Controller.getCurrentPlayerUserName());
        String message = new Gson().toJson(request);
        sendRequest(authToken, "ShowDeckButtonsRequest", message);
    }


    public void sendShowSpecialCardsOfHeroRequest() {
        Request request = new ShowSpecialCardsOfHeroRequest(Controller.getCurrentPlayerUserName());
        String message = new Gson().toJson(request);
        sendRequest(authToken, "ShowSpecialCardsOfHeroRequest", message);
    }


    public void sendRemoveDeckRequest(String requestType) {
        Request request = new MakeChangeToDeckToChangeRequest(Controller.getCurrentPlayerUserName(), requestType, null);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "MakeChangeToDeckToChangeRequest", message);
    }

    public void sendChangeHeroOfDeckRequest(String requestType, String heroName) {
        Request request = new MakeChangeToDeckToChangeRequest(Controller.getCurrentPlayerUserName(), requestType, heroName);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "MakeChangeToDeckToChangeRequest", message);
    }

    public void sendSelectMainDeckRequest(String requestType) {
        Request request = new MakeChangeToDeckToChangeRequest(Controller.getCurrentPlayerUserName(), requestType, null);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "MakeChangeToDeckToChangeRequest", message);
    }


    public void sendChangeNameOfDeckRequest(String requestType, String newName) {
        Request request = new MakeChangeToDeckToChangeRequest(Controller.getCurrentPlayerUserName(), requestType, newName);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "MakeChangeToDeckToChangeRequest", message);
    }


    public void sendRemoveCardFromDeckToChangeRequest(String cardName) {
        System.out.println("send remove card from deck");
        Request request = new RemoveCardFromDeckToChangeRequest(Controller.getCurrentPlayerUserName(), cardName);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "RemoveCardFromDeckToChangeRequest", message);
    }


    public void sendSetAllLittleCardsPanelsRequest() {
        Request request = new SetAllLittleCardsPanelsRequest(Controller.getCurrentPlayerUserName());
        String message = new Gson().toJson(request);
        sendRequest(authToken, "SetAllLittleCardsPanelsRequest", message);
    }


    public void sendMakeNewDeckRequest(String deckName, String heroName) {
        Request request = new MakeNewDeckRequest(Controller.getCurrentPlayerUserName(), deckName, heroName);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "MakeNewDeckRequest", message);
    }


    public void sendDoneCreatDeckRequest() {
        Request request = new DoneCreatDeckRequest(authToken, Controller.getCurrentPlayerUserName());
        String message = new Gson().toJson(request);
        sendRequest(authToken, "DoneCreatDeckRequest", message);
    }


    public void sendMouseClickedRequest(String cardName, String typeOfCard, boolean clicked,
                                        int xCoordinateOfCard, int yCoordinateOfCard,
                                        Alliance alliance, String typeOfClick, boolean isLock) {

        System.out.println("send mouse Click Request");
        Request request = new MouseClickRequest(Controller.getCurrentPlayerUserName(), cardName, typeOfCard,
                clicked, xCoordinateOfCard, yCoordinateOfCard, alliance, typeOfClick, isLock);

        String message = new Gson().toJson(request);
        sendRequest(authToken, "MouseClickRequest", message);
    }


    public void sendLeftClickRequest(String cardName, boolean isLock) {
        Request request = new LeftClickRequest(cardName, Controller.getCurrentPlayerUserName(), isLock);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "LeftClickRequest", message);
    }


    public void sendShowWalletRequest(String userName) {
        Request request = new ShowWalletRequest(authToken, userName);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "ShowWalletRequest", message);
    }

    public void sendShowSpecificCardsRequest(String group, String pageName) {
        Request request = new ShowSpecificCardsRequest(authToken, Controller.getCurrentPlayerUserName(), group, pageName);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "ShowSpecificCardsRequest", message);
    }

    public void sendChangeBackOfCardRequest(String mode) {
        Request request = new ChangeBackOfCardRequest(authToken, Controller.getCurrentPlayerUserName(), mode);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "ChangeBackOfCardRequest", message);
    }


    public void sendChangeVolumeRequest(String state) {
        Request request = new ChangeVolumeRequest(authToken, Controller.getCurrentPlayerUserName(), state);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "ChangeVolumeRequest", message);
    }

    public void sendShowDeckNumber(int number) {
        Request request = new ShowDeckNumberRequest(authToken, Controller.getCurrentPlayerUserName(), number);
        String message = new Gson().toJson(request);
        sendRequest(authToken, "ShowDeckNumberRequest", message);
    }


    //getter and setters
    //********************

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ArrayList<Response> getResponses() {
        return responses;
    }

    public void setResponses(ArrayList<Response> responses) {
        this.responses = responses;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
