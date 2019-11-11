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
/**
 *
 * @author S331474817
 */
public class BattleShip extends JPanel{

    public static int[] xCoord=new int[12];
    public static int[] yCoord=new int[12];

        public static void boardInit(int turn){

        JFrame screen = new JFrame("Player "+turn);
        BattleShip ship = new BattleShip();


        screen.add(ship);

        screen.setSize(1000,700);
        screen.setVisible(true);
        //screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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

    public void shipDraw(Graphics g){
                Ship C =new Ship(5,"Carrier");

        g.setColor(Color.gray);
        /*System.out.println(C.check("x")*50);
        System.out.println(C.check("y")*50);
        System.out.println(C.check("x")*50);
        System.out.println(C.check("y")*50);*/
        System.out.println("xStart "+C.shipPos[0][0]);
        System.out.println("yStart "+C.shipPos[0][1]);
        System.out.println("xEnd "+C.shipPos[1][0]);
        System.out.println("yEnd "+C.shipPos[1][1]);

        
        g.fillRect(C.shipPos[0][0]*50, C.shipPos[0][1]*50, C.shipPos[1][0]*50, C.shipPos[1][1]*50);
        System.out.println("box xS "+C.shipPos[0][0]*50);
        System.out.println("box yS "+C.shipPos[0][1]*50);
        System.out.println("box xe "+C.shipPos[1][0]*50);
        System.out.println("box ye "+C.shipPos[1][1]*50);
        /*Ships Cr=new Ships(2,"Cruise");
        Ships S=new Ships(3,"Sub");
        Ships D=new Ships(4,"destroyer");*/


        /*
        g.fillRect(Cr.shipPos[0][1]*50, Cr.shipPos[0][0]*50, Cr.shipPos[1][1]*50, Cr.shipPos[1][0]*50);
        g.fillRect(S.shipPos[0][1]*50, S.shipPos[0][0]*50, S.shipPos[1][1]*50, S.shipPos[1][0]*50);
        g.fillRect(D.shipPos[0][1]*50, D.shipPos[0][0]*50, D.shipPos[1][1]*50, D.shipPos[1][0]*50);*/
                 Ship B = new Ship(3,"Battleship");
         System.out.println("xStart "+B.shipPos[0][0]);
        System.out.println("yStart "+B.shipPos[0][1]);
        System.out.println("xEnd "+B.shipPos[1][0]);
        System.out.println("yEnd "+B.shipPos[1][1]);
        if(B.shipPos[0][0]==B.shipPos[1][0]) {
        g.fillRect(B.shipPos[0][0]*50, B.shipPos[0][1]*50, 50, B.shipPos[1][1]*50);

        }
        else if (B.shipPos[0][1]==B.shipPos[1][1]) {
            g.fillRect(B.shipPos[0][0]*50, B.shipPos[0][1]*50, B.shipPos[1][0]*50, 50);

        }
        	
        //g.fillRect(B.shipPos[0][0]*50, B.shipPos[0][1]*50, B.shipPos[1][0]*50, B.shipPos[1][1]*50);
        System.out.println("box xS "+B.shipPos[0][0]*50);
        System.out.println("box yS "+B.shipPos[0][1]*50);
        System.out.println("box xe "+B.shipPos[1][0]*50);
        System.out.println("box ye "+B.shipPos[1][1]*50);
        
       /* g.setColor(Color.MAGENTA);
        g.fillRect(50, 150, 150, 50);*/
        //comment continuation
    }
    public int count=0;
    public void paintComponent(Graphics g){
        grid(g);
        shipDraw(g);
        //System.out.println("count "+count);
        /*while(count==0){
            shipDraw(g);
            count++;
        }*/
        
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // TODO code application logic here
        int ShipP1=5;
        int ShipP2=5;
        int turn=1;
        boardInit(turn);
       /* do{
           boolean turnEnd=false;
           boardInit(turn);
           do{
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
        }while(ShipP1!=0 && ShipP2!=0);
        */
    }

}


//https://stackoverflow.com/questions/15544549/how-does-paintcomponent-work
