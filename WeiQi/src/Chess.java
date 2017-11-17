/*
 * 
 * @Author:Shangshang Han
 */


import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;


public class Chess extends Frame{
	ChessPad chesspad = new ChessPad();
	Chess()
	{
	setVisible(true);
	setLayout(null);
	
	add(chesspad);
	chesspad.setBounds(45,45,840,880);
	addWindowListener(new WindowAdapter()
	{
	public void windowClosing(WindowEvent e)
	{
	System.exit(0);
	}
	}
	);
	pack();
	setSize(1000,1000);
	}
	public static void main(String args[])
	{
	Chess chess = new Chess();
	}

}