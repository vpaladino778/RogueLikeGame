package com.Artanes.RougeLike;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.Artanes.RougeLike.display.Display;
import com.Artanes.RougeLike.gfx.AssetLoader;
import com.Artanes.RougeLike.gfx.GameCamera;
import com.Artanes.RougeLike.states.GameState;
import com.Artanes.RougeLike.states.States;
import com.Artanes.RougeLike.utils.Utils;

public class Game implements Runnable{
	private Display display;
	
	private Thread thread;
	public boolean running = false;
	public String title;
	private int width, height;
	
	public BufferStrategy bs;
	public Graphics g;
	
	//User Input
	private KeyManager keyManager;

	
	//State
	private States gameState;
	
	
	//Camera
	private GameCamera gameCamera;
	
	public Game(String t, int w, int h)
	{
		height = h;
		width = w;
		title = t;
		keyManager = new KeyManager();

	}
	
	//Method run when initialized
	private void init()
	{
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		AssetLoader.init();
		
		gameCamera = new GameCamera(this,0,0);
		gameState = new GameState(this);
		//menuState = new MenuState(this);
		States.setStates(gameState);
		Utils.playSound("res/sounds/theme.wav");
		}
	
	private void tick()
	{
		keyManager.tick();
		if(States.getState() != null)
			States.getState().tick();
	}
	
	
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw
		
		//Returns the current state and runs the render method within it
		if(States.getState() != null)
			States.getState().render(g);
		
		//End Draw
		bs.show();
		g.dispose();
		
	}
	
	public void run()
	{
		init();
		
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		//Game Loop
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now- lastTime;
			lastTime = now;
			if(delta >= 1)
			{
				tick();
				render();
				ticks++;
				delta--;
			}
			//FPS counter
			if(timer >= 1000000000)
			{
				System.out.println("FPS: " + ticks);
				ticks=0;
				timer = 0;
			}
			
		}
		stop();
	}
	
	public String getTitle() {
		return title;
	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
	
	public GameCamera getGameCamera()
	{
		return gameCamera;
	}
	public synchronized void start()
	{
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		if(running == false)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
