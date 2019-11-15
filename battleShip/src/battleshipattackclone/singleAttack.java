/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipattackclone;
import ship.*;
/**
 *
 * @author S331474817
 */
public class singleAttack extends BattleshipAttackClone{ //create a subclass of battleshipattackclone called singleattack
    public int[][]singleCoords=new int[1][2]; //create an array of integers that stores the coordinates for the single attacks
    public String[] hitOrMiss=new String[1]; //create an array of strings to hold whether the attack was a hit or a miss
    public void singlePos(){       //create a function called singlePos to assign the positions of the single attack
    //single
    	singleCoords[0][0]=coords[0]; //set x pos
    	singleCoords[0][1]=coords[0]; //set y pos
    }
    public void checkHit( int turn, int[][][][]shipPos,Ship[][]shipList){ //create a function to check to see if the attack was a hit
    	int pCheck; //create a variable called pCheck to hold the opponent player

    	if(turn==0) { // if it is player 0 turn, then it will switch/store the opponent as 1 to pCheck
    			pCheck=1;
    	}
    	else { //does the other player
    			pCheck=0;
    	}
    	hitOrMiss[0]=""; //preset hitOrMiss as blank
    	for(int sNum=0;sNum<5;sNum++) { //loops the number of ships
    		if(hitOrMiss[0].equalsIgnoreCase("hit")) { //checks to see if the hitOrMiss at the current attack position is a hit
    			break;//breaks out of the ship check
    		}
    		else { //if not a hit
    			for(int pNum=0;pNum<shipList[pCheck][sNum].size;pNum++) {//loops for the number of ship positions (number of squares the ship occupies)
    				if((singleCoords[0][0]==shipPos[pCheck][sNum][pNum][0])&&singleCoords[0][1]==shipPos[pCheck][sNum][pNum][1]) {//checks to see if the x and y coords of a ship position is the same as attack position
    					hitOrMiss[0]="hit"; //sets hitOrMiss for the current coord to hit
    					shipList[pCheck][sNum].health=shipList[pCheck][sNum].health-1;   	 //subtract 1 from the health of the ship being checked
    					if(shipList[pCheck][sNum].health==0){ // checks to see if the ship's health is 0
    						shipList[pCheck][sNum].sunk=true; //tells the ship is sunk
    					}
    					break; //breaks out of the loop if it is a hit
    				}
    				else{
    					hitOrMiss[0]="miss";//set hitorMiss as a miss
    				}
    			}
            }
   		}
    }
}
