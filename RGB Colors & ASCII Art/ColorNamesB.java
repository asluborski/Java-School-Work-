//Student Name: Alex Sluborski
//Class: CIS 180-02
//Assignment: Lab 4
//Due Date: 10/19/17

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorNamesB extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	//Create variables for colors and color rgb values
	private Color[] bgColors = { Color.red, Color.green, Color.blue, Color.yellow, Color.cyan, Color.magenta}; //If you want to add White and Black use: Color.white and Color.black
	private String[] strColors = {"(255,0,0)", "(0,255,0)", "(0,0,255)", "(255,255,0)", "(0,255,255)", "(255,0,255)"}; //If you want to add White and Black use: (255,255,255) and (0,0,0)
	
	//Create variables for GUI elements
	private JComboBox<String> colorCombo = new JComboBox<>(strColors);
	private JTextField txtColor = new JTextField("", 10);
	private JPanel backgroundPane = new JPanel();
	
	public ColorNamesB() {
		//Set up the GUI
		super("ColorNamesB");
		backgroundPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
		this.add(backgroundPane);
		
		//Add the combo box to the background pane
		backgroundPane.add(colorCombo);
		colorCombo.setSelectedIndex(0);
		colorCombo.addActionListener(this);
		backgroundPane.setBackground(bgColors[colorCombo.getSelectedIndex()]);
		
		//Add the text field to the background pane
		backgroundPane.add(txtColor);
		txtColor.setEnabled(false);
		txtColor.setText("Red");
		txtColor.setHorizontalAlignment(JTextField.CENTER);
		
		//Set the background pane parameters
		this.setSize(325, 200);
		this.setResizable(false);
		this.setLocationByPlatform(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource(); // Who generated the event?
		
		//If the combo box has changed
		if (source == colorCombo) {
			//Set the background to the selected color
			backgroundPane.setBackground(bgColors[colorCombo.getSelectedIndex()]);
			
			//Get the red, green, and blue values of the color (int red for red value, int green for green value, and int blue for blue value)
			int[] rgb = getRGB(bgColors[colorCombo.getSelectedIndex()]);
			int red = rgb[0];
			int green = rgb[1];
			int blue = rgb[2];
			
			/***********************************************
			 * Develop your if statements under this comment
			 * *********************************************
			 * Remember to have two separate java files for
			 * part a and b.
			 * Also, pay attention to the variables above.
			 * *********************************************
			 * To set the text value, use:
			 * txtColor.setText("YOUR_COLOR_NAME_HERE");
			 **********************************************/
			// Set up RGB colors red, green, and blue using if and else
			if (red == 255) {
			           txtColor.setText("Red");
			}
			else if (green == 255) {
					txtColor.setText("Green");
		    }
			else if (blue == 255) {
					  txtColor.setText("Blue");
			}
			// Set up yellow, cyan, and magenta RGB colors using if/else statements
			if (red == 255) 
			if (green == 255)
			if (blue == 0) {
				txtColor.setText("Yellow");
			}
			if (red == 0)	
			if (green == 255)
			if (blue == 255) {
				txtColor.setText("Cyan");
			}
			if (red == 255) 
			if (green == 0)
			if (blue == 255)
				txtColor.setText("Magenta");
			}
			
			
		}
			
			
			
		
		
	
	public static void main(String[] args) {
		new ColorNamesB();
	}
	
	public int[] getRGB(Color rgb) {
		int[] rgbVals =  new int[3];
		rgbVals[0] = rgb.getRed();
		rgbVals[1] = rgb.getGreen();
		rgbVals[2] = rgb.getBlue();
		return rgbVals;
	}
}

