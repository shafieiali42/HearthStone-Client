package controller.request;

public class PlayGameRequest extends Request {

    private String userName;
    private String gameMode;


    public PlayGameRequest(String userName, String gameMode) {
        this.userName = userName;
        this.gameMode = gameMode;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }
}
