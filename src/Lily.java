/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puv0
 */
public class Lily  {
    
     private double epicalyx_length ;  
     private double epicalyx_width; //çanak yaprak
     private double petal_length; // taç yaprak
     private double petal_width ; 
     private String type ;
     private double distance = 0 ; 

    public Lily(double epicalyx_length, double epicalyx_width, double petal_length, double petal_width, String type) {
        this.epicalyx_length = epicalyx_length;
        this.epicalyx_width = epicalyx_width;
        this.petal_length = petal_length;
        this.petal_width = petal_width;
        this.type = type;
    }

    public Lily(double epicalyx_length, double epicalyx_width, double petal_length, double petal_width) {
        this.epicalyx_length = epicalyx_length;
        this.epicalyx_width = epicalyx_width;
        this.petal_length = petal_length;
        this.petal_width = petal_width;
    }

   
     
     
     public Lily(){
     
     }

    public double getEpicalyx_length() {
        return epicalyx_length;
    }

    public void setEpicalyx_length(double epicalyx_length) {
        this.epicalyx_length = epicalyx_length;
    }

    public double getEpicalyx_width() {
        return epicalyx_width;
    }

    public void setEpicalyx_width(double epicalyx_width) {
        this.epicalyx_width = epicalyx_width;
    }

    public double getPetal_length() {
        return petal_length;
    }

    public void setPetal_length(double petal_length) {
        this.petal_length = petal_length;
    }

    public double getPetal_width() {
        return petal_width;
    }

    public void setPetal_width(double petal_width) {
        this.petal_width = petal_width;
    }

    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setDistance(Double distance){
        this.distance = distance ;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return epicalyx_length+" "+ epicalyx_width+" "+petal_length+" "+petal_width+" "+type  ;
    }
     
}
