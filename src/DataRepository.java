import java.io.*;

public class DataRepository implements Serialisable{

    public boolean dataOutput(FamilyTree familyTree, Person person) {

        File file = new File("D:\\GB\\JavaOOPFamilyTree\\homeWork_From_Salnikov_Vladislav\\src\\Family.txt");
        boolean flag = false;
        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos!=null){
                oos = new ObjectOutputStream(fos);
                oos.writeObject(familyTree);
                flag = true;
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
//    public FamilyTree deserialization(){
//        File file = new File("D:\\GB\\JavaOOPFamilyTree\\homeWork_From_Salnikov_Vladislav\\src\\Family.xml");
//        ObjectInputStream ois = null;
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            if(fis!= null){
//                ois = new ObjectInputStream(fis);
//                FamilyTree familyTree = (FamilyTree) ois.readObject();
//                return familyTree;
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        return new FamilyTree();
//    }
//    public boolean dataOutput(Person person){
//        File file = new File("D:\\GB\\JavaOOPFamilyTree\\homeWork_From_Salnikov_Vladislav\\src\\Person.txt");
//        boolean flag = false;
//        ObjectOutputStream oos = null;
//
//        try {
//            FileOutputStream fos = new FileOutputStream(file);
//            if (fos!=null){
//                oos = new ObjectOutputStream(fos);
//                oos.writeObject(person);
//                flag = true;
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            if (oos != null){
//                try {
//                    oos.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//        return flag;
//
//    }
//
//    public FamilyTree dataInput() throws InvalidObjectException {
//        File file = new File("D:\\GB\\JavaOOPFamilyTree\\homeWork_From_Salnikov_Vladislav\\src\\Family.txt");
//        ObjectInputStream ois = null;
//
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            if (fis != null) {
//                ois = new ObjectInputStream(fis);
//                FamilyTree familyTree = (FamilyTree) ois.readObject();
//                return familyTree;
//            }
//        }catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                ois.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        throw new InvalidObjectException("Object fail");
//    }
//    public Person dataInput(Person person) throws InvalidObjectException {
//        File file = new File("D:\\GB\\JavaOOPFamilyTree\\homeWork_From_Salnikov_Vladislav\\src\\Person.txt");
//        ObjectInputStream ois = null;
//
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            if (fis != null) {
//                ois = new ObjectInputStream(fis);
//                Person person = (Person) ois.readObject();
//                return person;
//            }
//        }catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                ois.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        throw new InvalidObjectException("Object fail");
//    }
}
