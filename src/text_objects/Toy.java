package text_objects;

import interfaces.Memorizible;
import interfaces.Playable;
import interfaces.Talkingable;

import java.util.ArrayList;
import java.util.Random;

public class Toy implements Memorizible, Talkingable, Playable {
    private String name;
    private ArrayList<String> memorizedPhrases = new ArrayList<>();
    private int cost;


    public Toy(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public void memorizePhrase(String phrase) {
        memorizedPhrases.add(phrase);
    }

    @Override
    public void clearMemorize() {
        memorizedPhrases.clear();
    }

    @Override
    public void say(String phrase) {
        if (!memorizedPhrases.contains(phrase)) {
            memorizePhrase(phrase);
        }
        System.out.println(name + " is saying: " + phrase);
    }

    private void choicePhrase() {
        if (memorizedPhrases != null && !memorizedPhrases.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(memorizedPhrases.size());
            say(memorizedPhrases.get(randomIndex));
        } else {
            System.out.println(name + " doesn't have any memorized phrases.");
        }
    }
    public void say() {
        choicePhrase();
    }

    @Override
    public void play() {
        say();
    }
}