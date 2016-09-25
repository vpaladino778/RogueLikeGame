package com.Artanes.RougeLike.worlds;

import java.awt.Graphics;
import java.util.ArrayList;

import com.Artanes.RougeLike.BoxCollider;
import com.Artanes.RougeLike.Game;
import com.Artanes.RougeLike.entities.creatures.Creature;
import com.Artanes.RougeLike.entities.creatures.Enemy;
import com.Artanes.RougeLike.entities.creatures.Player;
import com.Artanes.RougeLike.tiles.Tile;
import com.Artanes.RougeLike.utils.Utils;

public class World {

	public static ArrayList<BoxCollider> colliderList = new ArrayList<BoxCollider>();
	
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	private int xPosition, yPosition;
	private Game game;
	private int enemyNumber = 5;
	private Player player;
	private boolean renderEnemies;
	public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	public World(Game game, String path,Player player,boolean renderEnemies)
	{
		this.player = player;
		this.game = game;
		this.renderEnemies = renderEnemies;
		
		if (renderEnemies)
		{
			generateEnemies(enemyNumber - 1);
		}
		loadWorld(path);
	}

	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		//Only render tiles on screen
		int xStart = (int) Math.max(0, game.getGameCamera().getxOffSet() / Tile.TILE_WIDTH);
		int yStart = (int) Math.max(0, game.getGameCamera().getyOffSet() / Tile.TILE_HEIGHT);
		int xEnd = (int) Math.min(width, (game.getGameCamera().getxOffSet() + game.getWidth()) / Tile.TILE_WIDTH + 1);
		int yEnd = (int) Math.min(height, (game.getGameCamera().getyOffSet() + game.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++)
		{
			for(int x = xStart; x < xEnd; x++)
			{
				xPosition = (int) (x * Tile.TILE_WIDTH - game.getGameCamera().getxOffSet());
				yPosition = (int) (y * Tile.TILE_HEIGHT - game.getGameCamera().getyOffSet());
				Tile tile = getTile(x,y);
				tile.render(g,xPosition,yPosition);
				colliderList.add(new BoxCollider(tile,xPosition,yPosition, Tile.TILE_WIDTH,Tile.TILE_HEIGHT));
			}
		}
		if(renderEnemies)
		{
		renderEnemies(g);
		}
		
	}
	//Enemy Classes
	
	//Fill enemies arraylist with Enemy objects
	public void generateEnemies(int number)
	{
		for(int i = 0; i < number; i++)
		{
			int yPos = Utils.randInt(0  + Tile.TILE_WIDTH +   Enemy.getPatrolHeight(),game.getHeight());
			int xPos = Utils.randInt(0 + Tile.TILE_WIDTH,game.getWidth() - Tile.TILE_WIDTH);
			Enemy newEnemy = new Enemy(game,xPos,yPos,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT,player);
			enemies.add(newEnemy);
		}
	}
	//Runs the enemies tick and render methods
	public void renderEnemies(Graphics g)
	{
		for(int j = 0; j < enemies.size(); j++)
		{
			enemies.get(j).tick();
			enemies.get(j).render(g);
		}
	}
	
	//Return tile from position in array
	public Tile getTile(int x, int y)
	{
		Tile t = Tile.tiles[tiles[x][y]];
		//Default to a dirtTile if the position is null
		if(t==null)
				return Tile.dirtTile;
		
		return t;
	}
	
	//Load world from file
	private void loadWorld(String path)
	{
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		
		//Converts the 1D array of tiles into a 2D array 
		for(int y= 0; y <height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
				
			}
		}
	}


	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	
}
