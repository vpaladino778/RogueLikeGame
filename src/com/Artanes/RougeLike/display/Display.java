package com.Artanes.RougeLike.display;

import java.awt.*;
import javax.swing.JFrame;

public class Display {
	private JFrame frame;
	
	private Canvas canvas;
	
	private String title;
	private int width;
	private int height;
	
	public Display(String t,int w, int h)
	{
		title = t;
		width = w;
		height = h;
		createDisplay();
	}
	
	private void createDisplay()
	{
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	//Acessor methods
	public Canvas getCanvas()
	{
		return canvas;
	}
	public JFrame getFrame()
	{
		return frame;
	}
	
}
