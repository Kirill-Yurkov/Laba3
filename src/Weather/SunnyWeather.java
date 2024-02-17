package Weather;

import Emotions.EmotionType;
import TextObjects.Person;

public class SunnyWeather extends AbstractWeather {
    public SunnyWeather() {
        super("Sunny");
    }

    @Override
    public void interact(Person person) {
        System.out.println(person.getName() + " is enjoying the sunshine!");
        person.setCurrentEmotion(EmotionType.JOY);
    }
}