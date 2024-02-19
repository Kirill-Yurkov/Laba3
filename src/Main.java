import emotions.EmotionType;
import locations.Home;
import locations.MedicineCenter;
import locations.Store;
import text_objects.*;
import weather.WeatherType;

public class Main {
    public static void main(String[] args) {
        Person louis = new Person("Louis");
        Person rachel = new Person("Rachel");
        Person gage = new Person("Gage");
        Store store = new Store("SuperMarket");
        Home home = new Home("Louis' Home");
        MedicineCenter medicineCenter = new MedicineCenter("City Medical Center");
        Parrot parrot = new Parrot("Kesha");
        WeatherType currentWeatherType = WeatherType.RAINY;
        SoftBear freddyBear = new SoftBear("FreddyBear", 3);

        home.addPeople(louis,rachel,gage);
        home.startCinema();
        louis.setCurrentEmotion(EmotionType.SURPRISE);
        parrot.memorizePhrase("Ариэль Шэрон свихнулся");
        parrot.say();
        rachel.openBirdCage(parrot);
        gage.chaseParrot(parrot);
        louis.haveConversation(rachel, "telling funny joke");
        louis.haveConversation(gage, "telling funny joke");
        louis.checkHealth();
        home.cookFood(FoodType.PASTA);
        louis.eat(FoodType.PASTA);
        louis.expressLoveFor(rachel);
        louis.expressLoveFor(gage);
        parrot.clearMemorize();
        home.exitLocation(louis);

        louis.setLocation(store);
        store.interactInside(louis);
        louis.setToy(store.buyToy(freddyBear));
        freddyBear.play();
        freddyBear.stop();
        louis.setCar(store.buyCar(new Car("Toyota")));
        louis.eat(store.buyFood(FoodType.CHIPS));
        store.exitLocation(louis);

        louis.getCar().start(CarSeat.DRIVER);
        louis.driveCar(CarSeat.DRIVER, currentWeatherType);
        louis.setCurrentEmotion(EmotionType.FEAR);
        louis.getCar().stop();

        louis.setLocation(medicineCenter);
        medicineCenter.buyMedicine(louis);
        medicineCenter.interactInside(louis);
        medicineCenter.exitLocation(louis);

        louis.setCurrentEmotion(EmotionType.SADNESS);
        currentWeatherType = WeatherType.SUNNY;
        louis.getCar().start(CarSeat.DRIVER);
        louis.driveCar(CarSeat.DRIVER, currentWeatherType);
        louis.playCarMusic();
        louis.getCar().stop();
        louis.stopCarMusic();
    }
}

