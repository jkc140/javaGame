/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areaandperimeter2d;

/**
 *
 * @author S331462374
 */
public class Area extends AreaandPerimeter2D {
 
    public Area(double L, double W, double H){
        P = W+W+H+H;
        A = W*H;
        V = L*W*H;
    }
    
    double P;
    double A;
    double V;
 
    
                   
}
