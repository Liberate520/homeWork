package homeWork.tree2.views;

public class MessageForUsers {
    private String textMessage;
    public MessageForUsers(String textMessage){
        this.textMessage = textMessage;
    }

    public MessageForUsers(){
        this(null);
    }

    public void setTextMessage(){
        System.out.println(this.textMessage);
    }
    public void setTextErrorMessage(){
        System.out.println("Произошла непредвиденная ошибка");
    }
}
