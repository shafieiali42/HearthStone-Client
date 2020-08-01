package controller.request;

public class ShowWalletRequest extends Request {


    private String userName;


    public ShowWalletRequest(String sendersToken,String userName) {
        setRequestType("ShowWalletRequest");
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
