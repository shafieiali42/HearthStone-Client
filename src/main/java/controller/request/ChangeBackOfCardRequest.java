package controller.request;

public class ChangeBackOfCardRequest extends Request {



        private String mode;

    public ChangeBackOfCardRequest(String sendersToken,String userName, String mode) {
        setUserName(userName);
        setRequestType("ChangeBackOfCardRequest");
        setRequestSendersToken(sendersToken);
        this.mode = mode;
    }


    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
