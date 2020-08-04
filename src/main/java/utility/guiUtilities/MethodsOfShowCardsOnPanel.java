package utility.guiUtilities;


import controller.Alliance;
import utility.constant.Constant;
import view.CardView.CardImagePanel;
import view.gui.panels.CollectionPages.LittleCardPanel;
import view.gui.panels.GamePage.PlayPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class MethodsOfShowCardsOnPanel {

    //this method used to show cards in shop and collection pages :))
    public static void showCards(ArrayList<String> cards, JPanel panel, int numOfCardInEveryRow) {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        int counter = 0;
        int xCoordinate = 10;
        int yCoordinate = 10;
        int xSapce = 170;
        int ySpace = 10;
        for (String cardName : cards) {
            counter++;
            CardImagePanel cardImagePanel = null;
            try {
                cardImagePanel = new CardImagePanel(cardName);
                addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, cardImagePanel.getWidth(),
                        cardImagePanel.getHeight());
                if (counter % numOfCardInEveryRow == 0) {
                    xCoordinate = 10;
                    yCoordinate += cardImagePanel.getHeight() + ySpace;
                } else {
                    xCoordinate += xSapce;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void showCards(ArrayList<String> cards, JPanel panel, int numOfCardInEveryRow,
                                 int width, int height) {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        int counter = 0;
        int yCoordinate = (770 - height) / 2;
        int xSpace = (1400 - 3 * width) / 4;
        int xCoordinate = xSpace;
        for (String cardsName : cards) {
            counter++;
            CardImagePanel cardImagePanel = null;
            try {
                cardImagePanel = new CardImagePanel(cardsName, width, height, true, 1, null);
                addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, width, height);
                xCoordinate += xSpace + width;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void showBackOfEnemyHandsCards(ArrayList<String> cards, JPanel panel, int numOfCardInEveryRow,
                                                 int typeOfBackOfCard) {
        int counter = 0;
        int xCoordinate = 10;
        int yCoordinate = 0;
        int xSapce = 20;
        int ySpace = 10;


        yCoordinate = 10;
        for (String cardsName : cards) {
            counter++;
            PlayPanel playPanel = (PlayPanel) Constant.getPanels().get("PlayPanel");
            CardImagePanel cardImagePanel = null;
            try {
                cardImagePanel = new CardImagePanel(Constant.WIDTH_OF_EACH_CARD_HANDS_CARDS,
                        Constant.HEIGHT_OF_EACH_CARD_HANDS_CARDS, typeOfBackOfCard);
                addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, cardImagePanel.getWidth(),
                        cardImagePanel.getHeight());

                if (counter % numOfCardInEveryRow == 0) {
                    xCoordinate = 10;
                    yCoordinate += cardImagePanel.getHeight() + ySpace;
                } else {
                    xCoordinate += xSapce + Constant.WIDTH_OF_EACH_CARD_HANDS_CARDS;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void showHandsCards(ArrayList<String> cards, JPanel panel, int numOfCardInEveryRow, Alliance alliance) {
        int counter = 0;
        int xCoordinate = 10;
        int yCoordinate = 0;
        int xSpace = 20;
        int ySpace = 10;
        if (alliance.equals(Alliance.BLACK)) {
            yCoordinate = 15;
        } else if (alliance.equals(Alliance.WHITE)) {
            yCoordinate = 690;
        }
        for (String cardsName : cards) {
            counter++;
            CardImagePanel cardImagePanel = null;
            try {
                cardImagePanel = new CardImagePanel(cardsName,
                        Constant.WIDTH_OF_EACH_CARD_HANDS_CARDS,
                        Constant.HEIGHT_OF_EACH_CARD_HANDS_CARDS, true, 1, alliance, counter, "");
//            CardPanel.getInstance().setBackground(Color.white);
                addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, cardImagePanel.getWidth(),
                        cardImagePanel.getHeight());

                if (counter % numOfCardInEveryRow == 0) {
                    xCoordinate = 10;
                    yCoordinate += cardImagePanel.getHeight() + ySpace;
                } else {
                    xCoordinate += xSpace + Constant.WIDTH_OF_EACH_CARD_HANDS_CARDS;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    public static void showBattleGroundCards(ArrayList<String> cards, JPanel panel, int numOfCardInEveryRow, Alliance alliance) {
        int counter = 0;
        int xCoordinate = 50;
        int yCoordinate = 0;
        if (alliance.equals(Alliance.WHITE)) {
            yCoordinate = 395;
        } else if (alliance.equals(Alliance.BLACK)) {
            yCoordinate = 385 - 10 - Constant.HEIGHT_OF_EACH_CARD_HANDS_CARDS;
        }
        int xSapce = 50;
        int ySpace = 10;

        for (int i = 0; i < cards.size(); i++) {
            String cardsName = cards.get(i);
            counter++;
            CardImagePanel cardImagePanel = null;
            try {
                cardImagePanel = new CardImagePanel(cardsName,
                        Constant.WIDTH_OF_EACH_CARD_HANDS_CARDS,
                        Constant.HEIGHT_OF_EACH_CARD_HANDS_CARDS,
                        true, 2, alliance, i + 1);
                cardImagePanel.repaint();
                cardImagePanel.revalidate();

//            CardPanel.getInstance().setBackground(Color.white);
                addPanel(cardImagePanel, panel, xCoordinate, yCoordinate, cardImagePanel.getWidth(),
                        cardImagePanel.getHeight());

//            System.out.println("X: "+xCoordinate+" Y: "+yCoordinate);

                if (counter % numOfCardInEveryRow == 0) {
                    xCoordinate = 100;
                    yCoordinate += cardImagePanel.getHeight() + ySpace;
                } else {
                    xCoordinate += xSapce + Constant.WIDTH_OF_EACH_CARD_GAME_PANEL;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void addPanel(JPanel originPanel, JPanel destinationPanel, int x, int y, int width, int height) {
        originPanel.setBounds(x, y, width, height);
        destinationPanel.add(originPanel);
    }

    public static void addPanel(LittleCardPanel originPanel, JPanel destinationPanel, int x, int y, int width, int height) {
        originPanel.setBounds(x, y, width, height);
        destinationPanel.add(originPanel);
    }


}
