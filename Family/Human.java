package JavaOOP.Family;

public class Human {

     String fName;
     Gender gender;
     int DateofBirth;
    Human mother;
     Human father;
     Human partner;
     Human children;
    
    public Human(int  DateofBirth,  String fName, Gender gender) {
        this.fName = fName;
        this.gender = gender;
        //this.sName = sName;
        this.DateofBirth = DateofBirth;
        this.mother =null;
        this.father = null;
        this.partner = null;
        this.children = null;
    }

    public boolean addFather(Human human){
        if(human.gender.equals(Gender.MAN) &&  ((this.DateofBirth-human.DateofBirth >18)&& ( this.DateofBirth- human.DateofBirth)<40) && this.father == null){
            this.father = human;
            this.father.children= this;
            if(this.mother!=null){
                this.mother.partner = this.father;
                this.father.partner = this.mother;
            }
            System.out.println(human.fName + " это отец " + this.fName);
            System.out.println();
            return true;
        }
        else{
            System.out.println("Этот человек не может быть отцом " + this.fName);
            System.out.println();
            return  false;
        }
    }
    public boolean addMother(Human human){
        if(human.gender.equals(Gender.WOMAN) && ((this.DateofBirth-human.DateofBirth >18)&& ( this.DateofBirth- human.DateofBirth)<40)&& this.mother == null){
            this.mother = human;
            this.mother.children = this;
            if(this.father!=null){
                this.father.partner = this.mother;
                this.mother.partner = this.father;
            }
            System.out.println(human.fName + " это мать " + this.fName);
            System.out.println();
            return true;
        }
        else{
            System.out.println("Этот человек не может быть матерью "+this.fName);
            System.out.println();
            return false;
        }

    }
}

