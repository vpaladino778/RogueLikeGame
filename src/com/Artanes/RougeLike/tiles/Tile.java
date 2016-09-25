package com.Artanes.RougeLike.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Tile {
	
	//Static Variables
	public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
	
	//Only instantiate each tile once
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile rockTile = new RockTile(2);
	public static Tile waterTile = new WaterTile(3);
	public static Tile blankTile = new blankTile(4);
	public static Tile treeTile = new TreeTile(5,"tree");
	public static Tile treeAppleTile = new TreeTile(6,"appletree");
	public static Tile treeBush = new TreeTile(7,"bush");
	public static Tile treeAppleBush = new TreeTile(8,"applebush");
	public static Tile treeEverGreen = new TreeTile(9,"evergreen");

	
	protected BufferedImage texture;
	protected final int id;
	
	private int xPos, yPos;
	public Tile(BufferedImage tex, int id )
	{
		texture = tex;
		this.id = id;
		tiles[id] = this;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g, int x, int y)
	{
		//Draws the image on the screen
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT,null);
		xPos = x;
		yPos = y;
	}
	//Rectangle used for collisions
	public Rectangle bounds()
	{
		Rectangle bounds = new Rectangle(xPos,yPos,TILE_WIDTH,TILE_HEIGHT);
		return bounds;
	}
	public int getID()
	{
		return id;
	}

	public boolean isWater()
	{
		return false;
	}
	public boolean isRoad()
	{
		return false;
	}
	public boolean isSolid()
	{
		return false;
	}
}
