package engine.process;

import config.GameConfiguration;
import engine.dynamic.Avion;
import engine.map.Airport;
import engine.map.Block;
import engine.map.Map;

public class AvionManager extends Thread{
	//
	private Avion avion;
	private Map map;
	private boolean atterminus = false;
	private boolean Flying = false;
	private MobileElementManager mE;
    
	public AvionManager(MobileElementManager mE,Avion avion, Map map) {
		super();
		this.avion = avion;
		this.map = map;
		this.mE = mE;
	}
	public boolean isFlying() {
		return Flying;
	}
	public void setFlying(boolean Flying) {
		this.Flying = Flying;
	}
	public Block getPosition() {
		return avion.getCurrentPosition();
	}
	public Block getArrivale_airport() {
		return avion.getArrivalPosition();
	}
	public String getAvionId() {
		return avion.getId();
	}
	public void updatePosition(Block position) {
		avion.setCurrentPosition(position);
	}
	public boolean isAtTerminus() {
		return atterminus;
	}
	public double getAltitude() {
		return avion.getAltitude();
	}
	public int getHeureDecollage() {
		return avion.getHeureDecollage();
	}
	@Override
	public void run() {
		while(!atterminus && Flying) {
			SimulationUtility.unitTime();
			Block position = avion.getCurrentPosition();
			Airport airport = map.getAirport(position);
			if(airport != null) {
				for(int stay=1;stay<=airport.getDepartTime();stay++) {
					SimulationUtility.unitTime();
				}
			}
		
		// on suppose que tous les avions vont voler ver le deuxieme airport  la periode test
		Block Destination = GameConfiguration.Airport_POSITION[3];
		avion.setArrivalPosition(Destination); //这里之后通过外部获取该飞机飞往哪个地方
		int column_airport = Destination.getColumn();
		int line_airport = Destination.getLine();
		int column_avion = position.getColumn(); 
		int line_avion = position.getLine();
		if(position.equals(Destination)) {	
			atterminus=true;
		}else {
			
			int ecart_column = column_avion-column_airport;
			int ecart_line = line_avion-line_airport;
			if(ecart_column>0) {  		//mettre a jour column
				if(ecart_column > 20) {
					int speed = avion.getSpeed(); // voler suivant la speed normal
					column_avion-=speed;
				}else {
					column_avion-=1;   //atterrir, diminution de vitesse  
				}
			}else if(ecart_column<0){
				if(ecart_column < -20) {
					int speed = avion.getSpeed(); // voler suivant la speed normal
					column_avion+=speed;
				}else {
					column_avion+=1;   //atterrir, diminution de vitesse  
				}
				
			}
			if(ecart_line > 0) {
				if(ecart_line > 20) {
					int speed = avion.getSpeed(); // voler suivant la speed normal
					line_avion-=speed;
				}else {
					line_avion-=1;   //atterrir, diminution de vitesse  
				}
			}else if(ecart_line<0){
				if(ecart_line < -20) {
					int speed = avion.getSpeed(); // voler suivant la speed normal
					line_avion+=speed;
				}else {
					line_avion+=1;   //atterrir, diminution de vitesse  
				}
			}
			updatePosition(new Block(line_avion,column_avion));
		}
		}
		
	}
	
}
