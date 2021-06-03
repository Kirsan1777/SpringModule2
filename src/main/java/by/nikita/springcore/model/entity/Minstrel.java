package by.nikita.springcore.model.entity;

import org.springframework.stereotype.Component;

@Component
public class Minstrel {
    private String song;

    public Minstrel(){

    }

    public Minstrel(String song){
        this.song = song;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return "Minstrel{" +
                "song='" + song + '\'' +
                '}';
    }

    public void beforeQuest(){
        song = "Before quest";
        System.out.println(song);
    }

    public void afterQuest(){
        song = "After quest";
        System.out.println(song);
    }
}
