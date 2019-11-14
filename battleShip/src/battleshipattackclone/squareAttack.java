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
public class squareAttack extends BattleshipAttackClone{
       public int[][]squareCoords=new int[5][2];
        public String[] hitOrMiss=new String[4];
        
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
        

    }
    public void checkHit( int turn, int[][][][]shipPos,Ship[][]shipList){
    	
    	int pCheck;
   	 
   	 if(turn==0) {
   		 pCheck=1;
   	 }
   	 else {
   		 pCheck=0;
   	 }
   	 for(int x=0;x<4;x++) {
    	hitOrMiss[x]="";
   	 }
   	 for(int atNum=0;atNum<4;atNum++) {
   		 for(int sNum=0;sNum<1;sNum++) {
   			 for(int pNum=0;pNum<shipList[pCheck][sNum].shipLength;pNum++) {
   				 if((squareCoords[atNum][0]==shipPos[pCheck][sNum][pNum][0])&&squareCoords[atNum][1]==shipPos[pCheck][sNum][pNum][1]) {
   					 System.out.println("Hit");
   	                hitOrMiss[sNum]="hit";
   	                System.out.println(shipList[pCheck][0].health);
   	                shipList[pCheck][0].health=shipList[pCheck][0].health-1;
   	                System.out.println(shipList[pCheck][0].health);
   	                
   	                if(shipList[pCheck][0].health==0){
   	                    System.out.println("Sunk");
   	                    shipList[pCheck][0].sunk=true;
   	                }
   	                break;
   				 }
   				 else{
   	                System.out.println("Miss");
   	                hitOrMiss[sNum]="miss";
   				 }
   			 }
   			 if(hitOrMiss[sNum].equalsIgnoreCase("hit")) {
   				 break;
   			 }
   		 }
   	 }
   	 
    }
}
/*
for(int x=0;x<5;x++){
for(int y=0;y<5;y++){
    for(int z=0;z<4;z++){
    		if(hitOrMiss[x]=="hit") {
    			break;
    		}
        	if((shipPos[pCheck][0][y][0]==squareCoords[x][0])&&(shipPos[pCheck][y][x][1]==squareCoords[x][1])){
                System.out.println("Hit");
                hitOrMiss[x]="hit";
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
                hitOrMiss[x]="miss";
            }
        
    }  
}
}*/