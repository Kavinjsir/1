package com.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author kavin
 * 
 */
public class CasualPractice {
    public static void main(String[] args) { 
        int x=5, y=0; 
        try{ 
             try { 
                  System.out.println(x); 
                  System.out.println(x/y); 
                  System.out.println(y); 
             } 
             catch(ArithmeticException ex){ 
                  System.out.println("Inner Catch1"); 
                  throw ex; 
             } 
             catch(RuntimeException ex){ 
                  System.out.println("Inner Catch2"); 
                  throw ex; 
             } 
             finally { 
                  System.out.println("Inner Finally"); 
             } 
        } 
        catch (Exception ex) { 
             System.out.println("Outer Catch"); 
        } 
   }
}
