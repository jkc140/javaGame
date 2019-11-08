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
        catch(inputmismatchexception){
        }
    }
    public static void main(String[] args) {
    
    }
    
}
