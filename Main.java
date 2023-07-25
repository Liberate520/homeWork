/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.


https://gb.ru/lessons/344116
*******************************************************************************/
import   java.time.LocalDate;   
// import static org.junit.Assert.*;  // https://junit.org/junit4/javadoc/latest/org/junit/Assert.html

import java.io.*; // Serializable

public class Main
{
    public static Human h1, h2, h3, h4;
    public static Human h1_, h2_, h3_, h4_;
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("Hello World\n OOP_FamilyTree.java Main() \n");
		
		
        // 		testCalculateAge_Success();  // test age
        // do some Humens
        
        h1 = new Human("IvanoV II", Gender.Man, LocalDate.of(1961, 5, 17)); 
        // Human(String aName, Gender aGender, LocalDate aBirthDay)
        h2 = new Human("PetroVa PP", Gender.Femail, LocalDate.of(1969, 3, 8));  
        h3 = new Human("SidoV SS", Gender.Man, LocalDate.of(1989, 3, 8));  
        h4 = new Human("SidoV SS_2", Gender.Man, LocalDate.of(1989, 3, 8));  
        
        h2.setParent(h1);
        
        System.out.println(" (IvanoV II, Gender.Man, LocalDate.of(1961, 5, 17)) " + h1);
        
        System.out.println(" (PetroVa PP, Gender.Femail, LocalDate.of(1969, 3, 8))) " + h2);

        System.out.println(" h2.getParentDad() : " + h2.getParentDad());
		System.out.println(" h2.getParentMom() : " + h2.getParentMom());
		
		System.out.println(" h2.addChild(h3): " + h2.addChild(h3));
		System.out.println(" h2.addChild(h4): " + h2.addChild(h4));
		// child unique ??
		System.out.println("+ h2.addChild(h3): " + h2.addChild(h3));
		System.out.println("+ h2.addChild(h4): " + h2.addChild(h4));
		
// 		h4 = new Human("SidoV SS_2", Gender.Man, LocalDate.of(1989, 3, 8));  
		
		
		System.out.println("++! h2.addChild(h4): " + h2.addChild(h4));
        // 		System.out.println("\n\n1..  " + "SidoV SS_2".equals("SidoV SS_2"));
        // 		System.out.println("2..  " +  LocalDate.of(1989, 3, 8).toString().equals
        // 		                        (LocalDate.of(1989, 3, 8).toString()));
        // 		System.out.println("3..  " + (Gender.Man == Gender.Man));
        
        
        System.out.println("++! h4.getGrandParents(): " + h4.getGrandParentsStr());
        
        System.out.println("++! h4.getParentDad(): " + h4.getParentDad());
        System.out.println("++! h4.getParentMom(): " + h4.getParentMom());
        
        System.out.println("++! h4.getBrotherSisterStr(): " + h4.getBrotherSisterStr());
		
    	System.out.println(h1.getChilds());
		System.out.println(h2.getChilds());
		
		System.out.println("h1 + h2 + h3 + h4 :\n");
		System.out.println(h1 + "\n" + h2 + "\n" + h3 + "\n" + h4);
		
		String fHumanLog = "Human.log";
		String fHumanTreeLog = "HumanTree.log";
		
		saveToFile(fHumanLog);
		loadFromFile(fHumanLog);
		
		System.out.println("h1_ + h2_ + h3_ + h4_ :\n");
		System.out.println(h1_ + "\n" + h2_ + "\n" + h3_ + "\n" + h4_);
		
		System.out.println(h2_.getChilds());
		
		// test "HumanTree.log";
		
		HumanTree newHumanTree = new HumanTree();
		// add humans
		newHumanTree.addHuman(h1);
		newHumanTree.addHuman(h2);
		newHumanTree.addHuman(h3);
		newHumanTree.addHuman(h4);
		// print newHumanTree
		System.out.println("newHumanTree h1 + h2 + h3 + h4 :\n");
		System.out.println(newHumanTree);
		
		// add newHumanTree.addHuman(h4);
		newHumanTree.addHuman(h4);
		System.out.println("newHumanTree h1 + h2 + h3 + h4 + h4 !!! :\n");
		System.out.println(newHumanTree);
		
		// add newHumanTree.addHumanTree(); addHumanTree
		newHumanTree.addHumanTree(newHumanTree.getHumans());
		System.out.println("addHumanTree newHumanTree  !!! :\n");
		System.out.println(newHumanTree);
		
		// save  newHumanTree.saveToFile fHumanTreeLog
		newHumanTree.saveToFile(fHumanTreeLog);
		//   
		System.out.println("add load FromFile HumanTree  !!! 2 :\n");
		newHumanTree.addFromFile(fHumanTreeLog);
		newHumanTree.addFromFile(fHumanTreeLog);
		System.out.println(newHumanTree);
	}
	
	public static void testCalculateAge_Success()     {
        // setup
        LocalDate birthDate = LocalDate.of(1961, 5, 17);
        // exercise
        int actual = AgeCalculator.calculateAge(birthDate, LocalDate.of(2016, 7, 12));
        // assert
        // Assert.assertEquals(55, actual);
        
        System.out.println("AgeCalculator : (2016, 7, 12) - (1961, 5, 17) : " );
        System.out.println(actual + " == 55  !!!" );
    }
    
    public static void saveToFile(String aFileName) throws IOException, ClassNotFoundException  {
        
         //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(aFileName));

        objectOutputStream.writeObject(h1);                
        objectOutputStream.writeObject(h2); 
        objectOutputStream.writeObject(h3); 
        objectOutputStream.writeObject(h4); 
        objectOutputStream.close();
    }
    
    public static void loadFromFile(String aFileName) throws IOException, ClassNotFoundException {
        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(aFileName));
        h1_ = (Human)  objectInputStream.readObject();
        h2_ = (Human)  objectInputStream.readObject();        
        h3_ = (Human)  objectInputStream.readObject();
        h4_ = (Human)  objectInputStream.readObject();

        objectInputStream.close();
        
        System.out.println(" !!! loadFromFile getChilds !!! ");
        System.out.println(h1_.getChilds());
		System.out.println(h2_.getChilds());
    }
    
}
