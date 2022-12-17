public class Main {
    public static void main(String[] args){
        Collection teachersCollection = new Collection();
        teachersCollection.addTeacher("Актыбаев", "Константин", "ООП: java");
        teachersCollection.addTeacher("Камянецкий", "Сергей", "java");
        teachersCollection.addTeacher("Гуляев", "Павел", "С#");
        teachersCollection.addTeacher("Акопян", "Сергей", "БД");


        for (Teachers teacher:teachersCollection){
            System.out.println(teacher);
        }
    }
}
