/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipattackclone;

import java.util.Scanner;
import javax.swing.*;

import battleship.hitMarker;
import battleship.shipInit;


/**
 *
 * @author S331462374
 */
public class BattleshipAttackClone { //creating a class called BattleshipAttackClone <-- its a clone because when working with git it is hard to actually get multiple people working on the same project, especially netbeans, so there have been multiple files with the same name created
    public int[]coords=new int[2]; //create a variable called coords to store the base coords of the attack
    /**
     * @return
     */
    public void AttackChoice() { //create a function called AttackChoice to determine the attack choice of the user <-- it will return a string
        String Choice=""; //create a function called choice that will hold the input of the user
        shipInit sI=new shipInit(); //create an object of type shipInit
        hitMarker hMark=new hitMarker(); //create an object of class hitMarker
        boolean valid=false; //create a variable to determine if the input is valid
        Scanner input = new Scanner(System.in);  //create an object called input of the scanner class
        System.out.println("Which attack would you like to choose?"); //ask the user what attack they would like
        String AttackChoice; //create a variable called attackChoice
        String Instruction = "Cross Attack(1)"+"\n"+"2x2(2)"+"\n"+"Single(3)"+"\n"+"Please enter the number: "; //create a string called Insturctions that holds the option that the user can print
        System.out.println(Instruction); //displays the Instruction to the user
        do{ //loops until input is valid
        	AttackChoice = input.nextLine(); //get user input
            if ("1".equals(AttackChoice)){ //check to see if the user chose cross attack
                Choice="Cross"; //sets choice as cross
                crossAttack cAttack = new crossAttack(); //creates a new object called cAttack that is of crossAttack class
                cAttack.getCoords();//gets the coordinate for the attack (middle coordinate for the cross attack)
                cAttack.crossPos(); //set the other coordinate for the cross attacks
                cAttack.checkHit(sI.turn,sI.pos,sI.shipList); //checks to see if the attack hits any of the opponents ships
                hMark.getInfo(sI.turn,5, cAttack.hitOrMiss, cAttack.crossCoords); //calls function getInfo from hitMarker class to set the information for the markers that has to be drawn
                valid=true; //sets valid to be true
            }
            else if("2".equals(AttackChoice)){ //same as cross attack, but  for 2x2 (square) attack
                Choice="2x2";
                squareAttack sAttack = new squareAttack(); //creates an object of squareAttack called sAttack
                sAttack.getCoords();//gets the coordinate for the attack (start/base of attack position)
                sAttack.squarePos();
                sAttack.checkHit(sI.turn,sI.pos,sI.shipList);
                hMark.getInfo(sI.turn,4, sAttack.hitOrMiss, sAttack.squareCoords);
                valid=true;
            }
            else if ("3".equalsIgnoreCase(AttackChoice)){ //same as cross attack, but for single attack
                Choice="Single";
                singleAttack singleAttack=new singleAttack(); //creates an object of singleAttack called singleAttack
                singleAttack.getCoords();
                singleAttack.singlePos();
                singleAttack.checkHit(sI.turn,sI.pos,sI.shipList);
                hMark.getInfo(sI.turn,1, singleAttack.hitOrMiss, singleAttack.singleCoords);

                valid=true;
            }
            else{ //if input is invalid
                System.out.println("Invalid entry try again"); //tells the user it is an invalid input
                valid=false; //sets valid to false
            }
        }while(valid==false); //loops until valid is true
    }
  
    public void getCoords(){ //create a function called getCoords to get the coordinates of the base attack
        Scanner sc=new Scanner(System.in); //create an object called sc which is the scanner class
        boolean valid=false;//create a variable to determine if the input is valid
        String tempCoords; //create a variable to hold the coords temporary to see if they are valid
        for(int x=0;x<2;x++){ //loops twice to get x and y coords
            if(x==0){ //if x is =0 then it ask for x coord
                System.out.println("Enter the x coordnate for the attack");
            }
            else{ //if not it ask for y coord
                System.out.println("Enter the y coordnate for the attack");
            }
            do{ //loops until input is valid
                tempCoords=sc.nextLine(); //get user's input
                 try{ //test to see if the input can be converted into an integer
                     coords[x]=Integer.parseInt(tempCoords); //stores converted coord into coords[x]
                     valid=true; //set valid to true
                }
                catch(Exception e){ //if there is an error
                    System.out.println("Invalid entry try again"); //tells user there is an error
                    valid=false; //set valid to false
                }
                if(valid ==true){ //checks to see if valid is ture (as this won't work if it is not an integer)
                  if((coords[x]>=0)&&(coords[x]<=8)){ //checks to see if the attack is in the grid
                    valid=true; //set valid to true
                  }
                  else{ //if attack is outside grid tells user that input is invalid and sets valid to false
                    System.out.println("Invalid entry try again");
                    valid=false;
                  }
                }
            }while(valid==false); //loops while valid is false
           valid=false; //set valid to false, so it can get next coord
        }

    }




    public void checkHit(){ //create a function called checkHit <-- it is more of an interface as it changes depending on attack
    }

}
