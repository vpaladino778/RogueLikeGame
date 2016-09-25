package com.Artanes.RougeLike.states;

import java.awt.Graphics;

import com.Artanes.RougeLike.Collisions;
import com.Artanes.RougeLike.Game;
import com.Artanes.RougeLike.entities.creatures.Player;
import com.Artanes.RougeLike.gfx.GUI;
import com.Artanes.RougeLike.worlds.World;

public class GameState extends States {

	private Player player;
	private GUI gui;
	private World world1Main;
	private World world1Trees;
	private World currentWorld;
	public GameState(Game game)
	{
		super(game);
		player = new Player(game, 100,100);	
		//currentWorld = playersdasdfsfsf33
		gui = new GUI(player);
		world1Main = new World(game, "res/worlds/world1.txt",player,true);
		//Get the instance of the work in the player class
		player.inputWorld(world1Main);
		world1Trees = new World(game,"res/worlds/world1Trees.txt",player,false);
	}
	@Override
	public void tick() 
	{
		world1Main.tick();
		world1Trees.tick();
		player.tick();
	}

	
	//Renderes the gui, world and player. Also checks for collisions
	@Override
	public void render(Graphics g)
	{
	    world1Main.render(g);
		world1Trees.render(g);
		player.render(g);
		gui.render(g);
		Collisions.collisionCheck(game, player, currentWorld);

	}

}
