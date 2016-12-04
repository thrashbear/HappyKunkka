import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gift {
	private boolean isActive;
	
	private Image img;
	
	private int x,y;
	
	private Timer tmUpdate;
	
	
	public Gift(Image img){
		this.isActive = false;
		this.img = img;
		
		tmUpdate = new Timer(500, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fall();
			}
			
		});
	}
	
	public void spawn(){
		this.isActive = true;
		this.tmUpdate.start();
		this.y = 0;
		this.x = (int)(Math.random()*700);
	}
	
	private void fall(){
		if(isActive)
			this.y+=6;
		
		if(y+img.getHeight(null)>=420) 
			tmUpdate.stop();
	}
	
	public void draw(Graphics gr){
		if(isActive)
			gr.drawImage(img, x, y, 100, 100, null);
	}
	
	
}
