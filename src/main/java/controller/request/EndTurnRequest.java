package controller.request;

public class EndTurnRequest extends Request {


    public EndTurnRequest(String userName) {
        setUserName(userName);
        setRequestType("EndTurnRequest");
    }


}
