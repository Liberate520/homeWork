import java.io.*;

public class FileHandler implements Writable {
    
    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(("FamTree.data")))) {                      
            oos.writeObject(serializable);
            System.out.printf("Сохранено\n", ("FamTree.data")); 
        } catch (Exception ex) {
            System.out.println("Ошибка");           
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    @Override
    public FamilyTree read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(("FamTree.data")))) {
            return (FamilyTree) ois.readObject();
        } catch (Exception ex) {
            System.out.println("Ошибка");
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    // @Override
    // public void save(Serializable serializable) throws FileNotFoundException {
    //     try (FileOutputStream outputStream = new FileOutputStream("FamTree.data")) {
    //         ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
    //         objectOutputStream.writeObject(serializable);

    //         try {
    //             objectOutputStream.writeObject(serializable);
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         }
    //         objectOutputStream.close();            
    //     } catch (IOException e) {            
    //         e.printStackTrace();
    //     }
    //     System.out.println("Сохранили");
    // }

    // @Override
    // public Object read() throws FileNotFoundException, IOException {
    //     ObjectInputStream objectInputStream = new ObjectInputStream(
    //             new FileInputStream("FamTree.data"));
    //             try {
    //                 Writable renatRestored = (Writable) objectInputStream.readObject();
    //             } catch (ClassNotFoundException e) {
    //                 // TODO Auto-generated catch block
    //                 e.printStackTrace();
    //             }
    //     objectInputStream.close();
    //     return null;
    // }

        public void test() {
    }
}