package se.annsofi.kalken;
/*****************************************************
TNM040
Authors: Annsofi Pettersson & Gabriella Ivarsson
University of Linköping - Campus Norrköping
*****************************************************/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import javax.swing.border.LineBorder;
import java.lang.Object.*;

public class About extends JFrame implements ActionListener {
	
	private ClassLoader cl;
	private JPanel pnlSouth, pnlCenter;
	private ImageIcon imgAbout;
	private JLabel lblAbout;
	private JButton btnOk;
	
	public About()
	{
	cl = ClassLoader.getSystemClassLoader();
	
	
		//----------------------------------------CENTER--------------------------------//
		imgAbout=new ImageIcon(cl.getResource("om.png"));

		lblAbout = new JLabel(imgAbout);
		
		lblAbout.setBounds(0,0,450,263);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(null);  
		pnlCenter.add(lblAbout);
			
		btnOk=new JButton(new ImageIcon(cl.getResource("ok.png")));
		btnOk.setBounds(390,215,40,30);
		pnlCenter.add(btnOk);		
		btnOk.addActionListener(this);
	
		//-----------------------------------CONTAINER----------------------------------//
		Container c = getContentPane();
		c.setLayout(new BorderLayout());  
		c.add(pnlCenter, BorderLayout.CENTER);
		setSize(450,280);
		setVisible(true);
		setResizable(false);
		setLocation(580,280);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
			
	
		public void actionPerformed(ActionEvent e){
		setVisible(false);
		}
			
		
}