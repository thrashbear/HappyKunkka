
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.*;
import java.io.*;

public class GamePanel extends JPanel {
	private Image bg, catcher;
	
	private int cPos;	// CatcherPOSition
	
	public GamePanel(){
		loadRes();
		cPos = 300;
		
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
	
	public void paintComponent(Graphics gr){
		gr.drawImage(bg, 0, 0, 800, 600, null);
		gr.drawImage(catcher, cPos, 410, 180, 170, null);
	}
	
	private void loadRes(){
		try{
			bg = ImageIO.read(new File("sprites\\bg.jpg"));
			catcher = ImageIO.read(new File("sprites\\catcher.png"));
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
