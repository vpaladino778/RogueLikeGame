package com.Artanes.RougeLike.tiles;

import java.awt.image.BufferedImage;

import com.Artanes.RougeLike.gfx.AssetLoader;

public class TreeTile extends Tile{
	String TreeType;
	public TreeTile(int id, String treeType)
	{
		super(getTree(treeType),id);
	}
	public static BufferedImage getTree(String treeType)
	{
		if(treeType.toLowerCase().equals("tree"))
			return AssetLoader.tree;
		if(treeType.toLowerCase().equals("appletree"))
			return AssetLoader.treeApple;
		if(treeType.toLowerCase().equals("evergreen"))
			return AssetLoader.treeEverGreen;
		if(treeType.toLowerCase().equals("bush"))
			return AssetLoader.treeBush;
		if(treeType.toLowerCase().equals("applebush"))
			return AssetLoader.treeAppleBush;

		return AssetLoader.tree;
		
	}
	
	public boolean isSolid()
	{
		return true;
	}
}
