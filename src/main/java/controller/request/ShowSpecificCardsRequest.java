package controller.request;

public class ShowSpecificCardsRequest extends Request {


    private String group;
    private String panelName;


    public ShowSpecificCardsRequest(String sendersToken, String userName, String group,String panelName) {
        setUserName(userName);
        setRequestType("ShowSpecificCardsRequest");
        setRequestSendersToken(sendersToken);
        this.group = group;
        this.panelName = panelName;
    }


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPanelName() {
        return panelName;
    }

    public void setPanelName(String panelName) {
        this.panelName = panelName;
    }
}
