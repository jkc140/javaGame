/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipattackclone;

import java.util.Scanner;
import javax.swing.*;


/**
 *
 * @author S331462374
 */
public class BattleshipAttackClone {
    public int[]coords=new int[2];
    /**
     * @return 
     */
    public String AttackChoice() {
        String Choice="";
         Scanner input = new Scanner(System.in);  
        System.out.println("Which attack would you like to choose?");
        String AttackChoice;
        String Instruction = "Cross Attack(1)"+"\n"+"2x2(2)"+"\n"+"Single(3)";
        System.out.println(Instruction);
        AttackChoice = input.nextLine();
        if ("1".equals(AttackChoice)){
            Choice="Cross";
            //else if("2".equals(AttackChoice)){
              //      Choice="2x2";
              //  }
                //else{
                   // Choice="Single";
                   // }
          
        }
        return null;
    }
    public void getCoords(){
        Scanner sc=new Scanner(System.in);
        boolean valid=false;
        String tempCoords;
        for(int x=0;x<2;x++){
            if(x==0){
                System.out.println("Enter the x coordnate for the attack");
            }
            else{
                System.out.println("Enter the y coordnate for the attack");
            }
            do{
                tempCoords=sc.nextLine();
                 try{
                     coords[x]=Integer.parseInt(tempCoords);
                }
                catch(Exception e){
                    System.out.println("Invalid entry try again");
                }
            }while(valid==false);
           valid=false;
        }
               
    }
    public void crossPos(){
        int[][] crossCoords=new int[5][2];
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
    public void squarePos(){
        int[][]squareCoords=new int[4][2];
        
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
    
    
    private void GettingCoordinates2x2(){
        while (true){
        String[] xCoordinates = {"a", "b", "c", "d","e","f","g","h","i"};
        String xValue;
        int x;
        boolean letterWasFound = false;
        xValue = JOptionPane.showInputDialog(null,
                "Enter a coordinate ranging from a-i");
        for(x = 0; x < xCoordinates.length; ++x)
            if(xValue.equals(xCoordinates [x]))
                letterWasFound = true;
        if(letterWasFound == false){
            
        } else {
            break;
        }
    }
        
        try{
            System.out.println("Enter a y-coordinate");
            
        }
        catch(Exception e){
        }
    }
    public static void main(String[] args) {
    
    }
    
}
