/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author S331474817
 */
public class BattleShip {

    public static JButton bAttack1, bAttack2,bAttack3,bFire; //declaring variables as buttons
    static JTextField xPos, yPos;

    public static void buttonConfig(){
        bAttack1 =new JButton("Normal Attack");
        bAttack2=new JButton("Cross Attack");
        bAttack3=new JButton("2x2 Attack");
        bFire=new JButton("fire");
        bAttack1.setBounds(600, 30,120,50);
        bAttack2.setBounds(600, 100,120,50);
        bAttack3.setBounds(600, 170,120,50);
        bFire.setBounds(600, 500,120,50);
    }
    
    public static void textFieldConfig() {
    	xPos=new JTextField("xCoord");
    	yPos=new JTextField("yCoord");
    	
    	xPos.setBounds(600, 300,120,25);
    	yPos.setBounds(600, 335,120,25);
    }
    
    public static void screenInit(){
      JFrame screen = new JFrame("test");
      JPanel grid= new grid();
      //screen.setLayout(null);
      buttonConfig();
      textFieldConfig();

      screen.add(bAttack1);
      screen.add(bAttack2);
      screen.add(bAttack3);
      screen.add(bFire);
      screen.add(xPos);
      screen.add(yPos);
      
      screen.add(grid);

      screen.setSize(1000,700);
      screen.setVisible(true);
      screen.setResizable(false);
      screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void boatInitScreen() {
    	JFrame bInit=new JFrame("boat setup");
    	bInit.setSize(500, 300);
    	bInit.setVisible(true);
    	bInit.setResizable(false);
    	bInit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	bInit.setLayout(null);
    	
    	//Labels
    	String boatSize="3";
    	JLabel xCoordStart,yCoordStart,xCoordEnd,yCoordEnd,boat;
    	boat=new JLabel("Placing " +boatSize);
    	Dimension bsize=boat.preferredSize();
    	boat.setBounds(30,30,bsize.width,bsize.height);
    	
       
    	xCoordStart=new JLabel("Select start x position of boat");
    	Dimension xStartSize=xCoordStart.preferredSize();
    	xCoordStart.setBounds(30,50,xStartSize.width,xStartSize.height);
        
    	xCoordEnd=new JLabel("Select end x position of boat");
    	Dimension xEndSize=xCoordEnd.preferredSize();
    	xCoordEnd.setBounds(30,70,xEndSize.width,xEndSize.height);

    	yCoordStart=new JLabel("Select start y position of boat");
    	Dimension yStartSize=yCoordStart.preferredSize();
    	yCoordStart.setBounds(30,90,yStartSize.width,yStartSize.height);
    	
    	yCoordEnd=new JLabel("Select end y position of boat");
    	Dimension yEndSize=yCoordEnd.preferredSize();
    	yCoordEnd.setBounds(30,110,yEndSize.width,yEndSize.height);    	
    	
    	bInit.add(boat);
        bInit.add(xCoordStart);
        bInit.add(xCoordEnd);
        bInit.add(yCoordStart);
        bInit.add(yCoordEnd);
    	
    	//JTextFields
        JTextField xStartInput,xEndInput,yStartInput,yEndInput;
    	xStartInput=new JTextField("Input start x position");
        xStartInput.setBounds(225,50,150,20);
    	bInit.add(xStartInput);
        
        xEndInput=new JTextField("Input end x position");
        xEndInput.setBounds(225,70,150,20);
    	bInit.add(xEndInput);
        
        yStartInput=new JTextField("Input start y position");
        yStartInput.setBounds(225,90,150,20);
    	bInit.add(yStartInput);
        
        yEndInput=new JTextField("Input end y position");
        yEndInput.setBounds(225,110,150,20);
    	bInit.add(yEndInput);
        
        //input button
        JButton submit,reset;
        submit=new JButton("Submit");
        submit.setBounds(100, 200, 100, 25);
        bInit.add(submit);
        
        reset=new JButton("reset");
        reset.setBounds(225, 200, 100, 25);
        bInit.add(reset);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        screenInit();
        boatInitScreen();
    }

}


//https://stackoverflow.com/questions/15544549/how-does-paintcomponent-work
//https://stackoverflow.com/questions/20343667/java-graphics-graphics-panel-and-buttons-panel
//http://www.java2s.com/Tutorials/Java/Swing_How_to/Layout/Set_location_of_JLabel_in_a_JFrame.htm <-- label position
//https://docs.oracle.com/javase/tutorial/uiswing/layout/none.html
