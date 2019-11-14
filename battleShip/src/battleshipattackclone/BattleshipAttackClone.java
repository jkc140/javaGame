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
        do{
        	AttackChoice = input.nextLine();
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

   

    
    public void checkHit(){
    }
        
}
