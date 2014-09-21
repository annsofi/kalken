package se.annsofi.kalken;
/*****************************************************
TNM040
Authors: Annsofi Pettersson & Gabriella Ivarsson
University of Linköping - Campus Norrköping
*****************************************************/


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.applet.*; //to handle sounds
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.border.LineBorder; //a border class

import java.lang.Object.*;



public class Kalken extends JFrame implements ActionListener {

private static int sum=0, number=0, random=0, points=0;
private boolean first = true;
private static Object button;
private static int level=1, integer1 = 0, integer2 = 0;
private ClassLoader cl;
private static int THRESHOLD = 50;
private static int ROOF = 20;
private GameBoard board;
	
	public Kalken() {
		cl = ClassLoader.getSystemClassLoader();
	//----------------------------MENU-----------------------------------//
	    setUpMenu();	

		JPanel pnlWest =  setUpNumberPadPanel();
			
		
		board = new GameBoard.Builder()
		.lblLevel(setLabelFont(new JLabel("Level 1"), new Font("Arial Rounded MT Bold", Font.PLAIN, 13)))
		.lblPoints(setLabelFont(new JLabel("Poäng"), new Font("Arial Rounded MT Bold", Font.PLAIN, 13)))
		.lblNrpoints(setLabelFont(new JLabel("0"), new Font("Courier", Font.BOLD, 18)))
		.lblBoard(new JLabel(new ImageIcon(cl.getResource("board.png"))))
		.lblSum( setLabelFont(new JLabel(" = " + sum), new Font("Courier", Font.BOLD, 24)))
		.lblAnswer(setLabelFont(new JLabel(), new Font("Courier", Font.BOLD, 18)) )
		.lblTrack(new JLabel(new ImageIcon(cl.getResource("travbana.png"))))
		.lblProgress(new JLabel(new ImageIcon(cl.getResource("human.png"))))
		.txtSum(setUpChalkBoard(new JTextArea(3,1)))
		.lblBig(setLabelForgroundColor(new JLabel(), Color.WHITE))
		.btnHelp(new JButton(new ImageIcon(cl.getResource("helpbutton.png"))))
		.btnAbout(new JButton(new ImageIcon(cl.getResource("about.png"))))
		.build();
		
		//random();

		//imgBike=new ImageIcon(cl.getResource("bike.png"));
		//imgHorse=new ImageIcon(cl.getResource("horse.png"));
		
		
		JPanel pnlCenter = createPanelWithSize(3200,200);
		addComponentToPanel(board.getLblAnswer(), pnlCenter, new Bounds(40,0,320,60));
		addComponentToPanel(board.getLblSum(), pnlCenter, new Bounds(200,220,100,80));		
		addComponentToPanel(board.getTxtSum(), pnlCenter, new Bounds(45,50,250,190));				
				
		JPanel pnlEast = createPanelWithSize(100,200);
		addComponentToPanel(board.getLblLevel(), pnlEast, new Bounds(15,40,60,60));
		addComponentToPanel(board.getLblPoints(), pnlEast, new Bounds(15,90,60,60));
		addComponentToPanel(board.getLblNrpoints(), pnlEast, new Bounds(40,110,60,60));		
		addComponentToPanel(board.getLblBoard(), pnlEast, new Bounds(0,50,80,130));		
		addComponentToPanel(board.getBtnHelp(), pnlEast, new Bounds(20,15,30, 30));		
		addComponentToPanel(board.getBtnAbout(), pnlEast, new Bounds(55,15,30, 30));

		
		JPanel pnlSouth = createPanelWithSize(550,100);
		addComponentToPanel(board.getLblBig(), pnlSouth, new Bounds(300,10,300,60));		
		addComponentToPanel(board.getLblTrack(), pnlSouth, new Bounds(0,0,650,100));
		addComponentToPanel(board.getLblProgress(), pnlSouth, new Bounds(0,40,100,60));
				
		setActionListners();	
		createContainer(pnlWest, pnlCenter, pnlEast, pnlSouth);
		
	}
	private JLabel setLabelFont(JLabel label, Font font){
		label.setFont(font);
		return label;
	}

	private JLabel setLabelForgroundColor(JLabel label, Color color){
		label.setForeground(color);
		return label;
	}
	
	private JTextArea setUpChalkBoard(JTextArea area) {
		area.setFont(new Font("Courier", Font.BOLD, 16));		
		area.setLineWrap(true);		
		area.setBorder(null);	
		area.setEditable(false);
		area.setForeground(Color.WHITE);		
		area.setBackground(Color.BLACK);
		return area;
	}

	private void createContainer(JPanel pnlWest, JPanel pnlCenter,
			JPanel pnlEast, JPanel pnlSouth) {
		Container c = getContentPane();
		c.setLayout(new BorderLayout());  
		c.add(pnlWest, BorderLayout.WEST);   
		c.add(pnlEast, BorderLayout.EAST);
		c.add(pnlCenter, BorderLayout.CENTER);
		c.add(pnlSouth, BorderLayout.SOUTH);
		setSize(650,425);
		setVisible(true);
		setResizable(false);
		setLocation(500,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void addComponentToPanel(JComponent component, JPanel panel, Bounds bounds) {
		component.setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
		panel.add(component);
	}
	
	private JPanel createPanelWithSize(int width, int height) {
		JPanel panel = new JPanel();
		panel.setLayout(null);  
		panel.setPreferredSize(new Dimension(width, height));
		return panel;
	}

	private JPanel setUpNumberPadPanel() {
		ArrayList<JButton> numberButtons = new ArrayList<JButton>();
		numberButtons.add(new JButton(new ImageIcon(cl.getResource("1.png"))));
		numberButtons.add(new JButton(new ImageIcon(cl.getResource("2.png"))));
		numberButtons.add(new JButton(new ImageIcon(cl.getResource("3.png"))));
		numberButtons.add(new JButton(new ImageIcon(cl.getResource("4.png"))));
		numberButtons.add(new JButton(new ImageIcon(cl.getResource("5.png"))));
		numberButtons.add(new JButton(new ImageIcon(cl.getResource("6.png"))));
		numberButtons.add(new JButton(new ImageIcon(cl.getResource("7.png"))));
		numberButtons.add(new JButton(new ImageIcon(cl.getResource("8.png"))));
		numberButtons.add(new JButton(new ImageIcon(cl.getResource("9.png"))));
		numberButtons.add(new JButton(new ImageIcon(cl.getResource("level.png"))));
		numberButtons.add(new JButton(new ImageIcon(cl.getResource("angra.png"))));
		
		NumberPad numberPad = new NumberPad.Builder()
		.lblKalken(new JLabel(new ImageIcon(cl.getResource("kalken.png"))))
		.numberButtons(numberButtons)
		.build();

		numberPad.getLblKalken().setBounds(5,8,92,33);
		numberPad.getNumberButtons().get(0).setBounds(25,40,45,45);
		numberPad.getNumberButtons().get(1).setBounds(75,40,45,45);
		numberPad.getNumberButtons().get(2).setBounds(125,40,45,45);
		numberPad.getNumberButtons().get(3).setBounds(25,90,45, 45);
		numberPad.getNumberButtons().get(4).setBounds(75,90,45, 45);
		numberPad.getNumberButtons().get(5).setBounds(125,90,45, 45);
		numberPad.getNumberButtons().get(6).setBounds(25,140, 45, 45);
		numberPad.getNumberButtons().get(7).setBounds(75,140,45, 45);
		numberPad.getNumberButtons().get(8).setBounds(125,140,45, 45);
		numberPad.getNumberButtons().get(9).setBounds(5,200,110, 45);
		numberPad.getNumberButtons().get(10).setBounds(120,200,70, 45);
		
		numberPad.getNumberButtons().get(9).setEnabled(false);
		JPanel panel = new JPanel();	
		panel.add(numberPad.getLblKalken());
		
		JButton button;
		for(int i=0; i < numberPad.getNumberButtons().size(); i++){
			button = numberPad.getNumberButtons().get(i);
			setActionListners(button);
			panel.add(button);
		}
		
		panel.setLayout(null);  
		panel.setPreferredSize(new Dimension(200,200));
		
		return panel;
	}
	
	
	private void setActionListners(JButton button) {
		button.addActionListener(this);
	}
	
	private void setActionListners() {
/*		btnHelp.addActionListener(this);
		btnAbout.addActionListener(this);*/
	}
	
	private void setUpMenu() {
	/*	mnuBar = new JMenuBar();
		mnuIcon = new JMenu("Byt karaktär");
		mnuFile = new JMenu("Arkiv");
		itmExit = new JMenuItem("Avsluta");
		itmRestart = new JMenuItem("Starta om");
		
		chkHuman = new JRadioButton("Människa", true);
		chkHorse = new JRadioButton("Häst", false);
		chkBike = new JRadioButton("Motorcykel", false);
		
		chkHuman.addActionListener(this);
		chkHorse.addActionListener(this);
		chkBike.addActionListener(this);
		itmExit.addActionListener(this);
		itmRestart.addActionListener(this);
		
		mnuFile.add(itmRestart);	
		mnuFile.add(itmExit);
		
		mnuIcon.add(chkHuman);
		mnuIcon.add(chkHorse);
		mnuIcon.add(chkBike);
		
		mnuBar.add(mnuFile);
		mnuBar.add(mnuIcon);
		
		setJMenuBar(mnuBar);*/
	}
	//-------------------------------BUTTONENABLER-----------------------------------//
	public void buttonEnabler(){
	/*	
				btnLevel.setEnabled(true);
				btnOne.setEnabled(false);
				btnTwo.setEnabled(false);
				btnThree.setEnabled(false);
				btnFour.setEnabled(false);
				btnFive.setEnabled(false);
				btnSix.setEnabled(false);
				btnSeven.setEnabled(false);
				btnEight.setEnabled(false);
				btnNine.setEnabled(false);
				btnReset.setEnabled(false); */
	}
	
	//-------------------------------LEVELCHOOSER-----------------------------------//
	public void levelChooser(){
		/*	if(level == 1){
			level1();
			lblAnswer.setText("Addition ?+? = " + random);
			lblLevel.setText("Level 1");
		}
		else if(level==2){
			lblAnswer.setText("Subtraktion "+ROOF+" - ? = " + random);
			lblLevel.setText("Level 2");
			level2();

			
		}
		else if(level==3){
			level3();
			lblAnswer.setText("Multiplikation ? * ? = " + random);
			lblLevel.setText("Level 3");
		}
		else if(level==4){
			level4();
			lblAnswer.setText("Division " +random+ " / ? = " + integer1);
			lblLevel.setText("Level 4");
		}*/
	}
	
	//------------------------------------MOVE--------------------------------------//
	public void move(){
	/*int tempx = (int)(540/THRESHOLD)*points;
	lblProgress.setBounds(tempx,40,100,53);	*/
	}
	
	//-----------------------------------RANDOM-------------------------------------//
	public void random(){
		//-------Labels-------//
		/*if (level==1){		
			random = (int) Math.ceil( Math.random() * (ROOF-1));
			lblAnswer.setText("Addition ? + ? = " + random);
			lblLevel.setText("Level 1");
		}
		else if (level==2){
			random = (int) Math.ceil( Math.random() * (ROOF-1));
			lblAnswer.setText("Subtraktion "+ROOF+" - ? = " + random);
			sum = ROOF;		
		}
		else if (level==3){
			int temp1 = (int) Math.ceil( Math.random() * 9);
			int temp2 = (int) Math.ceil( Math.random() * 9);
			random = temp1 * temp2;
			lblAnswer.setText("Multiplikation ? * ? = " + random);
			sum = 0;		
		}
		
		//------level4-------//
		else if (level==4){
			integer1 = (int) Math.ceil( Math.random() * 9);
			integer2 = (int) Math.ceil( Math.random() * 9);
		
			random = integer1*integer2;
			lblAnswer.setText("Division " +random+ " / ? = " + integer1);	
	
			sum = 0;		
		}*/
	}
   
	//-----------------------------------EMPTY--------------------------------------//
	public void empty(){
		/*txtSum.setText("");
		first = true;*/
	}

	//---------------------------------RESTART---------------------------------------//
	public void restart(){	
		/*	level=1;
			sum=0;
			points=0;
			lblNrpoints.setText(""+ points);
			lblLevel.setText("Level 1");
			lblSum.setText(" = 0");
			random();
			empty();
			lblProgress.setBounds(0,40,100,53);
			levelChooser();	*/
	}
	
	//----------------------------------LEVEL 1-------------------------------------//
	public void level1(){
	/*	if (first == true){
			lblBig.setText("");
		}
		//---------1--------//
		if (button == btnOne){
				if (first == true){
					txtSum.setText("1");
					sum+=1;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else if (txtSum.getLineCount() <= 9){
					txtSum.append(" + 1");
					sum+=1;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				else{
					sum=sum;	
					}
				}
		//---------2--------//
			if (button== btnTwo){
				if (first == true){
					txtSum.setText("2");
					sum+=2;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else if (txtSum.getLineCount() <= 9){
					txtSum.append(" + 2");
					sum+=2;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				else{
					sum=sum;	
					}
				}
			//---------3--------//
			if (button== btnThree){
				if (first == true){
					txtSum.setText("3");
					sum+=3;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else if (txtSum.getLineCount() <= 9){
					txtSum.append(" + 3");
					sum+=3;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				else{
					sum=sum;	
					}
				}
			//---------4--------//
			if (button== btnFour){
				if (first == true){
					txtSum.setText("4");
					sum+=4;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else if (txtSum.getLineCount() <= 9){
					txtSum.append(" + 4");
					sum+=4;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				else{
					sum=sum;	
					}
				}
			//---------5--------//
			if (button== btnFive){
				if (first == true){
					txtSum.setText("5");
					sum+=5;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else if (txtSum.getLineCount() <= 9){
					txtSum.append(" + 5");
					sum+=5;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				else{
					sum=sum;	
					}
				}
			//---------6--------//
			if (button== btnSix){
				if (first == true){
					txtSum.setText("6");
					sum+=6;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else if (txtSum.getLineCount() <= 9){
					txtSum.append(" + 6");
					sum+=6;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				else{
					sum=sum;	
					}
				}
			//---------7--------//
			if (button== btnSeven){
				if (first == true){
					txtSum.setText("7");
					sum+=7;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else if (txtSum.getLineCount() <= 9){
					txtSum.append(" + 7");
					sum+=7;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				else{
					sum=sum;	
					}
				}
			//---------8--------//
			if (button== btnEight){
				if (first == true){
					txtSum.setText("8");
					sum+=8;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else if (txtSum.getLineCount() <= 9){
					txtSum.append(" + 8");
					sum+=8;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				else{
					sum=sum;	
					}
				}
			//---------9--------//
			if (button== btnNine){
				if (first == true){
					txtSum.setText("9");
					sum+=9;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else if (txtSum.getLineCount() <= 9){
					txtSum.append(" + 9");
					sum+=9;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				else{
					sum=sum;	
					}
				}
			//---------Reset--------//
			if (button== btnReset){
			empty();
			lblSum.setText(" = 0");
			sum = 0;

				}
			//---------Correct answer--------//
			if (sum==random && first!=true){
				lblBig.setText("Bra gjort!");
					empty();
					random();
					points+=5;
					lblNrpoints.setText(""+ points);
					lblSum.setText(" = 0");
					sum = 0;
					move();
			}
			//---------Too big numbers--------//
			if (sum>random && first!=true){
			lblBig.setText("Nu blev summan för stor, försök igen.");
					empty();
					points-=1;
					lblNrpoints.setText(""+ points);
					lblSum.setText(" = 0");
					sum = 0;
			}
			if(points >= THRESHOLD){
				level = 2;
				random();
				lblBig.setText("Grattis! Du har nu nått Level 2.");
				points = 0;
				lblNrpoints.setText(""+ points);
				lblProgress.setBounds(0,40,100,53);
				buttonEnabler();
				Help.setLevel(level);
			}	*/
			
	}
	
	//----------------------------------LEVEL 2-------------------------------------//
	public void level2(){
	/*	if (first == true){
			lblBig.setText("");
		}
		//---------1--------//
		if (button == btnOne){
				if (first == true){
					txtSum.setText(ROOF + " - 1");
					sum=ROOF-1;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else {
					txtSum.append(" - 1");
					sum-=1;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
		//---------2--------//
			if (button== btnTwo){
				if (first == true){
					txtSum.setText(ROOF + " - 2");
					sum=ROOF - 2;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else{
					txtSum.append(" - 2");
					sum-=2;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------3--------//
			if (button== btnThree){
				if (first == true){
					txtSum.setText(ROOF + " - 3");
					sum=ROOF-3;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else{
					txtSum.append(" - 3");
					sum-=3;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------4--------//
			if (button== btnFour){
				if (first == true){
					txtSum.append(ROOF + " - 4");
					sum=ROOF-4;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else {
					txtSum.append(" - 4");
					sum-=4;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------5--------//
			if (button== btnFive){
				if (first == true){
					txtSum.append(ROOF + " - 5");
					sum=ROOF-5;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else{
					txtSum.append(" - 5");
					sum-=5;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------6--------//
			if (button== btnSix){
				if (first == true){
					txtSum.append(ROOF + " - 6");
					sum=ROOF - 6;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else{
					txtSum.append(" - 6");
					sum-=6;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------7--------//
			if (button== btnSeven){
				if (first == true){
					txtSum.append(ROOF + " - 7");
					sum=ROOF-7;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else{
					txtSum.append(" - 7");
					sum-=7;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------8--------//
			if (button== btnEight){
				if (first == true){
					txtSum.append(ROOF + " - 8");
					sum=ROOF-8;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else{
					txtSum.append(" - 8");
					sum-=8;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------9--------//
			if (button== btnNine){
				if (first == true){
					txtSum.append(ROOF + " - 9");
					sum=ROOF-9;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else{
					txtSum.append(" - 9");
					sum-=9;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------Reset--------//
			if (button== btnReset){
			empty();
			lblSum.setText(" = " + ROOF);
				}
			//---------Correct answer--------//
			if (sum==random && first!=true){
				lblBig.setText("Bra gjort!");
					empty();
					random();
					points+=5;
					lblNrpoints.setText(""+ points);
					sum = ROOF;
					lblSum.setText(" = " + ROOF);
					move();
			}
			//---------Too big numbers--------//
			if (sum<random && first!=true){
			lblSum.setText(" = " + ROOF);
			lblBig.setText("Nu blev differansen för liten, försök igen.");
					empty();
					points-=1;
					lblNrpoints.setText(""+ points);
			}
			if(points > THRESHOLD){
				level = 3;
				random();
				lblBig.setText("Grattis! Du har nu nått Level 3.");
				points = 0;
				lblNrpoints.setText(""+ points);
				lblProgress.setBounds(0,40,100,53);
				btnLevel.setEnabled(true);
				sum = 0;
				lblSum.setText("= " + sum);
				buttonEnabler();
				Help.setLevel(level);
			}		*/
	}
	
	//----------------------------------LEVEL 3-------------------------------------//
	public void level3(){
	/*	if (first == true){
			lblBig.setText("");
		}
		//---------1--------//
		if (button == btnOne){
				if (first == true){
					txtSum.setText("1");
					sum=1;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else {
					txtSum.append(" * 1");
					sum*=1;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
		//---------2--------//
			if (button== btnTwo){
				if (first == true){
					txtSum.setText("2");
					sum=2;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else{
					txtSum.append(" * 2");
					sum*=2;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------3--------//
			if (button== btnThree){
				if (first == true){
					txtSum.setText("3");
					sum=3;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else{
					txtSum.append(" * 3");
					sum*=3;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------4--------//
			if (button== btnFour){
				if (first == true){
					txtSum.append("4");
					sum=4;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else {
					txtSum.append(" * 4");
					sum*=4;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------5--------//
			if (button== btnFive){
				if (first == true){
					txtSum.append("5");
					sum=5;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else{
					txtSum.append(" * 5");
					sum*=5;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------6--------//
			if (button== btnSix){
				if (first == true){
					txtSum.append("6");
					sum=6;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else{
					txtSum.append(" * 6");
					sum*=6;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------7--------//
			if (button== btnSeven){
				if (first == true){
					txtSum.append("7");
					sum=7;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else{
					txtSum.append(" * 7");
					sum*=7;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------8--------//
			if (button== btnEight){
				if (first == true){
					txtSum.append("8");
					sum=8;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else{
					txtSum.append(" * 8");
					sum*=8;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------9--------//
			if (button== btnNine){
				if (first == true){
					txtSum.append("9");
					sum=9;
					lblSum.setText(" = " + sum);
					first = false;
					number+=1;
				}
				else{
					txtSum.append(" * 9");
					sum*=9;
					lblSum.setText(" = " + sum);
					number+=4;
					}
				}
			//---------Reset--------//
			if (button== btnReset){
			empty();
			lblSum.setText(" = 0");
				}
			//---------Correct answer--------//
			if (sum==random && first!=true){
					lblBig.setText("Bra gjort!");
					empty();
					random();
					points+=5;
					lblNrpoints.setText(""+ points);
					sum = 0;
					lblSum.setText(" = 0");
					move();
			}
			//---------Too big numbers--------//
			if (sum>random && first!=true){
					lblSum.setText(" = 0");
					lblBig.setText("Nu blev produkten för stor, försök igen.");
					empty();
					points-=1;
					lblNrpoints.setText(""+ points);
			}	
			if(points > THRESHOLD){
				level = 4;
				random();
				lblBig.setText("Grattis! Du har nu nått Level 4.");
				points = 0;
				lblNrpoints.setText(""+ points);
				lblProgress.setBounds(0,40,100,53);
				btnLevel.setEnabled(true);
				sum = 0;
				lblSum.setText("= " + sum);
				buttonEnabler();
				Help.setLevel(level);
			}	*/
				
	}
	
		//-----------------------------LEVEL 4--------------------------------------//
	public void level4(){
	/*	if (first == true){
			lblBig.setText("");
		}
		//---------1--------//
		if (button == btnOne){
			sum=1;
				}
		//---------2--------//
			if (button== btnTwo){
				sum=2;
				}
			//---------3--------//
			if (button== btnThree){
			sum=3;
				}
			//---------4--------//
			if (button== btnFour){
			sum=4;
				}
			//---------5--------//
			if (button== btnFive){
			sum=5;
				}
			//---------6--------//
			if (button== btnSix){
			sum=6;
				}
			//---------7--------//
			if (button== btnSeven){
			sum=7;
				}
			//---------8--------//
			if (button== btnEight){
			sum=8;
				}
			//---------9--------//
			if (button== btnNine){
			sum=9;
				}
			//---------Reset--------//
			if (button== btnReset){
			empty();
			lblSum.setText(" = 0");
				}
			//---------Correct answer--------//
			if (sum==integer2){
					lblBig.setText("Bra gjort!");
					empty();
					random();
					points+=5;
					lblNrpoints.setText(""+ points);
					sum = 0;
					lblSum.setText(" = 0");
					move();
			}
			//---------Too big numbers--------//
			if (sum!=integer2&&sum!=0){
					lblSum.setText(" = 0");
					lblBig.setText(sum + " är fel tal, försök igen.");
					empty();
					points-=1;
					lblNrpoints.setText(""+ points);
			}	
			if(points > THRESHOLD){
			buttonEnabler();
			restart();
			End endframe = new End();	
			}	*/
	}
	
	//------------------------------ACTIONPERFORMED--------------------------------//	
	public void actionPerformed(ActionEvent e) {
	/*	button = e.getSource();

		if (button==btnLevel){
				btnLevel.setEnabled(false);
				btnOne.setEnabled(true);
				btnTwo.setEnabled(true);
				btnThree.setEnabled(true);
				btnFour.setEnabled(true);
				btnFive.setEnabled(true);
				btnSix.setEnabled(true);
				btnSeven.setEnabled(true);
				btnEight.setEnabled(true);
				btnNine.setEnabled(true);
				btnReset.setEnabled(true);
				empty();
				sum=0;
				lblSum.setText("= " + sum);
			levelChooser();
			}
			else if (button==itmRestart)
			{
			restart();
			}
			else if(button==chkHorse)
			{
			lblProgress.setIcon(imgHorse);	
			chkHuman.setSelected(false);
			chkBike.setSelected(false);
			}
			else if(button==chkHuman)
			{
			lblProgress.setIcon(imgHuman);	
			chkBike.setSelected(false);
			chkHorse.setSelected(false);	
			}
			else if(button==chkBike)
			{
			lblProgress.setIcon(imgBike);
			chkHorse.setSelected(false);
			chkHuman.setSelected(false);		
			}
			else if(button==itmExit)
			{
				System.exit(0);
			}
			else if(button==btnHelp){
				Help helpframe = new Help();
			}	
			else if(button==btnAbout){
				About aboutframe = new About();
			}		
			
		else {
			 levelChooser();
			 }
		
			*/	
	}

	
	
	public static void main(String[] args) {
		Kalken frame = new Kalken();	
	}
	
}
