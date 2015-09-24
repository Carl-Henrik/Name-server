package com.example.main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;


public class client {
	JFrame frame = new JFrame();
	JButton button = new JButton("Show name!");
	JTextArea text = new JTextArea();
	Socket mySocket = null;
	
	public client(){
		frame.setLayout(new GridLayout());
		frame.add(button);
		frame.add(text);
		frame.setSize(500, 70);
	    frame.setResizable(false);
	    frame.setVisible(true);
	    
	    text.setEditable(false);
	    
	    
	    
	    frame.addWindowListener(new WindowAdapter(){
	    	
	    	public void windowClosing(WindowEvent event){
	    	
	    		if (mySocket != null){
	    		
	    		try {
					mySocket.close();
				} catch (IOException e) {
					
					e.printStackTrace();
					System.exit(1);
				}
	    		}
	    		System.exit(0);
	    	}
	    	
	    });
	    
	    
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	
					try {
						text.setText(getName());
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
				
                       
            }
        });
	    	    	    
	}
	
	public String getName() throws UnknownHostException, IOException{
						
		mySocket = new Socket("localhost", 8107);
		Scanner input = new Scanner (mySocket.getInputStream());
		String name = input.nextLine();
		
		if (mySocket != null){
			mySocket.close();
		}
		
		return name;
		
		
	}
	
}
	
	
	

