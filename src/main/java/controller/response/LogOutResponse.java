package controller.response;

import Main.ClientMain;
import controller.controllers.Controller;
import view.gui.panels.logInPage.LogInPage;

public class LogOutResponse extends Response {


    boolean successful;

    public LogOutResponse(boolean successful) {
        setResponseType("LogOutResponse");
        this.successful = successful;
    }

    @Override
    public void execute() {
        if (successful) {
            Controller.getCurrentClient().setAuthToken(null);
            Controller.setCurrentPlayerUserName(null);
            ClientMain.getMyMainFrame().setContentPane(new LogInPage());
        }
    }

        public boolean isSuccessful () {
            return successful;
        }

        public void setSuccessful ( boolean successful){
            this.successful = successful;
        }

    }
