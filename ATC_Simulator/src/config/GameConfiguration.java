package config;

import engine.map.Block;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author tianxiao.liu@cyu.fr
 *
 */
public class GameConfiguration {
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 750;
	
	public static final int BLOCK_SIZE = 1;
	
	public static final int LINE_COUNT = WINDOW_HEIGHT / BLOCK_SIZE; //750
	public static final int COLUMN_COUNT = WINDOW_WIDTH / BLOCK_SIZE; //1000
	
	public static final int GAME_MAX_SPEED = 10;
	public static final int GAME_MIN_SPEED = 5;
	public static final int JEUX_DURATION = 200;
	public static final Block[] Airport_POSITION = new Block[] {new Block(100,300),new Block(20,600),new Block(700,950),new Block(400,400)};
	public static final String[] Airport_NAME = new String[] {new String("shanghai"),new String("cdg"),new String("casablanca"),new String("London")};
	public static final int STATION_MIN_STAY= 10;
	public static final int STATION_MAX_STAY= 20;
	public static final int AVION_INTERVAL = 20;

}
