package controller.request;

public class ShowWalletRequest extends Request {


    public ShowWalletRequest(String sendersToken,String userName) {
        setUserName(userName);
        setRequestType("ShowWalletRequest");
        setRequestSendersToken(sendersToken);
    }

}
