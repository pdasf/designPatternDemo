package singleton;

public class Main {
    public static void main(String[] args) {
        Demo1.getInstance().print();
        Demo2.getInstance().print();
        Demo3.getInstance().print();
        Demo4.INSTANCE.print();
    }
}

class Demo1{
    private static Demo1 instance = new Demo1();

    public static Demo1 getInstance(){
        return instance;
    }

    public void print(){
        System.out.println("Singleton pattern");
    }
}

class Demo2{
    private static Demo2 instance;

    public static Demo2 getInstance(){
        if (instance == null){
            instance = new Demo2();
        }
        return instance;
    }

    public void print(){
        System.out.println("Singleton pattern with lazy loading");
    }
}

class Demo3{
    public static Demo3 getInstance(){
        return InnerDemo3.instance;
    }

    private static class InnerDemo3{
        static Demo3 instance = new Demo3();
    }
    public void print(){
        System.out.println("Singleton pattern using static inner class");
    }
}

enum Demo4{
    INSTANCE;
    public void print(){
        System.out.println("Singleton Pattern using enum");
    }
}

