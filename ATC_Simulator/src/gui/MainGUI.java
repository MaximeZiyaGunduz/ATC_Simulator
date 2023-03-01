
package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTextField;
import config.GameConfiguration;
import engine.process.*;
import engine.map.*;


public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);

	private Map map;
	private MobileElementManager manager;
	private ATCDisplay dashboard;
	

	public MainGUI(String title) {
		super(title);
		init();
	}

	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		JTextField textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);

		map = MapBuilder.buildMap();
		manager = MapBuilder.buildInitMobile(map);
		dashboard = new ATCDisplay(map,manager);

		dashboard.setPreferredSize(preferredSize);
		contentPane.add(dashboard, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE); //set up shutdown methode
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}

	@Override
	public void run() {
		int time = 0;
		while (time <= GameConfiguration.JEUX_DURATION*2) {
			SimulationUtility.unitTime();
			if ( time % GameConfiguration.AVION_INTERVAL == 0 && manager.getNextAvion()!=null) {
				AvionManager nextAvion = manager.getNextAvion(); 
				nextAvion.setFlying(true);
				nextAvion.start();
			}
			dashboard.repaint();
			time++;
		}
//		SimulationUtility.windowRefreshTime();
//		manager.stopAllAvions();
		
	}

//	private class KeyControls implements KeyListener {
//
//		@Override
//		public void keyPressed(KeyEvent event) {
//			char keyChar = event.getKeyChar();
//			dashboard.MoveAircraft(keyChar);
//
//		}
//
//		@Override
//		public void keyTyped(KeyEvent e) {
//
//		}
//
//		@Override
//		public void keyReleased(KeyEvent e) {
//
//		}
//	}
//
//	private class MouseControls implements MouseListener {
//
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			int x = e.getX();
//			int y = e.getY();
//
//			dashboard.PutBomb(x, y);
//		}
//
//		@Override
//		public void mousePressed(MouseEvent e) {
//
//		}
//
//		@Override
//		public void mouseReleased(MouseEvent e) {
//
//		}
//
//		@Override
//		public void mouseEntered(MouseEvent e) {
//
//		}
//
//		@Override
//		public void mouseExited(MouseEvent e) {
//
//		}
//	}

}
