

//  java enum to string

public enum Gender{
    Man    // ("мужской")
    , Femail    // ("женский")
    ;  // мужской, женский  String CONNST
    
    @Override
    public String toString() {
        if (this == Man) { return "мужской";}
        else { return "женский";}
    }
}