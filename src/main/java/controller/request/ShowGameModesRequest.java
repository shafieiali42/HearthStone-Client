package controller.request;

public class ShowGameModesRequest extends Request {



    private String userName;


    public ShowGameModesRequest(String userName) {
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
