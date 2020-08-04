package controller.request;

public class EndTurnRequest extends Request {


    private String userName;


    public EndTurnRequest(String userName) {
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
