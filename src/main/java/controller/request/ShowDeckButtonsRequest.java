package controller.request;

public class ShowDeckButtonsRequest extends Request{

    private String userName;

    public ShowDeckButtonsRequest(String userName) {
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
