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

public class End extends JFrame implements ActionListener {
	
	private ClassLoader cl;
	private JPanel pnlSouth, pnlCenter;
	private ImageIcon imgEnd;
	private JLabel lblEnd;
	private JButton btnRestart;
	
	public End()
	{
	cl = ClassLoader.getSystemClassLoader();
	
	
		//----------------------------------------CENTER--------------------------------//
		imgEnd=new ImageIcon(cl.getResource("end.png"));
		lblEnd = new JLabel(imgEnd);
		btnRestart=new JButton(new ImageIcon(cl.getResource("restart.png")));
		btnRestart.setBounds(300,180,80,40);
		lblEnd.setBounds(0,0,450,263);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(null);  
		pnlCenter.add(lblEnd);	
		pnlCenter.add(btnRestart);
		//pnlCenter.setPreferredSize(new Dimension(3200,200));
		
		btnRestart.addActionListener(this);
		
		//--------------------------------------SOUTH-------------------------------------//
		JPanel pnlSouth = new JPanel();		
		pnlSouth.setLayout(null);  		
	
		//-----------------------------------CONTAINER----------------------------------//
		Container c = getContentPane();
		c.setLayout(new BorderLayout());  
		c.add(pnlCenter, BorderLayout.CENTER);
		c.add(pnlSouth, BorderLayout.SOUTH);
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
			
		
