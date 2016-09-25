package com.Artanes.RougeLike.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.Artanes.RougeLike.Game;
import com.Artanes.RougeLike.gfx.AssetLoader;
import com.Artanes.RougeLike.gfx.GUI;
import com.Artanes.RougeLike.utils.Utils;
import com.Artanes.RougeLike.worlds.World;

public class Player extends Creature 
{
	//Used for collision pusposes
	public static ArrayList<Float> xPositions = new ArrayList<Float>();
	public static ArrayList<Float> yPositions = new ArrayList<Float>();
	public static Rectangle playerBounds;
	public static boolean goingLeft = false, goingRight = false,goingUp = false,goingDown = false;
	
	//Hero Stats
	private int maxHealth = 10;
	private int speed = 3;
	private int level = 1;
	private int exp;
	private int nextLevelExp = level * level;
	
	private World world;
	private int xPos, yPos;
	private int attackCount = 0;
	private int regenCount = 0;
	private boolean gameOver = false;
	private boolean recentlyAttacked = false;
	public Player(Game game, float x, float y) 
	{
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		exp=0;	
	}

	@Override
	public void tick()
	{
		//If the player loses, dont allow them to use controls
		if(gameOver == false)
		{
			getInput();
		}
		move();
		
		//Make the player lose after their health is 0
		if(health <= 0)
		{
			gameOver = true;
		}
		game.getGameCamera().centerOnEntity(this);
		if(regenCount >= 500)
		{
			System.out.println("Health Regenerated");
			regenCount = 0;
			regenHealth();
		} else{
			regenCount++;
		}
		
		
	}
	//Check if the player leveled up
	public void checkLevel()
	{
		if(exp >= nextLevelExp)
		{
			levelUp();
			health = maxHealth;
		}
	}
	//Sets stats when the player levels up and play level up sound
	public void levelUp()
	{
		level++;
		maxHealth += 2;
		damage++;
		nextLevelExp = level * level;
		Utils.playSound("res/sounds/levelup.wav");
	}
	//Gets keyboard input from the player
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up)
		{
			goingUp = true;
			goingDown = false;
			goingLeft = false;
			goingRight = false;
			yMove = -speed;
			updatePositions(x,y);
		}	
		if(game.getKeyManager().down)
		{
			goingUp = false;
			goingDown = true;
			goingLeft = false;
			goingRight = false;
			yMove = speed;
			updatePositions(x,y);
		}
		if(game.getKeyManager().left)
		{
			goingUp = false;
			goingDown = false;
			goingLeft = true;
			goingRight = false;
			xMove = -speed;
			updatePositions(x,y);
		}
		if(game.getKeyManager().right)
		{
			goingUp = false;
			goingDown = false;
			goingLeft = false;
			goingRight = true;
			xMove = speed;
			updatePositions(x,y);
		}
		
		//Show extra stats
		if(game.getKeyManager().shift)
		{
			GUI.showStats = true;
		} else{
			GUI.showStats = false;
		}
		
		//Attack enemy
		if(game.getKeyManager().space)
		{
			//Only allows player to attack after 50 ticks
			if(recentlyAttacked == false)
			{
				attack();
				recentlyAttacked = true;
			}

		}
		if(recentlyAttacked && attackCount >= 35)
		{
			recentlyAttacked = false;
			attackCount = 0;
		}else{
			attackCount++;
		}
		
		
	}

	//If health is less then max health add 1 hp
	public void regenHealth()
	{
		if(health < maxHealth)
		{
			health++;
		}
	}
	public void attack() 
	{
		for(int i = 0; i < world.enemies.size(); i++)
		{
			if(world.enemies.get(i).bounds().intersects(bounds()))
			{
				//Deal damage to player if they are in the attack boundry
				world.enemies.get(i).health -= damage;
				
				Utils.playSound("res/sounds/playerhit.wav");
				}
			//Enemy dies
			if(world.enemies.get(i).health <= 0)
			{
				world.enemies.remove(i);
				world.generateEnemies(1);
				exp += 4;
				checkLevel();
			}
		}
	}

	//Get the world instance
	public void inputWorld(World w)
	{
		world = w;
	}
	//Used to store previous positions of the player for collisions
	public void updatePositions(float x, float y)
	{
		xPositions.add(0,x);
		yPositions.add(0,y);
		if(xPositions.size() > 5)
			xPositions.remove(5);
		
		if(yPositions.size() > 5)
			yPositions.remove(5);
	}

	@Override
	public void render(Graphics g)
	{
		xPos = (int) (x - game.getGameCamera().getxOffSet());
		yPos = (int) (y - game.getGameCamera().getyOffSet());
		g.drawImage(AssetLoader.player,xPos,yPos, width, height, null);
	}
	
	//Returns a rectangle for collision purposes
	public Rectangle bounds()
	{
		Rectangle bounds = new Rectangle(xPos,yPos,width,height);
		playerBounds = bounds;
		return bounds;
	}
	
	

	//Accessors and Mutators
	public int nextLevelExp()
	{
		return nextLevelExp;
	}
	public int getExp()
	{
		return exp;
	}
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	public void setXPos(int x)
	{
		xPos = x;
	}
	public void setYPos(int y)
	{
		yPos = y;
	}
	public int getLevel()
	{
		return level;
	}
	public int getMaxHealth()
	{
		return maxHealth;
	}
	public float getXPos()
	{
		return x;
	}
	public float getYPos()
	{
		return y;
	}
}
