package Weather;

import Emotions.EmotionType;
import TextObjects.Person;

public class SnowyWeather extends AbstractWeather {
    public SnowyWeather() {
        super("Snowy");
    }

    @Override
    public void interact(Person person) {
        System.out.println(person.getName() + " is building a snowman!");
        person.setCurrentEmotion(EmotionType.JOY);
    }
}