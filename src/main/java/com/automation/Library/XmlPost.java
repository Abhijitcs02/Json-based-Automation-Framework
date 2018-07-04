package com.automation.Library;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by 543175 on 4/18/2018.
 */
public class XmlPost {
    public static void main(String args[]){
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the file content:");
            String para= buff.readLine();
            System.out.println("Enter the virus keyword:");
            String para2= buff.readLine();
            if(para.contains(para2.trim()))
                System.out.println("Virus  "+para2.trim()+"  is present");
            else
                System.out.println("Virus  "+para2.trim()+"  is not present");

        }
        catch (Exception e) {
            System.out.println("Virus");
        }


    }
}
