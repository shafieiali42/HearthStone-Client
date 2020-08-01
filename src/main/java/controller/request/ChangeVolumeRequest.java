package controller.request;

public class ChangeVolumeRequest extends Request {

    private String status;
    private String userName;

    public ChangeVolumeRequest(String sendersToken,String status, String userName) {
        setRequestType("ChangeVolumeRequest");
        setRequestSendersToken(sendersToken);
        this.status = status;
        this.userName = userName;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
