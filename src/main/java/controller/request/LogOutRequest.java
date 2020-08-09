package controller.request;

public class LogOutRequest extends Request {


    private boolean exit;


    public LogOutRequest(String sendersToken, String userName,boolean exit) {
        setUserName(userName);
        setRequestType("LogOutRequest");
        setRequestSendersToken(sendersToken);
        this.exit=exit;
    }


    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
