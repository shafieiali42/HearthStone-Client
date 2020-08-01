package controller.response;

import controller.Administer;
import utility.constant.Constant;
import view.gui.panels.SettingPanel.SettingPage;

public class ChangeVolumeResponse extends Response {


    private String mode;


    public ChangeVolumeResponse(String mode) {
        this.mode = mode;
    }

    @Override
    public void execute() {
        if (mode.equalsIgnoreCase("+")) {
            Administer.increaseSound();
        } else if (mode.equalsIgnoreCase("-")) {
            Administer.decreaseSound();
        } else {
            int modeInt = Integer.parseInt(mode);
            Administer.changeStatusOfSound(modeInt);
            SettingPage.setNumberOfPushMuteBtn(SettingPage.getNumberOfPushMuteBtn()+1);
        }
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
