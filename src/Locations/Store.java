package Locations;

import Emotions.EmotionType;
import TextObjects.Car;
import TextObjects.CarSeat;
import TextObjects.FoodType;
import TextObjects.Person;

public class Store extends AbstractLocation {
    public Store(String name) {
        super(name);
    }

    private Person person;

    @Override
    public void interactInside(Person person) {
        enterLocation(person);
        this.person = person;
        System.out.println(person.getName() + " is shopping at " + getName() + ".");
        person.setCurrentEmotion(EmotionType.JOY);
    }

    public void buyCar(Car car, Person person) {
        if (person.getMoney() > car.getCost()) {
            System.out.println(person.getName() + " buy a new car!");
            person.setCar(car);
            person.getCar().setCarSeat(CarSeat.BACK);
            person.getCar().setCarSeat(CarSeat.FRONT);
            person.getCar().setCarSeat(CarSeat.DRIVER);
            person.setCurrentEmotion(EmotionType.JOY);
            person.setMoney(person.getMoney() - car.getCost());
        } else {
            System.out.println(person.getName() + " dont have much money to buy the car.");
            person.setCurrentEmotion(EmotionType.SADNESS);
        }
    }

    public FoodType buyFastFood(FoodType foodType, Person person) {
        int foodCost = foodType.getCost();
        if (discountOnFood()) {
            foodCost = (int) (foodCost * 0.9);
        }
        if (foodType.getPreparationTime() == 0) {
            if (person.getMoney() > foodCost) {
                System.out.println(person.getName() + "buy fastfood in vending machine.");
                person.setCurrentEmotion(EmotionType.JOY);
                person.setMoney(person.getMoney() - foodCost);
                return foodType;
            } else {
                return null;
            }
        }
        return null;
    }

    private boolean discountOnFood() {
        if (getPeople().length >= 3) {
            return true;
        } else {
            return false;
        }
    }

    public void buyToy(Person person){
        int toyCost = (int) (Math.random()*2)+1;
        if(person.getMoney()>toyCost){
            person.setMentalHealth(person.getMentalHealth()+3);
            person.setCurrentEmotion(EmotionType.JOY);
        }else {
            person.setCurrentEmotion(EmotionType.SADNESS);
        }
    }
}