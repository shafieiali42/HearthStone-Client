package controller.request;

public class ShowDeckButtonsRequest extends Request{


    public ShowDeckButtonsRequest(String userName) {
        setUserName(userName);
        setRequestType("ShowDeckButtonsRequest");
    }

}
