package controller.response;

import utility.constant.Constant;
import view.gui.panels.GamePage.PlayPanel;

public class ShowTimerResponse extends Response {


    private boolean finished;
    private int secondPassed;

    public ShowTimerResponse(boolean finished, int secondPassed) {
        this.finished = finished;
        this.secondPassed = secondPassed;
    }

    @Override
    public void execute() {
        PlayPanel playPanel = (PlayPanel) Constant.getPanels().get("PlayPanel");
        if (!finished) {
            playPanel.setTime((60 - secondPassed) + "");
            playPanel.setNeedTimer(true);
        } else {
            playPanel.setNeedTimer(false);
            playPanel.setNeedsToRepaint(true);
            playPanel.repaint();
            playPanel.revalidate();
        }
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getSecondPassed() {
        return secondPassed;
    }

    public void setSecondPassed(int secondPassed) {
        this.secondPassed = secondPassed;
    }
}
