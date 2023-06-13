package homeWork.tree2.middleware;

public class MessageForUsers {
    private String textMessage;
    public MessageForUsers(String textMessage){
        this.textMessage = textMessage;
    }

    public void setTextMessage(){
        System.out.println(this.textMessage);
    }
}
