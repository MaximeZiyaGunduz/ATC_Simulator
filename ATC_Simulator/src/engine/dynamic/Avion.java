package engine.dynamic;

import engine.map.Block;

public class Avion extends MobileElement {
    private String id;
    private int speed;
    private Block CurrentPosition;
    private Block ArrivalPosition;
    private int HeureDecollage;
    private double Altitude = 0;
	public Avion(String id,int speed,Block position) {
		super(position);
		CurrentPosition = position;
		this.id = id;
		this.speed = speed;
	}
	public String getId() {
		return id;
	}
	public int getSpeed() {
		return speed;
	}
	public Block getCurrentPosition() {
		return CurrentPosition;
	}
	public void setCurrentPosition(Block currentPosition) {
		CurrentPosition = currentPosition;
	}
	public Block getArrivalPosition() {
		return ArrivalPosition;
	}
	public void setArrivalPosition(Block arrivalPosition) {
		ArrivalPosition = arrivalPosition;
	}
	public int getHeureDecollage() {
		return HeureDecollage;
	}
	public double getAltitude() {
		return Altitude;
	}
	public void setHeureDecollage(int heureDecollage) {
		HeureDecollage = heureDecollage;
	}
	public void setAltitude(double altitude) {
		Altitude = altitude;
	}
	
	
}
