package com.Artanes.RougeLike.entities;

import com.Artanes.RougeLike.Game;

import java.awt.*;

public abstract class Entity {
	
	protected float x, y;
	protected Game game;
	protected int width,height;
	//Starting Position of entity
	public Entity(Game game, float x, float y, int wid, int hei) {
		this.game = game;
		width = wid;
		height = hei;
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

	//Accessors and Mutators Methods
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
