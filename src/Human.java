import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Human  implements Serializable{
    private String name;
    private String patronymic;
    private String dateBirth;
    private String dateDeath;
    private Gender gender;
    private Human father;
    private Human mather;
    private List<Human> children;
  
    
    
    public Human (String name,String patronymic, String dateBirth,Gender gender){
        this(name, patronymic, dateBirth, null,gender, null, null,null);
    }

    public Human (String name,String patronymic,String dateBirth,String dateDeath,Gender gender,Human father,Human mather,Human human){
        this.name=name;
        this.patronymic= patronymic;
        this.dateBirth=dateBirth;
        this.dateDeath=dateDeath;
        this.gender=gender;
        this.father= father;
        this.mather=mather;
        children= new ArrayList<>();
        }

        public boolean addChild (Human child){
     
            if (!children.contains(child)){
                children.add(child);
                return true;
            }
            return false;
        
            
        }

        private String getMatherInfo(){
            String res = "Мать: ";
            if (mather !=null){
                res += mather.getName()+" "+ mather.getPatronymic();
                }
            else {
                res +="неизвестна";
            }
            return res;
        }
        private String getFatherInfo(){
            String res = "Отец: ";
            if (father!=null){
                res += father.getName() + " "+ father.getPatronymic();
                }
            else {
                res +="неизвестен";
            }
            return res;
        }


        private String getChildrenInFo(){
            StringBuilder res = new StringBuilder();
            res.append("дети: ");
            if (children.size() !=0){
                res.append((children.get(0).getName()));
                for(int i =1; i<children.size(); i++){
                    res.append(", ");
                    res.append(children.get(i).getName());
                }
            } else
        {
            res.append("отсутствует");
        }
        return res.toString();
        }
        private String dateLife(){
            String res = ", Даты жизни: " + dateBirth +" - " + dateDeath;
               
           if (dateBirth == null && dateDeath ==null){
           res = ", Даты жизни: ... - ..."  ;
               }
               else if (dateBirth != null && dateDeath ==null){
                   res = ", Даты жизни: "+ getDateBirth() + " - ..." ;
               }
               else if (dateBirth == null && dateDeath !=null){
                   res = ", Даты жизни: ... - " +  dateDeath;
               }
               return res;
       
           }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getDateDeath() {
        return dateDeath;
    }

    public void setDateDeath(String dateDeath) {
        this.dateDeath = dateDeath;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMather() {
        return mather;
    }

    public void setMather(Human mather) {
        this.mather = mather;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }
  
    @Override
    public String toString(){
        return "\n"+"Имя: " + name +" "+ patronymic + dateLife()+ ", пол " +gender + "., "+ getFatherInfo() + ",  "+ getMatherInfo() + ", "+ getChildrenInFo();
    }
    public void saveObj(IO save)
    {
        save = new IO();
        save.save("FreeFamily.data", this);
    }

}