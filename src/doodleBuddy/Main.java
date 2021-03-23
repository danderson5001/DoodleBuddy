package doodleBuddy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.swing.JFrame;

public class Main {
	//variables
	protected int numOf,x,y;
	protected boolean filled;
	protected Color color;
	protected String shape;
	protected char ifFilled;
	protected double proportion;
	protected int r,green,b;
	
	//creation of frames and objects
	protected BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
	protected Graphics g = image.getGraphics();
	protected Scanner scan = new Scanner(System.in);
		
	public Main() {	}
	
	public static void main(String[]args) { 
		DoodleBuddy db = new DoodleBuddy();
		db.setInfo();
	}
}
