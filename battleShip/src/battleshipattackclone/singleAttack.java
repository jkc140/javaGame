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
    //left
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
    	//for(int x=0;x<5;x++){
            for(int y=0;y<5;y++){
                
                    	if((shipPos[pCheck][0][y][0]==singleCoords[0][0])&&(shipPos[pCheck][y][0][1]==singleCoords[0][1])){
                            System.out.println("Hit");
                            hitOrMiss[0]="hit";
                            System.out.println(shipList[pCheck][0].health);
                            shipList[pCheck][0].health=shipList[pCheck][0].health-1;
                            System.out.println(shipList[pCheck][0].health);
                            
                            if(shipList[pCheck][0].health==0){
                                System.out.println("Sunk");
                                shipList[pCheck][0].sunk=true;
                            }
                        }
                        else{
                            System.out.println("Miss");
                            hitOrMiss[0]="miss";
                        }
                    
                }  
            }
        //}
    
}
