package view.gui.panels.CollectionPages;


import controller.Controller;
import utility.constant.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;

public class LittleCardPanel extends JPanel implements MouseListener, Serializable {


    public JLabel getManaLabel() {
        return manaLabel;
    }

    public JLabel getUsedLabel() {
        return usedLabel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public static ArrayList<LittleCardPanel> getAllLittleCardPanels() {
        return allLittleCardPanels;
    }

    private JLabel manaLabel;
    private JLabel usedLabel;
    private JLabel nameLabel;

    private static ArrayList<LittleCardPanel> allLittleCardPanels = new ArrayList<LittleCardPanel>();


    public LittleCardPanel(int mana, String name, int used) {
        setLayout(null);
        setSize(Constant.width, Constant.height);
        manaLabel = new JLabel();
        manaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        manaLabel.setText(mana + "");
        manaLabel.setOpaque(true);
        manaLabel.setBackground(Color.RED);
        manaLabel.setBounds(0, 0, Constant.height, Constant.height);
        nameLabel = new JLabel();
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setText(name);
        nameLabel.setOpaque(true);
        nameLabel.setBackground(Color.ORANGE);
        nameLabel.setBounds(Constant.height, 0,
                (Constant.width - 2 * Constant.height),Constant. height);
        manaLabel.addMouseListener(this);
//        nameLabel.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (SwingUtilities.isLeftMouseButton(e)) {
//                    CollectionController.removeThisCardFromCollectionStatesDeck(LittleCardPanel.this);
//                    ((DeckViewer)Constant.getPanels().get("DeckViewer")).showCardsInDecK();
//
//                }
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });
        usedLabel = new JLabel();
        usedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usedLabel.setText(used + "");
        usedLabel.setOpaque(true);
        usedLabel.setBackground(Color.RED);
        usedLabel.setBounds((Constant.width - Constant.height), 0, Constant.height, Constant.height);
        add(manaLabel);
        add(nameLabel);
        add(usedLabel);
    }

    public static void setAllLittleCardPanels() {
        allLittleCardPanels.clear();
        Controller.getCurrentClient().sendSetAllLittleCardsPanelsRequest();
    }






    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            Controller.getCurrentClient().sendRemoveCardFromDeckToChangeRequest(this.nameLabel.getText());
//            CollectionController.removeThisCardFromCollectionStatesDeck(LittleCardPanel.this);
//            ((DeckViewer)Constant.getPanels().get("DeckViewer")).showCardsInDecK();

        }
    }





    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
