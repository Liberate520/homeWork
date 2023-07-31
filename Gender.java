// https://gb.ru/lessons/344116

//  https://yandex.ru/search/?clid=9582&text=java+enum+to+string&l10n=en-US&lr=213
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