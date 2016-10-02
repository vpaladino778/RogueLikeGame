package com.Artanes.RougeLike.tiles;

import com.Artanes.RougeLike.gfx.AssetLoader;

import java.awt.image.BufferedImage;

public class WaterTile extends Tile{
	
	public WaterTile(int id) {
		super(getWater(), id);
		
	}
	//Returns random water tile
	public static BufferedImage getWater() {
		double ran = Math.random();
		if( ran <= .33)
			return AssetLoader.water1;
		if(ran <= .66)
			return AssetLoader.water2;
		else
			return AssetLoader.water3;
	}
	
	@Override
	public boolean isSolid()
	{
		return true;
	}
	
}
