/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_7188;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lab3_7188
 */
public class Lab3_7188 {

    /**
     * @param args the command line arguments
     */

    //scanner for user inputs of weight, and numOfPages
    static Scanner scan = new Scanner(System.in);
    
    /**
     * method to create random instances 
     * of Package class
     */
    public static Package load_a_package(){
        Package pack = null;
        int rand = (new Random()).nextInt(4); //random number generator
        
        switch(rand){
            case 0:
                pack = new Box(); //new Box object
                break;
            case 1:
                pack = new Letter(); //new Letter object
                break;
            case 2:
                pack = new MetalCrate(); //new MetalCrate object
                break;
            case 3:
                pack = new WoodCrate(); //new WoodCrate object
                break;
        }
        pack.input(); //calls input method for package object
        return pack;
    }
    
    /**
     * displays package number and cost for shipping 
     */
    public static void main(String[] args) {
        Package pack = null;
        for(int i=0;i<5;i++){
            System.out.printf("\n**** package %d ****\n",i);
            pack=load_a_package(); // calls method for a random package
            System.out.printf(
                    "The cost of this package is $%.2f\n",pack.cost());
        }
    }
    /**
     * package class interface
     */
    static interface Package{
        double cost(); //cost method for shipping cost calculation
        void input(); //input method for user input
    }
    
    /**
     * derived class from Package
     * for shipping of boxes
     */
    static class Box implements Package{
        
        int weight; //instance variable for user weight input
        
        //Box cost method
        public double cost(){
            
            return 1.2 * weight; //returns Box shipping calculation
        
        }
        
        //Box user input method
        public void input(){
            System.out.print("Please enter the weight for the Box"
                    + " (lbs) : ");
            weight = scan.nextInt(); //input for weight
        }
    }
    
    /**
     * derived class from Package
     * for shipping of letters
     */
    static class Letter implements Package{
        
        int numOfPages; //instance variable for user pages input
        
        //Letter cost method
        public double cost(){
            
            return .05 * numOfPages; //returns Letter shipping calculation
        
        }
        
        //Letter user input method
        public void input(){
            System.out.print("Please input the number of pages for the letter"
                    + " (pgs) : ");
            numOfPages = scan.nextInt(); //input for pages
        }
    }
    
    /**
     * abstract class derived from Package
     * for shipping two different types of
     * crates
     */
    static abstract class Crate implements Package{
        int weight; //instance variable for weight
        
        //variable to retain where the class was called from
        Class obj = this.getClass(); 
        
        //Crate input method
        public void input(){
            //obtain and print class name with prompt
            System.out.print("Please input the weight for the " + 
                    obj.getSimpleName() + " (lbs) : "); 
            weight = scan.nextInt(); //input for weight
        }
    }
    
    /**
     * derived class from Crate
     * calculates MetalCrate 
     * shipping costs
     */
    static class MetalCrate extends Crate{
        public double cost(){
            return 1.3 * weight;
        }
        
    }
    
    /**
     * derived class from Crate
     * calculates WoodCrate 
     * shipping costs
     */
    static class WoodCrate extends Crate{
        public double cost(){
            return 1.4 * weight;
        }
    }
    
}
