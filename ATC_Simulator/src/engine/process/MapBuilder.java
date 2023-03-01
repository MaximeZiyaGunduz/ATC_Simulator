package engine.process;


import config.GameConfiguration;
import engine.map.*;


/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author CHEN Junjie
 * @time 25/2/2023
 *
 */
public class MapBuilder {
	public static Map buildMap() {
		return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}

	public static MobileElementManager buildInitMobile(Map map) {
		MobileElementManager manager = new MobileElementManager(map);	
		intializeAirports(map);
		return manager;
	}

	private static void intializeAirports(Map map) {
		int AirportNumber = 1;
		for(Block airportPosition : GameConfiguration.Airport_POSITION) {
			  map.addAirport(GameConfiguration.Airport_NAME[AirportNumber-1]+AirportNumber, airportPosition);
			  AirportNumber++;
		}
	}
	
	

}