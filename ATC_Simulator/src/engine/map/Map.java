package engine.map;

import java.util.ArrayList;
import java.util.HashMap;

import engine.process.SimulationUtility;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author tianxiao.liu@cyu.fr
 *
 */
public class Map {
	private ArrayList<Airport> airports = new ArrayList<>();
	
	//HashMap pour list
	private HashMap<Block,Airport> airportMap = new HashMap<>();
	
	private Block[][] blocks;
	
	private int lineCount;
	private int columnCount;

	public Map(int lineCount, int columnCount) {
		this.lineCount = lineCount;
		this.columnCount = columnCount;

		blocks = new Block[lineCount][columnCount];

		for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				blocks[lineIndex][columnIndex] = new Block(lineIndex, columnIndex);
			}
		}
	}
	public void addAirport(String name, Block position) {
		Airport airport = SimulationUtility.generateRandomAirport(name, position);
		airports.add(airport);
		airportMap.put(position, airport);
	}
	public ArrayList<Airport> getAirports(){
		return airports;
	}
	public Airport getAirport(Block position) {
		return airportMap.get(position);
	}
	public Block[][] getBlocks() {
		return blocks;
	}

	public int getLineCount() {
		return lineCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public Block getBlock(int line, int column) {
		return blocks[line][column];
	}

	public boolean isOnTop(Block block) {
		int line = block.getLine();
		return line == 0;
	}

	public boolean isOnBottom(Block block) {
		int line = block.getLine();
		return line == lineCount - 1;
	}

	public boolean isOnLeftBorder(Block block) {
		int column = block.getColumn();
		return column == 0;
	}

	public boolean isOnRightBorder(Block block) {
		int column = block.getColumn();
		return column == columnCount - 1;
	}

	public boolean isOnBorder(Block block) {
		return isOnTop(block) || isOnBottom(block) || isOnLeftBorder(block) || isOnRightBorder(block);
	}

}

