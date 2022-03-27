package labforapp;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App extends JFrame {

    private JFrame frame;
    private JButton popStefan;
    private JButton itemx2;
    private JButton itemplus500;
    private JButton itemx3;
    private JButton itemplus69420;

    private JLabel cntPop;
    private JLabel cntPopBlank;
    private JLabel logo;
    private JLabel priceItem1;
    private JLabel priceItem2;
    private JLabel priceItem3;
    private JLabel priceItem4;

    private long stefanClick = 0;
    private int clicker = 100;
    private int width = 350;
    private int widthFrame = 400;
    private long saleItemx2 = 1000;
    private long saleItemsausage = 20000;
    private long saleItemturtleWave = 50000;
    private long saleItemSulu = 100000;
    private long power = 1;

    private boolean check_button1 = false;
    private boolean check_button2 = false;
    private boolean check_button3 = false;
    private boolean check_button4 = false;

    private ImageIcon stefanImage;
    private ImageIcon iconHaed;
    private ImageIcon dogBurger;
    private ImageIcon peterSausage;
    private ImageIcon turtleWavePower;
    private ImageIcon mrSulu;

    Container container;

    public App() {

        frame = new JFrame("Stefan Clicker ");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        detail();
        frame.setVisible(true);

    }
    
    private void detail() {

        try{
            
            stefanImage = new ImageIcon("labforapp/stefan01.png");
            iconHaed = new ImageIcon("labforapp/logoStefan.png");
            dogBurger = new ImageIcon("labforapp/dogburger.png");
            peterSausage = new ImageIcon("labforapp/dogsausage.png");
            turtleWavePower = new ImageIcon("labforapp/dragondog.png");
            mrSulu = new ImageIcon("labforapp/dogsulu.png");

        }catch(Exception e){}

        // head logo
        logo = new JLabel(iconHaed);
        logo.setPreferredSize(new Dimension(width, 80));

        // label count clicker
        cntPop = new JLabel("  stefanClick: ");
        cntPop.setForeground(Color.WHITE);
        // blank
        cntPopBlank = new JLabel("0");
        cntPopBlank.setForeground(Color.WHITE);

        // popStefan
        popStefan = new JButton(stefanImage);
        popStefan.setPreferredSize(new Dimension(width, 300));
        popStefan.setBackground(null);
        popStefan.setBorder(null);

        // ----- button item -----
        //  item x 2
        itemx2 = new JButton(dogBurger);
        itemx2.setPreferredSize(new Dimension(width, 70));
        //  item + 500
        itemplus500 = new JButton(peterSausage);
        itemplus500.setPreferredSize(new Dimension(width, 70));
        //  item x 3
        itemx3 = new JButton(turtleWavePower);
        itemx3.setPreferredSize(new Dimension(width, 70));
        // item + 69420
        itemplus69420 = new JButton(mrSulu);
        itemplus69420.setPreferredSize(new Dimension(width, 70));

        
        frame.setLayout(new FlowLayout());
        frame.add(logo);
        frame.add(cntPop);
        frame.add(cntPopBlank);
        frame.add(popStefan);

        Listener listener = new Listener();
        popStefan.addActionListener(listener);

    }



    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            JButton source = (JButton) event.getSource();

            if ((source == popStefan)) {

                if(stefanClick < saleItemx2) frame.setSize(400, 500);
                stefanClick += clicker * power;
                cntPopBlank.setText(""+stefanClick);

            } else if ((source == itemx2) && stefanClick >= saleItemx2) {
                
                stefanClick -= saleItemx2;
                saleItemx2 += 500;
                power *= 2;
                cntPopBlank.setText(""+stefanClick);
                priceItem1.setText("Price of Dogburger : "+saleItemx2);
                checkRemoveButton();

            } else if ((source == itemplus500) && stefanClick >= saleItemsausage){

                stefanClick -= saleItemsausage;
                saleItemsausage += 700;
                clicker += 500;
                cntPopBlank.setText(""+stefanClick);
                priceItem2.setText("Price of Saltpeter sausage : "+saleItemsausage);
                checkRemoveButton();

            } else if ((source == itemx3) && stefanClick >= saleItemturtleWave){

                stefanClick -= saleItemturtleWave;
                power *= 3;
                saleItemturtleWave += 1000;
                cntPopBlank.setText(""+stefanClick);
                priceItem3.setText("Price of Turtle Wave Power : "+saleItemturtleWave);
                checkRemoveButton();

            } else if ((source == itemplus69420) && stefanClick >= saleItemSulu){

                stefanClick -= saleItemSulu;
                clicker += 69420;
                saleItemSulu += 7000;
                cntPopBlank.setText(""+stefanClick);
                priceItem4.setText("Price of Mr.Sulu : "+saleItemSulu);
                checkRemoveButton();

            } 

            buildButton();

        }

        private void buildButton(){

            Listener listener = new Listener();

            if(stefanClick >= saleItemx2 && !check_button1){

                if(!itemx2.isVisible()) itemx2.setVisible(true);
                check_button1 = true;
                priceItem1 = new JLabel("Price of Dogburger : "+saleItemx2);
                priceItem1.setForeground(Color.WHITE);
                frame.add(priceItem1);
                frame.setSize(widthFrame, frame.getHeight() + 100);
                frame.add(itemx2);
                itemx2.addActionListener(listener);
    
            }if(stefanClick >= saleItemsausage && !check_button2){

                if(!itemplus500.isVisible()) itemplus500.setVisible(true);
                check_button2 = true;
                priceItem2 = new JLabel("Price of Saltpeter sausage : "+saleItemsausage);
                priceItem2.setForeground(Color.WHITE);
                frame.add(priceItem2);
                frame.setSize(widthFrame, frame.getHeight() + 100);
                frame.add(itemplus500);
                itemplus500.addActionListener(listener);

            }if(stefanClick >= saleItemturtleWave && !check_button3){

                if(!itemx3.isVisible()) itemx3.setVisible(true);
                check_button3 = true;
                priceItem3 = new JLabel("Price of Turtle Wave Power : "+saleItemturtleWave);
                priceItem3.setForeground(Color.WHITE);
                frame.add(priceItem3);
                frame.setSize(widthFrame, frame.getHeight() + 80);
                frame.add(itemx3);
                itemx3.addActionListener(listener);

            }if(stefanClick >= saleItemSulu && !check_button4){

                if(!itemplus69420.isVisible()) itemplus69420.setVisible(true);
                check_button4 = true;
                priceItem4 = new JLabel("Price of Mr.Sulu : "+saleItemSulu);
                priceItem4.setForeground(Color.WHITE);
                frame.add(priceItem4);
                frame.setSize(widthFrame, frame.getHeight() + 80);
                frame.add(itemplus69420);
                itemplus69420.addActionListener(listener);

            }

        }


        private void checkRemoveButton(){

            if(stefanClick < saleItemx2 && check_button1){

                itemx2.setVisible(false);
                priceItem1.setVisible(false);
                frame.setSize(widthFrame, frame.getHeight() - 100);
                check_button1 = false;

            }if(stefanClick < saleItemsausage && check_button2){

                itemplus500.setVisible(false);
                priceItem2.setVisible(false);
                frame.setSize(widthFrame, frame.getHeight() - 100);
                check_button2 = false;

            }if(stefanClick < saleItemturtleWave && check_button3){

                itemx3.setVisible(false);
                priceItem3.setVisible(false);
                frame.setSize(widthFrame, frame.getHeight() - 80);
                check_button3 = false;

            }if(stefanClick < saleItemturtleWave && check_button4){

                itemplus69420.setVisible(false);
                priceItem4.setVisible(false);
                frame.setSize(widthFrame, frame.getHeight() - 80);
                check_button4 = false;

            }

        }
    }

}
