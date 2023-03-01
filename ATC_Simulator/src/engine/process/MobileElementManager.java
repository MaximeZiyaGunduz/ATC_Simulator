package engine.process;


import java.util.ArrayList;

import config.GameConfiguration;
import engine.dynamic.Avion;
import engine.map.*;

public class MobileElementManager {
	private Map map;
	private ArrayList<AvionManager> avionManagers = new ArrayList<AvionManager>();
	
	public MobileElementManager(Map map) {
		this.map = map;
		int AvionCount = GameConfiguration.JEUX_DURATION/GameConfiguration.AVION_INTERVAL;
		for(int i=1;i<=AvionCount;i++) {
			Avion avion = SimulationUtility.generateRandomAvion("U00"+i);
			AvionManager avionmanager = new AvionManager(this,avion,map);
			avionManagers.add(avionmanager);
		}
	}
	public void stopAllAvions() {
		for(AvionManager avionmanager:avionManagers) {
			avionmanager.setFlying(false);
		}
	}
	
	public ArrayList<AvionManager> getAvionManager(){
		return avionManagers;
	}
	
	public AvionManager getNextAvion() {
		for(AvionManager avionManager : avionManagers) {
			if(!avionManager.isFlying()) {
				return avionManager;
			}
		}
		return null;
	}
	
	public Map getMap() {
		return map;
	}
	
}


