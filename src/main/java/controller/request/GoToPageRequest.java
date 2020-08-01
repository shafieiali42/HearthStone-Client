package controller.request;

public class GoToPageRequest extends Request {


    private String pageName;
    private String userName;



    public GoToPageRequest(String sendersToken,String userName, String pageName) {
        setRequestType("GoToPageRequest");
        setRequestSendersToken(sendersToken);
        this.pageName = pageName;
        this.userName=userName;
    }




    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
