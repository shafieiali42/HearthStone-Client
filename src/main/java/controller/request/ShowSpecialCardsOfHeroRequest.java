package controller.request;

public class ShowSpecialCardsOfHeroRequest extends Request {


    private String userName;


    public ShowSpecialCardsOfHeroRequest(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
