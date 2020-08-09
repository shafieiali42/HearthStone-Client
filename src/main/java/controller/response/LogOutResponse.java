package controller.response;

import Main.ClientMain;
import controller.controllers.Controller;
import view.gui.Loop.GraphicLoop;
import view.gui.panels.logInPage.LogInPage;

public class LogOutResponse extends Response {


    boolean successful;
    boolean exit;

    public LogOutResponse(boolean successful,boolean exit) {
        setResponseType("LogOutResponse");
        this.successful = successful;
        this.exit=exit;
    }

    @Override
    public void execute() {
        if (successful) {
            Controller.getCurrentClient().setAuthToken(null);
            Controller.setCurrentPlayerUserName(null);
            ClientMain.getMyMainFrame().setContentPane(new LogInPage());
            if (exit) {
                GraphicLoop.getInstance().stop();
                System.exit(0);
            }
        }
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
