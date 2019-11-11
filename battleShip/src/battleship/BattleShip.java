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
    public static JFrame screen ;
    public static shipInit sI=new shipInit();

        public static void boardInit(int turn){

        screen = new JFrame("Player "+turn);
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

            g.drawLine(val, 0, val, maxHeight);
            g.drawLine(0, val,maxLength, val);
        }
        for(int x=0;x<charNum;x++){
            letter=String.valueOf((char)(65+x));
            int val=0+(x*50);
            g.drawString(letter, 70+val, 30);
            g.drawString(String.valueOf(x),20,80+val);
        }//
    }
   

    public static int turn=1;
    public void paintComponent(Graphics g){
    	
        grid(g);
        sI.turnDraw(g);
        
       
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
        //shipInit();
        sI.init(0);
        boardInit(0);
        delay(3);
        screen.hide();
        delay(3);
        sI.init(1);
        sI.turn=1;
        screen.show();
        screen.repaint();
        
        
        System.out.println("End");
    
    }

}


//https://stackoverflow.com/questions/15544549/how-does-paintcomponent-work
