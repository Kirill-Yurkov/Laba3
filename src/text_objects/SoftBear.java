package text_objects;

import java.util.Objects;

public class SoftBear extends Toy {
    private String name;
    private int cost;
    private boolean inMotion;
    private String costume;
    public SoftBear(String name, int cost) {
        super(name, cost);
        inMotion = false;
        costume = "T-Shirt";
    }
    public SoftBear(String name, int cost, String costume){
        super(name,cost);
        this.costume = costume;
        inMotion = false;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCostume() {
        return costume;
    }

    public void setCostume(String costume) {
        this.costume = costume;
    }

    @Override
    public void memorizePhrase(String phrase) {
        startDance();
        super.memorizePhrase(phrase);
        stopDance();
    }

    @Override
    public void clearMemorize() {
        startClap();
        super.clearMemorize();
        stopClap();
    }
    private void startDance(){
        if(!inMotion){
            System.out.println(name + " is starting dancing.");
            inMotion = true;
        }else {
            System.out.println(name + " is busy.");
        }
    }
    private void stopDance(){
        if(inMotion){
            System.out.println(name + " stop dancing.");
            inMotion = false;
        }
    }
    private void startClap() {
        if(!inMotion){
            System.out.println(name + " is starting clapping.");
            inMotion = true;
        }else {
            System.out.println(name + " is busy.");
        }
    }
    private void stopClap(){
        if(inMotion){
            System.out.println(name + " stop clapping.");
            inMotion = false;
        }
    }

    @Override
    public void play() {
        super.play();
        if (Math.random() > 0.5) {
            startDance();
        } else {
            startClap();
        }
    }
    public void stop(){
        stopClap();
        stopDance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoftBear softBear = (SoftBear) o;
        return cost == softBear.cost && inMotion == softBear.inMotion && Objects.equals(name, softBear.name) && Objects.equals(costume, softBear.costume);
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = total * 31 + name.hashCode();
        total = total * 31 + cost;
        total = inMotion ? total * 31 + 1 : total * 31;
        total = total * 31 + costume.hashCode();
        return total;
    }

    @Override
    public String toString() {
        return "SoftBear{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", inMotion=" + inMotion +
                ", costume='" + costume + '\'' +
                '}';
    }
}
