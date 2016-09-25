package com.Artanes.RougeLike.entities.creatures;


import java.awt.Graphics;
import java.awt.Rectangle;

import com.Artanes.RougeLike.Game;
import com.Artanes.RougeLike.gfx.AssetLoader;
import com.Artanes.RougeLike.utils.Utils;

public class Enemy extends Creature{

	private boolean goingDown = true;
	private int relativeX = 0,relativeY = 0;
	public static int patrolHeight = 200;
	private Rectangle attackBoundry;
	private Player player;
	private int attackSpeed = 100;
	private int counter = 0;
	private int playerLevel;
	public Enemy(Game game, float x, float y, int wid, int hei,Player player) {
		super(game, x, y, wid, hei);
		this.player = player;
		playerLevel = player.getLevel();
	}

	public void tick() {
		patrolUp();
		attack();
	}

	
	public void attack()
	{
		counter++;
			if(counter >= attackSpeed)
			{
				bounds();
					if(attackBoundry.intersects(player.bounds()))
					{
						damage = (playerLevel * damage);
						player.health -= damage;
						System.out.println(damage);
						Utils.playSound("res/sounds/hit.wav");

					}
					counter = 0;
			}
			
	}

	//Rectangle that determines if the player can be attacked
	public Rectangle bounds()
	{
		attackBoundry = new Rectangle((int)((x + relativeX)  - game.getGameCamera().getxOffSet() - 15),(int)((y + relativeY)  - game.getGameCamera().getyOffSet() - 15),width + 15, height + 15);
		return attackBoundry;
	}
	//Move the enemy up and down 
	public void patrolUp()
	{
		
		if (goingDown == true){
		    if (relativeY <= 0){
		        goingDown = false;
		        relativeY++;
		    }
		    else {
		    	relativeY--; 
		    }
		}
		else {
		    if (relativeY >= patrolHeight){
		        goingDown = true;
		        relativeY--;
		    }
		    else {
		    	relativeY++;
		    }
		}


	}
		

	public void render(Graphics g) {
		int xPos = (int)((x + relativeX)  - game.getGameCamera().getxOffSet());
		int yPos = (int)((y + relativeY)  - game.getGameCamera().getyOffSet());
		g.drawImage(AssetLoader.enemy,xPos,yPos,width, height, null);

	}

	public static int getPatrolHeight() {
		return patrolHeight;
	}
	
	

}
