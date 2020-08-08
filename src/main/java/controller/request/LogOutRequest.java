package controller.request;

public class LogOutRequest extends Request {




    public LogOutRequest(String sendersToken, String userName) {
        setUserName(userName);
        setRequestType("LogOutRequest");
        setRequestSendersToken(sendersToken);
    }


}
