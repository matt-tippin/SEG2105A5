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
	JComboBox patField;
	//using full name of List as java.awt.List and java.util.List are both imported
	java.util.List<Patient> patients;
	public View(){
		//Setting close operation and window size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(760,760));
		//initializing the patient list
		patients=new ArrayList<Patient>();
		//init the combo box
		patField=new JComboBox();
		//All the individual views that will be switched between
		JPanel menu = new JPanel(new GridLayout(0,2,50,50));
		menu.setName("menu");
		JPanel newPat = new JPanel(new GridLayout(0,2,25,50));
		newPat.setName("newPat");
		JPanel newTest = new JPanel(new GridLayout(0,2,25,50));
		newTest.setName("newTest");
		JPanel newSymp = new JPanel(new GridLayout(0,2,25,50));
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
		setupNewTest(newTest);
		setupNewSymp(newSymp);
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

	private void setupNewTest(JPanel panel){
		String[] op = new String[2];
		JLabel type = new JLabel("Type: ",SwingConstants.RIGHT);
		JLabel date = new JLabel("Date: ",SwingConstants.RIGHT);
		JLabel time = new JLabel("Time: ",SwingConstants.RIGHT);
		JLabel location = new JLabel("Location: ",SwingConstants.RIGHT);
		JLabel manu = new JLabel("Manufacturer: ",SwingConstants.RIGHT);
		JLabel lab = new JLabel("Processed at: ",SwingConstants.RIGHT);
		JLabel proc = new JLabel("Processed on: ",SwingConstants.RIGHT);
		JLabel outcome = new JLabel("Outcome: ",SwingConstants.RIGHT);
		JLabel patAss = new JLabel("Patient: ",SwingConstants.RIGHT);
		op[0]="Virus";
		op[1]="Antibody";
		JComboBox typeField = new JComboBox(op);
		JTextField dateField = new JTextField();
		JTextField timeField = new JTextField();
		JTextField locationField = new JTextField();
		JTextField manuField = new JTextField();
		JTextField labField = new JTextField();
		JTextField procField = new JTextField();
		op[0]="False";
		op[1]="True";
		JComboBox outcomeField = new JComboBox(op);
		
		
		//Setting up submit and cancel buttons
		JButton submit = new JButton("Submit Test");
		JButton cancel = new JButton("Cancel");
		submit.addActionListener(this);
		cancel.addActionListener(this);

		//Add components to the panel
		panel.add(type);
		panel.add(typeField);
		panel.add(date);
		panel.add(dateField);
		panel.add(time);
		panel.add(timeField);
		panel.add(location);
		panel.add(locationField);
		panel.add(manu);
		panel.add(manuField);
		panel.add(lab);
		panel.add(labField);
		panel.add(proc);
		panel.add(procField);
		panel.add(outcome);
		panel.add(outcomeField);
		panel.add(patAss);
		//Adds the earlier created combobox
		panel.add(patField);
		panel.add(cancel);
		panel.add(submit);
	}

	private void setupNewSymp(JPanel panel){
		JLabel name = new JLabel("Name: ",SwingConstants.RIGHT);
		JLabel start = new JLabel("Start Date: ",SwingConstants.RIGHT);
		JLabel end = new JLabel("End Date: ",SwingConstants.RIGHT);
		JLabel desc = new JLabel("Description: ",SwingConstants.RIGHT);
		JTextField nameField = new JTextField();
		JTextField startField = new JTextField();
		JTextField endField = new JTextField();
		JTextField descField = new JTextField();

		//Setting up submit and cancel buttons
		JButton submit = new JButton("Submit Symptom");
		JButton cancel = new JButton("Cancel");
		submit.addActionListener(this);
		cancel.addActionListener(this);

		panel.add(name);
		panel.add(nameField);
		panel.add(desc);
		panel.add(descField);
		panel.add(start);
		panel.add(startField);
		panel.add(end);
		panel.add(endField);
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
			case "NEW PATIENT"://Opens patient creation page
				cl.show(cards,"newPat");
				break;
			case "NEW TEST"://Opens test creation page
				//Upon clicking the new test button, we must refresh the list of available patients
				//Creates a new combobox model with the updated String array of patients and applies it 
				DefaultComboBoxModel model = new DefaultComboBoxModel(patients.toArray());
				patField.setModel(model);
				cl.show(cards,"newTest");
				break;
			case "NEW SYMPTOMS":
				cl.show(cards,"newSymp");
				break;
			case "VIEW PATIENTS":
				cl.show(cards,"view patients");
				break;
			case "ADD CONNECTION":
				cl.show(cards,"add connection");
				break;
			case "Cancel": //generalized cancel button
				//Finds and clears all JTextFields currently displayed
				clearBoxes(cl);
				cl.show(cards,"menu");
				break;
			case "Submit Patient": //for the patient creation page
				String[] data = new String[4];
				int i =0;
				Boolean flag=false;
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
					clearBoxes(cl);
					//return to main menu
					cl.show(cards,"menu");
				}
				break;

			case "Submit Test":
				String[] data2 = new String[9];
				Patient hold = null;
				int k =0;
				Boolean flag2=false;
				Test testy = null;
				for(Component comp:currCard(cl).getComponents()){
					if(comp instanceof JTextField){
						if(((JTextField) comp).getText().equals("")){
							JOptionPane.showMessageDialog(this, "Please fill in all textboxes.","Error",JOptionPane.ERROR_MESSAGE);
							break;
						}
						data2[k]=((JTextField)comp).getText();
						k++;
					} else if(comp instanceof JComboBox&&k<8){
						data2[k]=(String)((JComboBox)comp).getSelectedItem();
						k++;
					} else if(comp instanceof JComboBox&&k==8){
						hold = (Patient)((JComboBox)comp).getSelectedItem();
						flag2=true;
					}
				}
				if(data2[0].equals("Virus")&&flag2){
					testy=new VirusTest(data2[1],data2[2],data2[3],data2[0],Boolean.parseBoolean(data2[7]),data2[4],data2[5],data2[6],hold);
					hold.addTest(testy);
					clearBoxes(cl);
					cl.show(cards,"menu");
				} else if(data2[0].equals("Antibody")&&flag2){
					testy=new AntibodyTest(data2[1],data2[2],data2[3],data2[0],Boolean.parseBoolean(data2[7]),data2[4],data2[5],data2[6],hold);
					hold.addTest(testy);
					clearBoxes(cl);
					cl.show(cards,"menu");
				}
				break;

		}
	}
	//Clears all the textfields in the currently displayed JPanel
	private void clearBoxes(CardLayout cl){
		for(Component comp: currCard(cl).getComponents()){
			if(comp instanceof JTextField){
				((JTextField) comp).setText("");
			}
		}
	}
	public static void main(String[] args){
		View window = new View();
	}
}