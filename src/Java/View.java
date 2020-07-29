import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class View extends JFrame implements ActionListener{
	//The master JPanel that will control the view
	JPanel cards;
	public View(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(760,760));
		//All the individual views that will be switched between
		JPanel menu = new JPanel(new GridLayout(0,2,25,25));
		JPanel newPat = new JPanel(new GridLayout(0,2));
		JPanel newTest = new JPanel();
		JPanel newSymp = new JPanel();
		JPanel viewPat = new JPanel();
		JPanel addConn = new JPanel();
		//Cards will control the other panels using CardLayout
		cards = new JPanel(new CardLayout());

		//Adding components to main menu
		JButton pat = new JButton("NEW PATIENT");
		JButton test = new JButton("NEW TEST");
		JButton symp = new JButton("NEW SYMPTOMS");
		JButton conn = new JButton("NEW CONNECTION");
		JButton viewPatients = new JButton("VIEW PATIENTS");

		
		pat.addActionListener(this);
		test.addActionListener(this);
		symp.addActionListener(this);
		conn.addActionListener(this);
		viewPatients.addActionListener(this);
		menu.add(pat);
		menu.add(test);
		menu.add(symp);
		menu.add(conn);
		menu.add(viewPatients);
		//adding other panels to cards
		cards.add(menu,"menu");
		cards.add(newPat,"new patient");
		cards.add(newTest,"new test");
		cards.add(newSymp,"new symptoms");
		cards.add(viewPat,"view patients");
		cards.add(addConn,"add connection");

		add(cards);
		//Testing purposes
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards,"menu");

		//addComponentToPane(getContentPane());
		pack();
		setVisible(true);
	}


	public void actionPerformed(ActionEvent e){
		JButton source = (JButton) e.getSource();
	}

	public static void main(String[] args){
		View window = new View();
	}
}