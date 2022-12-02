package analizator;

public interface Analizer {
    String stats = "";

    default String sendStats(){
        return this.getStats();
    };

    String getStats();
}
