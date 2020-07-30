package controller;

import com.google.gson.Gson;
import controller.request.*;
import controller.response.Response;
import utility.json.JsonDeSerializerForResponse;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Client extends Thread{

    private String serverIp;
    private int serverPort;
    private Socket socket;
    private ArrayList<Response> responses;
    private String authToken;


    public Client(String serverIp,int serverPort){
        try {
            this.socket=new Socket(serverIp,serverPort);
            this.responses=new ArrayList<>();
            this.authToken=null;
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


    public void sendLogInRequest(String userName,String password,String mode){
        Request request =new LogInRequest(authToken,userName,password,mode);
        String message = new Gson().toJson(request);
        sendRequest(authToken,"LogInRequest",message);
    }


    public void sendDeletePlayerRequest(String userName,String passWord){
        Request request =new DeletePlayerRequest(authToken,userName,passWord);
        String message=new Gson().toJson(request);
        sendRequest(authToken,"DeletePlayerRequest",message);
    }

    public void sendLogOutRequest(String userName){
        Request request =new LogOutRequest(authToken,userName);
        String message =new Gson().toJson(request);
        sendRequest(authToken,"LogOutRequest",message);
    }


    public void sendGoToPage(String pageName){
        Request request =new GoToPageRequest(authToken,pageName);
        String message =new Gson().toJson(request);
        sendRequest(authToken,"GoToPageRequest",message);
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
