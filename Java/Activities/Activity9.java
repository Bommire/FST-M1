package com.example.Activity;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        
        ArrayList<String> myList = new ArrayList<String>();
       
        myList.add("Suchi");
        myList.add("Bhar");
        myList.add("Rohini");
        
        myList.add(3, "Bommi");
        myList.add(1, "Renu");
        
        System.out.println("Print All the Objects:");
        for(String s:myList){
            System.out.println(s);
        }
        
        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is gottumukula is in list: " + myList.contains("Gottumukula"));
        System.out.println("Size of ArrayList: " + myList.size());
        
        myList.remove("Bommi");
        
        System.out.println("New Size of ArrayList: " + myList.size());
    }
}
