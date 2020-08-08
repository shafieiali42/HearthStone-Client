package controller.request;

import controller.response.Response;

public class LogInRequest extends Request {



    private String password;
    private String mode;


    public LogInRequest(String sendersToken,String userName, String password, String mode) {
        setUserName(userName);
        setRequestType("LogInRequest");
        setRequestSendersToken(sendersToken);
        this.password = password;
        this.mode = mode;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

}
