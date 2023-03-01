package testATC;

import engine.map.Block;
import gui.MainGUI;

public class TestATC {

	public static void main(String[] args) {
		MainGUI gameMainGUI = new MainGUI("ATC_Simulator");

		Thread gameThread = new Thread(gameMainGUI);
		gameThread.start();
	
	}

}
