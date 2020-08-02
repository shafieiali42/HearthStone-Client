package controller.request;

public class GoBackFromCollectionPages extends Request {


    private String userName;


    public GoBackFromCollectionPages(String userName) {
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
