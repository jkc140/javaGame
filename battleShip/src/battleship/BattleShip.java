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
    public static hitMarker hMark=new hitMarker();
    

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
    public static boolean attacking=false;
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
        	if(attacking==true) {
        		System.out.println("Setting markers");
        		hMark.drawMarker(g);
        	}
        	
        	
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

        BattleshipAttackClone att=new BattleshipAttackClone();
        String choice=att.AttackChoice();
                
        if(choice.equals("Cross")){
            System.out.println("cross");
            crossAttack cAttack = new crossAttack();
            cAttack.getCoords();

            cAttack.crossPos();
            if(sI.turn==1){
              cAttack.checkHit(sI.turn,sI.pos,sI.test);
            }
            else if(sI.turn==0){
              cAttack.checkHit(sI.turn,sI.pos,sI.test);
              
            }
            hMark.getInfo(5, cAttack.hitOrMiss, cAttack.crossCoords);
            
            
        }
        else if(choice.equals("2x2")){
            System.out.println("square");
            squareAttack sAttack = new squareAttack();
            sAttack.getCoords();
            sAttack.squarePos();
            if(sI.turn==1){
              sAttack.checkHit(sI.turn,sI.pos,sI.test);
            }
            else if(sI.turn==0){
              sAttack.checkHit(sI.turn,sI.pos,sI.test);
            }
            hMark.getInfo(4, sAttack.hitOrMiss, sAttack.squareCoords);
        }
        else if(choice.equals("Single")){
        	System.out.println("single");
            singleAttack singleAttack=new singleAttack();
            singleAttack.getCoords();
            singleAttack.singlePos();
            if(sI.turn==1){
                singleAttack.checkHit(sI.turn,sI.pos,sI.test);
              }
              else if(sI.turn==0){
            	  singleAttack.checkHit(sI.turn,sI.pos,sI.test);
              }
            hMark.getInfo(1, singleAttack.hitOrMiss, singleAttack.singleCoords);
            
            
        }
        attacking=true;
        
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
            //do {
            	//screen.repaint();
                attack();
                System.out.println("Attacking: "+attacking);
                screen.repaint();
                delay(5);
                attacking=false;
                int sunkCount=0;
                for(int x=0;x<1;x++) {
                	int tempTurn;

                	if(sI.turn==0) {
                		tempTurn=1;
                	}
                	else {
                		tempTurn=0;
                	}
                	if(sI.test[tempTurn][x].sunk==true) {
                		sunkCount++;
                		
                		System.out.println("Sunk "+sunkCount);
                	}
                	else {
                		sunkCount=0;
                	}
                	if(sunkCount==5) {
                		ender=true;
                		System.out.println("Game over");
                	}
                	else {
                		ender=false;
                	}
                }
            /*	System.out.println("enter fire to end turn");
                useIn=sc.nextLine();
                if(useIn.equalsIgnoreCase("fire")) {
                	ender=true;
                }
                else {
                	ender=false;
                }
            }while(ender==false);*/
            System.out.println("player after turn "+sI.turn);
            if(sI.turn==0) {
            	sI.turn=1;
            }
            else {
            	sI.turn=0;
            }
            
            

   //         screen.repaint();
        }while(ender==false);
        


        //System.out.println("End");
        //test

    }

}


//https://stackoverflow.com/questions/15544549/how-does-paintcomponent-work
