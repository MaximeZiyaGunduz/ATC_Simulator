package engine.process;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import config.GameConfiguration;
import engine.dynamic.Avion;
import engine.map.Airport;
import engine.map.Block;

public class SimulationUtility {
	/**
	 * read a image from an image file
	 * @param filepath the path(from 'src') of the image file
	 * @return the read file
	 *
	 */
	public static Image readImage(String filePath) {
		try {
			return ImageIO.read(new File(filePath));
			
		}catch(IOException e) {
			System.out.println("Can not read the image file");
			return null;
		}
	}
	
	public static int getRandom(int min,int max) {
		return (int)(Math.random()*(max+1-min))+min;
		
	}
	public static Avion generateRandomAvion(String id) {
		return new Avion(id,getRandom(GameConfiguration.GAME_MIN_SPEED,GameConfiguration.GAME_MAX_SPEED),GameConfiguration.Airport_POSITION[getRandom(0, 2)]);
	}
	public static Airport generateRandomAirport(String name,Block position) {
		return new Airport(name,position,getRandom(GameConfiguration.STATION_MIN_STAY,GameConfiguration.STATION_MAX_STAY));
	}
	public static void unitTime() {
		try {
			Thread.sleep(20);
		}catch(InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	public static void windowRefreshTime() {
		try {
			Thread.sleep(200);
		}catch(InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
}
