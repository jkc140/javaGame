/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import javax.swing.JFrame;
import javax.swing.*;

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
    	xPos=new JTextField("test");
    	yPos=new JTextField("test");
    	
    	xPos.setBounds(600, 300,120,25);
    	yPos.setBounds(600, 335,120,25);
    }
    
    public static void screenInit(){
      JFrame screen = new JFrame("test");
      JPanel test= new grid();
      //screen.setLayout(null);
      buttonConfig();
      textFieldConfig();

      screen.add(bAttack1);
      screen.add(bAttack2);
      screen.add(bAttack3);
      screen.add(bFire);
      screen.add(xPos);
      screen.add(yPos);
      
      screen.add(test);

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
    	
    	//Labels
    	String boatSize="3";
    	JLabel xCoordStart,yCoordStart,xCoordEnd,yCoordEnd,boat;
    	boat=new JLabel("Placing " +boatSize);
    	xCoordStart=new JLabel("Select start x position of boat");
    	xCoordEnd=new JLabel("Select end x position of boat");
    	yCoordStart=new JLabel("Select start y position of boat");
    	yCoordEnd=new JLabel("Select end y position of boat");
    	
    	bInit.add(boat);
    	bInit.add(yCoordEnd);
    	bInit.add(xCoordEnd);
    	bInit.add(yCoordStart);
    	bInit.add(xCoordStart);
    	
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
