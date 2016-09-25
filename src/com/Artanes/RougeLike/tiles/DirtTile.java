package com.Artanes.RougeLike.tiles;

import com.Artanes.RougeLike.gfx.AssetLoader;

public class DirtTile extends Tile{

	public DirtTile(int id)
	{
		super(AssetLoader.dirt1,id);
	}
	//Determine if tile is a road
	@Override
	public boolean isRoad()
	{
		return true;
	}
}
