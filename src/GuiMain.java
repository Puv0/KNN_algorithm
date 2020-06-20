
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter.Entry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puv0
 */
public class GuiMain {  //
     
    public LinkedListt readFromFile(){
        Scanner file = null ;
       LinkedListt flowers = new LinkedListt();
        try {
             file = new Scanner(new FileInputStream("data.txt"));
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GuiMain.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        while(file.hasNext()){
                StringTokenizer token = new StringTokenizer(file.nextLine()) ; 
                        int tempCount = 0  ;
                        Lily newLily = new Lily();
                        while(token.hasMoreTokens()){
                            String temp = token.nextToken(",");
                            switch(tempCount){
                                    case 0 :
                                        newLily.setEpicalyx_length(Double.parseDouble(temp));
                                        tempCount++;
                                        break;
                                    case 1:
                                        newLily.setEpicalyx_width(Double.parseDouble(temp));
                                        tempCount++;
                                        break;
                                    case 2 :
                                        newLily.setPetal_length(Double.parseDouble(temp));
                                        tempCount++;
                                        break;
                                    case 3 :
                                        newLily.setPetal_width(Double.parseDouble(temp));
                                        tempCount++;
                                        break;
                                    case 4 :
                                        newLily.setType(temp);
                                        tempCount = 0 ;
                                                                  flowers.addLast(newLily);
                                                  

                                        break;  
                            }
                            
                        }
        }
        return flowers;
    }

    public Lily[] KNN(LinkedListt flowers,Lily flower,int k){  
          
          Lily testLily = new Lily(flower.getEpicalyx_length(), flower.getEpicalyx_width(), flower.getPetal_length(), flower.getPetal_width()) ;
          Lily [] k_list = new Lily[k+1];
          LinkedListt distance_list = new LinkedListt();
          double distance = 0 ;
          LinkedListt.ite iterator = flowers.iterator();
         
          while(iterator.hasNext()){
              Lily dataLily = iterator.next();
              double a  = Math.pow(testLily.getEpicalyx_length()-dataLily.getEpicalyx_length(),2) +  // Calculate the distance beetween given flower and flower in database
                      Math.pow(testLily.getEpicalyx_width()-dataLily.getEpicalyx_width(),2) + 
                      Math.pow(testLily.getPetal_length()-dataLily.getPetal_length(),2)+
                      Math.pow(testLily.getPetal_width() - dataLily.getPetal_width(),2);
              distance  =Math.sqrt (a) ;
              
              dataLily.setDistance(distance);
              distance_list.addOrder(dataLily);
          
          }
          k_list[0] = testLily ; // we want to keep given flower by user to decide which type it is. 
          LinkedListt.ite x = distance_list.iterator() ;
          for(int i = 1; i<k+1 ; i++){
              k_list[i] = x.next() ;
                      }
          return k_list;
    } //this method return an array which has closest flowers which user wants to find out flowers type
    public Lily[] KNNepicalyx(LinkedListt flowers,Lily testLily,int k){
       
        
          Lily [] k_list = new Lily[k+1];
          LinkedListt distance_list = new LinkedListt();
          double distance = 0 ;
          LinkedListt.ite iterator = flowers.iterator();
         
          while(iterator.hasNext()){
              Lily dataLily = iterator.next();
              double a  = Math.pow(testLily.getEpicalyx_length()-dataLily.getEpicalyx_length(),2) + 
                      Math.pow(testLily.getEpicalyx_width()-dataLily.getEpicalyx_width(),2) ;
              distance  =Math.sqrt(a) ;
              
              dataLily.setDistance(distance);
              distance_list.addOrder(dataLily);
          
          }
          k_list[0] = testLily ;
          LinkedListt.ite x = distance_list.iterator() ;
          for(int i = 1; i<k+1 ; i++){
              k_list[i] = x.next() ;
                      }
          return k_list;
    
    } //KNN method limited by only 2 attribute
    public Lily[] KNNpetal(LinkedListt flowers, Lily flower, int k){
        
        Lily testLily = new Lily();
        testLily.setPetal_length(flower.getPetal_length());
        testLily.setPetal_width(flower.getPetal_width());
        Lily [] k_list = new Lily[k+1];
          LinkedListt distance_list = new LinkedListt();
          double distance = 0 ;
          LinkedListt.ite iterator = flowers.iterator();
          while(iterator.hasNext()){
              Lily dataLily = iterator.next();
              double a  = Math.pow(testLily.getPetal_length()-dataLily.getPetal_length(),2)+
                                  Math.pow(testLily.getPetal_width()-dataLily.getPetal_width(),2 );
              
              distance  =Math.sqrt(a) ;
              
              dataLily.setDistance(distance);
              distance_list.addOrder(dataLily);
          
          }
          k_list[0] = testLily ;
          LinkedListt.ite x = distance_list.iterator() ;
          for(int i = 1; i<k+1 ; i++){
              k_list[i] = x.next() ;
                      }
          return k_list;
    
    } // KNN method limited by only 2 attribute
    public Lily[] KNNtest(LinkedListt flowers, Lily flower,int k){
         Scanner scanner = new Scanner(System.in);     
          Lily givenLily = new Lily(flower.getEpicalyx_length(), flower.getEpicalyx_width(), flower.getPetal_length(), flower.getPetal_width()) ;
          Lily [] k_list = new Lily[k+1];
          LinkedListt distance_list = new LinkedListt();
          double distance = 0 ;
          LinkedListt.ite iterator = flowers.iterator();
         
          while(iterator.hasNext()){
              Lily existLily = iterator.next();
              double a  = Math.pow(givenLily.getEpicalyx_length()-existLily.getEpicalyx_length(),2) + 
                      Math.pow(givenLily.getEpicalyx_width()-existLily.getEpicalyx_width(),2) +
                      Math.pow(givenLily.getPetal_length()-existLily.getPetal_length(),2)+
                      Math.pow(givenLily.getPetal_width() - existLily.getPetal_width(),2);
              distance  =Math.sqrt (a) ;
              
              existLily.setDistance(distance);
              distance_list.addOrder(existLily);
          
          }
          k_list[0] = givenLily ;
          LinkedListt.ite x = distance_list.iterator() ;
          for(int i = 1; i<k+1 ; i++){
              k_list[i] = x.next() ;
                      }
          return k_list;
    } // For calculate succes rate
    public String guessType(Lily[] k_list){ 
            Map<String, Integer> map = new HashMap<String, Integer>(); // collect the number of types 
            int setosa = 0 ;
            int versicolor = 0 ;
            int virginica = 0 ;
            for(int i = 1 ; i<k_list.length ; i++){
                switch(k_list[i].getType()){
                 case "Iris-setosa":
                     setosa++;
                     break;
                 case "Iris-versicolor":
                     versicolor++;
                     break;
                 case "Iris-virginica":
                     virginica++;
                     break;
                }
            
            }
            map.put("Iris-setosa", setosa);
            map.put("Iris-versicolor", versicolor);
            map.put("Iris-virginica", virginica);
            
            int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
            for (Map.Entry<String, Integer> entry : map.entrySet()) {  // Itarete through hashmap
                if (entry.getValue()==maxValueInMap) {
                    k_list[0].setType(entry.getKey());
            }
              
          }
            return k_list[0].getType();
    } //Guessing which type of flower 
    
    public String test(int k){    //Succes Rate 
       String temp = "" ;
       LinkedListt flowers = readFromFile();
        LinkedListt data = new LinkedListt() ;
        LinkedListt testData = new LinkedListt();
        int index = 0 ;
        double correct = 0 ;
        LinkedListt.ite ite = flowers.iterator();
        while(ite.hasNext()){ 
            Lily flower = ite.next();
            if(index>39 && index<50){
                testData.addLast(flower);
                index++ ;
                
            }
            else if (index>89 && index<100){
               testData.addLast(flower);
               index ++;
            }
            else if(index>139 && index<150){
                testData.addLast(flower);
                index ++;
            }
            else{
                data.addLast(flower);
                index ++;
            }
        }
            LinkedListt.ite iterator = testData.iterator();
            while(iterator.hasNext()){
                Lily testLily = iterator.next();
                String tempType = testLily.getType();
                Lily[] k_list = KNNtest(data, testLily,k);
                guessType(k_list);
                
                if(k_list[0].getType().equals(tempType)){
                    temp +=  "Correct! \n"  +
                            "Guess: " + k_list[0].getType()+"\n"
                    ;
                    
                    correct ++ ;
                }
                else{
                    
                    temp += "Wrong! Guess: "+ k_list[0].getType()+" \n" + 
                            "Actual Type: " + tempType+"\n" ;
                }
            }
            
            double succes_rate = (correct/30);
            temp += "\n Succes Rate = " + String.valueOf(succes_rate) ;
            return temp ;
    }
    
}