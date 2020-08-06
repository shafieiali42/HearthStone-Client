package controller.request;



public class OkButtonDiscoverPageRequest extends Request {


    private String userName;

    public OkButtonDiscoverPageRequest(String userName) {
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
