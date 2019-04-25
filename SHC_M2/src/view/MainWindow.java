package view;
import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import exceptions.InvalidPowerUseException;
import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.NonActivatablePowerHero;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKick;
public class MainWindow extends JFrame implements ActionListener{
	
	private JFrame Game;
	private JButton boardfield[][];
	private Game g1;
	private int j=0;
	private int k=0;
	private JButton[] D1;
	private JButton[] D2;
	private JButton[] P1;
	private JButton[] P2;
	private boolean flag1;
	private boolean flag2;
	private boolean flag3;
	private int d1;
	private int d2;
	private JFrame W1;
	private boolean flagT;
	private int a1;
	private int a2;
	private int x1;
	private int x2;

	private JButton player1;
	private String name1;
	private String name2;
	
	public MainWindow() throws IOException{
		
		
		
	     int p1InitRow = 4;

		 int p2InitRow = 1;
		
		 
		Game= new JFrame();
		Game.setVisible(true);
		Game.setLayout(new WrapLayout());
		Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image img = new ImageIcon(this.getClass().getResource("/backfin.png")).getImage();
		
		ImagePanel G= new ImagePanel(img);
		G.setLayout(new WrapLayout());
		Game.add(G);
		Game.setSize(1400,1400);
		
		Game.setBounds(200,0,1300,850);
		 
		Game.setResizable(false);
		
		 JPanel myWindow = new JPanel();
         Game.setTitle("KICKOFF WAR");
         
        
         myWindow.setVisible(true);
       
         myWindow.setLayout(new BorderLayout());
         JPanel J0= new JPanel(new WrapLayout());
         myWindow.add(J0,BorderLayout.CENTER);
         
         myWindow.setOpaque(false);
         J0.setOpaque(false);
         
         G.add(myWindow);
         
         Image img1 = new ImageIcon(this.getClass().getResource("/footballfield.jpg")).getImage();
        ImagePanel Field= new ImagePanel(img1);
        Field.setLayout(new GridLayout(7,6));
        Field.setVisible(true);
         
         boardfield = new JButton[7][6];
         
         for(int i=0;i<=6;i++){
        	 for(int j=0;j<=5;j++){
        		 JButton x = new JButton();
        		 x.setActionCommand("Tech");
        		 x.addActionListener(this);
        		 boardfield[i][j]= x;
        		 x.setOpaque(false);
        		 x.setContentAreaFilled(false);
        		 Field.add(x);
        		   	
        	 }
         }
         
         
         J0.add(Field);
        
      
         name1=JOptionPane.showInputDialog("Enter player1 Name:");
         name2=JOptionPane.showInputDialog("Enter player2 Name:");
         
         g1= new Game(new Player(name1),new Player(name2));
         
         
         ArrayList<Integer> ind1=new ArrayList<Integer>();
         ArrayList<Integer> ind2=new ArrayList<Integer>();
         
         
         while(!g1.getGUI1().isEmpty()){
        	 ind1.add(g1.getGUI1().remove(0));
        	 
         }
         
         while(!g1.getGUI2().isEmpty()){
        	 ind2.add(g1.getGUI2().remove(0));
        	 
         }
        
         
         
         
         
         
         
      
         
         
        ImageIcon a1 = new ImageIcon(this.getClass().getResource("/sanchezsh.png"));
 		boardfield[p1InitRow + 1][ind1.remove(0)].setIcon(a1);
 		ImageIcon a2 = new ImageIcon(this.getClass().getResource("/xavish.png"));
 		boardfield[p2InitRow][ind2.remove(0)].setIcon(a2);

 		ImageIcon m1 = new ImageIcon(this.getClass().getResource("/zidane.png"));
 		boardfield[p1InitRow + 1][ind1.remove(0)].setIcon(m1);

 		ImageIcon m2 = new ImageIcon(this.getClass().getResource("/maradona.png"));
 		boardfield[p2InitRow][ind2.remove(0)].setIcon(m2);

 		ImageIcon r1 = new ImageIcon(this.getClass().getResource("/zlatan.png"));
 		boardfield[p1InitRow + 1][ind1.remove(0)].setIcon(r1);

 		ImageIcon r2 = new ImageIcon(this.getClass().getResource("/suarez.png"));
 		boardfield[p2InitRow][ind2.remove(0)].setIcon(r2);

 		ImageIcon sp1 = new ImageIcon(this.getClass().getResource("/bale.png"));
 		boardfield[p1InitRow + 1][ind1.remove(0)].setIcon(sp1);

 		ImageIcon sp2 = new ImageIcon(this.getClass().getResource("/neymar.png"));
 		boardfield[p2InitRow][ind2.remove(0)].setIcon(sp2);

 		ImageIcon su1 = new ImageIcon(this.getClass().getResource("/pirlo.png"));
 		boardfield[p1InitRow + 1][ind1.remove(0)].setIcon(su1);

 		ImageIcon su2 = new ImageIcon(this.getClass().getResource("/ronaldinho.png"));
 		boardfield[p2InitRow][ind2.remove(0)].setIcon(su2);

 		ImageIcon t1 = new ImageIcon(this.getClass().getResource("/ronaldo.png"));
 		boardfield[p1InitRow + 1][ind1.remove(0)].setIcon(t1);

 		ImageIcon t2 = new ImageIcon(this.getClass().getResource("/messi.png"));
 		boardfield[p2InitRow][ind2.remove(0)].setIcon(t2);
        
         
         
         
 		for(int i=0;i<=5;i++){
 			ImageIcon t = new ImageIcon(this.getClass().getResource("/sidekcick p1.gif"));
 			boardfield[4][i].setIcon(t);
 		}
         
		for(int i=0;i<=5;i++){
 			ImageIcon t = new ImageIcon(this.getClass().getResource("/sidekcick p2.png"));
 			boardfield[2][i].setIcon(t);
 		}
         
         
        
		Image jr= new ImageIcon(this.getClass().getResource("/pay.png")).getImage();
		ImagePanel J1= new ImagePanel(jr);
		
		Image jl= new ImageIcon(this.getClass().getResource("/ps.png")).getImage();
 	    ImagePanel J2= new ImagePanel(jl);
 		
 		
 		J1.setOpaque(false);
 		J2.setOpaque(false);
 		
 		J2.setLayout(new GridLayout(6,1));
 		J1.setLayout(new GridLayout(9,1));
 		
 		J2.setVisible(true);
        J1.setVisible(true);
        
        JPanel JP1= new JPanel(new FlowLayout());
        JP1.setVisible(true);
        JP1.add(J1);
        JP1.add(J2);
        
        
        
        
        
        ImagePanel K1= new ImagePanel(jr);
        ImagePanel K2= new ImagePanel(jl);
        
 		K1.setOpaque(false);
 		K2.setOpaque(false);
 		
        K2.setLayout(new GridLayout(6,1));
 		K1.setLayout(new GridLayout(9,1));
      
 		K2.setVisible(true);
        K1.setVisible(true);

        JPanel JP2= new JPanel(new FlowLayout());
        JP2.setVisible(true);
        JP2.add(K2);
        JP2.add(K1);
        
        
        JP1.setOpaque(false);
        JP2.setOpaque(false);
        
        
        myWindow.add(JP1,BorderLayout.EAST);
        myWindow.add(JP2,BorderLayout.WEST);
        
        
        
         P1 = new JButton[6];
         P2 = new JButton[6];
         D1 = new JButton[9];
         D2 = new JButton[9];
         

         
         
         Image cl= new ImageIcon(this.getClass().getResource("/back2.jpg")).getImage();
         ImagePanel currentplayer= new ImagePanel(cl);
         
         currentplayer.setLayout(new WrapLayout());
         currentplayer.setVisible(true);
         
         
         player1=new JButton(name1+"'s turn");
         
         player1.setVisible(true);
         
         currentplayer.add(player1);
         
         
         Game.add(currentplayer,BorderLayout.SOUTH);
        
         player1.setForeground(Color.MAGENTA);
         player1.setBackground(Color.BLACK);
         
         
         
         
         
         
         
         
         for(int i=0;i<=8;i++){
        	 JButton l= new JButton();
        	 D1[i]=l;
        	 l.setOpaque(false);
        	 l.setContentAreaFilled(false);
        	 l.addActionListener(this);
        	 J1.add(l);
         }
         
         
         for(int i=0;i<=5;i++){
        	 JButton l= new JButton();
        	 P1[i]=l;
        	 l.setOpaque(false);
        	 l.setContentAreaFilled(false);
        	 J2.add(l);
         }
         
         
         
         
         for(int i=0;i<=8;i++){
        	 JButton l= new JButton();
        	 D2[i]=l;
        	 l.setOpaque(false);
        	 l.setContentAreaFilled(false);
        	 l.addActionListener(this);
        	 K1.add(l);
         }
         
         
         for(int i=0;i<=5;i++){
        	 JButton l= new JButton();
        	 P2[i]=l;
        	 l.setOpaque(false);
        	 l.setContentAreaFilled(false);
        	 K2.add(l);
         }
         
         
         
         
      
        
        JButton [][] cont = new JButton [3][3];
        JPanel CP = new JPanel();
       
        CP.setLayout(new GridLayout(3,3));
        CP.setVisible(true);
        JPanel J4 = new JPanel(new WrapLayout());
        J4.setVisible(true);
        J4.setOpaque(false);
        for(int i=0;i<=2;i++) {
        	for(int j=0;j<=2;j++) {
        		JButton B = new JButton();
        		cont [i][j] = B;
        		
        		B.setOpaque(false);
        		B.setContentAreaFilled(false);
        		CP.add(B);
        	}
        }
        
        J4.add(CP);
      
        CP.setOpaque(false);
      
        
        
        JPanel Z= new JPanel();
        Z.setLayout(new WrapLayout());
        Z.setVisible(true);
        Z.setOpaque(false);
        Z.add(J4);
        G.add(Z,BorderLayout.EAST);
        
        
        
        
        cont[0][1].setActionCommand("UP");
        cont[0][1].addActionListener(this);
        cont[0][1].setIcon(new ImageIcon(this.getClass().getResource("/up.png")));
        
        cont[2][1].setActionCommand("DOWN");
        cont[2][1].addActionListener(this);
        cont[2][1].setIcon(new ImageIcon(this.getClass().getResource("/down.png")));
        
        
        cont[1][0].setActionCommand("LEFT");
        cont[1][0].addActionListener(this);
        cont[1][0].setIcon(new ImageIcon(this.getClass().getResource("/left.png")));
        
        cont[1][2].setActionCommand("RIGHT");
        cont[1][2].addActionListener(this);
        cont[1][2].setIcon(new ImageIcon(this.getClass().getResource("/right.png")));
        
        cont[0][2].setActionCommand("UPRIGHT");
        cont[0][2].addActionListener(this);
        cont[0][2].setIcon(new ImageIcon(this.getClass().getResource("/upright.png")));
        
        cont[0][0].setActionCommand("UPLEFT");
        cont[0][0].addActionListener(this);
        cont[0][0].setIcon(new ImageIcon(this.getClass().getResource("/upleft.png")));
        
        cont[2][2].setActionCommand("DOWNRIGHT");
        cont[2][2].addActionListener(this);
        cont[2][2].setIcon(new ImageIcon(this.getClass().getResource("/downright.png")));
        
        cont[2][0].setActionCommand("DOWNLEFT");
        cont[2][0].addActionListener(this);
        cont[2][0].setIcon(new ImageIcon(this.getClass().getResource("/downleft.png")));
        
        
        cont[1][1].setActionCommand("USEPOWER");
        cont[1][1].addActionListener(this);
        cont[1][1].setIcon(new ImageIcon(this.getClass().getResource("/p.png")));
        
       
        
        
        
      
        
        
        
       
	}
	
	
	
	
    
	
	
	public void moveIcon1(int x , int y){
		moveGUI();
		
		int up=x-1;
		if (up < 0) {
			up = g1.getBoardHeight() - 1;
		}
		int down = x + 1;

		if (down == g1.getBoardHeight()) {
			down = 0;
		}
		int right = y + 1;

		if (right == g1.getBoardWidth()) {
			right = 0;
		}
		
		int left = y - 1;

		if (left < 0) {
			left = g1.getBoardWidth() - 1;
		}
		
		int uprighti = x - 1;
		int uprightj = y + 1;

		if (uprighti < 0) {
			uprighti = g1.getBoardHeight() - 1;
		}

		if (uprightj == g1.getBoardWidth()) {
			uprightj = 0;
		}
		
		
		int uplefti = x- 1;
		int upleftj = y - 1;

		if (uplefti < 0) {
			uplefti = g1.getBoardHeight() - 1;
		}

		if (upleftj < 0) {
			upleftj = g1.getBoardWidth() - 1;
		}
		
		
		int downrighti = x + 1;
		int downrightj = y + 1;

		if (downrighti == g1.getBoardHeight()) {
			downrighti = 0;
		}

		if (downrightj == g1.getBoardWidth()) {
			downrightj = 0;
		}
		
		
		int downlefti = x + 1;
		int downleftj = y - 1;

		if (downlefti == g1.getBoardHeight()) {
			downlefti = 0;
		}
		if (downleftj < 0) {
			downleftj = g1.getBoardWidth() - 1;
		}
		
		
		if(g1.getCellAt(k,j).getPiece() instanceof Armored  ){
			
			
			
			moveGUI();
				
			
				
				
				if(g1.getCellAt(up,y).getPiece() instanceof Armored && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //up
					boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
					}
				if(g1.getCellAt(up,y).getPiece() instanceof Medic && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
					boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
					}
				if(g1.getCellAt(up,y).getPiece() instanceof Tech && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
					boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
					}
				if(g1.getCellAt(up,y).getPiece() instanceof Ranged && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
					boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
					}
				if(g1.getCellAt(up,y).getPiece() instanceof Super && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
					boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
					}
				if(g1.getCellAt(up,y).getPiece() instanceof Speedster && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
					boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
					}
				if(g1.getCellAt(up,y).getPiece() instanceof SideKick && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
					boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
					}
				
				
				if(g1.getCellAt(down,j).getPiece() instanceof Armored && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
					boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
					}
				if(g1.getCellAt(down,j).getPiece() instanceof Medic && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
					boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
					}
				if(g1.getCellAt(down,j).getPiece() instanceof Tech && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
					boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
					}
				if(g1.getCellAt(down,j).getPiece() instanceof Ranged && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
					boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
					}
				if(g1.getCellAt(down,j).getPiece() instanceof Super && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
					boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
					}
				if(g1.getCellAt(down,j).getPiece() instanceof Speedster && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
					boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
					}
				if(g1.getCellAt(down,j).getPiece() instanceof SideKick && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
					boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
					}
				
				
				
				
				
				if(g1.getCellAt(x,left).getPiece() instanceof Armored && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
					boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
					}
				
				if(g1.getCellAt(x,left).getPiece() instanceof Medic && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
					boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
					}
				if(g1.getCellAt(x,left).getPiece() instanceof Tech && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
					boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
					}
				if(g1.getCellAt(x,left).getPiece() instanceof Ranged && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
					boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
					}
				if(g1.getCellAt(x,left).getPiece() instanceof Super && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
					boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
					}
				if(g1.getCellAt(x,left).getPiece() instanceof Speedster && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
					boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
					}
				if(g1.getCellAt(x,left).getPiece() instanceof SideKick && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
					boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
					}
				
				
				
				
				if(g1.getCellAt(x,right).getPiece() instanceof Armored && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
					boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
					}

				if(g1.getCellAt(x,right).getPiece() instanceof Medic && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
					boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
					}

				if(g1.getCellAt(x,right).getPiece() instanceof Tech && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
					boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
					}

				if(g1.getCellAt(x,right).getPiece() instanceof Ranged && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
					boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
					}

				if(g1.getCellAt(x,right).getPiece() instanceof Super && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
					boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
					}

				if(g1.getCellAt(x,right).getPiece() instanceof Speedster && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
					boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
					}

				if(g1.getCellAt(x,right).getPiece() instanceof SideKick && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
					boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
					}
				
				
				
				
				
				if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Armored && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
					boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
					}
				if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Medic && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
					boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
					}
				if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Tech && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
					boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
					}
				if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Ranged && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
					boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
					}
				if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Super && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
					boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
					}
				if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Speedster && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){//upleft
					boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
					}
				if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof SideKick && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
					boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
					}
				
				
				
				
				
				if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Armored && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
					boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
					}
				if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Medic && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
					boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
					}
				if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Tech && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
					boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
					}
				if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Ranged && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
					boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
					}
				if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Super && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
					boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
					}
				if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Speedster && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
					boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
					}
				if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof SideKick && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
					boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
					}
				
				
				
				
				if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Armored && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
					boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
					}
				if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Medic && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
					boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
					}
				if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Tech && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
					boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
					}
				if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Ranged && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
					boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
					}
				if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Super && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
					boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
					}
				if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Speedster && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
					boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
					}
				if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof SideKick && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
					boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
					}
				
				
				
				
				if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Armored && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
					boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
					}
				if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Medic && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
					boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
					}
				if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Tech && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
					boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
					}
				if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Ranged && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
					boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
					}
				if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof  Super && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
					boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
					}
				if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Speedster && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
					boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
					}
				if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof SideKick && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
					boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
					}
				
				
				
				
				
				
				
				
			if(boardfield[up][y].getIcon()==null ){
				boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sanchezbw.png")));			//black and white
				}
			if(boardfield[down][y].getIcon()==null ){
				boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/sanchezbw.png")));
				}
			if(boardfield[x][left].getIcon()==null ){
				boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sanchezbw.png")));
				}
			if(boardfield[x][right].getIcon()==null ){
				boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sanchezbw.png")));
				}
			if(boardfield[uprighti][uprightj].getIcon()==null){
				boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/sanchezbw.png")));
				}
			if(boardfield[uplefti][upleftj].getIcon()==null ){
				boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/sanchezbw.png")));
				}
			if(boardfield[downrighti][downrightj].getIcon()==null ){
				boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sanchezbw.png")));
				}
			if(boardfield[downlefti][downleftj].getIcon()==null ){
				boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sanchezbw.png")));
				}
			
			
		
		
		
			
			
			
			
			
			
			
			
				
		
			}
		
	if(g1.getCellAt(k,j).getPiece() instanceof Ranged  ){
			
			
			
			moveGUI();
				
			
				
				
			if(g1.getCellAt(up,y).getPiece() instanceof Armored && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //up
				boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
				}
			if(g1.getCellAt(up,y).getPiece() instanceof Medic && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
				boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
				}
			if(g1.getCellAt(up,y).getPiece() instanceof Tech && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
				boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
				}
			if(g1.getCellAt(up,y).getPiece() instanceof Ranged && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
				boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
				}
			if(g1.getCellAt(up,y).getPiece() instanceof Super && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
				boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
				}
			if(g1.getCellAt(up,y).getPiece() instanceof Speedster && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
				boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
				}
			if(g1.getCellAt(up,y).getPiece() instanceof SideKick && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
				boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
				}
				
				
			if(g1.getCellAt(down,j).getPiece() instanceof Armored && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
				boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
				}
			if(g1.getCellAt(down,j).getPiece() instanceof Medic && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
				boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
				}
			if(g1.getCellAt(down,j).getPiece() instanceof Tech && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
				boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
				}
			if(g1.getCellAt(down,j).getPiece() instanceof Ranged && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
				boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
				}
			if(g1.getCellAt(down,j).getPiece() instanceof Super && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
				boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
				}
			if(g1.getCellAt(down,j).getPiece() instanceof Speedster && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
				boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
				}
			if(g1.getCellAt(down,j).getPiece() instanceof SideKick && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
				boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
				}
				
				
				
				
				
			if(g1.getCellAt(x,left).getPiece() instanceof Armored && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
				boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
				}
			
			if(g1.getCellAt(x,left).getPiece() instanceof Medic && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
				boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
				}
			if(g1.getCellAt(x,left).getPiece() instanceof Tech && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
				boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
				}
			if(g1.getCellAt(x,left).getPiece() instanceof Ranged && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
				boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
				}
			if(g1.getCellAt(x,left).getPiece() instanceof Super && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
				boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
				}
			if(g1.getCellAt(x,left).getPiece() instanceof Speedster && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
				boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
				}
			if(g1.getCellAt(x,left).getPiece() instanceof SideKick && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
				boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
				}
			
				
				
				
				
			if(g1.getCellAt(x,right).getPiece() instanceof Armored && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
				boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
				}

			if(g1.getCellAt(x,right).getPiece() instanceof Medic && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
				boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
				}

			if(g1.getCellAt(x,right).getPiece() instanceof Tech && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
				boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
				}

			if(g1.getCellAt(x,right).getPiece() instanceof Ranged && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
				boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
				}

			if(g1.getCellAt(x,right).getPiece() instanceof Super && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
				boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
				}

			if(g1.getCellAt(x,right).getPiece() instanceof Speedster && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
				boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
				}

			if(g1.getCellAt(x,right).getPiece() instanceof SideKick && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
				boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
				}
			
				
				
				
				
				
			if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Armored && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
				boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
				}
			if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Medic && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
				boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
				}
			if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Tech && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
				boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
				}
			if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Ranged && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
				boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
				}
			if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Super && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
				boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
				}
			if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Speedster && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){//upleft
				boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
				}
			if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof SideKick && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
				boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
				}
				
				
				
				
				
			if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Armored && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
				boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
				}
			if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Medic && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
				boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
				}
			if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Tech && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
				boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
				}
			if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Ranged && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
				boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
				}
			if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Super && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
				boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
				}
			if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Speedster && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
				boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
				}
			if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof SideKick && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
				boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
				}
				
				
				
				
			if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Armored && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
				boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
				}
			if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Medic && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
				boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
				}
			if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Tech && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
				boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
				}
			if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Ranged && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
				boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
				}
			if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Super && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
				boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
				}
			if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Speedster && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
				boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
				}
			if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof SideKick && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
				boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
				}
				
				
				
				
			if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Armored && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
				boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
				}
			if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Medic && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
				boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
				}
			if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Tech && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
				boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
				}
			if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Ranged && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
				boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
				}
			if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof  Super && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
				boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
				}
			if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Speedster && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
				boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
				}
			if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof SideKick && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
				boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
				}
				
				
				
				
				
				
				
				
			if(boardfield[up][y].getIcon()==null ){
				boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/zlatanbw.png")));			//black and white
				}
			if(boardfield[down][y].getIcon()==null ){
				boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/zlatanbw.png")));
				}
			if(boardfield[x][left].getIcon()==null ){
				boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/zlatanbw.png")));
				}
			if(boardfield[x][right].getIcon()==null ){
				boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/zlatanbw.png")));
				}
			if(boardfield[uprighti][uprightj].getIcon()==null){
				boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/zlatanbw.png")));
				}
			if(boardfield[uplefti][upleftj].getIcon()==null ){
				boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/zlatanbw.png")));
				}
			if(boardfield[downrighti][downrightj].getIcon()==null ){
				boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/zlatanbw.png")));
				}
			if(boardfield[downlefti][downleftj].getIcon()==null ){
				boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/zlatanbw.png")));
				}
			
			
		
		
		
			
			
			
			
			
			
			
			
				
		
			}
	
	
	
	
	
	
	
	if(g1.getCellAt(k,j).getPiece() instanceof Medic	  ){
		
		
		
		moveGUI();
			
		
			
			
		if(g1.getCellAt(up,y).getPiece() instanceof Armored && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Medic && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Tech && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Ranged && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Super && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Speedster && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof SideKick && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
			
			
		if(g1.getCellAt(down,j).getPiece() instanceof Armored && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
			boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}
		if(g1.getCellAt(down,j).getPiece() instanceof Medic && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
			boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}
		if(g1.getCellAt(down,j).getPiece() instanceof Tech && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
			boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}
		if(g1.getCellAt(down,j).getPiece() instanceof Ranged && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
			boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}
		if(g1.getCellAt(down,j).getPiece() instanceof Super && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
			boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}
		if(g1.getCellAt(down,j).getPiece() instanceof Speedster && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
			boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}
		if(g1.getCellAt(down,j).getPiece() instanceof SideKick && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
			boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
			
			
			
			
		if(g1.getCellAt(x,left).getPiece() instanceof Armored && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}
		
		if(g1.getCellAt(x,left).getPiece() instanceof Medic && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Tech && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Ranged && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Super && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Speedster && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof SideKick && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
			
			
			
			
		if(g1.getCellAt(x,right).getPiece() instanceof Armored && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Medic && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Tech && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Ranged && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Super && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Speedster && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof SideKick && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
			
			
			
			
			
		
			
			
			
			
			
			
		if(boardfield[up][y].getIcon()==null ){
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/zidanebw.png")));			//black and white
			}
		if(boardfield[down][y].getIcon()==null ){
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/zidanebw.png")));
			}
		if(boardfield[x][left].getIcon()==null ){
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/zidanebw.png")));
			}
		if(boardfield[x][right].getIcon()==null ){
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/zidanebw.png")));
			}
		
		
	
	
	
		
		
		
		
		
		
		
		
			
	
		}
	
	
	
	
	
	
	
	if(g1.getCellAt(k,j).getPiece() instanceof Super	  ){
		
		
		
		moveGUI();
			
		
			
			
		if(g1.getCellAt(up,y).getPiece() instanceof Armored && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Medic && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Tech && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Ranged && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Super && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Speedster && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof SideKick && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
			
			
		if(g1.getCellAt(down,j).getPiece() instanceof Armored && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
			boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}
		if(g1.getCellAt(down,j).getPiece() instanceof Medic && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
			boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}
		if(g1.getCellAt(down,j).getPiece() instanceof Tech && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
			boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}
		if(g1.getCellAt(down,j).getPiece() instanceof Ranged && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
			boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}
		if(g1.getCellAt(down,j).getPiece() instanceof Super && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
			boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}
		if(g1.getCellAt(down,j).getPiece() instanceof Speedster && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
			boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}
		if(g1.getCellAt(down,j).getPiece() instanceof SideKick && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
			boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
			
			
			
			
			
		if(g1.getCellAt(x,left).getPiece() instanceof Armored && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}
		
		if(g1.getCellAt(x,left).getPiece() instanceof Medic && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Tech && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Ranged && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Super && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Speedster && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof SideKick && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
			
			
			
			
		if(g1.getCellAt(x,right).getPiece() instanceof Armored && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Medic && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Tech && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Ranged && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Super && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Speedster && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof SideKick && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
			
			
			
			
			
		
			
			
			
			
			
			
		if(boardfield[up][y].getIcon()==null ){
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/pirlobw.png")));			//black and white
			}
		if(boardfield[down][y].getIcon()==null ){
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/pirlobw.png")));
			}
		if(boardfield[x][left].getIcon()==null ){
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/pirlobw.png")));
			}
		if(boardfield[x][right].getIcon()==null ){
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/pirlobw.png")));
			}
		
		
	
	
	
		
		
		
		
		
		
		
		
			
	
		}
	if(g1.getCellAt(k,j).getPiece() instanceof Speedster){
	
	
	
	up = x - 2 + g1.getBoardHeight();

	up %= g1.getBoardHeight();
		
	down = x + 2;

	down %= g1.getBoardHeight();
			
	right = y + 2;

	right %= g1.getBoardWidth();
	
	left = y - 2 + g1.getBoardWidth();

	left %= g1.getBoardWidth();
	
		
	uprighti = x - 2 + g1.getBoardHeight();
	uprightj = y + 2;

	uprighti %= g1.getBoardHeight();

	uprightj %= g1.getBoardWidth();
	
	uplefti = x - 2 + g1.getBoardHeight();
	upleftj = y - 2 + g1.getBoardWidth();

	uplefti  %= g1.getBoardHeight();

	upleftj %= g1.getBoardWidth();

	downrighti = x + 2;
	downrightj = y + 2;

	downrighti %= g1.getBoardHeight();

	downrightj %= g1.getBoardWidth();
	
	downlefti = x + 2;
	downleftj = y - 2 + g1.getBoardWidth();

	downlefti %= g1.getBoardHeight();

	downleftj %= g1.getBoardWidth();
	
	
	
	
	
	moveGUI();
	
	
	
	
	if(g1.getCellAt(up,y).getPiece() instanceof Armored && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //up
		boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
		}
	if(g1.getCellAt(up,y).getPiece() instanceof Medic && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
		boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
		}
	if(g1.getCellAt(up,y).getPiece() instanceof Tech && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
		boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
		}
	if(g1.getCellAt(up,y).getPiece() instanceof Ranged && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
		boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
		}
	if(g1.getCellAt(up,y).getPiece() instanceof Super && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
		boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
		}
	if(g1.getCellAt(up,y).getPiece() instanceof Speedster && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
		boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
		}
	if(g1.getCellAt(up,y).getPiece() instanceof SideKick && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
		boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
		}
	
	
	if(g1.getCellAt(down,j).getPiece() instanceof Armored && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
		boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
		}
	if(g1.getCellAt(down,j).getPiece() instanceof Medic && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
		boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
		}
	if(g1.getCellAt(down,j).getPiece() instanceof Tech && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
		boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
		}
	if(g1.getCellAt(down,j).getPiece() instanceof Ranged && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
		boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
		}
	if(g1.getCellAt(down,j).getPiece() instanceof Super && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
		boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
		}
	if(g1.getCellAt(down,j).getPiece() instanceof Speedster && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
		boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
		}
	if(g1.getCellAt(down,j).getPiece() instanceof SideKick && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //down
		boardfield[down][j].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
		}
	
	
	
	
	
	if(g1.getCellAt(x,left).getPiece() instanceof Armored && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
		boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
		}
	
	if(g1.getCellAt(x,left).getPiece() instanceof Medic && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
		boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
		}
	if(g1.getCellAt(x,left).getPiece() instanceof Tech && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
		boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
		}
	if(g1.getCellAt(x,left).getPiece() instanceof Ranged && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
		boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
		}
	if(g1.getCellAt(x,left).getPiece() instanceof Super && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
		boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
		}
	if(g1.getCellAt(x,left).getPiece() instanceof Speedster && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
		boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
		}
	if(g1.getCellAt(x,left).getPiece() instanceof SideKick && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
		boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
		}
	
	
	
	
	if(g1.getCellAt(x,right).getPiece() instanceof Armored && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
		boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
		}

	if(g1.getCellAt(x,right).getPiece() instanceof Medic && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
		boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
		}

	if(g1.getCellAt(x,right).getPiece() instanceof Tech && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
		boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
		}

	if(g1.getCellAt(x,right).getPiece() instanceof Ranged && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
		boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
		}

	if(g1.getCellAt(x,right).getPiece() instanceof Super && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
		boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
		}

	if(g1.getCellAt(x,right).getPiece() instanceof Speedster && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
		boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
		}

	if(g1.getCellAt(x,right).getPiece() instanceof SideKick && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
		boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
		}
	
	
	
	
	
	if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Armored && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
		boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
		}
	if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Medic && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
		boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
		}
	if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Tech && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
		boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
		}
	if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Ranged && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
		boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
		}
	if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Super && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
		boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
		}
	if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Speedster && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){//upleft
		boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
		}
	if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof SideKick && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
		boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
		}
	
	
	
	
	
	if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Armored && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
		boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
		}
	if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Medic && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
		boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
		}
	if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Tech && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
		boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
		}
	if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Ranged && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
		boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
		}
	if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Super && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
		boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
		}
	if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Speedster && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
		boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
		}
	if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof SideKick && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
		boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
		}
	
	
	
	
	if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Armored && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
		boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
		}
	if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Medic && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
		boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
		}
	if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Tech && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
		boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
		}
	if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Ranged && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
		boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
		}
	if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Super && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
		boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
		}
	if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Speedster && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
		boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
		}
	if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof SideKick && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
		boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
		}
	
	
	
	
	if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Armored && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
		boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
		}
	if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Medic && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
		boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
		}
	if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Tech && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
		boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
		}
	if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Ranged && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
		boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
		}
	if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof  Super && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
		boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
		}
	if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Speedster && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
		boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
		}
	if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof SideKick && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
		boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
		}
	
	
	
	
	
	
	
	
if(boardfield[up][y].getIcon()==null ){
	boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/balebw.png")));			//black and white
	}
if(boardfield[down][y].getIcon()==null ){
	boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/balebw.png")));
	}
if(boardfield[x][left].getIcon()==null ){
	boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/balebw.png")));
	}
if(boardfield[x][right].getIcon()==null ){
	boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/balebw.png")));
	}
if(boardfield[uprighti][uprightj].getIcon()==null){
	boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/balebw.png")));
	}
if(boardfield[uplefti][upleftj].getIcon()==null ){
	boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/balebw.png")));
	}
if(boardfield[downrighti][downrightj].getIcon()==null ){
	boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/balebw.png")));
	}
if(boardfield[downlefti][downleftj].getIcon()==null ){
	boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/balebw.png")));
	}

	}
	
	
		
	if(g1.getCellAt(k,j).getPiece() instanceof Tech  ){
		
		
		
		moveGUI();
			
		
			
			
	
			
			
			
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Armored && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Medic && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Tech && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Ranged && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Super && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Speedster && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){//upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof SideKick && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
		
		
		
		
		
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Armored && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Medic && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Tech && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Ranged && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Super && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Speedster && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof SideKick && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
		
		
		
		
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Armored && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Medic && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Tech && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Ranged && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Super && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Speedster && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof SideKick && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
		
		
		
		
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Armored && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Medic && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Tech && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Ranged && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof  Super && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Speedster && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof SideKick && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
		
			
			
			
		
		if(boardfield[uprighti][uprightj].getIcon()==null){
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldobw.png")));
			}
		if(boardfield[uplefti][upleftj].getIcon()==null ){
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldobw.png")));
			}
		if(boardfield[downrighti][downrightj].getIcon()==null ){
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldobw.png")));
			}
		if(boardfield[downlefti][downleftj].getIcon()==null ){
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldobw.png")));
			}
		
		
	
	
	
		
		
		
		
		
		
		
		
			
	
		}
	
	if(g1.getCellAt(k,j).getPiece() instanceof SideKick  ){
		
		
		
		moveGUI();
			
		
			
			
		if(g1.getCellAt(up,y).getPiece() instanceof Armored && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){ //up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Medic && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Tech && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Ranged && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Super && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Speedster && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof SideKick && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer2()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
		
			
			
			
			
			
			
			
		if(g1.getCellAt(x,left).getPiece() instanceof Armored && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}
		
		if(g1.getCellAt(x,left).getPiece() instanceof Medic && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Tech && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Ranged && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Super && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Speedster && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof SideKick && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer2()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
		
			
			
			
			
		if(g1.getCellAt(x,right).getPiece() instanceof Armored && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Medic && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Tech && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Ranged && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Super && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Speedster && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof SideKick && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer2()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
		
		
		
		
		
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Armored && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Medic && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Tech && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Ranged && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Super && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Speedster && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){//upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof SideKick && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
		
		
		
		
		
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Armored && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/xavitarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Medic && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/maradonatarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Tech && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/messitarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Ranged && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/suareztarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Super && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhotarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Speedster && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/neymartarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof SideKick && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer2()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2target.png")));
			}
		
			

			
			
			
			
			
			
		if(boardfield[up][y].getIcon()==null ){
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1bw.png")));			//black and white
			}
		
		if(boardfield[x][left].getIcon()==null ){
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1bw.png")));
			}
		if(boardfield[x][right].getIcon()==null ){
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1bw.png")));
			}
		if(boardfield[uprighti][uprightj].getIcon()==null){
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1bw.png")));
			}
		if(boardfield[uplefti][upleftj].getIcon()==null ){
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1bw.png")));
			}
		
		
	
	
	
		
		
		
		
	}
		

	
	
	
	
		
	}
	public void moveIcon2(int x,int y){
		moveGUI();
		int up=x-1;
		if (up < 0) {
			up = g1.getBoardHeight() - 1;
		}
		int down = x + 1;

		if (down == g1.getBoardHeight()) {
			down = 0;
		}
		int right = y + 1;

		if (right == g1.getBoardWidth()) {
			right = 0;
		}
		
		int left = y - 1;

		if (left < 0) {
			left = g1.getBoardWidth() - 1;
		}
		
		int uprighti = x - 1;
		int uprightj = y + 1;

		if (uprighti < 0) {
			uprighti = g1.getBoardHeight() - 1;
		}

		if (uprightj == g1.getBoardWidth()) {
			uprightj = 0;
		}
		
		
		int uplefti = x- 1;
		int upleftj = y - 1;

		if (uplefti < 0) {
			uplefti = g1.getBoardHeight() - 1;
		}

		if (upleftj < 0) {
			upleftj = g1.getBoardWidth() - 1;
		}
		
		
		int downrighti = x + 1;
		int downrightj = y + 1;

		if (downrighti == g1.getBoardHeight()) {
			downrighti = 0;
		}

		if (downrightj == g1.getBoardWidth()) {
			downrightj = 0;
		}
		
		
		int downlefti = x + 1;
		int downleftj = y - 1;

		if (downlefti == g1.getBoardHeight()) {
			downlefti = 0;
		}
		if (downleftj < 0) {
			downleftj = g1.getBoardWidth() - 1;
		}
		
		
	if(g1.getCellAt(k,j).getPiece() instanceof Armored)	{
		moveGUI();
		
		if(g1.getCellAt(up,y).getPiece() instanceof Armored && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Medic && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Tech && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Ranged && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Super && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Speedster && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof SideKick && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		if(g1.getCellAt(down,y).getPiece() instanceof Armored && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Medic && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Tech && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Ranged && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Super && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Speedster && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof SideKick && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		if(g1.getCellAt(x,left).getPiece() instanceof Armored && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		
		if(g1.getCellAt(x,left).getPiece() instanceof Medic && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Tech && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Ranged && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Super && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Speedster && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1())){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof SideKick && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		if(g1.getCellAt(x,right).getPiece() instanceof Armored && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Medic && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Tech && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Ranged && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Super && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Speedster && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof SideKick && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Armored && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Medic && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Tech && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Ranged && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Super && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Speedster && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){//upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof SideKick && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Armored && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Medic && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Tech && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Ranged && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Super && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Speedster && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof SideKick && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Armored && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Medic && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Tech && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Ranged && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Super && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Speedster && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof SideKick && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Armored && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Medic && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Tech && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Ranged && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof  Super && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Speedster && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof SideKick && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		
		
		
	if(boardfield[up][y].getIcon()==null ){
		boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/xavibw.png")));			//black and white
		}
	if(boardfield[down][y].getIcon()==null ){
		boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/xavibw.png")));
		}
	if(boardfield[x][left].getIcon()==null ){
		boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/xavibw.png")));
		}
	if(boardfield[x][right].getIcon()==null ){
		boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/xavibw.png")));
		}
	if(boardfield[uprighti][uprightj].getIcon()==null){
		boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/xavibw.png")));
		}
	if(boardfield[uplefti][upleftj].getIcon()==null ){
		boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/xavibw.png")));
		}
	if(boardfield[downrighti][downrightj].getIcon()==null ){
		boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/xavibw.png")));
		}
	if(boardfield[downlefti][downleftj].getIcon()==null ){
		boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/xavibw.png")));
		}
	}
	
	
	
	if(g1.getCellAt(k,j).getPiece() instanceof Ranged)	{
		moveGUI();
		
		if(g1.getCellAt(up,y).getPiece() instanceof Armored && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Medic && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Tech && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Ranged && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Super && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Speedster && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof SideKick && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		if(g1.getCellAt(down,y).getPiece() instanceof Armored && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Medic && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Tech && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Ranged && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Super && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Speedster && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof SideKick && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		if(g1.getCellAt(x,left).getPiece() instanceof Armored && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		
		if(g1.getCellAt(x,left).getPiece() instanceof Medic && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Tech && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Ranged && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Super && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Speedster && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1())){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof SideKick && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		if(g1.getCellAt(x,right).getPiece() instanceof Armored && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Medic && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Tech && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Ranged && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Super && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Speedster && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof SideKick && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Armored && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Medic && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Tech && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Ranged && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Super && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Speedster && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){//upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof SideKick && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Armored && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Medic && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Tech && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Ranged && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Super && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Speedster && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof SideKick && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Armored && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Medic && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Tech && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Ranged && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Super && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Speedster && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof SideKick && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Armored && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Medic && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Tech && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Ranged && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof  Super && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Speedster && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof SideKick && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		
		
		
		
	if(boardfield[up][y].getIcon()==null ){
		boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/suarezbw.png")));			//black and white
		}
	if(boardfield[down][y].getIcon()==null ){
		boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/suarezbw.png")));
		}
	if(boardfield[x][left].getIcon()==null ){
		boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/suarezbw.png")));
		}
	if(boardfield[x][right].getIcon()==null ){
		boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/suarezbw.png")));
		}
	if(boardfield[uprighti][uprightj].getIcon()==null){
		boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/suarezbw.png")));
		}
	if(boardfield[uplefti][upleftj].getIcon()==null ){
		boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/suarezbw.png")));
		}
	if(boardfield[downrighti][downrightj].getIcon()==null ){
		boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/suarezbw.png")));
		}
	if(boardfield[downlefti][downleftj].getIcon()==null ){
		boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/suarezbw.png")));
		}
	}
	
	
	
	
	
	
	
	if(g1.getCellAt(k,j).getPiece() instanceof Medic)	{
		moveGUI();
		
		if(g1.getCellAt(up,y).getPiece() instanceof Armored && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Medic && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Tech && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Ranged && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Super && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Speedster && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof SideKick && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		if(g1.getCellAt(down,y).getPiece() instanceof Armored && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Medic && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Tech && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Ranged && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Super && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Speedster && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof SideKick && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		if(g1.getCellAt(x,left).getPiece() instanceof Armored && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		
		if(g1.getCellAt(x,left).getPiece() instanceof Medic && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Tech && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Ranged && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Super && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Speedster && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1())){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof SideKick && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		if(g1.getCellAt(x,right).getPiece() instanceof Armored && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Medic && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Tech && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Ranged && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Super && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Speedster && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof SideKick && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		
		
		
		
		
		
		
	if(boardfield[up][y].getIcon()==null ){
		boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/maradonabw.png")));			//black and white
		}
	if(boardfield[down][y].getIcon()==null ){
		boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/maradonabw.png")));
		}
	if(boardfield[x][left].getIcon()==null ){
		boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/maradonabw.png")));
		}
	if(boardfield[x][right].getIcon()==null ){
		boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/maradonabw.png")));
		}
	
	}
	
	
	
	
	
	
	
	if(g1.getCellAt(k,j).getPiece() instanceof Super)	{
		moveGUI();
		
		if(g1.getCellAt(up,y).getPiece() instanceof Armored && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Medic && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Tech && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Ranged && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Super && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Speedster && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof SideKick && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		if(g1.getCellAt(down,y).getPiece() instanceof Armored && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Medic && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Tech && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Ranged && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Super && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Speedster && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof SideKick && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		if(g1.getCellAt(x,left).getPiece() instanceof Armored && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		
		if(g1.getCellAt(x,left).getPiece() instanceof Medic && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Tech && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Ranged && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Super && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Speedster && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1())){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof SideKick && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		if(g1.getCellAt(x,right).getPiece() instanceof Armored && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Medic && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Tech && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Ranged && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Super && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Speedster && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof SideKick && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		
		
		
		
	if(boardfield[up][y].getIcon()==null ){
		boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhobw.png")));			//black and white
		}
	if(boardfield[down][y].getIcon()==null ){
		boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhobw.png")));
		}
	if(boardfield[x][left].getIcon()==null ){
		boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhobw.png")));
		}
	if(boardfield[x][right].getIcon()==null ){
		boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhobw.png")));
		}
	
	}
	
	
	
	
	
	
	if(g1.getCellAt(k,j).getPiece() instanceof Tech)	{
		moveGUI();
	
		
		
		
		
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Armored && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Medic && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Tech && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Ranged && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Super && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Speedster && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){//upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof SideKick && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Armored && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Medic && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Tech && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Ranged && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Super && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Speedster && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof SideKick && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Armored && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Medic && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Tech && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Ranged && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Super && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Speedster && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof SideKick && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Armored && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Medic && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Tech && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Ranged && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof  Super && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Speedster && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof SideKick && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		
		
		
	
	if(boardfield[uprighti][uprightj].getIcon()==null){
		boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/messibw.png")));
		}
	if(boardfield[uplefti][upleftj].getIcon()==null ){
		boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/messibw.png")));
		}
	if(boardfield[downrighti][downrightj].getIcon()==null ){
		boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/messibw.png")));
		}
	if(boardfield[downlefti][downleftj].getIcon()==null ){
		boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/messibw.png")));
		}
	}
	
	
	
	if(g1.getCellAt(k,j).getPiece() instanceof Speedster)	{
		up = x - 2 + g1.getBoardHeight();

		up %= g1.getBoardHeight();
			
		down = x + 2;

		down %= g1.getBoardHeight();
				
		right = y + 2;

		right %= g1.getBoardWidth();
		
		left = y - 2 + g1.getBoardWidth();

		left %= g1.getBoardWidth();
		
			
		uprighti = x - 2 + g1.getBoardHeight();
		uprightj = y + 2;

		uprighti %= g1.getBoardHeight();

		uprightj %= g1.getBoardWidth();
		
		uplefti = x - 2 + g1.getBoardHeight();
		upleftj = y - 2 + g1.getBoardWidth();

		uplefti  %= g1.getBoardHeight();

		upleftj %= g1.getBoardWidth();

		downrighti = x + 2;
		downrightj = y + 2;

		downrighti %= g1.getBoardHeight();

		downrightj %= g1.getBoardWidth();
		
		downlefti = x + 2;
		downleftj = y - 2 + g1.getBoardWidth();

		downlefti %= g1.getBoardHeight();

		downleftj %= g1.getBoardWidth();
		
		moveGUI();
		
		if(g1.getCellAt(up,y).getPiece() instanceof Armored && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Medic && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Tech && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Ranged && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Super && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof Speedster && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){	//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(up,y).getPiece() instanceof SideKick && g1.getCellAt(up,y).getPiece().getOwner().equals(g1.getPlayer1()) ){		//up
			boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		if(g1.getCellAt(down,y).getPiece() instanceof Armored && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Medic && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Tech && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Ranged && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Super && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Speedster && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof SideKick && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		if(g1.getCellAt(x,left).getPiece() instanceof Armored && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		
		if(g1.getCellAt(x,left).getPiece() instanceof Medic && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Tech && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Ranged && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Super && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Speedster && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1())){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof SideKick && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		if(g1.getCellAt(x,right).getPiece() instanceof Armored && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Medic && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Tech && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Ranged && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Super && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Speedster && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof SideKick && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Armored && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Medic && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Tech && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Ranged && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Super && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof Speedster && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){//upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(uplefti,upleftj).getPiece() instanceof SideKick && g1.getCellAt(uplefti,upleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upleft
			boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Armored && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Medic && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Tech && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Ranged && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Super && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof Speedster && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(uprighti,uprightj).getPiece() instanceof SideKick && g1.getCellAt(uprighti,uprightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //upright
			boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Armored && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Medic && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Tech && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Ranged && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Super && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Speedster && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof SideKick && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Armored && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Medic && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Tech && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Ranged && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof  Super && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Speedster && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof SideKick && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
	if(boardfield[up][y].getIcon()==null ){
		boardfield[up][y].setIcon(new ImageIcon(this.getClass().getResource("/neymarbw.png")));			//black and white
		}
	if(boardfield[down][y].getIcon()==null ){
		boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/neymarbw.png")));
		}
	if(boardfield[x][left].getIcon()==null ){
		boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/neymarbw.png")));
		}
	if(boardfield[x][right].getIcon()==null ){
		boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/neymarbw.png")));
		}
	if(boardfield[uprighti][uprightj].getIcon()==null){
		boardfield[uprighti][uprightj].setIcon(new ImageIcon(this.getClass().getResource("/neymarbw.png")));
		}
	if(boardfield[uplefti][upleftj].getIcon()==null ){
		boardfield[uplefti][upleftj].setIcon(new ImageIcon(this.getClass().getResource("/neymarbw.png")));
		}
	if(boardfield[downrighti][downrightj].getIcon()==null ){
		boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/neymarbw.png")));
		}
	if(boardfield[downlefti][downleftj].getIcon()==null ){
		boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/neymarbw.png")));
		}
	}
	
	
	
	if(g1.getCellAt(k,j).getPiece() instanceof SideKick)	{
		moveGUI();
		
		
			
		
		
		if(g1.getCellAt(down,y).getPiece() instanceof Armored && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Medic && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Tech && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Ranged && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Super && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof Speedster && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(down,y).getPiece() instanceof SideKick && g1.getCellAt(down,y).getPiece().getOwner().equals(g1.getPlayer1()) ){ //down
			boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		if(g1.getCellAt(x,left).getPiece() instanceof Armored && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		
		if(g1.getCellAt(x,left).getPiece() instanceof Medic && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Tech && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Ranged && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Super && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof Speedster && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1())){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(x,left).getPiece() instanceof SideKick && g1.getCellAt(x,left).getPiece().getOwner().equals(g1.getPlayer1()) ){ //left
			boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		if(g1.getCellAt(x,right).getPiece() instanceof Armored && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Medic && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Tech && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Ranged && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Super && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof Speedster && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}

		if(g1.getCellAt(x,right).getPiece() instanceof SideKick && g1.getCellAt(x,right).getPiece().getOwner().equals(g1.getPlayer1()) ){ //right
			boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		
		
		
		
		
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Armored && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Medic && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Tech && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Ranged && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Super && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof Speedster && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(downrighti,downrightj).getPiece() instanceof SideKick && g1.getCellAt(downrighti,downrightj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downright
			boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
		
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Armored && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sancheztarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Medic && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/zidanetarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Tech && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/ronaldotarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Ranged && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/zlatantarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof  Super && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/pirlotarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof Speedster && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/baletarget.png")));
			}
		if(g1.getCellAt(downlefti,downleftj).getPiece() instanceof SideKick && g1.getCellAt(downlefti,downleftj).getPiece().getOwner().equals(g1.getPlayer1()) ){ //downleft
			boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1target.gif")));
			}
		
		
		
	
	if(boardfield[down][y].getIcon()==null ){
		boardfield[down][y].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2bw.png")));
		}
	if(boardfield[x][left].getIcon()==null ){
		boardfield[x][left].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2bw.png")));
		}
	if(boardfield[x][right].getIcon()==null ){
		boardfield[x][right].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2bw.png")));
		}
	
	if(boardfield[downrighti][downrightj].getIcon()==null ){
		boardfield[downrighti][downrightj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2bw.png")));
		}
	if(boardfield[downlefti][downleftj].getIcon()==null ){
		boardfield[downlefti][downleftj].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2bw.png")));
		}
	}
	
	
	
	
	
	
	
	}




	
	public void actionPerformed(ActionEvent e) {
		 
			if(e.getActionCommand().equals("restart")){
			 	
		    	 try {
					MainWindow W=new MainWindow();
				} catch (IOException a) {
					
					System.out.println("file not found");
				}
			}
		
			if(e.getActionCommand().equals("quit")){
			 	W1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	 
				
				
			}
		
		
		
		
			
			
			
			
			
		
		
		for(int i=0;i<=6;i++){
	       	 for( int c=0;c<=5;c++){
	       		 if(e.getSource()==boardfield[i][c]) {
	       			 k=i;
	       			 j=c;
	       			 break;
	       		 }
	       		
	       	 }
	       	 
	       	 
		}
		
		
		
		

		

		if(g1.getCellAt(k, j).getPiece()!=null){
		
		
			if(g1.getCellAt(k, j).getPiece().getOwner().equals(g1.getPlayer1())&& g1.getCurrentPlayer().equals(g1.getPlayer1())){
			 moveIcon1(k,j);
			}
			else if(g1.getCellAt(k, j).getPiece().getOwner().equals(g1.getPlayer2())&& g1.getCurrentPlayer().equals(g1.getPlayer2()) ){
				 moveIcon2(k,j);
				}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
			
		
			
			
			if(e.getActionCommand().equals("USEPOWER")  ){
				if((g1.getCellAt(k,j).getPiece() instanceof ActivatablePowerHero)){
				if( ((ActivatablePowerHero)g1.getCellAt(k,j).getPiece()).isPowerUsed()==false){
				
				if((g1.getCellAt(k,j).getPiece() instanceof Super || g1.getCellAt(k,j).getPiece() instanceof Medic || g1.getCellAt(k,j).getPiece() instanceof Ranged )&& ((ActivatablePowerHero)g1.getCellAt(k,j).getPiece()).isPowerUsed()==false){
					flag1=true;
					
				}
				else if(g1.getCellAt(k, j).getPiece() instanceof Tech && ((ActivatablePowerHero)g1.getCellAt(k,j).getPiece()).isPowerUsed()==false){
					
					flagT=true;
					a1=k;
					a2=j;
				}
				
				
				}
				}
		  	}
		
			
		
			
		
			
			if(!(g1.getCellAt(k, j).getPiece() instanceof Tech ) && flagT==true  && g1.getCellAt(k, j).getPiece()!=null){										// Tech usepower
				
				
				
				
				
			
				
				
				if(x1==k && x2==j){
				try {
					
					
					((Tech)g1.getCellAt(a1, a2).getPiece()).usePower(null, g1.getCellAt(k,j).getPiece(), null);
					moveGUI();
					flagT=false;
					
					x1=-1;
					x2=-1;
				} catch (InvalidPowerUseException e1) {
					JFrame ex = new JFrame();
					 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Invalid Power use ");
					ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				} catch (WrongTurnException e1) {
					JFrame ex = new JFrame();
					 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
						ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Wrong Turn ");
				}
					
				
				
				}
				else{
					x1=k;
					x2=j;
				}
				
			}
			
			if(flagT==true && g1.getCellAt(k, j).getPiece()==null){
				
				try {
					
					
					((Tech)g1.getCellAt(a1, a2).getPiece()).usePower(null, g1.getCellAt(x1,x2).getPiece(), new Point(k,j));
					moveGUI();
					flagT=false;
					
					
					
				}catch (InvalidPowerUseException e1) {
					JFrame ex = new JFrame();
					 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Invalid Power use ");
					ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				} catch (WrongTurnException e1) {
					JFrame ex = new JFrame();
					 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
						ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Wrong Turn ");
				}
				
				
			}
				
				
			
			
				
				
	
			
			
			
			
			
			
			if(g1.getCellAt(k,j).getPiece()!=null  ) {
				
				
			
			if(g1.getCellAt(k, j).getPiece() instanceof Medic){								//Medic usepower
				
				
					if(g1.getCellAt(k,j).getPiece().getOwner().equals(g1.getPlayer1())){
						
							for(int i=0;i<=8;i++){
								if(e.getSource().equals(D1[i])){
									d1=i;
									break;
								}
							}
						
							
							
							if(e.getActionCommand().equals("UP") && flag1==true){
								flag1=false;
							
						try {
							((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.UP,g1.getPlayer1().getDeadCharacters().get(d1),null);
							moveGUI();
						}catch (InvalidPowerUseException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Invalid Power use ");
							ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						} catch (WrongTurnException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
								ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Wrong Turn ");
						}
						return;
							}
							
							if(e.getActionCommand().equals("LEFT") && flag1==true){
								flag1=false;
								try {
									((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.LEFT,g1.getPlayer1().getDeadCharacters().get(d1),null);
									moveGUI();
								}catch (InvalidPowerUseException e1) {
									JFrame ex = new JFrame();
									 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
									ImagePanel ex1 = new ImagePanel(img2);
									ex.setBounds(500, 150, 370, 300);
									ex1.setVisible(true);
									ex.add(ex1);
									ex.setVisible(true);
									ex.setTitle("Foul!! Invalid Power use ");
									ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
								} catch (WrongTurnException e1) {
									JFrame ex = new JFrame();
									 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
										ImagePanel ex1 = new ImagePanel(img2);
									ex.setBounds(500, 150, 370, 300);
									ex1.setVisible(true);
									ex.add(ex1);
									ex.setVisible(true);
									ex.setTitle("Foul!! Wrong Turn ");
								}
								return;
									}
							
							if(e.getActionCommand().equals("RIGHT")  && flag1==true){
								flag1=false;
								try {
									((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.RIGHT,g1.getPlayer1().getDeadCharacters().get(d1),null);
									moveGUI();
								} catch (InvalidPowerUseException e1) {
									JFrame ex = new JFrame();
									 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
									ImagePanel ex1 = new ImagePanel(img2);
									ex.setBounds(500, 150, 370, 300);
									ex1.setVisible(true);
									ex.add(ex1);
									ex.setVisible(true);
									ex.setTitle("Foul!! Invalid Power use ");
									ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
								} catch (WrongTurnException e1) {
									JFrame ex = new JFrame();
									 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
										ImagePanel ex1 = new ImagePanel(img2);
									ex.setBounds(500, 150, 370, 300);
									ex1.setVisible(true);
									ex.add(ex1);
									ex.setVisible(true);
									ex.setTitle("Foul!! Wrong Turn ");
								}
								return;
									}
							
							
							if(e.getActionCommand().equals("DOWN") && flag1==true){
								flag1=false;
								try {
									((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.DOWN,g1.getPlayer1().getDeadCharacters().get(d1),null);
									moveGUI();					
								}catch (InvalidPowerUseException e1) {
									JFrame ex = new JFrame();
									 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
									ImagePanel ex1 = new ImagePanel(img2);
									ex.setBounds(500, 150, 370, 300);
									ex1.setVisible(true);
									ex.add(ex1);
									ex.setVisible(true);
									ex.setTitle("Foul!! Invalid Power use ");
									ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
								} catch (WrongTurnException e1) {
									JFrame ex = new JFrame();
									 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
										ImagePanel ex1 = new ImagePanel(img2);
									ex.setBounds(500, 150, 370, 300);
									ex1.setVisible(true);
									ex.add(ex1);
									ex.setVisible(true);
									ex.setTitle("Foul!! Wrong Turn ");
								}
								return;
									}
							
							
							
							if(e.getActionCommand().equals("UPLEFT") && flag1==true){
								flag1=false;
							
						try {
							((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.UPLEFT,g1.getPlayer1().getDeadCharacters().get(d1),null);
							moveGUI();
						} catch (InvalidPowerUseException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Invalid Power use ");
							ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						} catch (WrongTurnException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
								ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Wrong Turn ");
						}
						return;
							}
							
							
							if(e.getActionCommand().equals("UPRIGHT") && flag1==true){
								flag1=false;
							
						try {
							((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.UPRIGHT,g1.getPlayer1().getDeadCharacters().get(d1),null);
							moveGUI();
						} catch (InvalidPowerUseException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Invalid Power use ");
							ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						} catch (WrongTurnException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
								ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Wrong Turn ");
						}
						return;
							}
							
							
							if(e.getActionCommand().equals("DOWNLEFT") && flag1==true){
								flag1=false;
							
						try {
							((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.DOWNLEFT,g1.getPlayer1().getDeadCharacters().get(d1),null);
							moveGUI();
						} catch (InvalidPowerUseException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Invalid Power use ");
							ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						} catch (WrongTurnException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
								ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Wrong Turn ");
						}
						return;
							}
							
							if(e.getActionCommand().equals("DOWNRIGHT") && flag1==true){
								flag1=false;
							
						try {
							((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.DOWNRIGHT,g1.getPlayer1().getDeadCharacters().get(d1),null);
							moveGUI();
						} catch (InvalidPowerUseException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Invalid Power use ");
							ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						} catch (WrongTurnException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
								ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Wrong Turn ");
						}
						return;
							}
							
							
							
							
							
							
							
							
						
					}
					
					if(g1.getCellAt(k,j).getPiece().getOwner().equals(g1.getPlayer2())){
						
						for(int i=0;i<=8;i++){
							if(e.getSource().equals(D2[i])){
								d2=i;
								break;
							}
						}
						
						
						
						if(e.getActionCommand().equals("UP") && flag1==true){
							flag1=false;
						
					try {
						((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.UP,g1.getPlayer2().getDeadCharacters().get(d2),null);
						moveGUI();
					}catch (InvalidPowerUseException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
						ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Invalid Power use ");
						ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					} catch (WrongTurnException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Wrong Turn ");
					}
					return;
						}
						
						if(e.getActionCommand().equals("LEFT") && flag1==true){
							flag1=false;
							try {
								((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.LEFT,g1.getPlayer2().getDeadCharacters().get(d2),null);
								moveGUI();
							} catch (InvalidPowerUseException e1) {
								JFrame ex = new JFrame();
								 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
								ImagePanel ex1 = new ImagePanel(img2);
								ex.setBounds(500, 150, 370, 300);
								ex1.setVisible(true);
								ex.add(ex1);
								ex.setVisible(true);
								ex.setTitle("Foul!! Invalid Power use ");
								ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
							} catch (WrongTurnException e1) {
								JFrame ex = new JFrame();
								 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
									ImagePanel ex1 = new ImagePanel(img2);
								ex.setBounds(500, 150, 370, 300);
								ex1.setVisible(true);
								ex.add(ex1);
								ex.setVisible(true);
								ex.setTitle("Foul!! Wrong Turn ");
							}
							return;
								}
						
						if(e.getActionCommand().equals("RIGHT")  && flag1==true){
							flag1=false;
							try {
								((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.RIGHT,g1.getPlayer2().getDeadCharacters().get(d2),null);
								moveGUI();
							}catch (InvalidPowerUseException e1) {
								JFrame ex = new JFrame();
								 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
								ImagePanel ex1 = new ImagePanel(img2);
								ex.setBounds(500, 150, 370, 300);
								ex1.setVisible(true);
								ex.add(ex1);
								ex.setVisible(true);
								ex.setTitle("Foul!! Invalid Power use ");
								ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
							} catch (WrongTurnException e1) {
								JFrame ex = new JFrame();
								 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
									ImagePanel ex1 = new ImagePanel(img2);
								ex.setBounds(500, 150, 370, 300);
								ex1.setVisible(true);
								ex.add(ex1);
								ex.setVisible(true);
								ex.setTitle("Foul!! Wrong Turn ");
							}
							return;
								}
						
						
						if(e.getActionCommand().equals("DOWN") && flag1==true){
							flag1=false;
							try {
								((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.DOWN,g1.getPlayer2().getDeadCharacters().get(d2),null);
								moveGUI();					
							} catch (InvalidPowerUseException e1) {
								JFrame ex = new JFrame();
								 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
								ImagePanel ex1 = new ImagePanel(img2);
								ex.setBounds(500, 150, 370, 300);
								ex1.setVisible(true);
								ex.add(ex1);
								ex.setVisible(true);
								ex.setTitle("Foul!! Invalid Power use ");
								ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
							} catch (WrongTurnException e1) {
								JFrame ex = new JFrame();
								 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
									ImagePanel ex1 = new ImagePanel(img2);
								ex.setBounds(500, 150, 370, 300);
								ex1.setVisible(true);
								ex.add(ex1);
								ex.setVisible(true);
								ex.setTitle("Foul!! Wrong Turn ");
							}
							return;
								}
						
						
						
						if(e.getActionCommand().equals("UPLEFT") && flag1==true){
							flag1=false;
						
					try {
						((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.UPLEFT,g1.getPlayer2().getDeadCharacters().get(d2),null);
						moveGUI();
					} catch (InvalidPowerUseException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
						ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Invalid Power use ");
						ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					} catch (WrongTurnException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Wrong Turn ");
					}
					return;
						}
						
						
						if(e.getActionCommand().equals("UPRIGHT") && flag1==true){
							flag1=false;
						
					try {
						((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.UPRIGHT,g1.getPlayer2().getDeadCharacters().get(d2),null);
						moveGUI();
					} catch (InvalidPowerUseException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
						ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Invalid Power use ");
						ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					} catch (WrongTurnException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Wrong Turn ");
					}
					return;
						}
						
						
						if(e.getActionCommand().equals("DOWNLEFT") && flag1==true){
							flag1=false;
						
					try {
						((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.DOWNLEFT,g1.getPlayer2().getDeadCharacters().get(d2),null);
						moveGUI();
					} catch (InvalidPowerUseException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
						ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Invalid Power use ");
						ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					} catch (WrongTurnException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Wrong Turn ");
					}
					return;
						}
						
						if(e.getActionCommand().equals("DOWNRIGHT") && flag1==true){
							flag1=false;
						
					try {
						((Medic)g1.getCellAt(k, j).getPiece()).usePower(Direction.DOWNRIGHT,g1.getPlayer2().getDeadCharacters().get(d2),null);
						moveGUI();
					}catch (InvalidPowerUseException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
						ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Invalid Power use ");
						ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					} catch (WrongTurnException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Wrong Turn ");
					}
					return;
						}
						
						
						
						
						
						
						
					
					
				}
					
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			if(g1.getCellAt(k, j).getPiece() instanceof Super){									//super usepower
				
				
				
				if(e.getActionCommand().equals("UP") && flag1==true){
					flag1=false;
				
			try {
				((Super)g1.getCellAt(k, j).getPiece()).usePower(Direction.UP,null,null);
				moveGUI();
			}catch (InvalidPowerUseException e1) {
				JFrame ex = new JFrame();
				 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
				ImagePanel ex1 = new ImagePanel(img2);
				ex.setBounds(500, 150, 370, 300);
				ex1.setVisible(true);
				ex.add(ex1);
				ex.setVisible(true);
				ex.setTitle("Foul!! Invalid Power use ");
				ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			} catch (WrongTurnException e1) {
				JFrame ex = new JFrame();
				 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
				ex.setBounds(500, 150, 370, 300);
				ex1.setVisible(true);
				ex.add(ex1);
				ex.setVisible(true);
				ex.setTitle("Foul!! Wrong Turn ");
			}
			return;
				}
				
				if(e.getActionCommand().equals("LEFT") && flag1==true){
					flag1=false;
					try {
						((Super)g1.getCellAt(k, j).getPiece()).usePower(Direction.LEFT,null,null);
						moveGUI();
					}catch (InvalidPowerUseException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
						ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Invalid Power use ");
						ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					} catch (WrongTurnException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Wrong Turn ");
					}
					return;
						}
				
				if(e.getActionCommand().equals("RIGHT")  && flag1==true){
					flag1=false;
					try {
						((Super)g1.getCellAt(k, j).getPiece()).usePower(Direction.RIGHT,null,null);
						moveGUI();
					}catch (InvalidPowerUseException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
						ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Invalid Power use ");
						ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					} catch (WrongTurnException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Wrong Turn ");
					}
					return;
						}
				
				
				if(e.getActionCommand().equals("DOWN") && flag1==true){
					flag1=false;
					try {
						((Super)g1.getCellAt(k, j).getPiece()).usePower(Direction.DOWN,null,null);
						moveGUI();					
					}catch (InvalidPowerUseException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
						ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Invalid Power use ");
						ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					} catch (WrongTurnException e1) {
						JFrame ex = new JFrame();
						 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
						ex.setBounds(500, 150, 370, 300);
						ex1.setVisible(true);
						ex.add(ex1);
						ex.setVisible(true);
						ex.setTitle("Foul!! Wrong Turn ");
					}
					return;
						}
				
				
				
				
				
				
				
			}
		
			
			
			
			
			
			
			
			
			
			
			
			
			
				if(g1.getCellAt(k, j).getPiece() instanceof Ranged){						//ranged usepower
					
					if(e.getActionCommand().equals("UP") && flag1==true ){
						flag1=false;
						
				try {
					((Ranged)g1.getCellAt(k, j).getPiece()).usePower(Direction.UP,null,null);
					moveGUI();
				}catch (InvalidPowerUseException e1) {
					JFrame ex = new JFrame();
					 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Invalid Power use ");
					ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				} catch (WrongTurnException e1) {
					JFrame ex = new JFrame();
					 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
						ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Wrong Turn ");
				}
				return;
					}
					
					if(e.getActionCommand().equals("LEFT")  && flag1==true){
						flag1=false;
						try {
							((Ranged)g1.getCellAt(k, j).getPiece()).usePower(Direction.LEFT,null,null);
							moveGUI();
						}catch (InvalidPowerUseException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Invalid Power use ");
							ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						} catch (WrongTurnException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
								ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Wrong Turn ");
						}
						return;
							}
					
					if(e.getActionCommand().equals("RIGHT") && flag1==true){
						flag1=false;
						try {
							((Ranged)g1.getCellAt(k, j).getPiece()).usePower(Direction.RIGHT,null,null);
							moveGUI();
						}catch (InvalidPowerUseException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Invalid Power use ");
							ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						} catch (WrongTurnException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
								ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Wrong Turn ");
						}
						return;
							}
					
					
					if(e.getActionCommand().equals("DOWN") && flag1==true){
						flag1=false;
						try {
							((Ranged)g1.getCellAt(k, j).getPiece()).usePower(Direction.DOWN,null,null);
							moveGUI();					
						} catch (InvalidPowerUseException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
							ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Invalid Power use ");
							ex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						} catch (WrongTurnException e1) {
							JFrame ex = new JFrame();
							 Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
								ImagePanel ex1 = new ImagePanel(img2);
							ex.setBounds(500, 150, 370, 300);
							ex1.setVisible(true);
							ex.add(ex1);
							ex.setVisible(true);
							ex.setTitle("Foul!! Wrong Turn ");
						}
						return;
							}
					
							
				
				
					
				
			}
			
			
			
			
		
         if(e.getActionCommand().equals("UP") && flag1==false) {									//MOVE
        	 
				try {
					g1.getCellAt(k,j).getPiece().move(Direction.UP);
					moveGUI();
					j=0;
					k=0;
				} catch (UnallowedMovementException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Unallowed Movement ");
					
				} catch (OccupiedCellException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Occupied Cell ");
					
				} catch (WrongTurnException e1) {
					
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Wrong Turn ");
				}
				
			
         }
         
         
         if(e.getActionCommand().equals("DOWN") && flag1==false) {
        	 
   				try {
   					g1.getCellAt(k,j).getPiece().move(Direction.DOWN);
   					moveGUI();
   					j=0;
   					k=0;
   				} catch (UnallowedMovementException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Unallowed Movement ");
					
				} catch (OccupiedCellException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Occupied Cell ");
					
				} catch (WrongTurnException e1) {
					
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Wrong Turn ");
				}
   			
            }
         
         
         
         
         
         
         
         if(e.getActionCommand().equals("LEFT") && flag1==false) {
        	 
   				try {
   					g1.getCellAt(k,j).getPiece().move(Direction.LEFT);
   					moveGUI();
   					j=0;
   					k=0;
   				}catch (UnallowedMovementException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Unallowed Movement ");
					
				} catch (OccupiedCellException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Occupied Cell ");
					
				} catch (WrongTurnException e1) {
					
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Wrong Turn ");
				}
   				
   			
            }
         
         
         
         
         if(e.getActionCommand().equals("RIGHT") && flag1==false) {
        	 
   				try {
   					g1.getCellAt(k,j).getPiece().move(Direction.RIGHT);
   					moveGUI();
   					j=0;
   					k=0;
   				}catch (UnallowedMovementException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Unallowed Movement ");
					
				} catch (OccupiedCellException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Occupied Cell ");
					
				} catch (WrongTurnException e1) {
					
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Wrong Turn ");
				}
   			
            }
         
         
         
         
         if(e.getActionCommand().equals("UPRIGHT") && flag1==false ) {
        	 
   				try {
   					g1.getCellAt(k,j).getPiece().move(Direction.UPRIGHT);
   					moveGUI();
   					j=0;
   					k=0;
   				}catch (UnallowedMovementException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Unallowed Movement ");
					
				} catch (OccupiedCellException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Occupied Cell ");
					
				} catch (WrongTurnException e1) {
					
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Wrong Turn ");
				}
   			
            }
         
         
         if(e.getActionCommand().equals("UPLEFT")  && flag1==false) {
        	 
   				try {
   					g1.getCellAt(k,j).getPiece().move(Direction.UPLEFT);
   					moveGUI();
   					j=0;
   					k=0;
   				} catch (UnallowedMovementException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Unallowed Movement ");
					
				} catch (OccupiedCellException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Occupied Cell ");
					
				} catch (WrongTurnException e1) {
					
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Wrong Turn ");
				}
   			
            }
         
         
         
         if(e.getActionCommand().equals("DOWNLEFT")  && flag1==false) {
        	 
   				try {
   					g1.getCellAt(k,j).getPiece().move(Direction.DOWNLEFT);
   					moveGUI();
   					j=0;
   					k=0;
   				}catch (UnallowedMovementException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Unallowed Movement ");
					
				} catch (OccupiedCellException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Occupied Cell ");
					
				} catch (WrongTurnException e1) {
					
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Wrong Turn ");
				}
   			
            }
         
         
         
         
         if(e.getActionCommand().equals("DOWNRIGHT")  && flag1==false) {
        	 
   				try {
   					g1.getCellAt(k,j).getPiece().move(Direction.DOWNRIGHT);
   					moveGUI();
   					j=0;
   					k=0;
   				} catch (UnallowedMovementException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Unallowed Movement ");
					
				} catch (OccupiedCellException e1) {
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Occupied Cell ");
					
				} catch (WrongTurnException e1) {
					
					JFrame ex = new JFrame();
					Image img2 = new ImageIcon(this.getClass().getResource("/ex.png")).getImage();
					ImagePanel ex1 = new ImagePanel(img2);
					ex.setBounds(500, 150, 370, 300);
					ex1.setVisible(true);
					ex.add(ex1);
					ex.setVisible(true);
					ex.setTitle("Foul!! Wrong Turn ");
				}
   			
            }
         
		}
        
         
		
         
         

	
}
	
	
	
	
	
	
	
	
	
	
	
	
	public void moveGUI() {
		
		
		repaint();
		revalidate();
		
		if(g1.getCurrentPlayer().equals(g1.getPlayer1())){
			player1.setText(name1+"'s turn");
			player1.setForeground(Color.MAGENTA);
		}
		else{
			player1.setText(name2+"'s turn");
			player1.setForeground(Color.WHITE);
		}
		
		
		
		
		
		
		
		
		
		
		
		 int j=g1.getPlayer1().getDeadCharacters().size();
         int g=g1.getPlayer2().getDeadCharacters().size();
         
         
         for(int i=0;i<=8;i++){
        	 D1[i].setIcon(null);
        	 D2[i].setIcon(null);
         }
         
         
         if(!g1.getPlayer1().getDeadCharacters().isEmpty()){										//update of dead characters p1
         for(int i=0;i<j;i++){
        	if( g1.getPlayer1().getDeadCharacters().get(i) instanceof Armored){
        		D1[i].setIcon(new ImageIcon(this.getClass().getResource("/sanchezred.png")));
        	}
        	if( g1.getPlayer1().getDeadCharacters().get(i) instanceof Medic){
        		D1[i].setIcon(new ImageIcon(this.getClass().getResource("/zidanered.png")));
        	}
        	if( g1.getPlayer1().getDeadCharacters().get(i) instanceof Ranged){
        		D1[i].setIcon(new ImageIcon(this.getClass().getResource("/zlatanred.png")));
        	}
        	if( g1.getPlayer1().getDeadCharacters().get(i) instanceof Speedster){
        		D1[i].setIcon(new ImageIcon(this.getClass().getResource("/balered.png")));
        	}
        	if( g1.getPlayer1().getDeadCharacters().get(i) instanceof Super){
        		D1[i].setIcon(new ImageIcon(this.getClass().getResource("/pirlored.png")));
        	}
        	if( g1.getPlayer1().getDeadCharacters().get(i) instanceof Tech){
        		D1[i].setIcon(new ImageIcon(this.getClass().getResource("/ronaldored.png")));
        	}
        	if( g1.getPlayer1().getDeadCharacters().get(i) instanceof SideKick){
        		D1[i].setIcon(new ImageIcon(this.getClass().getResource("/side1red.png")));
        	}
        	 
        	 
         }	 
         
         }
         
         
         
         
         
         
         
        
         if(!g1.getPlayer2().getDeadCharacters().isEmpty()){								//update of dead characters p2
         for(int i=0;i<g;i++){
        	if( g1.getPlayer2().getDeadCharacters().get(i) instanceof Armored){
        		D2[i].setIcon(new ImageIcon(this.getClass().getResource("/xavired.png")));
        	}
        	if( g1.getPlayer2().getDeadCharacters().get(i) instanceof Medic){
        		D2[i].setIcon(new ImageIcon(this.getClass().getResource("/maradonared.png")));
        	}
        	if( g1.getPlayer2().getDeadCharacters().get(i) instanceof Ranged){
        		D2[i].setIcon(new ImageIcon(this.getClass().getResource("/suarezred.png")));
        	}
        	if( g1.getPlayer2().getDeadCharacters().get(i) instanceof Speedster){
        		D2[i].setIcon(new ImageIcon(this.getClass().getResource("/neymarred.png")));
        	}
        	if( g1.getPlayer2().getDeadCharacters().get(i) instanceof Super){
        		D2[i].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhored.png")));
        	}
        	if( g1.getPlayer2().getDeadCharacters().get(i) instanceof Tech){
        		D2[i].setIcon(new ImageIcon(this.getClass().getResource("/messired.png")));
        	}
        	if( g1.getPlayer2().getDeadCharacters().get(i) instanceof SideKick){
        		D2[i].setIcon(new ImageIcon(this.getClass().getResource("/side2red.png")));
        	}
        	 
        	 
         }	 
         
         }
         
         
         
         
         
         
        
         
         
         
         
         
         
         
         
         
         
         
         
         
		
		
		
		 int m1=g1.getPlayer1().getPayloadPos();
         int m2=g1.getPlayer2().getPayloadPos();
         
         for(int i=0;i<m1;i++){
        	 P1[i].setIcon(new ImageIcon(this.getClass().getResource("/ball1.gif")));
        	
         }
         
         
         for(int i=0;i<m2;i++){
        	 P2[i].setIcon(new ImageIcon(this.getClass().getResource("/ball2.gif")));
        	 
         }
		
		
		
         if( g1.checkWinner()){
        	 W1= new JFrame();
        	 Image img3 = new ImageIcon(this.getClass().getResource("/salah.jpg")).getImage();
        	 ImagePanel salah= new ImagePanel(img3);
        	 salah.setLayout(new WrapLayout());
        	 W1.setVisible(true);
        	 salah.setVisible(true);
        	 W1.setSize(800,300);
        	 W1.setBounds(300,300, 800, 600);
        	 salah.setSize(200,200);
        	 W1.add(salah);
        	 W1.setTitle("KICK-OFF WAR");
        	 JLabel T=new JLabel("the winner is :"+g1.getCurrentPlayer().getName());
        	 T.setVisible(true);
        	 
        	 W1.add(T,BorderLayout.NORTH);
        	 W1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	 Game.dispose();
        	 JButton res= new JButton("Restart");
        	salah.add(res,BorderLayout.SOUTH);
        	 res.setVisible(true);
        	 res.addActionListener(this);
        	 res.setActionCommand("restart");
        	 res.setSize(100,100);
        	 
    
        	
        	 
        	
        	 
        	
         }
         
		
        
		
		
		
		
		
		
		
		
		
		
		 for(int i=0 ;i<=6;i++) {
			  for(int c=0;c<=5;c++) {
				  boardfield[i][c].setIcon(null);
			  }
		 }
		
				  
				  for(int i=0 ;i<=6;i++) {
			  for(int c=0;c<=5;c++) {
				  if(g1.getCellAt(i, c).getPiece()!=null) {
				  if(g1.getCellAt(i, c).getPiece() instanceof Armored) {
					  if(g1.getCellAt(i, c).getPiece().getOwner().equals(g1.getPlayer1())) {
						 
						  if(((Armored)g1.getCellAt(i, c).getPiece()).isArmorUp()==true){
							  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/sanchezsh.png")));
						  }
						  else{
						  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/sanchez.png")));
						  }
					  }
					  else {
						  if(((Armored)g1.getCellAt(i, c).getPiece()).isArmorUp()==true){
							  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/xavish.png")));
						  }
						  else{
						  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/xavi.png")));
						  }
					  }
				  }
					  
					  
					  
					  
					  if(g1.getCellAt(i, c).getPiece() instanceof Medic) {
						  if(g1.getCellAt(i, c).getPiece().getOwner().equals(g1.getPlayer1())) {
							  if(((Medic)g1.getCellAt(i, c).getPiece()).isPowerUsed()==true){
							  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/zidaneyell.png")));
							  }
							  else{
								  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/zidane.png"))); 
							  }
								  
						  }
						  else {
							  if(((Medic)g1.getCellAt(i, c).getPiece()).isPowerUsed()==true){
								  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/maradonayell.png")));
								  }
								  else{
									  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/maradona.png"))); 
								  }
						  }
				
				  }
			  
					  
					  
					  
					  if(g1.getCellAt(i, c).getPiece() instanceof Ranged) {
						  if(g1.getCellAt(i, c).getPiece().getOwner().equals(g1.getPlayer1())) {
							  if(((Ranged)g1.getCellAt(i, c).getPiece()).isPowerUsed()==true){
								  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/zlatanyell.png")));
								  }
								  else{
									  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/zlatan.png"))); 
								  }
						  }
						  else {
							  if(((Ranged)g1.getCellAt(i, c).getPiece()).isPowerUsed()==true){
								  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/suarezyell.png")));
								  }
								  else{
									  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/suarez.png"))); 
								  }
						  }
				
				  }
					  
					  
					  
					  if(g1.getCellAt(i, c).getPiece() instanceof Speedster) {
						  if(g1.getCellAt(i, c).getPiece().getOwner().equals(g1.getPlayer1())) {
							  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/bale.png")));
						  }
						  else {
							  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/neymar.png")));
						  }
				
				  }
					  
					  
					  
					  
					  
					  
					  if(g1.getCellAt(i, c).getPiece() instanceof Super) {
						  if(g1.getCellAt(i, c).getPiece().getOwner().equals(g1.getPlayer1())) {
							  if(((Super)g1.getCellAt(i, c).getPiece()).isPowerUsed()==true){
								  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/pirloyell.png")));
								  }
								  else{
									  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/pirlo.png"))); 
								  }
						  }
						  else {
							  if(((Super)g1.getCellAt(i, c).getPiece()).isPowerUsed()==true){
								  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinhoyell.png")));
								  }
								  else{
									  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/ronaldinho.png"))); 
								  }
						  }
				
				  }
					  
					  
					  
					  
					  
					  if(g1.getCellAt(i, c).getPiece() instanceof Tech) {
						  if(g1.getCellAt(i, c).getPiece().getOwner().equals(g1.getPlayer1())) {
							  if(((Tech)g1.getCellAt(i, c).getPiece()).isPowerUsed()==true){
								  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/ronaldoyell.png")));
								  }
								  else{
									  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/ronaldo.png"))); 
								  }
						  }
						  else {
							  if(((Tech)g1.getCellAt(i, c).getPiece()).isPowerUsed()==true){
								  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/messiyell.png")));
								  }
								  else{
									  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/messi.png"))); 
								  }
						  }
				
				  }
					  
					  
					  
					  if(g1.getCellAt(i, c).getPiece() instanceof SideKick) {
						  if(g1.getCellAt(i, c).getPiece().getOwner().equals(g1.getPlayer1())) {
							  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p1.gif")));
						  }
						  else {
							  boardfield[i][c].setIcon(new ImageIcon(this.getClass().getResource("/sidekcick p2.png")));
						  }
				
				  }
			  
			  
			  
			  
			    
					  
					  
					  
					  
					  
			  }
		  }
	}
	
	
	
	
}
	
	
	
	 public static void main(String[] args){
	    	
    	 try {
			MainWindow W=new MainWindow();
		} catch (IOException e) {
			
			System.out.println("file not found");
		}
    	 

         }






	
	
	
}








