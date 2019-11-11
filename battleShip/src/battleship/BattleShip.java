/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.Scanner;
import ship.*;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author S331474817
 */
public class BattleShip extends JPanel{

    public static int[] xCoord=new int[12];
    public static int[] yCoord=new int[12];
    public static JFrame screen, screen2 ;
        public static void boardInit(int turn){

        screen = new JFrame("Player "+turn);
        BattleShip ship = new BattleShip();

        screen.add(ship);

        screen.setSize(1000,700);
        screen.setVisible(true);
        //screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
        public static void boardP2() {
        	screen2 = new JFrame("Player 2");
            BattleShip ship = new BattleShip();

            screen2.add(ship);

            screen2.setSize(1000,700);
            screen2.setVisible(true);
            //screen.setResizable(false);
            screen2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    public void grid(Graphics g){
        int maxHeight=500;
        int maxLength=500;
        int gridSize=11;
        int charNum=9;
        String letter="";


        g.setColor(Color.blue);
        g.fillRect(50, 50, maxLength-50, maxHeight-50);
        g.setColor(Color.black);


        for(int x=0;x<gridSize;x++){
            int val=0+(x*50);
            xCoord[x]=val;
            yCoord[x]=val;
            g.drawLine(val, 0, val, maxHeight);
            g.drawLine(0, val,maxLength, val);
        }
        for(int x=0;x<charNum;x++){
            letter=String.valueOf((char)(65+x));
            int val=0+(x*50);
            g.drawString(letter, 70+val, 30);
            g.drawString(String.valueOf(x),20,80+val);
        }


        //test
    }
   
    public static int pShow=0;
   
    public static Ship C2;
    public static void shipInit2() {
    	C2 =new Ship(5,"Carrier");
    }
    public void shipDraw2(Graphics g){
        //Ship C =new Ship(5,"Carrier");

    	g.setColor(Color.gray);


    		if(C2.shipPos[0][0]==C2.shipPos[1][0]) {
    			g.fillRect(C2.shipPos[0][0]*50, C2.shipPos[0][1]*50, 50, C2.size*50);

    			}
    			else if (C2.shipPos[0][1]==C2.shipPos[1][1]) {
    					g.fillRect(C2.shipPos[0][0]*50, C2.shipPos[0][1]*50, C2.size*50, 50);

    				}
    }
    
    public void testing(Graphics g) {
    	g.drawLine(300,300,600,600);
    }
    public static int turn=1;
    public void paintComponent(Graphics g){
        grid(g);
        
        shipDraw(g);
        if (turn==1) {
        	shipDraw(g);
        	turn=0;
        }
        else if (turn==0) {
        	shipDraw2(g);
        	turn=1;
        }
        /*while(pShow==1){
        	System.out.println("Drawing boat");
            shipDraw(g);
        }
        */
    }


    /**
     * @param args the command line arguments
     */
    public static void delay(int time) {
    	try{
        	TimeUnit.SECONDS.sleep(time);
        }catch(Exception e) {
        	
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
       /* shipInit();
        System.out.println(pShow);
        boardInit(0);
        delay(5);
        screen.hide();
        
        
        shipInit();
        boardP2();
        delay(5);
        screen2.hide();
        screen.show();
        screen.repaint();*/
        shipInit();
        boardInit(0);
        
        delay(3);
        shipInit2();
        screen.hide();
        delay(3);
        
        screen.show();
        screen.repaint();
        
        
        System.out.println("End");
        // TODO code application logic here
       /* int ShipP1=5;
        int ShipP2=5;
        int turn=1;
        //boardInit(turn);
        do{
        	System.out.println("Running a game");
           boolean turnEnd=false;
           boardInit(turn);
           do{
        	   System.out.println("running a turn");
               String uInput;
               uInput=sc.nextLine();
               if(uInput.equalsIgnoreCase("fire")){
                   turnEnd=false;
               }
           }while (turnEnd==true);
           if(turn==1){
               turn=0;
           }
           else{
               turn=1;
           }
        }while(ShipP1!=0 && ShipP2!=0);*/
        
    }

}


//https://stackoverflow.com/questions/15544549/how-does-paintcomponent-work
