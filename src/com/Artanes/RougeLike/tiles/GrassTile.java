package com.Artanes.RougeLike.tiles;

import java.awt.image.BufferedImage;

import com.Artanes.RougeLike.gfx.AssetLoader;

public class GrassTile extends Tile{

	public GrassTile(int id) {
		super(getGrass(), id);
		// TODO Auto-generated constructor stub
	}
	
	//Returns 1 of 3 grass tiles randomly
	public static BufferedImage getGrass()
	{
		double ran = Math.random();
		if( ran <= .33)
			return AssetLoader.grass1;
		if(ran <= .66)
			return AssetLoader.grass2;
		else
			return AssetLoader.grass3;
	}
	
	

}
