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
        System.out.println(coords[0]+1);
        System.out.println("Coord x"+coords[0]);
        System.out.println("Coord y"+coords[1]);
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
       		 System.out.println("Checking attact: " +atNum);
       		 for(int sNum=0;sNum<1;sNum++) {
       			if(hitOrMiss[atNum].equalsIgnoreCase("hit")) {
       				System.out.println("Already a hit");
      				 break;
      			 }
      			 else {
      				 
      			 
       	   		 System.out.println("Checking ship: " +sNum);
       	   		 System.out.println("Ship Length: "+shipList[pCheck][sNum].size);
       			 for(int pNum=0;pNum<shipList[pCheck][sNum].size;pNum++) {
       		   		 System.out.println("Checking pos: " +pNum);

       				 System.out.println(crossCoords[atNum][0] +" : "+shipPos[pCheck][sNum][pNum][0]);
       				 System.out.println(crossCoords[atNum][1] +" : "+shipPos[pCheck][sNum][pNum][1]);
       				 if((crossCoords[atNum][0]==shipPos[pCheck][sNum][pNum][0])&&crossCoords[atNum][1]==shipPos[pCheck][sNum][pNum][1]) {
       					 System.out.println("Hit");
       	                hitOrMiss[atNum]="hit";
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
       	                hitOrMiss[atNum]="miss";
       				 }
       			 }
      			 }
       		 }
       	 }
    	 
    	 for(int x=0;x<5;x++) {
    		System.out.println("HOM: "+ hitOrMiss[x]);
    	 }
    	 
           
        
    }
}

/*// for(int y=0;y<5;y++){ //boat
                //for(int z=0;z<5;z++){ //spaces on boat
                    for(int x=0;x<5;x++) { //number of attack positions
                        if((shipPos[pCheck][0][x][0]==crossCoords[x][0])&&(shipPos[pCheck][0][x][1]==crossCoords[x][1])){
                            System.out.println("x:"+crossCoords[x][0] + " y:"+crossCoords[x][1]+ " Hit");
                        	//System.out.println("Hit");
                            hitCoords[0][0]=crossCoords[x][0];
                            hitCoords[0][1]=crossCoords[x][1];
                            hitOrMiss[x]="hit";
                            System.out.println(shipList[pCheck][0].health);
                            shipList[pCheck][0].health=shipList[pCheck][0].health-1;
                            System.out.println(shipList[pCheck][0].health);
                            
                            if(shipList[pCheck][0].health==0){
                                System.out.println("Sunk");
                                shipList[pCheck][0].sunk=true;
                            }
                            
                           // break; //remove ??
                        }
                        else{
                            System.out.println("x:"+crossCoords[x][0] + " y:"+crossCoords[x][1]+ " Miss");
                            System.out.println("Miss");
                            hitOrMiss[x]="miss";
                        
                        }
                    }
                //}  
            //}*/
