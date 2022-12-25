package homeWork.src;

import java.io.*;

// Сериализация (Serialization) — это процесс, который переводит объект в последовательность байтов, по которой затем его можно полностью восстановить.
// Сериализация позволяет расширить эти рамки и «дать жизнь» объекту между запусками программы.
// Необходимо, чтобы класс реализовывал интерфейс Serializable.
// Это интерфейс — идентификатор, который не имеет методов, но он указывает jvm, что объекты этого класса могут быть сериализованы.
// Так как механизм сериализации связан с базовой системой ввода/вывода и переводит объект в поток байтов,
// для его выполнения необходимо создать выходной поток OutputStream, упаковать его в ObjectOutputStream и вызвать метод writeObject().
// Для восстановления объекта нужно упаковать InputStream в ObjectInputStream и вызвать метод readObject().
// В процессе сериализации вместе с сериализуемым объектом сохраняется его граф объектов.
// Т.е. все связанные с этим объектом, объекты других классов так же будут сериализованы вместе с ним.
// В них необходимо также имплементировать Serializable

public class FileHandler implements Writable, Serializable {

    private String filename;

    //    в будущем в клиентском коде можно определять другой файл
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileHandler() {
//        имя файла по умолчанию. определяем в пустом конструкторе
        this.filename = "familytree.dat";
    }

    /**
     * запись в файл
     *
     * @param serializable сериализуемый объект
     */
    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            System.out.printf("FamilyTree save in %s\n", filename);
            oos.writeObject(serializable);
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так");
            System.out.println(ex.getMessage());
        }
    }

    /**
     * чтение из файла
     *
     * @return FamilyTree
     */
    @Override
    public Object read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
//            System.out.printf("Файл %s прочитан\n", filename);
//            FamilyTree familyTree = (FamilyTree)ois.readObject();
//            System.out.println(familyTree);
            return ois.readObject();
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так");
            System.out.println(ex.getMessage());
        }
        return null;
    }


}
