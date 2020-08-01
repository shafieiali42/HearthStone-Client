package view.gui.panels.StatusPanel;


import utility.constant.Constant;

import javax.swing.*;

public class StatusPage extends JPanel {



    public StatusPage(){
        setLayout(null);
        setSize(Constant.widthOfMainFrame,Constant.heightOfMainFrame);
        add(Constant.getPanels().get("RankedPanel"));
        add(Constant.getPanels().get("ShowDeckInfoPanel"));
    }

}
