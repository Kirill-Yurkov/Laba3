package Locations;

import Emotions.EmotionType;
import TextObjects.*;

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

    public Car buyCar(Car car) {
        if (person.getMoney() > car.getCost()) {
            System.out.println(person.getName() + " buy a new car!");
            person.getCar().setCarSeat(CarSeat.BACK);
            person.getCar().setCarSeat(CarSeat.FRONT);
            person.getCar().setCarSeat(CarSeat.DRIVER);
            person.setCurrentEmotion(EmotionType.JOY);
            person.setMoney(person.getMoney() - car.getCost());
            return car;
        } else {
            System.out.println(person.getName() + " dont have much money to buy the car.");
            person.setCurrentEmotion(EmotionType.SADNESS);
            return null;
        }
    }

    public FoodType buyFood(FoodType foodType, Person person) {
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
        return getPeople().length >= 3;
    }

    public Toy buyToy(Toy toy){
        int toyCost = toy.getCost();
        if(person.getMoney()>toyCost){
            person.setMentalHealth(person.getMentalHealth()+3);
            person.setCurrentEmotion(EmotionType.JOY);
        }else {
            person.setCurrentEmotion(EmotionType.SADNESS);
        }
        return toy;
    }
}