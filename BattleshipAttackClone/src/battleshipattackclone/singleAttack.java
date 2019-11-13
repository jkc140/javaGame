package battleshipattackclone;

public class singleAttack extends BattleshipAttackClone{
	public int[][]singleCoords=new int[1][2];
    public String[] hitOrMiss=new String[1];
    public void singlePos(){       
    //left
    	singleCoords[0][0]=coords[0];
    	singleCoords[0][1]=coords[0];
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
                
                    	if((shipPos[pCheck][0][y][0]==singleCoords[0][0])&&(shipPos[pCheck][y][x][1]==singleCoords[0][1])){
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
