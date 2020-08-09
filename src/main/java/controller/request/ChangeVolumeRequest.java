package controller.request;

public class ChangeVolumeRequest extends Request {

    private String status;

    public ChangeVolumeRequest(String sendersToken, String userName,String status) {
        setUserName(userName);
        setRequestType("ChangeVolumeRequest");
        setRequestSendersToken(sendersToken);
        this.status = status;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
