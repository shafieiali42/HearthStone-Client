package controller.response;

import controller.controllers.GamePartController;

public class WriteOnLogPanelResponse extends Response {


    private String log;

    public WriteOnLogPanelResponse(String log) {
        setResponseType("WriteOnLogPanelResponse");
        this.log = log;
    }

    @Override
    public void execute() {
        GamePartController.writeOnLogPanel(log);
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
