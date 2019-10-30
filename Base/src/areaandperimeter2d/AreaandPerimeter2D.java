/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areaandperimeter2d;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Liam and Moe
 */
public class AreaandPerimeter2D {
    static double L, W, H;
    //These are the main variables 
    //They'll get extended to the other classes

    /**
     * @param l_
     * @return 
     */
   
    

public  static double GetValue(String l_){
    Scanner input = new Scanner(System.in);
    double num;
            while (true){
                try{
                    num=input.nextDouble();
                    break;
                }
                catch(InputMismatchException err){
                    input.next();
                    System.out.print("That's not a number, start again another.");
                }
            }
            return num;
        

}

public  static void main (String[] args) {
        System.out.println("Enter the Length, Width and Height below,:");
        Scanner input;
        input = new Scanner(System.in);
        L=GetValue("L: ");  
        W=GetValue("W: ");
        H=GetValue("H: ");
        Area area= new Area(L,W,H);
        System.out.println("The Perimeter is: " + area.P);
        System.out.println("The Volume is: " + area.V);
        System.out.println("The Area is: " + area.A);
        
  
    }

           
        
    }



