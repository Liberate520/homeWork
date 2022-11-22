import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PhoneBook {
 public static void main(String[] args) {
 
  String fname,lname;
  Scanner input=new Scanner(System.in);
  PhoneBook ph=new PhoneBook();
  int acode,number,ch=0;

  do{
   System.out.println("Select a choice\n1:Add a new phonebook entry\n2:Find number\n3:Find name for a number\n4:Display phonebook\n5:Exit\n");
   try{
    ch=input.nextInt();
   }catch (Exception e) {
    System.out.println("Sorry you entered string .....program is terminated...");
    break;
   }
   switch(ch){
   case 1 :
    System.out.println("Enter the first name: ");
    fname=input.next();
    System.out.println("Enter the last name: ");
    lname=input.next();
    System.out.println("Enter the areacode: ");
    acode=input.nextInt();
    System.out.println("Enter phone number: ");
    number=input.nextInt();
    
    if(ph.doEntry(fname, lname, acode, number)==true)
      System.out.println("Record successfully saved.\n");
    else 
     System.out.println("Phone number repeated.\n");
    break;
    
   case 2:
    System.out.println("Enter the name");
    fname=input.next();
    boolean bb=true;
    int a[]=ph.findNumber(fname);
    for(int i : a){
     if(i!=0){
      System.out.println("Firstname :"+fname+"\nNumber: "+i+"\n");
      bb=false;
     }
    }
    
    if(bb)
     System.out.println("No record found...");
    break;
    
   case 3:
    System.out.println("Enter the number for name : ");
    number=input.nextInt();
    String ss=ph.findName(number);
    if(ss.length()==0){
     System.out.println("No record found"+"\n");
    }
    else
    System.out.println("Name is : "+ph.findName(number)+"\n");
    break;
    
   case 4:
    ph.display();
    break;
    
   case 5 :
    break;
    
   default:
    System.out.println("Invalid input!!");
   }
  }while(ch!=9);
  
 }
}

class Person{
 String fname;
 String lname;
 Person(String fname,String lname){
  this.fname=fname;
  this.lname=lname;
 }
}

class PhoneNumber{
 int acode,number;
 public PhoneNumber(int acode,int number) {
  this.acode=acode;
  this.number=number;
 }
}

class BookEntry{
 Person p;
 PhoneNumber pn;
 BookEntry(Person p,PhoneNumber pn){
  this.p=p;
  this.pn=pn;
 }
}

class PhoneBook{
 HashMap map=new HashMap();
 Map.Entry map1;
 Collection c;
 Iterator it,it1;
 Person p;
 Set s;
 BookEntry b,b1;
 boolean check;
 PhoneNumber pn;
 
 public boolean doEntry(String fname,String lname,int acode,int number){
  p=new Person(fname, lname);
  pn=new PhoneNumber(acode, number);
  b=new BookEntry(p, pn);
  check=true;
  s=map.entrySet();
  it=s.iterator();
  
  while (it.hasNext() ) { 
   map1=(Map.Entry)it.next();
   b1=(BookEntry)map1.getValue();
   if(b1.pn.number==number){
    check=false;
    break;
   }
  }
  
  if(check){
   map.put(p,b);
  }
  return check;
 }
 
 public void display(){
  s=map.entrySet();
  it=s.iterator();
  System.out.println("\n");
  System.out.printf("%-15s%-15s%-15s%-15s\n","First name","Last name", "Areacode","Phone number");
  
  while(it.hasNext()){
   map1=(Map.Entry)it.next();
   b=(BookEntry)map1.getValue();
   System.out.printf("%-15s%-15s%-15s%-15s",b.p.fname,b.p.lname,b.pn.acode,b.pn.number);
   System.out.println();
  }
  System.out.println("\n");
 }
 
 public int[] findNumber(String fname) {
  int a[]=new int[map.size()];
  int i=0;
  s=map.entrySet();
  it=s.iterator();
  
  while ( it.hasNext() ) {
   map1=(Map.Entry)it.next();
   b=(BookEntry)map1.getValue();
   if(b.p.fname.equals(fname)){
    a[i]=b.pn.number;
    i++;
   }
  }
  return a;
 }
 
 public String findName(int number){
  String st="";
  s=map.entrySet();
  it=s.iterator();
  
  while ( it.hasNext() ) {
   map1=(Map.Entry)it.next();
   b=(BookEntry)map1.getValue();
   if(b.pn.number==number){
    st=b.p.fname;
   }
  }
  return st;
 }
 
 public void sort(){
  s=map.entrySet();
  LinkedList lt=(LinkedList)s;
  Collections.sort(lt);
 }
}