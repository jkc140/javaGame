/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipattackclone;

import java.util.Scanner;

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
            else if("2".equals(AttackChoice)){
                    Choice="2x2";
                }
                    else{
                    Choice="Single";
                    }
          
        }
        return null;
    }
    public static void main(String[] args) {
    
    }
    
}
