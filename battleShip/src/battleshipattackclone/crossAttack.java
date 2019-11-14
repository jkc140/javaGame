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
public class crossAttack extends BattleshipAttackClone{
    public int[][] crossCoords=new int[5][2];
    int[][] hitCoords=new int[5][2];
    public String[] hitOrMiss=new String[5];
     public void crossPos(){
         
         //center
        crossCoords[0][0]=coords[0];
        crossCoords[0][1]=coords[1];
        
        //top left
        crossCoords[1][0]=coords[0]-1;
        crossCoords[1][1]=coords[1]-1;
        //bottom left
        crossCoords[2][0]=coords[0]-1;
        crossCoords[2][1]=coords[1]+1;
        //top right
        crossCoords[3][0]=coords[0]+1;
        crossCoords[3][1]=coords[1]-1;
        //bottom right
        crossCoords[4][0]=coords[0]+1;
        crossCoords[4][1]=coords[1]+1;

    }
     public void checkHit(int turn, int[][][][]shipPos,Ship[][] shipList){
    	int pCheck;
    	 
    	 if(turn==0) {
            pCheck=1;
    	 }
    	 else {
            pCheck=0;
    	 }
    	 for(int x=0;x<5;x++) {
    	    hitOrMiss[x]="";
    	}
    	for(int atNum=0;atNum<5;atNum++) {
            for(int sNum=0;sNum<1;sNum++) {
       		if(hitOrMiss[atNum].equalsIgnoreCase("hit")) {
                    break;
      		}
      		else {
                    for(int pNum=0;pNum<shipList[pCheck][sNum].size;pNum++) {
       			if((crossCoords[atNum][0]==shipPos[pCheck][sNum][pNum][0])&&crossCoords[atNum][1]==shipPos[pCheck][sNum][pNum][1]) {
                            hitOrMiss[atNum]="hit";
                            shipList[pCheck][0].health=shipList[pCheck][0].health-1;
       	                
                            if(shipList[pCheck][0].health==0){
                                shipList[pCheck][0].sunk=true;
                            }
                            break;
       			}
       			else{
                            hitOrMiss[atNum]="miss";
       			}
                    }
      		}
            }
       	}
    }
}
