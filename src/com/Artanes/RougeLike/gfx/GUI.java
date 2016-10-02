package com.Artanes.RougeLike.gfx;

import com.Artanes.RougeLike.entities.creatures.Player;

import java.awt.*;

public class GUI {
	private Player player;
	
	public static boolean showStats = false;
	private boolean gameOver= false;
	public GUI(Player player)
	{
		this.player = player;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		//Always render this info
		g.drawString("Health: " + player.getHealth() + " / " + player.getMaxHealth(), 10, 20);
		g.drawString("Level: " + player.getLevel(),10,40);
		
		//Show this if key is held
		if(showStats)
		{
			g.drawString("Damage: " + player.getDamage(), 10, 60);
			g.drawString("EXP: " + player.getExp() + " / " + player.nextLevelExp(), 10, 80);
		}
		
		if(player.getHealth() <= 0)
		{
			gameOver = true;
		}
		if(gameOver)
		{
			g.setFont(new Font("TimesRoman", Font.BOLD, 40)); 

			g.drawString("Game Over", 384, 384);
		}
	}

}
