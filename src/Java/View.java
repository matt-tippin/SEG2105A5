//AUTHOR: Matt Tippin
//Student Number: 300066841
//Created for SEG2105

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class View extends JFrame implements ActionListener{
	//The master JPanel that will control the view
	private JPanel cards;
	private JComboBox patField,patField2,patField3,patField4,patField5;
	//using full name of List as java.awt.List and java.util.List are both imported
	private java.util.List<Patient> patients;
	public View(){
		//Setting close operation and window size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(900,900));
		//initializing the patient list
		patients=new ArrayList<Patient>();
		//init the combo box
		patField=new JComboBox();
		patField2=new JComboBox();
		patField3=new JComboBox();
		patField4=new JComboBox();
		patField5=new JComboBox();
		//All the individual views that will be switched between
		JPanel menu = new JPanel(new GridLayout(0,2,50,50));
		menu.setName("menu");
		JPanel newPat = new JPanel(new GridLayout(0,2,25,50));
		newPat.setName("newPat");
		JPanel newTest = new JPanel(new GridLayout(0,2,25,50));
		newTest.setName("newTest");
		JPanel newSymp = new JPanel(new GridLayout(0,2,25,50));
		newSymp.setName("newSymp");
		JPanel viewPat = new JPanel(new GridLayout(0,2,25,50));
		viewPat.setName("viewPat");
		JPanel addConn = new JPanel(new GridLayout(0,2,25,100));
		addConn.setName("addConn");
		//Cards will control the other panels using CardLayout
		cards = new JPanel(new CardLayout());

		//Calls method to setup menu buttons
		setupMenu(menu);
		setupNewPat(newPat);
		setupNewTest(newTest);
		setupNewSymp(newSymp);
		setupNewConn(addConn);
		setupViewPat(viewPat);
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
		JLabel pat = new JLabel("Patient: ",SwingConstants.RIGHT);
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
		panel.add(pat);
		panel.add(patField2);
		panel.add(cancel);
		panel.add(submit);
	}

	public void setupNewConn(JPanel panel){
		//Creating labels for the page
		JLabel p1=new JLabel("Person 1: ",SwingConstants.RIGHT);
		JLabel p2=new JLabel("Person 2: ",SwingConstants.RIGHT);
		//Setting up submit and cancel buttons
		JButton submit = new JButton("Submit Connection");
		JButton cancel = new JButton("Cancel");
		submit.addActionListener(this);
		cancel.addActionListener(this);
		panel.add(p1);
		panel.add(patField3);
		panel.add(p2);
		panel.add(patField4);
		panel.add(cancel);
		panel.add(submit);
	}

	public void setupViewPat(JPanel panel){
		//Creating labels
		JLabel pat=new JLabel("Patient: ",SwingConstants.RIGHT);
		JLabel name = new JLabel("Name: ",SwingConstants.RIGHT);
		JLabel address = new JLabel("Address :",SwingConstants.RIGHT);
		JLabel phone = new JLabel("Phone :",SwingConstants.RIGHT);
		JLabel health = new JLabel("Health Number: ",SwingConstants.RIGHT);
		JLabel tests = new JLabel("Tests: ",SwingConstants.RIGHT);
		JLabel symps = new JLabel("Symptoms: ",SwingConstants.RIGHT);
		JLabel cont = new JLabel("Had contact with: ",SwingConstants.RIGHT);
		//Creating uneditable text fields to display info, as well as setting wrap to be on.
		JTextField nameField = new JTextField();
		JTextField addressField = new JTextField();
		JTextField phoneField = new JTextField();
		JTextField healthField = new JTextField();
		JTextArea testField = new JTextArea();
		testField.setLineWrap(true);
		testField.setWrapStyleWord(true);
		JTextArea sympField = new JTextArea();
		sympField.setLineWrap(true);
		sympField.setWrapStyleWord(true);
		JTextArea contField = new JTextArea();
		contField.setLineWrap(true);
		contField.setWrapStyleWord(true);


		nameField.setEditable(false);
		addressField.setEditable(false);
		phoneField.setEditable(false);
		healthField.setEditable(false);

		//Setup cancel and update button
		JButton cancel = new JButton("Cancel");
		JButton update = new JButton("Update");
		cancel.addActionListener(this);
		update.addActionListener(this);

		//add components
		panel.add(pat);
		panel.add(patField5);
		panel.add(name);
		panel.add(nameField);
		panel.add(address);
		panel.add(addressField);
		panel.add(phone);
		panel.add(phoneField);
		panel.add(health);
		panel.add(healthField);
		panel.add(tests);
		panel.add(testField);
		panel.add(symps);
		panel.add(sympField);
		panel.add(cont);
		panel.add(contField);
		panel.add(cancel);
		panel.add(update);
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
		//Upon clicking a new button, we must refresh the list of available patients
		//Creates a new combobox model with the updated String array of patients and applies it in cases that require it
		DefaultComboBoxModel model = new DefaultComboBoxModel(patients.toArray());
		DefaultComboBoxModel model2 = new DefaultComboBoxModel(patients.toArray());
		
		switch(source.getText()){
			case "NEW PATIENT"://Opens patient creation page
				cl.show(cards,"newPat");
				break;
			case "NEW TEST"://Opens test creation page
				patField.setModel(model);
				cl.show(cards,"newTest");
				break;
			case "NEW SYMPTOMS":
				patField2.setModel(model);
				cl.show(cards,"newSymp");
				break;
			case "VIEW PATIENTS":
				patField5.setModel(model);
				cl.show(cards,"viewPat");
				break;
			case "NEW CONNECTION":
				patField3.setModel(model);
				patField4.setModel(model2);
				cl.show(cards,"addConn");
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

			case"Submit Symptom":
				String[] data3 = new String[4];
				int j = 0;
				Patient hold2 = null;
				Boolean flag3=false;
				for(Component comp:currCard(cl).getComponents()){
					if(comp instanceof JTextField){
						if(((JTextField) comp).getText().equals("")){
							JOptionPane.showMessageDialog(this, "Please fill in all textboxes.","Error",JOptionPane.ERROR_MESSAGE);
							break;
						} else {
							data3[j]=((JTextField) comp).getText();
							j++;
						}
					} else if(comp instanceof JComboBox){
						hold2=(Patient)((JComboBox)comp).getSelectedItem();
						j++;
						flag3=true;
					}
				}
				if(flag3){
					Symptom smp = new Symptom(data3[3],data3[2],data3[0],data3[1]);
					hold2.addSymptom(smp);
					clearBoxes(cl);
					cl.show(cards,"menu");
				}
				break;

			case"Submit Connection":
				Patient[] holder = new Patient[2];
				int l=0;
				for(Component comp:currCard(cl).getComponents()){
					if(comp instanceof JComboBox){
						holder[l]=(Patient)((JComboBox)comp).getSelectedItem();
						l++;
					}
				}
				if(holder[0]==holder[1]){
					JOptionPane.showMessageDialog(this, "Please select to DISTINCT patients.","Error",JOptionPane.ERROR_MESSAGE);
				} else {
					holder[0].addContactList(holder[1]);
					holder[1].addContactList(holder[0]);
					cl.show(cards,"menu");
				}
				break;

			case"Update":
				Patient viewed = null;
				int o = 0;
				String tests="";
				String sym="";
				String cont="";
				for(Component comp:currCard(cl).getComponents()){
					if(comp instanceof JComboBox){
						viewed=(Patient)((JComboBox)comp).getSelectedItem();
						for(Test testt: viewed.getTests()){
							tests=tests+testt.toString();
							tests=tests+"\n";
						}
						for(Symptom symm: viewed.getSymptoms()){
							sym=sym+symm.toString();
							sym=sym+"\n";
						}
						for(Patient connn: viewed.getContactList()){
							cont=cont+connn.toString();
							cont=cont+"\n";
						}
					}
					if(comp instanceof JTextField){
						switch(o){
							case 0:
								((JTextField)comp).setText(viewed.getName());
								o++;
								break;
							case 1:
								((JTextField)comp).setText(viewed.getAddress());
								o++;
								break;
							case 2:
								((JTextField)comp).setText(viewed.getPhoneNumber());
								o++;
								break;
							case 3:
								((JTextField)comp).setText(Integer.toString(viewed.getHealthNumber()));
								o++;
								break;
						}
					}
					if(comp instanceof JTextArea){
						switch(o){
							case 4:
								((JTextArea)comp).setText(tests);
								o++;
								break;
							case 5:
								((JTextArea)comp).setText(sym);
								o++;
								break;
							case 6:
								((JTextArea)comp).setText(cont);
								o++;
								break;
						}
					}
				}
		}
	}
	//Clears all the textfields in the currently displayed JPanel
	private void clearBoxes(CardLayout cl){
		for(Component comp: currCard(cl).getComponents()){
			if(comp instanceof JTextField){
				((JTextField) comp).setText("");
			}
			if(comp instanceof JTextArea){
				((JTextArea)comp).setText("");
			}
		}
	}
	public static void main(String[] args){
		View window = new View();
	}
}