
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.*;
import java.io.*;

public class GamePanel extends JPanel {
	private Image bg, catcher;
	
	private int cPos;	// CatcherPOSition
	
	private Gift[] gifts;
	
	private int difficulty;
	
	public GamePanel(int difficulty){
		loadRes();
		cPos = 300;
		
		this.difficulty = difficulty;
		
		Timer tmUpdate = new Timer(3000, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				spawnGifts();
			}
			
		});
		tmUpdate.start();
		
		Timer tmDraw = new Timer(50, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				repaint();
			}
			
		});
		tmDraw.start();
		
		this.setFocusable(true);
		
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				switch(arg0.getKeyCode()){
				case KeyEvent.VK_LEFT:
					if(cPos-30 > -48) cPos -= 30;
					else cPos = 752;
					break;
				case KeyEvent.VK_RIGHT:
					if(cPos+30 < 752) cPos+=30;
					else cPos = -48;
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void spawnGifts(){
		int gCount = 0; //GiftCount
		
		for(int i = 0; i < gifts.length; i++){
			if(!gifts[i].isActive){
				if(gCount < difficulty){
					gifts[i].spawn();
					break;
				}
			} else {
				gCount++;
			}
			
		}
		
	}
	
	public void paintComponent(Graphics gr){
		gr.drawImage(bg, 0, 0, 800, 600, null);
		gr.drawImage(catcher, cPos, 410, 180, 170, null);
		
		for(int i=0; i<gifts.length; i++){
			gifts[i].draw(gr);
		}
		
	}
	
	private void loadRes(){
		try{
			bg = ImageIO.read(new File("sprites\\bg.jpg"));
			catcher = ImageIO.read(new File("sprites\\catcher.png"));
			
			gifts = new Gift[2];
			
			for(int i = 0; i < gifts.length; i++){
				gifts[i] = new Gift(ImageIO.read(new File("sprites\\p"+i+".png")));
			}
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
