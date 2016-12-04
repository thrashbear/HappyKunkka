import javax.swing.*;

public class MainFrame extends JFrame {
	
	public MainFrame(int difficulty){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setBounds(250, 250, 800, 600);
		
		this.setTitle("HappyKunkka");
		
		this.add(new GamePanel(difficulty));
		
		this.setResizable(false);
		
		this.setVisible(true);
		
		
		
	}
	
}
