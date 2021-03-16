package de.thunderfrog;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class BMI_GUI implements ActionListener {

    private JFrame frame;

    private JTextField txtAge;
    private JTextField txtHeight;
    private JTextField txtWeight;
    private JButton btnCalculate;
    private JLabel lbBMIScore;
    private JLabel lbBMILow;
    private JLabel lbBMIMid;
    private JLabel lbBMIHigh;


    public BMI_GUI(String title){
        frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(385,215);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        //  Label Rand
        Border border = BorderFactory.createLineBorder(Color.black,1);


        //  Komponenten erzeugen
        JLabel lbAge = new JLabel();
        lbAge.setText("Alter:");
        lbAge.setSize(150,20);
        lbAge.setLocation(5,0);
        frame.add(lbAge);

        txtAge = new JTextField(8);
        txtAge.setSize(150,20);
        txtAge.setLocation(5,22);
        frame.add(txtAge);

        JLabel lbHeight = new JLabel();
        lbHeight.setText("Größe:");
        lbHeight.setSize(150,20);
        lbHeight.setLocation(5,47);
        frame.add(lbHeight);

        txtHeight = new JTextField(8);
        txtHeight.setSize(150,20);
        txtHeight.setLocation(5,69);
        frame.add(txtHeight);

        JLabel lbWeight = new JLabel();
        lbWeight.setText("Gewicht:");
        lbWeight.setSize(150,20);
        lbWeight.setLocation(5,99);
        frame.add(lbWeight);

        txtWeight = new JTextField(8);
        txtWeight.setSize(150,20);
        txtWeight.setLocation(5,119);
        frame.add(txtWeight);

        btnCalculate = new JButton("Berechnen");
        btnCalculate.setSize(150,20);
        btnCalculate.setLocation(5,149);
        frame.add(btnCalculate);

        //  AUSWERTUNG -> RECHTS
        JLabel lbScore = new JLabel();
        lbScore.setText("Auswertung");
        lbScore.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        lbScore.setSize(150,20);
        lbScore.setLocation(225,0);
        frame.add(lbScore);

        lbBMILow = new JLabel();
        lbBMILow.setText("  Untergewicht");
        lbBMILow.setSize(100,20);
        lbBMILow.setLocation(225,30);
        lbBMILow.setBorder(border);
        frame.add(lbBMILow);

        lbBMIMid = new JLabel();
        lbBMIMid.setText("  Normalgewicht");
        lbBMIMid.setSize(100,20);
        lbBMIMid.setLocation(225,60);
        lbBMIMid.setBorder(border);
        frame.add(lbBMIMid);

        lbBMIHigh = new JLabel();
        lbBMIHigh.setText("  Übergewicht");
        lbBMIHigh.setSize(100,20);
        lbBMIHigh.setLocation(225,90);
        lbBMIHigh.setBorder(border);
        frame.add(lbBMIHigh);

        lbBMIScore = new JLabel();
        lbBMIScore.setText("Dein Score: 00.00");
        lbBMIScore.setSize(100,20);
        lbBMIScore.setLocation(225,149);
        frame.add(lbBMIScore);

        btnCalculate.addActionListener(this);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!txtAge.getText().equals("") || !txtWeight.getText().equals("") || !txtHeight.getText().equals("")){
            double score = 0;
            double bmi = 0;

            score = Double.parseDouble(txtHeight.getText()) * Double.parseDouble(txtHeight.getText());

            //  Körpergröße in Meter
            score = score / 10000;

            bmi = Double.parseDouble(txtWeight.getText()) / score;

            lbBMIScore.setText("Dein Score: " + new DecimalFormat("#.##").format(bmi));



            //  Alter in int für bessere Verarbeitung
            int age = Integer.parseInt(txtAge.getText());

            if(age < 25){
                if(bmi >= 19 || bmi <= 24){
                    lbBMIMid.setForeground(Color.GREEN);
                    lbBMILow.setForeground(Color.BLACK);
                    lbBMIHigh.setForeground(Color.BLACK);
                }
                if(bmi <= 20){
                    lbBMILow.setForeground(Color.RED);
                    lbBMIMid.setForeground(Color.BLACK);
                    lbBMIHigh.setForeground(Color.BLACK);
                }
                if(bmi >= 25){
                    lbBMIHigh.setForeground(Color.RED);
                    lbBMILow.setForeground(Color.BLACK);
                    lbBMIMid.setForeground(Color.BLACK);
                }
            }
            if(age >= 25 || age <= 64){
                if(bmi >= 22 || bmi <=27){
                    lbBMIMid.setForeground(Color.GREEN);
                    lbBMILow.setForeground(Color.BLACK);
                    lbBMIHigh.setForeground(Color.BLACK);
                }
                if(bmi <= 21){
                    lbBMILow.setForeground(Color.RED);
                    lbBMIMid.setForeground(Color.BLACK);
                    lbBMIHigh.setForeground(Color.BLACK);
                }
                if(bmi >= 28){
                    lbBMIHigh.setForeground(Color.RED);
                    lbBMILow.setForeground(Color.BLACK);
                    lbBMIMid.setForeground(Color.BLACK);
                }
            }
            if(age > 64){
                if(bmi >= 24 || bmi <=29){
                    lbBMIMid.setForeground(Color.GREEN);
                    lbBMILow.setForeground(Color.BLACK);
                    lbBMIHigh.setForeground(Color.BLACK);
                }
                if(bmi <= 23){
                    lbBMILow.setForeground(Color.RED);
                    lbBMIMid.setForeground(Color.BLACK);
                    lbBMIHigh.setForeground(Color.BLACK);
                }
                if(bmi >= 30){
                    lbBMIHigh.setForeground(Color.RED);
                    lbBMILow.setForeground(Color.BLACK);
                    lbBMIMid.setForeground(Color.BLACK);
                }
            }


        }
    }
}
