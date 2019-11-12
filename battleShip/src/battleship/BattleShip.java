/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.Scanner;
import ship.*;
import java.util.concurrent.TimeUnit;
import battleshipattackclone.*;
/**
 *
 * @author S331474817
 */
public class BattleShip extends JPanel{
    public static JFrame screen ;
    public static shipInit sI=new shipInit();

        public static void boardInit(){

        screen = new JFrame("BattleShip");
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
        }
    }
    
    
    public static boolean screenSwitch=false;
    public void switchScreen(Graphics g,int turn) {
    	Font font=new Font("Verdana", Font.BOLD,40);
    	g.setFont(font);
    	g.drawString("Player "+turn,300,300);
    	screenSwitch=false;
    }
    
    public void paintComponent(Graphics g){

    	if(screenSwitch==true) {
    		switchScreen(g,sI.turn);
    	}
    	else {
        	Font font=new Font("Verdana", Font.PLAIN,12);
        	g.setFont(font);
    		grid(g);
        	sI.turnDraw(g);
    	}

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
    
    public static void hideScreen() {
    	delay(3);
        screen.hide();
        delay(3);
    }
    public static void attack(){
        int[][] shipPos=new int[5][5];
        
        int[][] shipPos1=new int[5][5];
        BattleshipAttackClone att=new BattleshipAttackClone();
        if(att.AttackChoice().equals("cross")){
            att.getCoords();
            crossAttack cAttack = new crossAttack();
            cAttack.crossPos();
            if(sI.turn==1){
              cAttack.checkHit(shipPos);
            }
            else if(sI.turn==0){
              cAttack.checkHit(shipPos1);
            }
            
        }
        if(att.AttackChoice().equals("square")){
            att.getCoords();
            squareAttack sAttack = new squareAttack();
            sAttack.squarePos();
            if(sI.turn==1){
              sAttack.checkHit(shipPos);
            }
            else if(sI.turn==0){
              sAttack.checkHit(shipPos1);
            }
        }
        if(att.AttackChoice().equals("single")){
            att.getCoords();
            
        }
        
    }
    public static void main(String[] args) {
    	boolean ender=false;
    	String useIn ;
        Scanner sc=new Scanner(System.in);
        
        sI.init(0);
        boardInit();
        hideScreen();
        sI.init(1);
        sI.turn=1;
        screen.show();
        do {
        	System.out.println("player "+sI.turn);
        	hideScreen();
        	screenSwitch=true;
            screen.show();
            hideScreen();
            System.out.println("screenSwitch: " +screenSwitch);
            screen.show();
            do {
                attack();
            	System.out.println("enter fire to end turn");
                useIn=sc.nextLine();
                if(useIn.equalsIgnoreCase("fire")) {
                	ender=true;
                }
                else {
                	ender=false;
                }
            }while(ender==false);
            System.out.println("player after turn "+sI.turn);
            if(sI.turn==0) {
            	sI.turn=1;
            }
            else {
            	sI.turn=0;
            }
            
            

   //         screen.repaint();
        }while(true);
        


        //System.out.println("End");
        //test

    }

}


//https://stackoverflow.com/questions/15544549/how-does-paintcomponent-work
