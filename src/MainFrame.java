import javax.swing.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
	
	public MainFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setBounds(250, 250, 800, 600);
		
		this.setTitle("HappyKunkka");
		
		this.add(new GamePanel());
		
		this.setResizable(false);
		
		this.setVisible(true);
		
		
		
	}
	
}
