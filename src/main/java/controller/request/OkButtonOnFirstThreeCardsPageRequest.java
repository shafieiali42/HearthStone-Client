package controller.request;

public class OkButtonOnFirstThreeCardsPageRequest extends Request {

    private String userName;

    public OkButtonOnFirstThreeCardsPageRequest(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
