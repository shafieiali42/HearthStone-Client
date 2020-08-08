package controller.request;

public class ShowGameModesRequest extends Request {


    public ShowGameModesRequest(String userName) {
        setUserName(userName);
        setRequestType("ShowGameModesRequest");
    }

}
