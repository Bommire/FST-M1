package com.example.Activity;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        
        hs.add("SS");
        hs.add("BS");
        hs.add("NS");
        hs.add("VS");
        hs.add("AS");
        hs.add("RS");
        
        
        System.out.println("Original HashSet: " + hs);        
        
        System.out.println("Size of HashSet: " + hs.size());
        
        
        System.out.println("Removing SS from HashSet: " + hs.remove("SS"));
        
        if(hs.remove("RS")) {
        	System.out.println("RS removed from the Set");
        } else {
        	System.out.println("RS is not present in the Set");
        }
        
        
        System.out.println("Checking if VS is present: " + hs.contains("VS"));
        
        System.out.println("Updated HashSet: " + hs);
    }
}
