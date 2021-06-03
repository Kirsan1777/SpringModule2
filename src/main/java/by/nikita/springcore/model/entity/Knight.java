package by.nikita.springcore.model.entity;

import org.springframework.stereotype.Component;

@Component
public class Knight {

    private String phrase;

    public Knight(){
    }

    public Knight(String phrase){
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public void acceptQuest(){
        System.out.println(phrase);
    }

    @Override
    public String toString() {
        return "Knight{" +
                "phrase='" + phrase + '\'' +
                '}';
    }
}
