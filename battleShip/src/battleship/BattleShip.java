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
public class BattleShip extends JPanel{ //creates a class called battleship that extends jPanel, letting it be added to a screen
    public static JFrame screen ; //creating a variable that is type JFrame and extends screen
    public static shipInit sI=new shipInit(); //create an object of type shipInit
    public static hitMarker hMark=new hitMarker(); //create an object of class hitMarker
    public static boolean screenSwitch=false; //create a variable to determine if the screen should be switched
    public static boolean attacking=false; //create a variable to determine if the screen should show the markers

        public static void boardInit(){ //creating a function to initiate the screen

        screen = new JFrame("BattleShip"); // initiating the variable screen to be an object of the JFrame type and to have the screen called battleship
        BattleShip ship = new BattleShip(); //create an object called ship of class battleship  <-- this lets the paintComponent to continuously run

        screen.add(ship); //add ship to the screen as a component

        screen.setSize(1000,700); //set the size of the screen
        screen.setVisible(true); //making the screen visible
        screen.setResizable(false); //making it so the screen cannot be resized
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //make it so that the screen will close when the x button is hit


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



    public void switchScreen(Graphics g,int turn) { //create a class that will let the users witch players so they don't know where the others ships are
    	Font switchFont=new Font("Verdana", Font.BOLD,40);//create an object of class font that will change the font used when drawing text
    	g.setFont(switchFont); //set the font to switchFont (make it so that this is the font that is used
    	g.drawString("Player "+turn,300,300); // draws/write the word player with a number roughly in the center of the screen
    	screenSwitch=false; //set screenSwitch to false as it no longer has to do it (since it just did)
    }

    public void paintComponent(Graphics g){ //overrides class paintComponents

    	if(screenSwitch==true) { // checks to see if screenSwitch is true (has to switch screen)
    		switchScreen(g,sI.turn); //calls function switchScreen with the parameters of g (graphics) and the player turn
    	}
    	else { //if it does not have to switch players
        	Font gridFont=new Font("Verdana", Font.PLAIN,12); //create a new object of class Font to be used for the grid
        	g.setFont(gridFont); //set the font to be gridFont
    		grid(g); //calls function grid to draw the grid
        	sI.shipDraw(g,sI.turn); //calls function turn draw from the object sI (obejct of shipInit) and it will draw the ships for that player
        	if(attacking==true) { // checks to see if the markers have to be drawn
        		hMark.drawMarker(g,sI.turn); //calls function drawMarker from the hitMarker class by using the object hMark, which is an obejct of hitMarker
        	}
    	}
    }


    /**
     * @param args the command line arguments
     */
    public static void delay(int time) {//create a function called delay that takes in an integer as a parameter
    	try{  //how to use TimeUnit.second.sleep
        	TimeUnit.SECONDS.sleep(time); //delays function for a number of seconds
        }catch(Exception e) {

        }
    }

    public static void hideScreen() { //create a function to hid the screen as it switches to another one
    	delay(3); //calls function delay to delay program for 3 seconds
        screen.hide(); //hides the screen
        delay(3); //calls function delay to delay program for 3 seconds
    }
    public static void attack(){

        BattleshipAttackClone att=new BattleshipAttackClone(); //create an object of class battlshipattackclone called att
        String choice=att.AttackChoice(); //creates a variable called choice and gets the type of attack the user is going to input

        if(choice.equals("Cross")){  //if the user chooses the cross attack
            crossAttack cAttack = new crossAttack(); //creates a new object called cAttack that is of crossAttack class
            cAttack.getCoords();//gets the coordinate for the attack (middle coordinate for the cross attack)
            cAttack.crossPos(); //set the other coordinate for the cross attacks
            cAttack.checkHit(sI.turn,sI.pos,sI.shipList); //checks to see if the attack hits any of the opponents ships
            hMark.getInfo(sI.turn,5, cAttack.hitOrMiss, cAttack.crossCoords); //calls function getInfo from hitMarker class to set the information for the markers that has to be drawn


        }
        else if(choice.equals("2x2")){ //same as the cross attack but for 2x2
            squareAttack sAttack = new squareAttack(); //creates an object of squareAttack called sAttack
            sAttack.getCoords();//gets the coordinate for the attack (start/base of attack position)
            sAttack.squarePos();
            sAttack.checkHit(sI.turn,sI.pos,sI.shipList);
            hMark.getInfo(sI.turn,4, sAttack.hitOrMiss, sAttack.squareCoords);
        }
        else if(choice.equals("Single")){ //same as the other two attacks, but for single attack
            singleAttack singleAttack=new singleAttack(); //creates an object of singleAttack called singleAttack
            att.getCoords();
            singleAttack.singlePos();
            singleAttack.checkHit(sI.turn,sI.pos,sI.shipList);
            hMark.getInfo(sI.turn,1, singleAttack.hitOrMiss, singleAttack.singleCoords);


        }
        attacking=true; //sets attacking to true, to signal that markers should be drawn

    }
    public static void main(String[] args) {
    	boolean ender=false; //create a variable to determine if the game is older

        sI.init(0); //calls function init from shipInit with parameters 0 (for player 0)
        boardInit(); //calls function boardInit to create the screen and draws the ships
        hideScreen(); //hides the screen
        sI.init(1); //calls function init from shipInit with parameters 1 (for player 1)
        sI.turn=0; //sets turn to be player 0
        screen.show(); //shows the screen
        do { //repeats until the game is over
        	hideScreen(); //hides the screen
        	screenSwitch=true; //tell that the screen needs to be switched
            screen.show(); //shows the screen
            hideScreen(); //hides the screen
            screen.show(); //shows the screen
                attack(); //calls function attack
                screen.repaint(); //repaints the board (show markers)
                delay(5); //delays for 5 second
                attacking=false; //set attacking to false (hide markers)
                int sunkCount=0; //create variable called sunk to check to hold the number of sunk ships
                for(int x=0;x<5;x++) {//checks each ship
                	int tempTurn; //create a variable to hold the opponents turn

                	if(sI.turn==0) { //checks to see who's turn it is and the switches the turn to be the opponents
                		tempTurn=1;
                	}
                	else {
                		tempTurn=0;
                	}


                	if(sI.shipList[tempTurn][x].sunk==true) { //checks to see if a ship has been sunk
                		sunkCount++;//adds one to ship sunk
                	}
                	else { //if the ships is not sunk it sets sunkcount to zero as they did not win
                		sunkCount=0;
                	}


                	if(sunkCount==5) { //if sunkcount is 5 then all ships are sunk and player wins
                		ender=true; //sets ender to true, meaning game is over

                	}
                	else { //if not all ships are sunk game continues
                		ender=false;
                	}
                }

            if(sI.turn==0) {//switches the players turn
            	sI.turn=1;
            }
            else {
            	sI.turn=0;
            }



        }while(ender==false); //loops until ender is true
        System.out.println("Game over"); //tells the user the game is over



    }

}
