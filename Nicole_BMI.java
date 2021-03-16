package bmi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Nicole_BMI  extends JFrame implements ActionListener, MouseListener  {
	private JFrame frame;
    private JTextField weight, height, age, bmi, eval;
    private JButton calculateBtn;
    
    public Nicole_BMI() {
    	frame = new JFrame();
    	frame.pack();
        frame.setTitle("BMI-Tron-3000");
        frame.setLocation(100, 200);
        frame.setMinimumSize(new Dimension(480, 320));
        frame.setLayout(new GridLayout(2,3));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	weight = new JTextField(7);
    		weight.setText("kg");
    		weight.setFont(new Font("Verdana", Font.ITALIC, 13));
        	weight.setForeground(Color.gray);
    	height = new JTextField(7);
			height.setText("m");
			height.setFont(new Font("Verdana", Font.ITALIC, 13));
	    	height.setForeground(Color.gray);
    	age = new JTextField(7);
			age.setText("alter");
			age.setFont(new Font("Verdana", Font.ITALIC, 13));
	    	age.setForeground(Color.gray);
	    calculateBtn = new JButton();
        	calculateBtn.setText("Berechne BMI");
        	calculateBtn.setFont(new Font("Alien Encounters", Font.PLAIN, 13));
        	calculateBtn.setBackground(Color.white);
    	bmi = new JTextField(7);
	    	bmi.setText("BMI");
	    	bmi.setFont(new Font("Verdana", Font.ITALIC, 13));
	    	bmi.setForeground(Color.gray);
    	eval = new JTextField(7);
	    	eval.setText("Wertung");
	    	eval.setFont(new Font("Verdana", Font.ITALIC, 13));
	    	eval.setForeground(Color.gray);
	    
	    frame.add(weight);
	    frame.add(height);
	    frame.add(age);
	    frame.add(calculateBtn);
	    frame.add(bmi);
	    frame.add(eval);
        frame.setVisible(true);
        
        height.addMouseListener(this);
        weight.addMouseListener(this);
        age.addMouseListener(this);
        bmi.addMouseListener(this);
        eval.addMouseListener(this);
        calculateBtn.addActionListener(this);	
    }
    
    public static void main(String[] args) {
        new Nicole_BMI();
    }

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(!(weight.getText().equals("")) & !(height.getText().equals("")) & !(age.getText().equals(""))) {
            double weightDouble = Double.parseDouble(weight.getText());
            double heightDouble = Double.parseDouble(height.getText());
            int ageInt = Integer.parseInt(age.getText());
            bmi.setText(String.valueOf(weightDouble / (heightDouble * heightDouble)));
            
            double bmiDouble = Double.parseDouble(bmi.getText());
    		int low, high;
    		if(ageInt > 64) {
    			low = 24;
    			high = 29;
    		} else if(ageInt < 25 ) {
    			low = 19;
    			high = 24;
    		} else {
    			low = 22;
    			high = 27;
    		}
    		if(bmiDouble < low) {
    			eval.setText("Untergewicht");
    			eval.setForeground(Color.red);
    		} else if (bmiDouble > high) {
    			eval.setText("Uebergewicht");
    			eval.setForeground(Color.red);
    		} else {
    			eval.setText("Normalgewicht");
    			eval.setForeground(Color.green);
    		}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		height.setText("");
	    	height.setFont(new Font("Verdana", Font.PLAIN, 13));
	    	height.setForeground(Color.black);
		weight.setText("");
	    	weight.setFont(new Font("Verdana", Font.PLAIN, 13));
	    	weight.setForeground(Color.black);
		age.setText("");
			age.setFont(new Font("Verdana", Font.PLAIN, 13));
			age.setForeground(Color.black);	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}


