package Serializator;

import Homework_7.Designer_Human;

import java.io.*;

public class Serializator implements InterfaseSave {
    /**
     * Метод сохранения serializa
     *
     * @param Human
     * @return
     */

    @Override
    public boolean serializaSave(Designer_Human Human) {

        boolean flag = false;

        File file = new File("Human.bin");
        ObjectOutputStream oss = null;

        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos != null) {
                oss = new ObjectOutputStream(fos);
                oss.writeObject(Human);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally { //если не равен null то закрываем
            if (oss != null) ;
            try {
                oss.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return flag;
    }

    /**
     * Метод чтения
     *
     * @return
     * @throws InvalidObjectException
     */
    @Override
    public Designer_Human DesSerializa(Designer_Human humans) throws InvalidObjectException {
        File file = new File("Human.bin");
        ObjectInputStream ous = null;


        try {
            FileInputStream fis = new FileInputStream(file);
            if (fis != null) {
                ous = new ObjectInputStream(fis);
                Designer_Human human = (Designer_Human) ous.readObject();
                return human;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ous.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        throw new InvalidObjectException("Fail");

    }

//
//    @Override
//    public void serializa() {
//        Serializator serializator = new Serializator();
//        System.out.println(serializator.serializa()); //Проверка если true - значит записть прошла
//

    public void serializatorMetod(Designer_Human designer_human) throws InvalidObjectException {
        WorkingFile fileworker = new WorkingFile();
        fileworker.serializaSave(designer_human); //записываем
        fileworker.DesSerializa(designer_human);// читаем
    }
}

