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
        boolean valid=false;
        Scanner input = new Scanner(System.in);  
        System.out.println("Which attack would you like to choose?");
        String AttackChoice;
        String Instruction = "Cross Attack(1)"+"\n"+"2x2(2)"+"\n"+"Single(3)";
        System.out.println(Instruction);
        AttackChoice = input.nextLine();
        do{
            if ("1".equals(AttackChoice)){
                Choice="Cross";
                valid=true;
                break;
            }
            else if("2".equals(AttackChoice)){
                Choice="2x2";
                valid=true;
                break;
            }
            else if ("3".equalsIgnoreCase(AttackChoice)){
                Choice="Single";
                valid=true;   
                break;}
            else{
                System.out.println("Invalid entry try again");
                valid=false;
            }
        }while(valid==false);
        return Choice;
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
                     valid=true;
                }
                catch(Exception e){
                    System.out.println("Invalid entry try again");
                    valid=false;
                }
            }while(valid==false);
           valid=false;
        }
               
    }

   

    
    public void checkHit(int[][] pos, int[][]shipPos){
        for(int x=0;x<5;x++){
            for(int y=0;y<5;y++){
                for(int z=0;z<pos.length;z++){
                    for(int a=0;a<2;a++){
                        if(shipPos[x][y]==pos[z][a]){
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
