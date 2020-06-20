
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    
    static LinkedListt flowers;
    
    public static void main(String[] args){
    
            GuiMain mainobject = new GuiMain(); //We want to keep main class simple so we decided to write our method in another class which is GuiMain
             flowers = mainobject.readFromFile(); 
 
          Guıform gf = new Guıform(); //Our Menu 
          gf.setVisible(true);            
    }
    
    public LinkedListt getList(){ // to return linkedlist that collect our flowers
        return flowers;
    
    }
 
}    
        
        
   

