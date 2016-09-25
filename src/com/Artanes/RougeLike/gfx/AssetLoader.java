package com.Artanes.RougeLike.gfx;

import java.awt.image.BufferedImage;

public class AssetLoader {
	public static BufferedImage player,grass1,grass2,grass3,water1,water2,water3,dirt1,dirt2,rock1,rock2,rock3,blank1,tree,treeApple,treeAppleBush,treeBush,treeEverGreen, enemy;
	
	public static void init()
	{
			grass1 = ImageLoader.loadImage("/textures/tiles/tileGrass1.png");
			grass2 = ImageLoader.loadImage("/textures/tiles/tileGrass2.png");
			grass3 = ImageLoader.loadImage("/textures/tiles/tileGrass3.png");
			water1 = ImageLoader.loadImage("/textures/tiles/tileWater1.png");
			water2 = ImageLoader.loadImage("/textures/tiles/tileWater2.png");
			water3 = ImageLoader.loadImage("/textures/tiles/tileWater3.png");
			dirt1 = ImageLoader.loadImage("/textures/tiles/tileDirt1.png");
			dirt2 = ImageLoader.loadImage("/textures/tiles/tileDirt2.png");
			rock1 = ImageLoader.loadImage("/textures/tiles/tileRock1.png");
			rock2 = ImageLoader.loadImage("/textures/tiles/tileRock2.png");
			rock3 = ImageLoader.loadImage("/textures/tiles/tileRock3.png");
			tree = ImageLoader.loadImage("/textures/tiles/tileTree.png");
			treeApple = ImageLoader.loadImage("/textures/tiles/tileTreeApple.png");
			treeBush = ImageLoader.loadImage("/textures/tiles/tileTreeBush.png");
			treeAppleBush = ImageLoader.loadImage("/textures/tiles/tileTreeAppleBush.png");
			treeEverGreen = ImageLoader.loadImage("/textures/tiles/tileTreeEverGreen.png");
			
			blank1 = ImageLoader.loadImage("/textures/tiles/blank1.png");

			enemy = ImageLoader.loadImage("/textures/hero/enemy.png");
			player = ImageLoader.loadImage("/textures/hero/player.png");
	}
}
