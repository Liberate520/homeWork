
public enum Gender {
    m ("М"),
    f ("Ж"); 

    private String gendName;

    Gender (String gendName){
        this.gendName = gendName;
    }
    public String getGendName() {
        return gendName;
    }

    @Override
    public String toString(){
        return gendName;
    }
}
