package com.Artanes.RougeLike.gfx;


import com.Artanes.RougeLike.Game;
import com.Artanes.RougeLike.entities.Entity;

public class GameCamera {


	private float xOffSet,yOffSet;
	private Game game;
	public GameCamera(Game game, float xOff, float yOff)
	{
		this.game = game;
		xOffSet = xOff ;
		yOffSet = yOff ;
	}
	
	//Centers the gameCamera on the entity
	public void centerOnEntity(Entity ent)
	{
		xOffSet = ent.getX() - game.getWidth() / 2 + ent.getWidth() / 2;
		yOffSet = ent.getY() - game.getHeight() / 2 + ent.getHeight() / 2;

	}
	
	//Mutators and Accessors
	public float getxOffSet() {
		return xOffSet;
	}
	public void setxOffSet(float xOffSet) {
		this.xOffSet = xOffSet;
	}
	public float getyOffSet() {
		return yOffSet;
	}
	public void setyOffSet(float yOffSet) {
		this.yOffSet = yOffSet;
	}
}
