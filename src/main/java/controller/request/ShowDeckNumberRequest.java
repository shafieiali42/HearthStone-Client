package controller.request;

public class ShowDeckNumberRequest extends Request {


    private String userName;
    private int number;

    public ShowDeckNumberRequest(String sendersToken,String userName, int number) {
        setRequestType("ShowDeckNumberRequest");
        setRequestSendersToken(sendersToken);
        this.userName = userName;
        this.number = number;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
