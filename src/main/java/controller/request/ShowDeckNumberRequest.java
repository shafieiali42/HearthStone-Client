package controller.request;

public class ShowDeckNumberRequest extends Request {


    private int number;

    public ShowDeckNumberRequest(String sendersToken,String userName, int number) {
        setUserName(userName);
        setRequestType("ShowDeckNumberRequest");
        setRequestSendersToken(sendersToken);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
