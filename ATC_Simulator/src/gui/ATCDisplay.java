package gui;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import engine.map.Airport;
import engine.process.AvionManager;
import engine.process.MobileElementManager;
import engine.dynamic.Avion;
import engine.map.*;
/* Permet de placer les elements sur la map
 * 
 * 
 */


public class ATCDisplay extends JPanel {

	private static final long serialVersionUID = 1L;
	private MobileElementManager manager;
	private Map map;
	private PaintStrategy paintStrategy = new PaintStrategy();

	public ATCDisplay (Map map,MobileElementManager manager) {
		this.map = map;
		this.manager = manager;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintStrategy.paint(map, g);
		
		ArrayList<Airport> airports = map.getAirports();
		
		for (Airport airport : airports) {
			System.out.println(airport.getName());
			paintStrategy.paint(airport, g);
		}	
		for (AvionManager avionManager : manager.getAvionManager()) {
			paintStrategy.paint(avionManager, g);
		}
		
		
	}
	
	
}
