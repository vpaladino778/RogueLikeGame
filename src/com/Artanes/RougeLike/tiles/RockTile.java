package com.Artanes.RougeLike.tiles;

import java.awt.image.BufferedImage;

import com.Artanes.RougeLike.gfx.AssetLoader;

public class RockTile extends Tile{
	
	public RockTile(int id)
	{
		super(getRock(), id);
		
	}
	
	public static BufferedImage getRock()
	{
		double ran = Math.random();
		if( ran <= .33)
			return AssetLoader.rock1;
		if(ran <= .66)
			return AssetLoader.rock2;
		else
			return AssetLoader.rock3;
	}
	
	@Override
	public boolean isSolid()
	{
		return true;
	}
	
}
