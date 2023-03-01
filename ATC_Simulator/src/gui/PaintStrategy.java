package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import config.GameConfiguration;
import engine.dynamic.Avion;
import engine.map.Airport;
import engine.map.Block;
import engine.map.Map;
import engine.process.AvionManager;
import engine.process.MobileElementManager;
import engine.process.SimulationUtility;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author tianxiao.liu@cyu.fr
 *
 *CREATION VISUEL
 *
 */
public class PaintStrategy {
	private double angle = 0;
	DecimalFormat df = new DecimalFormat("#.##");
	public void paint(Map map, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block[][] blocks = map.getBlocks();

		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];

				if ((lineIndex + columnIndex) % 2 == 0) {
					graphics.setColor(Color.decode("#EAE0DA"));
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
				}
			}
		}
	}
	
	public void paint(Airport airport,Graphics graphics) {
		Block position = airport.getPosition();
		
		int blockSize = GameConfiguration.BLOCK_SIZE;
	//	Image img = SimulationUtility.readImage("src/Image/avion.jpg");
	
	//	graphics.setFont(new Font("Dialog",Font.PLAIN,25));
	//	graphics.drawImage(img,position.getColumn()*blockSize,position.getLine()*blockSize,x,y,null);
		graphics.setColor(Color.BLUE);
		graphics.fillRect(position.getColumn() * blockSize, position.getLine() * blockSize, blockSize*20, blockSize*20);
		System.out.println(position);	
	}
	
  /*  public void paint(AvionManager avionManager, Graphics graphics) {
    	Block position = avionManager.getPosition();
    	Image img = SimulationUtility.readImage("src/Image/Avion.png");
    	int blockSize = GameConfiguration.BLOCK_SIZE;
    	int y = position.getLine();
    	int x = position.getColumn();
 
    //	graphics.setColor(Color.RED);
	//	graphics.fillRect(position.getColumn() * blockSize, position.getLine() * blockSize, blockSize, blockSize);
    	graphics.drawImage(img,x*blockSize,y*blockSize,20,20,null);
    	
    }*/
    public void paint(AvionManager avionManager, Graphics graphics) {
        Block position = avionManager.getPosition();
        Image img = SimulationUtility.readImage("src/Image/Avion.png");
        int blockSize = GameConfiguration.BLOCK_SIZE;
        int y = position.getLine();
        int x = position.getColumn();
        Block Destination = GameConfiguration.Airport_POSITION[3]; // l'airport temporaire
        System.out.println("airport："+avionManager.getArrivale_airport());
        if (Destination.getColumn() > position.getColumn()) {
            angle = 45;
        }else if (Destination.getColumn() < position.getColumn()) {
            angle = 225;
        }else if (Destination.getLine() < position.getLine()) {
            angle = 315;
        }else if(Destination.getLine() > position.getLine()) {
            angle = 135;
        }  
        Image rotatedImg = rotateImage(img, angle);
        graphics.drawImage(rotatedImg, x * blockSize, y * blockSize, 20,20, null);
        graphics.setColor(Color.black);
        graphics.drawString(df.format(avionManager.getAltitude()), x*blockSize, y*blockSize);
        }
    public static Image rotateImage(Image image, double angle) {
        BufferedImage rotatedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotatedImage.createGraphics();
        g2d.rotate(Math.toRadians(angle), image.getWidth(null) / 2, image.getHeight(null) / 2);
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        return rotatedImage;
    }

	}

