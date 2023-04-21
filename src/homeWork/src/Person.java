package homeWork.src;

public interface Person<T extends Person<T>> {
    String getName();
    int getAge();
    String getGender();
    void setParent(T parent);
    T getParent();
    T createNewInstance(String name, int age, String gender);
}
