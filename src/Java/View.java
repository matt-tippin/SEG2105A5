import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class View implements ActionListener{
	//The master JPanel that will control the view
	JPanel cards;
	public View(){
		//All the individual views that will be switched between
		JPanel newPat = new JPanel();
		JPanel newTest = new JPanel();
		JPanel newSymp = new JPanel();
		JPanel viewPat = new JPanel();
		JPanel addConn = new JPanel();
		//Cards will control the other panels using CardLayout
		cards = new JPanel(new CardLayout());
		//adding other panels to cards
		cards.add(newPat,"new patient");
		cards.add(newTest,"new test");
		cards.add(newSymp,"new symptoms");
		cards.add(viewPat,"view patients");
		cards.add(addConn,"add connection");
	}

	private static void setupWindow(){
		JFrame frame = new JFrame("Pandemic Tracker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		View window = new View();
		frame.pack();
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		
	}
}