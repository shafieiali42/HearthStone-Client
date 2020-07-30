package view.gui.panels.logInPage;


import controller.Controller;
import utility.constant.Constant;
import utility.guiUtilities.ImageBackGround;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LogInPage extends JPanel {

    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JTextField userNameTextField;
    private JPasswordField passwordField;
    private JButton signIn;
    private JButton signUpBtn;
    private JButton exitBtn;
    private ImageBackGround imageBackGround = new ImageBackGround();


    public LogInPage() {
        setSize(Constant.widthOfMainFrame, Constant.heightOfMainFrame);
        setLayout(null);
        setBackground(Color.GRAY);
        initImagePanel();
        initLabelsAndFields();
        initButtons();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        String welcome = "Welcome to HearthStone";
        g2d.setFont(new Font("TimesRoman", Font.ITALIC, 50));
        Rectangle2D bounds = g.getFontMetrics().getStringBounds(welcome, g2d);
        int lengthOfMessage = (int) bounds.getWidth();
        g2d.drawString(welcome, Constant.widthOfMainFrame / 2 + (Constant.widthOfMainFrame / 2 - lengthOfMessage) / 2, 100);
        String message = "Enjoy your time";
        g2d.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        Rectangle2D bounds1 = g.getFontMetrics().getStringBounds(message, g2d);
        int lengthOfMessage1 = (int) bounds1.getWidth();
        g2d.drawString(message, Constant.widthOfMainFrame / 2 + (Constant.widthOfMainFrame / 2 - lengthOfMessage1) / 2, 150);
    }


    private void initButtons() {
        initLogInSignUpButton();
        initExitButton();
    }

    private void initExitButton() {
        exitBtn = new JButton("Exit");
        exitBtn.setSize(100, 40);
        exitBtn.setBounds(Constant.widthOfMainFrame / 2 + (Constant.widthOfMainFrame / 2 - exitBtn.getWidth()) / 2,
                signUpBtn.getY() + 50,
                exitBtn.getWidth(), exitBtn.getHeight());
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(exitBtn);
    }

    private void initLogInSignUpButton() {
        signUpBtn = new JButton("SignUp");
        signIn = new JButton("SignIn");
        signIn.setSize(100, 40);
        signUpBtn.setSize(100, 40);
        signUpBtn.setBounds(Constant.widthOfMainFrame / 2 +
                        (Constant.widthOfMainFrame / 2 - signIn.getWidth() - signUpBtn.getWidth()) / 2 +
                        signIn.getWidth() + 5,
                passwordLabel.getY() + 50, signIn.getWidth(), signIn.getHeight());

        signIn.setBounds(Constant.widthOfMainFrame / 2 + (Constant.widthOfMainFrame / 2 -
                        signIn.getWidth() - signUpBtn.getWidth()) / 2,
                passwordLabel.getY() + 50, signIn.getWidth(), signIn.getHeight());

        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = getUserNameTextField().getText();
                String password = new String(getPasswordField().getPassword());
                Controller.getCurrentClient().sendLogInRequest(userName,password,"SignUp");
            }
        });

        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = getUserNameTextField().getText();
                String password = new String(getPasswordField().getPassword());
                Controller.getCurrentClient().sendLogInRequest(userName,password,"SignIn");
            }
        });

        this.add(signIn);
        this.add(signUpBtn);

    }


    private void initLabelsAndFields() {
        userNameLabel = new JLabel("UserName:");
        passwordLabel = new JLabel("Password:");
        passwordLabel.setText("Password:");
        userNameTextField = new JTextField();
        passwordField = new JPasswordField();
        userNameLabel.setSize(65, 20);
        passwordLabel.setSize(60, 20);
        userNameTextField.setSize(80, 20);
        passwordField.setSize(80, 20);
        userNameLabel.setBounds(Constant.widthOfMainFrame / 2 +
                        (Constant.widthOfMainFrame / 2 - userNameLabel.getWidth() - userNameTextField.getWidth()) / 2,
                350, userNameLabel.getWidth(), userNameLabel.getHeight());
        passwordLabel.setBounds(Constant.widthOfMainFrame / 2 +
                        (Constant.widthOfMainFrame / 2 - userNameLabel.getWidth() - userNameTextField.getWidth()) / 2,
                400, passwordLabel.getWidth(), passwordLabel.getHeight());

        userNameTextField.setBounds(Constant.widthOfMainFrame / 2 +
                        (Constant.widthOfMainFrame / 2 - userNameLabel.getWidth() - userNameTextField.getWidth()) / 2 +
                        userNameLabel.getWidth() + 5,
                350, userNameTextField.getWidth(), userNameTextField.getHeight());
        passwordField.setBounds(Constant.widthOfMainFrame / 2 +
                        (Constant.widthOfMainFrame / 2 - userNameLabel.getWidth() - userNameTextField.getWidth()) / 2 + passwordLabel.getWidth() + 8,
                400, passwordField.getWidth(), passwordField.getHeight());

        this.add(userNameLabel);
        this.add(userNameTextField);
        this.add(passwordLabel);
        this.add(passwordField);
    }

    private void initImagePanel()  {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/main/resources/Assets/LogInImage.jpg"));
            imageBackGround.setSize(Constant.widthOfMainFrame / 2, Constant.heightOfMainFrame);
            imageBackGround.setImageBackGround(image);
            imageBackGround.setBounds(0, 0, imageBackGround.getWidth(), imageBackGround.getHeight());
            this.add(imageBackGround);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public JTextField getUserNameTextField() {
        return userNameTextField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }


}

