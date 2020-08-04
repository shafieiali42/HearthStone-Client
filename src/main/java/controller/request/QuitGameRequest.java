package controller.request;

public class QuitGameRequest extends Request {


    private String userName;


    public QuitGameRequest(String userName) {
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
