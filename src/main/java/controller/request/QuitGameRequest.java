package controller.request;

public class QuitGameRequest extends Request {



    public QuitGameRequest(String userName) {
        setUserName(userName);
        setRequestType("QuitGameRequest");
    }

}
