package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Window extends JFrame {
    private JLabel labelStart = new JLabel("Начало: ");
    private JLabel labelPlace = new JLabel("<- Выбор места.");
    private JLabel labelEnd = new JLabel("<- Конец");
    private JTextField inputStart = new JTextField("");
    private JTextField inputEnd = new JTextField("");
    private JButton Req = new JButton("Проголосовать");
    private JButton Menu = new JButton("Главное меню");
    private  JComboBox comboBox = new JComboBox();

    Window() {
        super("Основное меню");
        Dimension dim = getToolkit().getScreenSize();
        this.setBounds(dim.width/2, dim.height/2, 500, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(7, 7, 7, 7));
        container.add(labelStart);
        container.add(inputStart);
        container.add(comboBox);
        container.add(labelPlace);
        container.add(inputEnd);
        container.add(labelEnd);
        ButtonGroup group = new ButtonGroup();
        group.add(Req);
        Req.addActionListener(new ButtonReqListener());
        container.add(Req);

        //Pairs.addActionListener(new ButtonPairsListener());

        Menu.addActionListener(new ButtonMenuListener());
        container.add(Menu);

        for(String place : Main.places){ // Инициализация мест
            comboBox.addItem(place);
        }

    }

    class ButtonMenuListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            Window.this.dispose();
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.setVisible(true);
        }
    }

//    class ButtonPairsListener implements ActionListener {
//        public void actionPerformed (ActionEvent e) {
//            printPairs(Main.currentUser);
//        }
//    }

    class ButtonReqListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (inputStart.getText().trim().length() > 0 && inputEnd.getText().trim().length() > 0 && comboBox.toString() != "") {
                if (Main.currentUser instanceof Member){
                    Member member = (Member) Main.currentUser;
                    int day = 12;
                    try {
                        member.addRequest(comboBox.getSelectedItem().toString(), day, Integer.parseInt(inputStart.getText().trim()), Integer.parseInt(inputEnd.getText().trim()));

                        for(int i = 0; i < (Main.Users).size(); ++i){
                            if(Main.Users.get(i).getLogin() == member.getLogin()){
                                Main.Users.remove(i);
                                break;
                            }
                        }
                        Main.Users.add(member);
                    }
                    catch (Exception e1){
                        JOptionPane.showMessageDialog(null, "Не правильный ввод", "Error", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Поля ввода должны быть заполнены.", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

//    private void addRequest(String disc, int group, int pairs) {
//        Request r = new Request(Main.currentUser, disc, group, pairs);
//        Main.requests.add(r);
//    }
}