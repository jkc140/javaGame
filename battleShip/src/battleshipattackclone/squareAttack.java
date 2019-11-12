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
        public int[][]squareCoords=new int[4][2];
        public void squarePos(int[] coords){       
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
    public void checkHit( int[][]shipPos){
        for(int x=0;x<5;x++){
            for(int y=0;y<5;y++){
                for(int z=0;z<4;z++){
                    for(int a=0;a<2;a++){
                        if(shipPos[x][y]==squareCoords[z][a]){
                            System.out.println("Hit");
                        }
                        else{
                            System.out.println("Miss");
                        }
                    }
                }  
            }
        }
    }
}
