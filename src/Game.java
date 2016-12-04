import javax.swing.JOptionPane;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		startGame();
	}
	
	private static void startGame(){
		
		int difficulty = 
				Integer.parseInt(
						JOptionPane.showInputDialog(
								null, 
								"Choose your destiny (1 - 7): ", 
								"Game difficulty", 
								1
								)
						);
		if((difficulty>0) && (difficulty<8)){
			MainFrame gw = new MainFrame(difficulty);
		}
	}

}
