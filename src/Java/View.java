//AUTHOR: Matt Tippin
//Student Number: 300066841
//Created for SEG2105

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class View extends JFrame implements ActionListener{
	//The master JPanel that will control the view
	JPanel cards;
	//using full name of List as java.awt.List and java.util.List are both imported
	java.util.List<Patient> patients;
	public View(){
		//Setting close operation and window size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(760,760));
		//initializing the patient list
		patients=new ArrayList<Patient>();
		//All the individual views that will be switched between
		JPanel menu = new JPanel(new GridLayout(0,2,50,50));
		menu.setName("menu");
		JPanel newPat = new JPanel(new GridLayout(0,2,25,50));
		newPat.setName("newPat");
		JPanel newTest = new JPanel();
		newTest.setName("newTest");
		JPanel newSymp = new JPanel();
		newSymp.setName("newSymp");
		JPanel viewPat = new JPanel();
		viewPat.setName("viewPat");
		JPanel addConn = new JPanel();
		addConn.setName("addConn");
		//Cards will control the other panels using CardLayout
		cards = new JPanel(new CardLayout());

		//Calls method to setup menu buttons
		setupMenu(menu);
		setupNewPat(newPat);

		//adding other panels to cards
		cards.add(menu,menu.getName());
		cards.add(newPat,newPat.getName());
		cards.add(newTest,newTest.getName());
		cards.add(newSymp,newSymp.getName());
		cards.add(viewPat,viewPat.getName());
		cards.add(addConn,addConn.getName());

		add(cards);
		//Testing purposes
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards,"menu");

		//addComponentToPane(getContentPane());
		pack();
		setVisible(true);
	}


	private void setupMenu(JPanel menu){
		//Creating components for main menu
		JButton pat = new JButton("NEW PATIENT");
		JButton test = new JButton("NEW TEST");
		JButton symp = new JButton("NEW SYMPTOMS");
		JButton conn = new JButton("NEW CONNECTION");
		JButton viewPatients = new JButton("VIEW PATIENTS");
		//Adding actionListeners
		pat.addActionListener(this);
		test.addActionListener(this);
		symp.addActionListener(this);
		conn.addActionListener(this);
		viewPatients.addActionListener(this);
		//adding components to menu JPanel
		menu.add(pat);
		menu.add(test);
		menu.add(symp);
		menu.add(conn);
		menu.add(viewPatients);
	}
	//Creates and adds components for the "Add Patient" page
	private void setupNewPat(JPanel panel){
		JLabel name = new JLabel("Name: ",SwingConstants.RIGHT);
		JLabel address = new JLabel("Address :",SwingConstants.RIGHT);
		JLabel phone = new JLabel("Phone :",SwingConstants.RIGHT);
		JLabel health = new JLabel("Health Number: ",SwingConstants.RIGHT);
		JTextField nameField = new JTextField();
		JTextField addressField = new JTextField();
		JTextField phoneField = new JTextField();
		JTextField healthField = new JTextField();
		JButton submit = new JButton("Submit Patient");
		JButton cancel = new JButton("Cancel");
		submit.addActionListener(this);
		cancel.addActionListener(this);
		panel.add(name);
		panel.add(nameField);
		panel.add(address);
		panel.add(addressField);
		panel.add(phone);
		panel.add(phoneField);
		panel.add(health);
		panel.add(healthField);
		panel.add(cancel);
		panel.add(submit);
	}
	//returns the currently displayed JFrame
	public JPanel currCard(CardLayout layout){
		JPanel top = null;
		for(Component comp: cards.getComponents()){
			if(comp.isVisible()==true){
				top = (JPanel) comp;
			}
		}
		return top;
	}
	public void actionPerformed(ActionEvent e){
		JButton source = (JButton) e.getSource();
		CardLayout cl = (CardLayout)(cards.getLayout());
		switch(source.getText()){
			case "NEW PATIENT":
				cl.show(cards,"newPat");
				break;
			case "NEW TEST":
				cl.show(cards,"new test");
				break;
			case "NEW SYMPTOMS":
				cl.show(cards,"new symptoms");
				break;
			case "VIEW PATIENTS":
				cl.show(cards,"view patients");
				break;
			case "ADD CONNECTION":
				cl.show(cards,"add connection");
				break;
			case "Cancel":
				//Finds and clears all JTextFields currently displayed
				for(Component comp: currCard(cl).getComponents()){
					if(comp instanceof JTextField){
						((JTextField) comp).setText("");
					}
				}
				cl.show(cards,"menu");
				break;
			case "Submit Patient":
				
				String[] data = new String[4];
				int i =0;
				Boolean flag=true;
				//cycle through all components in displayed JPanel
				for(Component comp: currCard(cl).getComponents()){
					if(comp instanceof JTextField){
						//if an empty textbox is found then show error, else gather input data
						if(((JTextField) comp).getText().equals("")){
							JOptionPane.showMessageDialog(this, "Please fill in all textboxes.","Error",JOptionPane.ERROR_MESSAGE);
							break;
						} else if(i==3){ //special case for health number, to ensure it's an integer
							try{
								data[i]=((JTextField) comp).getText();
								Integer.parseInt(data[3]);
								flag=true;
							} catch(Exception g){
								JOptionPane.showMessageDialog(this, "Health Number MUST be an integer.","Error",JOptionPane.ERROR_MESSAGE);
								flag=false;
								break;
							}
						}else { //gathering input data and increment i by 1
							data[i]=((JTextField) comp).getText();
							i++;
						}
					}
				}
				//create new patient with given data
				if(flag){
					Patient patX = new Patient(data[0],data[1],data[2],Integer.parseInt(data[3]));
					//add patient to master patient list
					patients.add(patX);
					//clear textboxes before leaving
					for(Component comp: currCard(cl).getComponents()){
						if(comp instanceof JTextField){
							((JTextField) comp).setText("");
						}
					}
					//return to main menu
					cl.show(cards,"menu");
				}
				break;
		}
	}

	public static void main(String[] args){
		View window = new View();
	}
}