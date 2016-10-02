package com.Artanes.RougeLike.entities.creatures;

import com.Artanes.RougeLike.Game;
import com.Artanes.RougeLike.entities.Entity;

public abstract class Creature extends Entity {

	//Default creature stats
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_DAMAGE = 3;
	
	public static final int DEFAULT_CREATURE_WIDTH = 32;
	public static final int DEFAULT_CREATURE_HEIGHT = 32;
	
	//Creature Stats
	protected int health;
	protected int damage;
	
	protected float speed;
	protected float xMove, yMove;
	
	public Creature(Game game, float x, float y, int wid, int hei) {
		super(game, x, y,wid,hei);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		damage = DEFAULT_DAMAGE;
		xMove = 0;
		yMove = 0;
	}

	//Add the move speed to the x and y position
	public void move() {
		x += xMove;
		y += yMove;
	}
	
	
	//Accessor and Mutator Methods
	public float getxMove() {
		return xMove;
	}
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}
	public float getyMove() {
		return yMove;
	}
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public float getSpeed() {
		return speed;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
