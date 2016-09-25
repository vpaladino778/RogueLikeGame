package com.Artanes.RougeLike.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	//Get image from path
	public static BufferedImage loadImage(String path)
	{
			try {
				return ImageIO.read(ImageLoader.class.getResource(path));
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("TryCatch Error");
				return null;
			}
			
	}
}
