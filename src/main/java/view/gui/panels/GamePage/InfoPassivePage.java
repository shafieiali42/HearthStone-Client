package view.gui.panels.GamePage;

import Controller.ControllerOfMainComponents;
import Controller.GamePartController;
import Logic.Status;
import Utility.Config2.ConfigLoader;
import View.Gui.Panels.MyMainFrame.MyMainFrame;
import utility.constant.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;


public class InfoPassivePage extends JPanel {




    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);
    public static final int WIDTH_OF_BTN = 200;
    public static final int HEIGHT_OF_BTN = 200;
    public static final int NUMBER_OF_BTN = 3;

    private static InfoPassivePage infoPassivePage = new InfoPassivePage();

    public static InfoPassivePage getInstance() {
        return infoPassivePage;
    }

    private JButton firstPassiveBtn;
    private JButton secondPassiveBtn;
    private JButton thirdPassiveBtn;


    private InfoPassivePage() {
        setLayout(null);
        setBackground(Color.gray);
        initButtons();
    }

    private void initButtons() {
        initFirstBtn();
        initSecondBtn();
        initThirdBtn();
    }

    public void designBtn(JButton btn) {
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setSize(new Dimension(WIDTH_OF_BTN, HEIGHT_OF_BTN));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);
    }

    private void initThirdBtn() {
        thirdPassiveBtn = new JButton(GamePartController.getNameOfFriendlyPassive(2));
        thirdPassiveBtn.setBounds(3 * Constant.X_COORDINATE_OF_FIRST_BTN + 2 * WIDTH_OF_BTN,
                Constant. Y_COORDINATE_OF_FIRST_BTN, WIDTH_OF_BTN, HEIGHT_OF_BTN);//////////
        designBtn(thirdPassiveBtn);
        thirdPassiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GamePartController.setFriendlyInfoPassiveOfGameState(2);
//                GameState.getInstance().setInfoPassive(GameState.getInstance().getPassivesToChoose().get(2));
                ControllerOfMainComponents.setStatus(Status.FIRST_THREE_CARDS_PAGE);
                if (GamePartController.showThreeCardsForChange()) {
                    MyMainFrame.getInstance().setContentPane(FirstThreeCardsPage.getInstance());
                    GamePartController.setNameOfFirstFriendlyThreeCards();
                }else{
                    ControllerOfMainComponents.setStatus(Status.PLAY_PAGE);
                    MyMainFrame.getInstance().setContentPane(GamePage.getInstance());
                }
            }
        });
        add(thirdPassiveBtn);
    }

    private void initSecondBtn() {
        secondPassiveBtn = new JButton(GamePartController.getNameOfFriendlyPassive(1));
        secondPassiveBtn.setBounds(2 * Constant.X_COORDINATE_OF_FIRST_BTN + WIDTH_OF_BTN,
                Constant.Y_COORDINATE_OF_FIRST_BTN, WIDTH_OF_BTN, HEIGHT_OF_BTN);
        designBtn(secondPassiveBtn);
        secondPassiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GamePartController.setFriendlyInfoPassiveOfGameState(1);
//                GameState.getInstance().setInfoPassive(GameState.getInstance().getPassivesToChoose().get(1));
                ControllerOfMainComponents.setStatus(Status.FIRST_THREE_CARDS_PAGE);
                if (GamePartController.showThreeCardsForChange()) {
                    MyMainFrame.getInstance().setContentPane(FirstThreeCardsPage.getInstance());
                    GamePartController.setNameOfFirstFriendlyThreeCards();
                }else{
                    ControllerOfMainComponents.setStatus(Status.PLAY_PAGE);
                    MyMainFrame.getInstance().setContentPane(GamePage.getInstance());
                }
            }
        });
        add(secondPassiveBtn);

    }

    private void initFirstBtn() {
        firstPassiveBtn = new JButton(GamePartController.getNameOfFriendlyPassive(0));
        firstPassiveBtn.setBounds(Constant.X_COORDINATE_OF_FIRST_BTN,
                Constant.Y_COORDINATE_OF_FIRST_BTN, WIDTH_OF_BTN, HEIGHT_OF_BTN);
        designBtn(firstPassiveBtn);
        firstPassiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GamePartController.setFriendlyInfoPassiveOfGameState(0);
//                GameState.getInstance().setInfoPassive(GameState.getInstance().getPassivesToChoose().get(0));
                ControllerOfMainComponents.setStatus(Status.FIRST_THREE_CARDS_PAGE);
                if (GamePartController.showThreeCardsForChange()) {
                    MyMainFrame.getInstance().setContentPane(FirstThreeCardsPage.getInstance());
                    GamePartController.setNameOfFirstFriendlyThreeCards();
                }else{

                    ControllerOfMainComponents.setStatus(Status.PLAY_PAGE);
                    MyMainFrame.getInstance().setContentPane(GamePage.getInstance());

                }
            }
        });
        add(firstPassiveBtn);
    }

    @Override
    protected void paintComponent(Graphics g) {//todo maybe its better to do it by Administer
        super.paintComponent(g);
        firstPassiveBtn.setText(GamePartController.getNameOfFriendlyPassive(0));
        secondPassiveBtn.setText(GamePartController.getNameOfFriendlyPassive(1));
        thirdPassiveBtn.setText(GamePartController.getNameOfFriendlyPassive(2));

    }


}
