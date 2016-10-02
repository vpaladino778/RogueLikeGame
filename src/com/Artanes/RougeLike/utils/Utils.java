package com.Artanes.RougeLike.utils;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Utils {
	
	//Converts Text file into a String
	public static String loadFileAsString(String path)
	{
		StringBuilder builder = new StringBuilder();
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return builder.toString();
	}

	
	//Converts String of numbers into a number
	public static int parseInt(String number)
	{
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
	
	//Generates a random integer between a range
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	//Take a file from the specified path and plays that file
	public static void playSound(String path)
	{
	    try
	    {
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(new File(path)));
	        clip.start();
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
	}
}
