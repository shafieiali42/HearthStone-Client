package controller.request;

public class PlayGameRequest extends Request {

    private String gameMode;


    public PlayGameRequest(String userName, String gameMode) {
        setUserName(userName);
        setRequestType("PlayGameRequest");
        this.gameMode = gameMode;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }
}
