package view;
import javax.swing.*;   

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;




public class StartWindow extends JFrame implements ActionListener{
	    public StartWindow(){
    super();
    setSize(400,100);
    getContentPane().setLayout(new FlowLayout());
    
    JButton Startbutton = new JButton("START GAME");
    
    Startbutton.setActionCommand("start");
    
    Startbutton.addActionListener(this);
    JPanel w= new JPanel();
    w.setVisible(true);
    w.setLayout(new WrapLayout());
    w.setOpaque(false);
    setTitle("KICKOFF WAR");
    setSize(1400, 1400);
    //setBounds(325,100,700,600);
    Image img = new ImageIcon(this.getClass().getResource("/FIFA back.png")).getImage();
    ImagePanel X= new ImagePanel(img);
    X.setLayout(new WrapLayout());
    X.setVisible(true);
    Startbutton.setBackground(Color.DARK_GRAY);
    Startbutton.setForeground(Color.WHITE);
    w.setSize(500, 500);
    w.add(Startbutton);
    X.add(w);
    getContentPane().add(X);
    
    WindowDestroyer myListener = new WindowDestroyer();
    addWindowListener(myListener);
    
    
   
   
    
}

    public void actionPerformed(ActionEvent e){
    
	if (e.getActionCommand().equals("start")){
           try {
			MainWindow W= new MainWindow();
		} catch (IOException e1) {
			System.out.println("file not found");
		}
           super.dispose();
           
           
           
           
       
		}
    }
    
    
    
    public static void main(String[] args)
    { StartWindow buttonGUI = new StartWindow();
	buttonGUI.setVisible(true);
	
    }
    
    
    
    
    

}
