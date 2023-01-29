package homeWorkSem1.Service;

public enum Gender {
    Male("Male"), Female("Female");

    private String string;
    private Gender (String string) {
        this.string = string;
    }

    public String getGender1() {
        return string;
    }

    // public String getUrl() {
    //     return url;
    // }

    // Gender g;
    // public Gender getGender(String choice) { 
    //     for (Gender gend : Gender.values()) {
    //         if (gend.valueOf(choice)) {
    //             return gend;
    //         }    
    //     }
             
    // }
}
