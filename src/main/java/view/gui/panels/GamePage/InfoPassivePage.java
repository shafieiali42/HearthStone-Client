package view.gui.panels.GamePage;


import controller.controllers.Controller;
import utility.constant.Constant;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class InfoPassivePage extends JPanel {


    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);
    public static final int WIDTH_OF_BTN = 200;
    public static final int HEIGHT_OF_BTN = 200;
    public static final int NUMBER_OF_BTN = 3;
    private ArrayList<String> nameOfPassives;



    private JButton firstPassiveBtn;
    private JButton secondPassiveBtn;
    private JButton thirdPassiveBtn;



    public InfoPassivePage() {
        setLayout(null);
        setBackground(Color.gray);
        initButtons();
        nameOfPassives=new ArrayList<>();
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
        thirdPassiveBtn = new JButton(nameOfPassives.get(2));
        thirdPassiveBtn.setBounds(3 * Constant.X_COORDINATE_OF_FIRST_BTN + 2 * WIDTH_OF_BTN,
                Constant. Y_COORDINATE_OF_FIRST_BTN, WIDTH_OF_BTN, HEIGHT_OF_BTN);//////////
        designBtn(thirdPassiveBtn);
        thirdPassiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Controller.getCurrentClient().sendSetPlayerInfoPassiveRequest(2);
//                GamePartController.setFriendlyInfoPassiveOfGameState(2);
////                GameState.getInstance().setInfoPassive(GameState.getInstance().getPassivesToChoose().get(2));
//                ControllerOfMainComponents.setStatus(Status.FIRST_THREE_CARDS_PAGE);
//                if (GamePartController.showThreeCardsForChange()) {
//                    MyMainFrame.getInstance().setContentPane(FirstThreeCardsPage.getInstance());
//                    GamePartController.setNameOfFirstFriendlyThreeCards();
//                }else{
//                    ControllerOfMainComponents.setStatus(Status.PLAY_PAGE);
//                    MyMainFrame.getInstance().setContentPane(GamePage.getInstance());
//                }
            }
        });
        add(thirdPassiveBtn);
    }

    private void initSecondBtn() {
        secondPassiveBtn = new JButton(nameOfPassives.get(1));
        secondPassiveBtn.setBounds(2 * Constant.X_COORDINATE_OF_FIRST_BTN + WIDTH_OF_BTN,
                Constant.Y_COORDINATE_OF_FIRST_BTN, WIDTH_OF_BTN, HEIGHT_OF_BTN);
        designBtn(secondPassiveBtn);
        secondPassiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Controller.getCurrentClient().sendSetPlayerInfoPassiveRequest(1);
//                GamePartController.setFriendlyInfoPassiveOfGameState(1);
////                GameState.getInstance().setInfoPassive(GameState.getInstance().getPassivesToChoose().get(1));
//                ControllerOfMainComponents.setStatus(Status.FIRST_THREE_CARDS_PAGE);
//                if (GamePartController.showThreeCardsForChange()) {
//                    MyMainFrame.getInstance().setContentPane(FirstThreeCardsPage.getInstance());
//                    GamePartController.setNameOfFirstFriendlyThreeCards();
//                }else{
//                    ControllerOfMainComponents.setStatus(Status.PLAY_PAGE);
//                    MyMainFrame.getInstance().setContentPane(GamePage.getInstance());
//                }
            }
        });
        add(secondPassiveBtn);

    }

    private void initFirstBtn() {
        firstPassiveBtn = new JButton(nameOfPassives.get(0));
        firstPassiveBtn.setBounds(Constant.X_COORDINATE_OF_FIRST_BTN,
                Constant.Y_COORDINATE_OF_FIRST_BTN, WIDTH_OF_BTN, HEIGHT_OF_BTN);
        designBtn(firstPassiveBtn);
        firstPassiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Controller.getCurrentClient().sendSetPlayerInfoPassiveRequest(0);
//                GamePartController.setFriendlyInfoPassiveOfGameState(0);
////                GameState.getInstance().setInfoPassive(GameState.getInstance().getPassivesToChoose().get(0));
//                ControllerOfMainComponents.setStatus(Status.FIRST_THREE_CARDS_PAGE);
//                if (GamePartController.showThreeCardsForChange()) {
//                    MyMainFrame.getInstance().setContentPane(FirstThreeCardsPage.getInstance());
//                    GamePartController.setNameOfFirstFriendlyThreeCards();
//                }else{
//
//                    ControllerOfMainComponents.setStatus(Status.PLAY_PAGE);
//                    MyMainFrame.getInstance().setContentPane(GamePage.getInstance());
//                }
            }
        });
        add(firstPassiveBtn);
    }

    @Override
    protected void paintComponent(Graphics g) {//todo maybe its better to do it by Administer
        super.paintComponent(g);
        firstPassiveBtn.setText(nameOfPassives.get(0));
        secondPassiveBtn.setText(nameOfPassives.get(1));
        thirdPassiveBtn.setText(nameOfPassives.get(2));

    }

    public ArrayList<String> getNameOfPassives() {
        return nameOfPassives;
    }

    public void setNameOfPassives(ArrayList<String> nameOfPassives) {
        this.nameOfPassives = nameOfPassives;
    }
}
