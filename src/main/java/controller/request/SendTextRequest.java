package controller.request;

public class SendTextRequest extends Request {


    private String text;


    public SendTextRequest(String userName, String text) {
        setUserName(userName);
        setRequestType("SendTextRequest");
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
