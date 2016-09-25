package com.Artanes.RougeLike.states;

import java.awt.Graphics;

import com.Artanes.RougeLike.Game;

public abstract class States {

	private static States currentState = null;
	
	public static void setStates(States state)
	{
		currentState = state;
	}
	public static States getState()
	{
		return currentState;
	}
	
	protected Game game;
	public States(Game game)
	{
		this.game = game;
	}
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	
}
