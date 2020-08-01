package controller.request;

public class LeftClickRequest extends Request {


    private String userName;
    private String cardName;
    private boolean isLock;

    public LeftClickRequest(String userName,String cardName,boolean isLock) {
        this.userName = userName;
        this.cardName=cardName;
        this.isLock=isLock;
    }




    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }
}

