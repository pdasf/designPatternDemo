package factory;

public class Main {
    public static void main(String[] args) {
        Car car1 = SimpleFactory.create("byd");
        if (car1 != null){
            car1.run();
        }

        FactoryMethod carFactory = new BmwFactory();
        Car car2 = carFactory.create();
        car2.run();
    }
}

interface FactoryMethod{
    Car create();
}

class BydFactory implements FactoryMethod{
    @Override
    public Car create() {
        return new Byd();
    }
}

class BmwFactory implements FactoryMethod{
    @Override
    public Car create() {
        return new Bmw();
    }
}


class SimpleFactory {
    static Car create(String name){
        return switch (name.toLowerCase()){
            case "bwm" -> new Bmw();
            case "byd" -> new Byd();
            default -> null;
        };
    }
}

interface Car {
    void run();
}

class Bmw implements Car {
    @Override
    public void run() {
        System.out.println("this is bmw");
    }
}

class Byd implements Car {
    @Override
    public void run() {
        System.out.println("this is byd");
    }
}