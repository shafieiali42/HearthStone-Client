package controller.request;

public class GoToPageRequest extends Request {


    private String pageName;



    public GoToPageRequest(String sendersToken, String pageName) {
        setRequestType("GoToPage");
        setRequestSendersToken(sendersToken);
        this.pageName = pageName;
    }




    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
}
