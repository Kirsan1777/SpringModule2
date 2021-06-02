package by.nikita.springcore.model.entity;

public class Knight {

    private String phraseYes;

    public Knight(){
    }

    public Knight(String phrase){
        this.phraseYes = phrase;
    }

    public String getPhraseYes() {
        return phraseYes;
    }

    public void setPhraseYes(String phraseYes) {
        this.phraseYes = phraseYes;
    }

    public void acceptQuest(){
        System.out.println(phraseYes);
    }

    @Override
    public String toString() {
        return "Knight{" +
                "phrase='" + phraseYes + '\'' +
                '}';
    }
}
