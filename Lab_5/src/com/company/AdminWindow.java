package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class AdminWindow extends JFrame{
    private JLabel countGroups = new JLabel("Название места: ");
    private JTextField inputPlace = new JTextField("");
    private JButton buttonSet = new JButton("Добавить место");
    private JButton buttonReq = new JButton("Получить отчёт");

    AdminWindow() {
        super("Меню администратора");
        Dimension dim = getToolkit().getScreenSize();
        this.setBounds(dim.width/2, dim.height/2, 350, 125);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));

        container.add(countGroups);
        container.add(buttonReq);
        buttonReq.addActionListener(new ButtonPrintListener());
        container.add(inputPlace);
        buttonSet.addActionListener(new ButtonRegisterEventListener());
        container.add(buttonSet);
    }

    class ButtonRegisterEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (inputPlace.getText().trim().length() > 0){
                Main.places.add(inputPlace.getText().trim());
                inputPlace.setText("");
            }
//            AdminWindow.this.dispose();
        }

        public void print(ActiveEvent e){

        }
    }

    class ButtonPrintListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            ArrayList<Request> SavedCommon = processRequests();
            String otc = "";
            for(Request req : SavedCommon){
                otc += ("Место: " + req.getPlace() + "\n" + "Начальное время: " +req.getStartHour() + "\n" + "Конечное вермя: " +req.getEndHour() + "\n");
            }
            JOptionPane.showMessageDialog(null, otc, "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

   private ArrayList<Request> processRequests(){
        ArrayList<Request> CommonRequests = null;

        for (User us : Main.Users) {
            if (us instanceof Member) {
                Member mmbr = (Member)us;

                if (CommonRequests == null) {
                    CommonRequests = mmbr.requests;
                }
                else {
                    ArrayList<Request> SavedCommon = new ArrayList<>();

                    for (Request BufRequest : CommonRequests) {
                        for (Request request : mmbr.requests) {

                            if (request.getPlace().compareTo(BufRequest.getPlace()) == 0 && !SavedCommon.contains(BufRequest)) {

                                if (request.getDay() == BufRequest.getDay()) {

                                    if (request.getStartHour() > BufRequest.getStartHour()) {
                                        BufRequest = new Request(BufRequest.getPlace(), BufRequest.getDay(), request.getStartHour(), BufRequest.getEndHour());
                                    }
                                    if (request.getEndHour() < BufRequest.getEndHour()) {
                                        BufRequest = new Request(BufRequest.getPlace(), BufRequest.getDay(), BufRequest.getStartHour(), request.getEndHour());
                                    }

                                    if (BufRequest.getStartHour() <= BufRequest.getEndHour()) {
                                        SavedCommon.add(BufRequest);
                                    }
                                }
                            }
                        }
                    }

                    CommonRequests = new ArrayList<>();

                    for (Request BufRequest : SavedCommon) {
                        CommonRequests.add(BufRequest);
                    }

                }
                 mmbr.requests = new ArrayList<>();
            }
        }

        return CommonRequests;
    }
}