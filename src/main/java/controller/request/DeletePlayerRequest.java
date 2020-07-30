package controller.request;

public class DeletePlayerRequest extends Request {

    String userName;
    String password;

    public DeletePlayerRequest(String sendersToken,String userName, String password) {
        setRequestType("LogInRequest");
        setRequestSendersToken(sendersToken);
        this.userName = userName;
        this.password = password;
    }



    //getter and setters
    //********************

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
