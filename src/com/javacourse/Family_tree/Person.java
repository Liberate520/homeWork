package com.javacourse.Family_tree;
import java.util.*;



public class Person{
        private String lfm;
        private Person mom;
        private Person dad;
        private Integer age;
        public ArrayList<String> children;

        public void buildperson(String lfm, Integer age){
            this.lfm = lfm;
            this.age = age;
            this.children = new ArrayList<String>();
            this.reset();
        }
        public void setMom(Person mom){
            this.mom = mom;
        }
        public void setDad(Person dad){
            this.dad = dad;
        }
        public String getName(){
            return this.lfm;
        }
        public Person getDad(){
            return this.dad;
        }
        public Person getMom(){
            return this.mom;
        }
        public Integer getAge(){
            return this.age;
        }
        public ArrayList<String> getChildren(){
            return this.children;
        }
        private void reset(){
                if (this.dad == null) {
                    this.dad = new Person();
                }
                if (this.mom == null) {
                    this.mom = new Person();
                }
        }
        
    }