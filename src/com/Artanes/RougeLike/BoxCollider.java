package com.Artanes.RougeLike;

import java.awt.Rectangle;

import com.Artanes.RougeLike.tiles.Tile;

public class BoxCollider {

	private int xPos,yPos,width,height;
	private Tile tile;
	public BoxCollider(Tile t, int x, int y, int w, int h)
	{
		tile = t;
		xPos = x;
		yPos = y;
		width = w;
		height = h;
	}
	//Create rectangle from instance variables
	public Rectangle bounds()
	{
		return new Rectangle(xPos,yPos,width,height);
	}
	public Tile getTile()
	{
		return tile;
	}
}
