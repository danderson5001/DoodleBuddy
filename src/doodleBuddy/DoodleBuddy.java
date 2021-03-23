package doodleBuddy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.swing.JFrame;

public class DoodleBuddy extends Main{
	//variables
	int numOf,x,y;
	boolean filled;
	Color color;
	String shape;
	char ifFilled;
	double proportion;
	int r,green,b;
	
	//creation of frames and objects
	BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
	Graphics g = image.getGraphics();
	JFrame frame1 = new JFrame();
	Scanner scan = new Scanner(System.in);
	
	/**
	 * the default constructor initializes the variables
	 * */
	public DoodleBuddy() {
		x=0;
		y=0;
		filled =false;
		color = new Color(100, 100, 100);
		shape = "rectangle";
	}//end of constructor
	
	/**
	 * This method will create a rectangle and 
	 * is called from with in the returnShapeValues(0 method which is called from the setInfo() method
	 * @param x,y sets the location of said object
	 * @param filled sets if it is an outline or filled shape
	 * @param color sets color
	 * @param g gets the Graphics object
	 * @param proportion helps set the size of the object
	 * 
	 * */
	public void drawRectangle( int x, int y, boolean filled, Color color, Graphics g, double proportion) {
		double size = 120/proportion;
		g.setColor(color);
		if(filled) {
			g.fillRect(x,y,(int)size,(int)size);
		}else {
			g.drawRect(x, y,(int)size,(int)size);
		}//end of if filled 
	}//end of drawRect method
	
	/**
	 * This method will create an ellipse and 
	 * is called from with in the returnShapeValues() method which is called from the setInfo() method
	 * @param x,y sets the location of said object
	 * @param filled sets if it is an outline or filled shape
	 * @param color sets color
	 * @param g gets the Graphics object
	 * @param proportion helps set the size of th eobject
	 * 
	 * */
	public void drawEllipse( int x, int y, boolean filled, Color color, Graphics g, double proportion) {
		double size = 120/proportion;
		g.setColor(color);
		if(filled) {
			g.fillOval(x,y,(int)size,(int)size);
		}else {
			g.drawOval(x, y,(int)size,(int)size);
		}//end of if filled 
	}
	
	/**
	 * Collects information from the user
	 * @return values true when the method is complete
	 * */
	public boolean setInfo() {
		//get x,y
		 System.out.println("Please enter the location you would like to put your shape at (x y)");
		 x = scan.nextInt();
		 y = scan.nextInt();
		 
		//get shape
		 System.out.println("Enter shape(circle or square))");
		 shape = scan.next();
		 
		//get filled
		 System.out.println("Would like an outline or filled shape. please enter f or o");
		 ifFilled = (scan.next().toLowerCase()).charAt(0);
		 
		 //gets and sets color
		 System.out.println("Enter three numbers, first a red value, then a green, then a blue");
		 r = scan.nextInt();
		 green = scan.nextInt();
		 b = scan.nextInt();
		 color = new Color(r,green,b);
		 
		 //sets Proportion
		 System.out.println("Please enter the proportion you would like the size divided by");
		 System.out.println("Ex: entering 1 will give you a shape of size 120, the original value");
		 System.out.println("Ex: entering 2 will give you a shape of size 60, the original value");
		 System.out.println("Ex: entering 0.5 will give you a shape of size 240, the original value");
		 
		 
		returnShapeValues();
		return true;
	}

	/**
	 * This method will return the filled value and run either 
	 * 		the drawRectangle or the drawEllipse method
	 * 
	 * 	@throws IndexOutOfBoundsException()
	 * 	@param none
	 *  @returns void
	 * */
	public void returnShapeValues() {
			if(ifFilled == 'f') {
				filled = true;
			}else if(ifFilled == 'o') {
				filled = false;
			}else {
				System.out.println("line:72 && line:66 \n filled values invalid");
				throw new IndexOutOfBoundsException();
			}// checks if filled
		if(shape.trim().toLowerCase().equals("square")) {
			drawRectangle(x,y, filled, color , g, proportion);
		}else if(shape.trim().toLowerCase().equals("circle")) {
			drawEllipse(x,y, filled, color , g, proportion);
		}else {
			System.out.println("You failed to enter a valid shape");
			throw new IndexOutOfBoundsException();
		}
	}
}
