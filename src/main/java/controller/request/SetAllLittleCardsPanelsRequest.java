package controller.request;

public class SetAllLittleCardsPanelsRequest extends Request {



    private String userName;

    public SetAllLittleCardsPanelsRequest(String userName) {
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
