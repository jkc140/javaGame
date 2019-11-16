/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipattackclone;
 import battleship.BattleShip;
import ship.*;
/**
 *
 * @author S331474817
 */
public class squareAttack extends BattleshipAttackClone{ //create a subclass of battleshipattackclone called square attack
       public int[][]squareCoords=new int[5][2];  //create an array of integers that stores the coordinates for the square attacks
        public String[] hitOrMiss=new String[4];//create an array of strings to hold whether the attack was a hit or a miss

        public void squarePos(){ //create a function called squarePos to assign the positions of the square attack
        //left
        squareCoords[0][0]=coords[0]; //x coord
        squareCoords[0][1]=coords[1]; //y coord
        //right
        squareCoords[1][0]=coords[0]+1; //x coord
        squareCoords[1][1]=coords[0]; //y coord
        //bottom left
        squareCoords[2][0]=coords[0]; //x coord
        squareCoords[2][1]=coords[0]+1; //y coord
        //bottom right
        squareCoords[3][0]=coords[0]+1; //x coord
        squareCoords[3][1]=coords[0]+1; //y coord


    }
    public void checkHit( int turn, int[][][][]shipPos,Ship[][]shipList){ //create a function to check to see if the attack was a hit
    	int pCheck; //create a variable called pCheck to hold the opponent player

    	if(turn==0) {// if it is player 0 turn, then it will switch/store the opponent as 1 to pCheck
    			pCheck=1;
    	}
    	else { //does the other player
    			pCheck=0;
    	}
    	for(int x=0;x<4;x++) { //presets all hitOrMiss to be blank
    			hitOrMiss[x]="";
    	}
    	for(int atNum=0;atNum<4;atNum++) {  //loops for the number of attack positions
            for(int sNum=0;sNum<5;sNum++) {//loops the number of ships
            	if(hitOrMiss[atNum].equalsIgnoreCase("hit")) { //checks to see if the hitOrMiss at the current attack position is a hit
                    break; //breaks out of the ship check
            	}
            	else { //if not a hit
                    for(int pNum=0;pNum<shipList[pCheck][sNum].size;pNum++) { //loops for the number of ship positions (number of squares the ship occupies)
                        if((squareCoords[atNum][0]==shipPos[pCheck][sNum][pNum][0])&&squareCoords[atNum][1]==shipPos[pCheck][sNum][pNum][1]) { //checks to see if the x and y coords of a ship position is the same as the current square attack position
                            hitOrMiss[atNum]="hit";//sets hitOrMiss for the current coord to hit
                            shipList[pCheck][sNum].health=shipList[pCheck][sNum].health-1;//subtract 1 from the health of the ship being checked
                            if(shipList[pCheck][sNum].health==0){// checks to see if the ship's health is 0
                                shipList[pCheck][sNum].sunk=true; //tells the ship is sunk
                                BattleShip.sunkCount[pCheck]++;
                            }
                            break;//breaks out of the loop if it is a hit
                        }
                        else{
                            hitOrMiss[atNum]="miss";//set hitorMiss as a miss
                        }
                    }
            	}
            }
    	}
    }
}
