package controller.request;

public class LogOutRequest extends Request {


    private String userName;


    public LogOutRequest(String sendersToken, String userName) {
        setRequestType("LogOutRequest");
        setRequestSendersToken(sendersToken);
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
