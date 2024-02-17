package TextObjects;

import Interfaces.Musicable;
import Weather.WeatherType;

import java.util.Objects;

public class Car implements Musicable {
    private String model;
    private boolean isRunning;
    private boolean isMusicPlaying;
    private int cost = 1000;

    private CarSeat carSeat;

    public CarSeat getCarSeat() {
        return carSeat;
    }
    public Car(){
        this.isRunning = false;
        this.isMusicPlaying = false;
    }
    public Car(String model) {
        this();
        this.model = model;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setCarSeat(CarSeat carSeat) {
        this.carSeat = carSeat;
    }

    public void start(CarSeat carSeat) {
        if (carSeat == CarSeat.DRIVER) {
            if (!isRunning) {
                System.out.println(model + " starts running.");
                isRunning = true;
            } else {
                System.out.println(model + " is already running.");
            }
        } else {
            System.out.println("You must seat on driver seat");
        }
    }

    public void stop() {
        if (carSeat == CarSeat.DRIVER) {
            if (isRunning) {
                System.out.println(model + " stops running.");
                isRunning = false;
            } else {
                System.out.println(model + " is already stopped.");
            }
        } else {
            System.out.println("You must seat on driver seat");
        }

    }

    public boolean startEngine() {
        for (int i = 0; i < 3; i++){
            if(Math.random()>0.5){
                return true;
            }
        }
        return false;
    }
    public boolean startEngine(WeatherType weatherType) {
        for (int i = 0; i < 3; i++){
            if(weatherType == WeatherType.SNOWY && Math.random()>0.7){
                return true;
            }
        }
        return false;
    }

    @Override
    public void playMusic() {
        if (isRunning) {
            if (!isMusicPlaying) {
                System.out.println(model + " is playing music.");
                isMusicPlaying = true;
            } else {
                System.out.println(model + " is already playing music.");
            }
        } else {
            System.out.println(model + " can't play music. The car is not running.");
        }
    }

    @Override
    public void stopMusic() {
        if (isMusicPlaying) {
            System.out.println(model + " stops playing music.");
            isMusicPlaying = false;
        } else {
            System.out.println(model + " is not playing music.");
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = 31 * model.hashCode();
        return total;
    }
}