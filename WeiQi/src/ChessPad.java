/*
 * 
 * @Author:Shangshang Han
 */


import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;
class ChessPad extends Panel implements MouseListener,ActionListener{
	
	int x = -1, y = -1 ,c = 1;
	Button button = new Button("Restart");
	TextField text_1 = new TextField("black chess");
	TextField text_2 = new TextField();
	
	 ChessPad(){
		setSize(840,880);
		setLayout(null);
		setBackground(Color.orange);
		addMouseListener(this);
		add(button);
		button.setBounds(10,5,60,26);
		button.addActionListener(this);
		add(text_1);
		text_1.setBounds(90, 5, 90, 24);
		add(text_2);
		text_2.setBounds(290,5,90,24);
		text_1.setEditable(false);
		text_2.setEditable(false);
	}
	    public void paint(Graphics g) {
			for (int i = 80; i<=800;i+=40) {
				g.drawLine(80,i,800,i);
			}
			for(int j = 80; j<=800;j+=40) {
				g.drawLine(j, 80, j, 800);
			}
			g.fillOval(194,194,12,12);
			g.fillOval(194, 674, 12, 12);
			g.fillOval(674, 194, 12, 12);
			g.fillOval(674, 674, 12, 12);
			g.fillOval(434, 434, 12, 12);
			g.fillOval(194, 474, 12, 12);
			g.fillOval(474, 194, 12, 12);
			g.fillOval(474,674,12,12);
			g.fillOval(674, 434, 12, 12);
			
		}
	
		public void mousePressed(MouseEvent e) {
			if(e.getModifiers()==InputEvent.BUTTON1_MASK) {
				x = (int)e.getX();
				y = (int)e.getY();
				ChessPoint_black chesspoint_black = new ChessPoint_black(this);
				ChessPoint_white chesspoint_white = new ChessPoint_white(this);
				int a =(x+20)/40 , b=(y+20)/40;
				if(x/40<2||y/40<2||x/40>19||y/40>19) {
					
				}
				else {
					if(c==1) {
						this.add(chesspoint_black);
						chesspoint_black.setBounds(a*40-20,b*40-20,40,40);
						c=c*(-1);
						text_1.setText(null);
						text_2.setText("White chess");
					}
					else if(c==-1) {
						this.add(chesspoint_white);
						chesspoint_white.setBounds(a*40-20,b*40-20,40,40);
						c=c*(-1);
						text_1.setText("Black chess");
						text_2.setText(null);
						
					}
				}
			}	
					
			}
		public void mouseReleased(MouseEvent e) {
			
		}
		public void mouseEntered(MouseEvent e) {
			
		}
		public void mouseExited(MouseEvent e) {
			
		}
		public void mouseClicked(MouseEvent e) {
			
		}
		public void actionPerformed(ActionEvent e) {
			this.removeAll();
	
			
			c=1;
			add(button);
			button.setBounds(10,5,60,26);
			add(text_1);
			text_1.setBounds(90,5,90,24);
			add(text_2);
			text_2.setBounds(290,5,90,24);
			text_1.setText("Black chess");
			text_2.setText(null);
		}	
		}

class ChessPoint_black extends Canvas implements MouseListener{
	
	ChessPad chesspad=null;
	ChessPoint_black(ChessPad p){
		setSize(40,40);
		chesspad=p;
		addMouseListener(this);
		
	}
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(0,0,40,40);
	}
	public void mousePressed(MouseEvent e) {
		if(e.getModifiers()==InputEvent.BUTTON3_MASK) {
			chesspad.remove(this);
			chesspad.c=1;
			chesspad.text_2.setText(null);
			chesspad.text_1.setText("Black chess");
			
		}
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()>=2) {
			chesspad.remove(this);
		}
	}		
	}
class ChessPoint_white extends Canvas implements MouseListener{
	
	ChessPad chesspad = null;
	ChessPoint_white(ChessPad p){
		setSize(40,40);
		chesspad=p;
		addMouseListener(this);
		
	}
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(0,0,40,40);
	}
	public void mousePressed(MouseEvent e) {
		if(e.getModifiers()==InputEvent.BUTTON3_MASK) {
			chesspad.remove(this);
			chesspad.c=-1;
			chesspad.text_2.setText("White chess");
			chesspad.text_1.setText(null);
			
		}
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()>=2)
			chesspad.remove(this);
	
	}
	
	
	
	
}


