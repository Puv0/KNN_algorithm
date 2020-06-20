
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puv0
 */
public class LinkedListt { // We have give a distance attribute to every flower.           
    private  int count;    // When user give us a flower we calculate the distance beetween every flower in our list. 
                                        //After that we add in order to our LinkedList small to large distance
    
    

    

    
        
    public class Node{

        private  int size() {
            return size ;
        }
            private Lily data ;     
            private Node next ;
            private Node prev ;
            private  int size = 0;
            
            public Node(){
                next = null;
                prev = null;
                data = null;
            }
            public Node(Lily data ,Node next,Node prev){
                 this.data = data ;
                this.next = next ;
                this.prev = prev ;
                count ++ ;
            }
        
            
        }
    
    public class ite{
        Node location ;
        public ite(){
            location = head ;
        }
        public Lily next(){
        
        
        if(!hasNext()){
                            
                           System.out.println("There is no next node in this list");
                            throw new NoSuchElementException() ;
                        }
                else{
                        Lily newData = location.data ;   
                        location = location.next; 
                        return newData ; 
                    } 
                    }
        
    public boolean hasNext() {
        return (location !=null ) ;
    }
    
    }
        public ite iterator(){
                        return new ite();
                    }
    
        private Node head ;
    private Node tail ;
            
    
    public LinkedListt(){
        head = null;
        tail = null ;


   }
    public boolean isEmpty(){
        
        return (head == null) ;
    }
    public void addFirst(Lily data){
        Node newHead = new Node(data,head, null);
        if(isEmpty()){
            head = newHead ;
            tail = newHead;
        }
        else{
            head.prev = newHead;
            head = newHead;
        }
    }
    public void addOrder(Lily data){
        if(isEmpty()){
            addFirst(data);
        }else{
            boolean flag = true ;
           Node location = head; 
            double given_value = data.getDistance() ;
            double exist_value = location.data.getDistance() ;
            if(given_value < exist_value){
                addFirst(data);
            }
            else{
                while(location!=null){
                    
                    if(given_value < location.data.getDistance()){
                        addBefore(data,location);
                        flag = false ;
                        break ;
                        
                    }
                    location = location.next ;
                    
                        }
                    if(flag){
                        addLast(data);
                        location = head ; 
                        
                    }
                    
            }
                
                }
            
    }
        
        public void addLast(Lily data) {
        Node newTail = new Node(data, null, tail);
        if(isEmpty()){
            head = newTail;
            tail = newTail;
        }
        tail.next  = newTail ;
        tail = newTail ;
       
        
            }
    
    public void addAfter(Lily data){
            Node location = head ;
            Node newNode = new Node(data,location.next , location);
            location.next = newNode;
            location.next.prev = newNode;
            if(location.next.next == null ){
                tail = newNode;
            }
        }
    public void addBefore(Lily data,Node location){
        
        
        Node newNode = new Node(data,location,location.prev);
       
        location.prev.next = newNode;
        location.prev = newNode;
        
       
    }
    public void print(){
        Node location = head;
        int x = 1 ;
        while(location != null){
               
            System.out.println(x+"- "+location.data.toString());
            x++ ;
            location = location.next ;
        
        }
    }
  public int getSizeList(){
      return count;
  }
 
  public ArrayList<String> getDataList(){
            ArrayList<String> array = new ArrayList<>() ;
            Node location = head ;
            
            while(location != null){
                array.add(location.data.toString()) ;
                location = location.next ;
                
        }
                return array ;
        }

public void delete(int index_data){
         Node position = null ;
        if(index_data ==0){
            Node temp ;
            temp = head.next ;
            head = null ;
            head = temp ;
            head.prev = null ;
        }  else if(index_data == count-1) {
           Node temp ;
            temp = tail.prev ;
            tail=null ;
            tail = temp ;
            tail.next = null ;

        }
        else{
                position = head ;
                         int index = 0 ;

                while(position.next != null){
                if(index_data == index){
                    position.prev.next = position.next ;
                    position.next.prev =position.prev ;
                    System.out.println("Delete: "+ position.data.getEpicalyx_length());
                    position = null ;
                    break;
                }
                    position = position.next;
                    index++ ;
                }
                 
                
        }
    }
public void deleteAll(){

    head = null ;
    tail = null ;
}
}

