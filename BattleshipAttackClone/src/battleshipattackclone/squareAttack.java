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
public class squareAttack extends BattleshipAttackClone{
        public int[][]squareCoords=new int[5][2];
        public String[] hitOrMiss=new String[5];
        public void squarePos(){       
        //left
        squareCoords[0][0]=coords[0];
        squareCoords[0][1]=coords[1];
        //right
        squareCoords[1][0]=coords[0]+1;
        squareCoords[1][1]=coords[0];
        //bottom left
        squareCoords[2][0]=coords[0];
        squareCoords[2][1]=coords[0]+1;
        //bottom right
        squareCoords[3][0]=coords[0]+1;
        squareCoords[3][1]=coords[0]+1;
        
        squareCoords[4][0]=-2;
        squareCoords[4][1]=-2;
    }
    public void checkHit( int turn, int[][][][]shipPos){
    	int pCheck;
   	 
   	 if(turn==0) {
   		 pCheck=1;
   	 }
   	 else {
   		 pCheck=0;
   	 }
    	for(int x=0;x<5;x++){
            for(int y=0;y<5;y++){
                for(int z=0;z<4;z++){
                		if(hitOrMiss[x]=="hit") {
                			break;
                		}
                    	if((shipPos[pCheck][0][y][0]==squareCoords[x][0])&&(shipPos[pCheck][y][x][1]==squareCoords[x][1])){
                            System.out.println("Hit");
                            hitOrMiss[x]="hit";
                        }
                        else{
                            System.out.println("Miss");
                            hitOrMiss[x]="miss";
                        }
                    
                }  
            }
        }
    }
}
