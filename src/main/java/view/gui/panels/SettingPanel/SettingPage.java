package view.gui.panels.SettingPanel;


import controller.controllers.Administer;
import controller.controllers.Controller;
import utility.constant.Constant;
import view.gui.panels.GamePage.PlayPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SettingPage extends JPanel {


    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);
    private static int numberOfPushMuteBtn = 0;
    private JButton changeBackOfCardsBtn;
    private JButton increaseVolumeBtn;
    private JButton decreaseVolumeBtn;
    private JButton muteSoundsBtn;
    private JButton backBtn;

    public SettingPage() {
        setLayout(null);
        setBackground(Color.gray);
        initButtons();
    }

    private void initButtons() {
        initChangeBackOfCards();
        initMuteSoundsBtn();
        initIncreaseBtn();
        initDecreaseBtn();
        initBackBtn();
    }

    private void initChangeBackOfCards() {
        changeBackOfCardsBtn = new JButton("Change card design");
        designBtn(changeBackOfCardsBtn);
        changeBackOfCardsBtn.setBounds(Constant.X_COORDINATE_OF_BUTTONS_IN_SETTING,
                Constant.Y_COORDINATE_OF_CHANGE_BACK_OF_CARDS_BTN, Constant.WIDTH_OF_BTN_IN_SETTING,
                Constant.HEIGHT_OF_BTN_IN_SETTING);
        changeBackOfCardsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayPanel playPanel=(PlayPanel)Constant.getPanels().get("PlayPanel");
                int a = playPanel.getTypeOfBackOfCards() + 1;
                Controller.getCurrentClient().sendChangeBackOfCardRequest(a + "");


            }
        });
        this.add(changeBackOfCardsBtn);

    }

    private void initBackBtn() {
        backBtn = new JButton("Back");
        designBtn(backBtn);
        backBtn.setBounds(Constant.X_COORDINATE_OF_BUTTONS_IN_SETTING, Constant.Y_COORDINATE_OF_BACK_BTN,
                Constant.WIDTH_OF_BTN_IN_SETTING, Constant.HEIGHT_OF_BTN_IN_SETTING);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                CardPanel.getInstanceOfCollectionPage().removeAll();
//                CardPanel.getInstanceOfCollectionPage().repaint();
//                CardPanel.getInstanceOfCollectionPage().revalidate();
//                Administer.writeLog("Go back from setting page");
//                CLI.currentPlayer.getLoggerOfMyPlayer().info("Go back from setting page");
                Administer.goBack();
            }
        });
        this.add(backBtn);
    }


    public void designBtn(JButton btn) {
        btn.setSize(Constant.WIDTH_OF_BTN_IN_SETTING, Constant.WIDTH_OF_BTN_IN_SETTING);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);
    }

    private void initMuteSoundsBtn() {
        muteSoundsBtn = new JButton("Mute/SoundsOn");
        designBtn(muteSoundsBtn);
        muteSoundsBtn.setBounds(Constant.X_COORDINATE_OF_BUTTONS_IN_SETTING, Constant.Y_COORDINATE_OF_MUTE_BTN,
                Constant.WIDTH_OF_BTN_IN_SETTING, Constant.HEIGHT_OF_BTN_IN_SETTING);
        muteSoundsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Administer.changeStatusOfSound(numberOfPushMuteBtn);
                Controller.getCurrentClient().sendChangeVolumeRequest(numberOfPushMuteBtn+"");
//                Sounds.changeStatus(numberOfPushMuteBtn);
                numberOfPushMuteBtn++;
            }
        });
        add(muteSoundsBtn);

    }

    private void initIncreaseBtn() {
        increaseVolumeBtn = new JButton("Increase Volume");
        designBtn(increaseVolumeBtn);
        increaseVolumeBtn.setBounds(Constant.X_COORDINATE_OF_BUTTONS_IN_SETTING, Constant.Y_COORDINATE_OF_INCREASE_BTN,
                Constant.WIDTH_OF_BTN_IN_SETTING, Constant.HEIGHT_OF_BTN_IN_SETTING);
        increaseVolumeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Administer.increaseSound();
                Controller.getCurrentClient().sendChangeVolumeRequest("+");
//                Sounds.increaseSound();
            }
        });
        add(increaseVolumeBtn);

    }

    private void initDecreaseBtn() {
        decreaseVolumeBtn = new JButton("Decrease Volume");
        designBtn(decreaseVolumeBtn);
        decreaseVolumeBtn.setBounds( Constant.X_COORDINATE_OF_BUTTONS_IN_SETTING,  Constant.Y_COORDINATE_OF_DECREASE_BTN,
                Constant.WIDTH_OF_BTN_IN_SETTING,  Constant.HEIGHT_OF_BTN_IN_SETTING);
        decreaseVolumeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Administer.decreaseSound();
                Controller.getCurrentClient().sendChangeVolumeRequest("-");
//                Sounds.decreaseSound();
            }
        });
        add(decreaseVolumeBtn);
    }


    public static int getNumberOfPushMuteBtn() {
        return numberOfPushMuteBtn;
    }

    public static void setNumberOfPushMuteBtn(int numberOfPushMuteBtn) {
        SettingPage.numberOfPushMuteBtn = numberOfPushMuteBtn;
    }
}
