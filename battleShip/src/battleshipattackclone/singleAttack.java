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
public class singleAttack extends BattleshipAttackClone{
    public int[][]singleCoords=new int[1][2];
    public String[] hitOrMiss=new String[1];
    public void singlePos(){       
    //single
    	singleCoords[0][0]=coords[0];
    	singleCoords[0][1]=coords[0];
    }
    public void checkHit( int turn, int[][][][]shipPos,Ship[][]shipList){
    	int pCheck;
   	 
   	if(turn==0) {
            pCheck=1;
   	}
   	else {
            pCheck=0;
   	}
   	hitOrMiss[0]="";
   	for(int sNum=0;sNum<1;sNum++) {
            if(hitOrMiss[0].equalsIgnoreCase("hit")) {
                break;
            }
            else {
  		for(int pNum=0;pNum<shipList[pCheck][sNum].size;pNum++) {
                    if((singleCoords[0][0]==shipPos[pCheck][sNum][pNum][0])&&singleCoords[0][1]==shipPos[pCheck][sNum][pNum][1]) {
   	                hitOrMiss[0]="hit";
   	                shipList[pCheck][0].health=shipList[pCheck][0].health-1;   	            
   	                if(shipList[pCheck][0].health==0){
   	                    shipList[pCheck][0].sunk=true;
   	                }
   	                break;
                    }
                    else{
   	                hitOrMiss[0]="miss";
                    }
   		}
            }
   	} 	 
    }
}