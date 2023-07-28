package ZOO;

public class Call {
    CatOwner catOwner;
    Cat cat;

    public Call(CatOwner catOwner, Cat cat){
        this.catOwner = catOwner;
        this.cat = cat;
    }

    public void call(){
        if (catOwner.getStatus() == "owner"){
            catOwner.CatCall(catOwner.getName());
            cat.CatSays(cat.getName());
        }else{
            catOwner.CatCall(cat.getName());
            cat.CatNotHearing(cat.getName());
        }
    }
}
