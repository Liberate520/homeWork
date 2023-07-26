class Person{
    private String name;
    private Gender gender;
    private String age;
    
    public Person(String name, Gender gender, String age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return "Имя: " + name;
    }
    
    public Gender getGender() {
        return gender;
    }
    
    public String getAge() {
        return "Возраст: " + age;
    }
    // Переопределение метода toString()
    @Override
    public String toString() {
        return name + " " + gender + " " + age;
    }
}


