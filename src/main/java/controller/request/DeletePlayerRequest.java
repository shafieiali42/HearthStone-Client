package controller.request;

public class DeletePlayerRequest extends Request {


    private String password;

    public DeletePlayerRequest(String sendersToken,String userName, String password) {
        setUserName(userName);
        setRequestType("DeletePlayerRequest");
        setRequestSendersToken(sendersToken);
        this.password = password;
    }



    //getter and setters
    //********************


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
