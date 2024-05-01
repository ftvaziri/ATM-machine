import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM implements ActionListener {
    JFrame frame = new JFrame("ATM");
    Font farFont = new Font("Geeza Pro",  Font.PLAIN, 15);
    JPanel langPanel, passPanel, mainPanel, changePassPanel, availablePanel, cashPanel, transferPanel, successPanel;
    JButton farsiButton, engButton, passButton;
    JButton toChangePassButton, toCashButton, toAvailableButton, toTransferButton;
    JButton changePassButton, transferButton;
    JButton[] cashButton = new JButton[4];
    JLabel farLabel, engLabel, passLabel, changePassLabel, availableLabel, transferAmountLabel, transferNumLabel, successLable;
    JTextField passTextField, changePassTextField, transferAmountTextField, transferNumTextField;
    ATM(){
        frame.setSize(new Dimension(1040, 720));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(3);

        // language panel
        langPanel = new JPanel();
        langPanel.setBounds(20, 310, 1000, 100);
        langPanel.setLayout(new GridLayout(1, 4, 100, 0));

        farsiButton = new JButton("فارسی");
        farsiButton.setFocusable(false);
        farsiButton.addActionListener(this);
        farLabel = new JLabel("زبان خود را انتخاب کنید", SwingConstants.CENTER);

        engButton = new JButton("English");
        engButton.setFocusable(false);
        engLabel = new JLabel("Choose Language", SwingConstants.CENTER);

        langPanel.add(engButton);
        langPanel.add(engLabel);
        langPanel.add(farLabel);
        langPanel.add(farsiButton);

        // password panel

        passPanel = new JPanel();
        passPanel.setBounds(445, 290, 150, 110);
        passPanel.setLayout(new GridLayout(3, 1, 0, 20));

        passLabel = new JLabel("رمز خود را وارد کنید:", SwingConstants.CENTER);
        passLabel.setFont(farFont);
        passTextField = new JTextField();
        passButton = new JButton("ثبت");
        passButton.setFocusable(false);
        passButton.addActionListener(this);

        passPanel.add(passLabel);
        passPanel.add(passTextField);
        passPanel.add(passButton);

        // main panel

        mainPanel = new JPanel();
        mainPanel.setBounds(20, 210, 1000, 300);
        mainPanel.setLayout(new GridLayout(2, 2, 600, 100));

        toChangePassButton = new JButton("تغییر رمز");
        toChangePassButton.setFocusable(false);
        toChangePassButton.addActionListener(this);

        toCashButton = new JButton("برداشت وجه");
        toCashButton.setFocusable(false);
        toCashButton.addActionListener(this);

        toAvailableButton = new JButton("اعلام موجودی");
        toAvailableButton.setFocusable(false);
        toAvailableButton.addActionListener(this);

        toTransferButton = new JButton("کارت به کارت");
        toTransferButton.setFocusable(false);
        toTransferButton.addActionListener(this);

        mainPanel.add(toChangePassButton);
        mainPanel.add(toCashButton);
        mainPanel.add(toAvailableButton);
        mainPanel.add(toTransferButton);

        // changePass panel

        changePassPanel = new JPanel();
        changePassPanel.setBounds(445, 290, 150, 110);
        changePassPanel.setLayout(new GridLayout(3, 1, 0, 20));

        changePassLabel = new JLabel("رمز جدید را وارد کنید:", SwingConstants.CENTER);
        changePassTextField = new JTextField();
        changePassButton = new JButton("تایید");
        changePassButton.setFocusable(false);
        changePassButton.addActionListener(this);

        changePassPanel.add(changePassLabel);
        changePassPanel.add(changePassTextField);
        changePassPanel.add(changePassButton);

        // cash panel

        cashPanel = new JPanel();
        cashPanel.setBounds(20, 210, 1000, 300);
        cashPanel.setLayout(new GridLayout(2, 2, 600, 100));

        cashButton[0] = new JButton("150000");
        cashButton[1] = new JButton("500000");
        cashButton[2] = new JButton("2000000");
        cashButton[3] = new JButton("1000000");

        for (int i = 0; i < 4; i++){
            cashButton[i].setFocusable(false);
            cashButton[i].addActionListener(this);
            cashPanel.add(cashButton[i]);
        }

        // available panel

        availablePanel = new JPanel();
        availablePanel.setBounds(430, 160, 200, 200);
        availablePanel.setLayout(new GridLayout(1, 1));

        availableLabel = new JLabel("موجودی حساب شما: ۴۵۳۴۶۰۰۰ ریال");

        availablePanel.add(availableLabel);

        // transfer panel

        transferPanel = new JPanel();
        transferPanel.setBounds(430, 200, 200, 200);
        transferPanel.setLayout(new GridLayout(5, 1));

        transferAmountLabel = new JLabel("مبلغ مورد نظر را وارد کنید:", SwingConstants.CENTER);
        transferAmountTextField = new JTextField();

        transferNumLabel = new JLabel("شماره کارت مقصد را وارد کنید:", SwingConstants.CENTER);
        transferNumTextField = new JTextField();

        transferButton = new JButton("ثبت");
        transferButton.setFocusable(false);
        transferButton.addActionListener(this);

        transferPanel.add(transferAmountLabel);
        transferPanel.add(transferAmountTextField);
        transferPanel.add(transferNumLabel);
        transferPanel.add(transferNumTextField);
        transferPanel.add(transferButton);

        // success panel

        successPanel = new JPanel();
        successPanel.setBounds(430, 160, 200, 200);
        successPanel.setLayout(new GridLayout(1, 1));

        successLable = new JLabel("عملیات با موفقیت انجام شد!", SwingConstants.CENTER);

        successPanel.add(successLable);


        frame.add(langPanel);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        ATM newATM = new ATM();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == farsiButton){
            frame.remove(langPanel);
            frame.add(passPanel);
            frame.revalidate();
            frame.repaint();
        }
        if (e.getSource() == passButton){
            frame.remove(passPanel);
            frame.add(mainPanel);
            frame.revalidate();
            frame.repaint();
        }
        if (e.getSource() == toChangePassButton) {
            frame.remove(mainPanel);
            frame.add(changePassPanel);
            frame.revalidate();
            frame.repaint();
        }
        if (e.getSource() == changePassButton) {
            frame.remove(changePassPanel);
            frame.add(successPanel);
            frame.revalidate();
            frame.repaint();
        }
        if (e.getSource() == toCashButton) {
            frame.remove(mainPanel);
            frame.add(cashPanel);
            frame.revalidate();
            frame.repaint();
        }
        for (int i = 0; i < 4; i++){
            if (e.getSource() == cashButton[i]) {
                frame.remove(cashPanel);
                frame.add(successPanel);
                frame.revalidate();
                frame.repaint();
            }
        }
        if (e.getSource() == toAvailableButton) {
            frame.remove(mainPanel);
            frame.add(availablePanel);
            frame.revalidate();
            frame.repaint();
        }
        if (e.getSource() == toTransferButton) {
            frame.remove(mainPanel);
            frame.add(transferPanel);
            frame.revalidate();
            frame.repaint();
        }
        if (e.getSource() == transferButton) {
            frame.remove(transferPanel);
            frame.add(successPanel);
            frame.revalidate();
            frame.repaint();
        }
    }
}