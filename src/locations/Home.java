package locations;

import emotions.EmotionType;
import text_objects.FoodType;
import text_objects.Person;

public class Home extends AbstractLocation {
    public Home(String name) {
        super(name);
    }

    @Override
    public void interactInside(Person person) {
        System.out.println(person.getName() + " is relaxing at " + getName() + ".");

        person.setCurrentEmotion(EmotionType.JOY);
    }

    public void cookFood(FoodType foodType) {
        if (foodType.getPreparationTime() != 0) {

            System.out.println("Cooking delicious " + foodType.getName() + " at " + getName() + ".");
            System.out.println("Preparing ingredients...");

            for (int i = 0; i < foodType.getPreparationTime(); i++) {
                System.out.println("Chopping vegetables... Step " + (i + 1));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {
                }
            }

            System.out.println("Boiling water...");

            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {}

            System.out.println("Cooking... Almost there!");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }

            System.out.println(foodType.getName() + " is ready to be served!");
        } else {
            System.out.println(foodType.getName() + " arent cooking delicious.");
        }
    }

    public void startCinema(Person... people){
        for(Person person: people){
            person.setMentalHealth(person.getMentalHealth()+10);
            person.setCurrentEmotion(EmotionType.JOY);
        }
    }
    public void startCinema(){
        for(Person person: getPeople()){
            person.setMentalHealth(person.getMentalHealth()+10);
            person.setCurrentEmotion(EmotionType.JOY);
        }
        System.out.println("Home cinema is started");
    }
}