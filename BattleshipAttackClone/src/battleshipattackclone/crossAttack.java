/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipattackclone;

/**
 *
 * @author S331474817
 */
public class crossAttack extends BattleshipAttackClone{
    int[][] crossCoords=new int[5][2];
     public void crossPos(){
        crossCoords[0][0]=coords[0];
        crossCoords[0][1]=coords[1];
        
        //top left
        crossCoords[1][0]=coords[0]-1;
        crossCoords[1][1]=coords[0]-1;
        //bottom left
        crossCoords[2][0]=coords[0]-1;
        crossCoords[2][1]=coords[0]+1;
        //top right
        crossCoords[3][0]=coords[0]+1;
        crossCoords[3][1]=coords[0]-1;
        //bottom right
        crossCoords[4][0]=coords[0]+1;
        crossCoords[4][1]=coords[0]+1;
    }
     public void checkHit(int turn, int[][][][]shipPos){
    	 int pCheck;
    	 int[][] hitCoords=new int[5][2];
    	 if(turn==0) {
    		 pCheck=1;
    	 }
    	 else {
    		 pCheck=0;
    	 }
    	
            for(int y=0;y<5;y++){
                for(int z=0;z<5;z++){
                    
                        if((shipPos[pCheck][y][z][0]==crossCoords[z][0])&&(shipPos[pCheck][y][z][1]==crossCoords[z][1])){
                            System.out.println("Hit");
                            hitCoords[y][0]=crossCoords[z][0];
                            hitCoords[y][1]=crossCoords[z][1];
                            
                        }
                        else{
                            System.out.println("Miss");
                        
                    }
                }  
            }
        
    }
}
