package engine.map;

//import java.util.ArrayList;
//import java.util.Queue;

import engine.dynamic.MobileElement;

public class Airport extends MobileElement {
	
	
//	ArrayList<airplane> airplanes;
//	Queue<airplane> airplanesQueue;
//  int pistes;

	private String name;
//	private Block position;
	private int departTime;
	public Airport(String name, Block position, int departTime) {
		super(position);
		this.name=name;
		this.departTime=departTime;
	}
	public String getName() {
		return name;
	}
	public int getDepartTime() {
		return departTime;
	}

}

	



