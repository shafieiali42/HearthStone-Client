package controller.request;

public class ShowSpecificCardsRequest extends Request {


    private String group;
    private String userName;


    public ShowSpecificCardsRequest(String sendersToken, String userName, String group) {
        setRequestType("ShowSpecificCardsRequest");
        setRequestSendersToken(sendersToken);
        this.group = group;
        this.userName = userName;
    }


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
