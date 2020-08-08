package controller.request;



public class ShowPlayPanelRequest extends Request {



    private String state;

    public ShowPlayPanelRequest(String userName, String state) {
        setUserName(userName);
        this.state = state;
    }


}
