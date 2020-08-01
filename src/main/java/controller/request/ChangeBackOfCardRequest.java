package controller.request;

public class ChangeBackOfCardRequest extends Request {


        private String userName;
        private String mode;

    public ChangeBackOfCardRequest(String sendersToken,String userName, String mode) {
        setRequestType("ChangeVolumeRequest");
        setRequestSendersToken(sendersToken);
        this.userName = userName;
        this.mode = mode;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
