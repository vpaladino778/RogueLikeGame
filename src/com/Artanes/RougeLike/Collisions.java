package com.Artanes.RougeLike;

import com.Artanes.RougeLike.entities.creatures.Player;
import com.Artanes.RougeLike.worlds.World;

public class Collisions {

	public static void collisionCheck(Game game, Player player, World world)
	{
		//Scroll through list of BoxColliders for every tile
		for(int i = 0; i < World.colliderList.size(); i++) {
				//Determines is the player is colliding with any tile
				if(player.bounds().intersects(World.colliderList.get(i).bounds())) {
					if(World.colliderList.get(i).getTile().isSolid()) {
						player.setX(Player.xPositions.get(0));
						player.setY(Player.yPositions.get(0));

					}
					//If the player is on the road, increase its speed
					if(World.colliderList.get(i).getTile().isRoad()) {
						player.setSpeed(4);
					} else { //Decrease speed when not on road or in water
						player.setSpeed(3);
					}
					
				}
		}
		//Clears the collider list so it can be filled on the next tick with the updated collider positions
		World.colliderList.clear();
	}
}
