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
    public static Ship C;
    public static Ship B;
    public static Ship Cr;
    public static Ship S;
    public static Ship D;
    public static int pShow=0;
    public static void shipInit() {
    	C =new Ship(5,"Carrier");
    	/*B = new Ship(4,"Battleship");
    	Cr=new Ship(3,"Cruise");
    	S=new Ship(3,"Submarine");
    	D=new Ship(2,"Destroyer");*/
    	pShow=1;
    }

    public void shipDraw(Graphics g){
                //Ship C =new Ship(5,"Carrier");

        g.setColor(Color.gray);
        /*System.out.println(C.check("x")*50);
        System.out.println(C.check("y")*50);
        System.out.println(C.check("x")*50);
        System.out.println(C.check("y")*50);*/
       /* System.out.println("xStart "+C.shipPos[0][0]);
        System.out.println("yStart "+C.shipPos[0][1]);
        System.out.println("xEnd "+C.shipPos[1][0]);
        System.out.println("yEnd "+C.shipPos[1][1]);*/

        if(C.shipPos[0][0]==C.shipPos[1][0]) {
            g.fillRect(C.shipPos[0][0]*50, C.shipPos[0][1]*50, 50, C.size*50);

       	}
        else if (C.shipPos[0][1]==C.shipPos[1][1]) {
            g.fillRect(C.shipPos[0][0]*50, C.shipPos[0][1]*50, C.size*50, 50);

        }
       /* System.out.println("box xS "+C.shipPos[0][0]*50);
        System.out.println("box yS "+C.shipPos[0][1]*50);
        System.out.println("box xe "+C.shipPos[1][0]*50);
        System.out.println("box ye "+C.shipPos[1][1]*50);
       
        Ship B = new Ship(4,"Battleship");
        System.out.println(B.size);
        System.out.println("xStart "+B.shipPos[0][0]);
        System.out.println("yStart "+B.shipPos[0][1]);
        System.out.println("xEnd "+B.shipPos[1][0]);
        System.out.println("yEnd "+B.shipPos[1][1]);
        if(B.shipPos[0][0]==B.shipPos[1][0]) {
        	g.fillRect(B.shipPos[0][0]*50, B.shipPos[0][1]*50, 50, B.size*50);
        	//g.setColor(Color.green);
        	g.drawLine(B.shipPos[0][0]*50,  B.shipPos[1][1]*50+50, B.shipPos[0][0]*50+50, B.shipPos[1][1]*50+50);
        	System.out.println("Horizontal");
        }
        else if (B.shipPos[0][1]==B.shipPos[1][1]) {
            g.fillRect(B.shipPos[0][0]*50, B.shipPos[0][1]*50, B.size*50, 50);
            System.out.println("Vertical");
        }
        	
        System.out.println("box xS "+B.shipPos[0][0]*50);
        System.out.println("box yS "+B.shipPos[0][1]*50);
        System.out.println("box xe "+B.shipPos[1][0]*50);
        System.out.println("box ye "+B.shipPos[1][1]*50);
        
        Ship Cr=new Ship(3,"Cruise");
        System.out.println("xStart "+Cr.shipPos[0][0]);
        System.out.println("yStart "+Cr.shipPos[0][1]);
        System.out.println("xEnd "+Cr.shipPos[1][0]);
        System.out.println("yEnd "+Cr.shipPos[1][1]);
        if(Cr.shipPos[0][0]==Cr.shipPos[1][0]) {
        	System.out.println("Drawing Horiz");
            g.fillRect(Cr.shipPos[0][0]*50, Cr.shipPos[0][1]*50, 50, Cr.size*50);

       	}
        else if (Cr.shipPos[0][1]==Cr.shipPos[1][1]) {
        	System.out.println("Drawing Vert");
            g.fillRect(Cr.shipPos[0][0]*50, Cr.shipPos[0][1]*50, Cr.size*50, 50);

        }
        
        
        Ship S=new Ship(3,"Submarine");
        if(S.shipPos[0][0]==S.shipPos[1][0]) {
            g.fillRect(S.shipPos[0][0]*50, S.shipPos[0][1]*50, 50, S.size*50);

       	}
        else if (S.shipPos[0][1]==S.shipPos[1][1]) {
            g.fillRect(S.shipPos[0][0]*50, S.shipPos[0][1]*50, S.size*50, 50);

        }
        Ship D=new Ship(2,"Destroyer");
        if(D.shipPos[0][0]==D.shipPos[1][0]) {
            g.fillRect(D.shipPos[0][0]*50, D.shipPos[0][1]*50, 50, D.size*50);

       	}
        else if (D.shipPos[0][1]==D.shipPos[1][1]) {
            g.fillRect(D.shipPos[0][0]*50, D.shipPos[0][1]*50, D.size*50, 50);

        }

       */
    }
    public void paintComponent(Graphics g){
        grid(g);
        shipDraw(g);
        /*while(pShow==1){
        	System.out.println("Drawing boat");
            shipDraw(g);
        }
        */
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        shipInit();
        System.out.println(pShow);
        boardInit(0);
        try{
        	TimeUnit.SECONDS.sleep(5);
        }catch(Exception e) {
        	
        }
        screen.hide();
        
        
        shipInit();
        boardP2();
       
        
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
