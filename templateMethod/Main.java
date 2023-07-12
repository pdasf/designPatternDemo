package templateMethod;

public class Main {
    public static void main(String[] args) {
        Program p = new WeChat();
        p.play();
    }
}

abstract class Program {
    abstract void initialize();
    abstract void start();
    abstract void process();
    abstract void end();

    public final void play(){
        initialize();
        start();
        process();
        end();
    }
}

class WeChat extends Program {
    @Override
    void initialize() {
        System.out.println("initialize");
    }

    @Override
    void start() {
        System.out.println("start");
    }

    @Override
    void process() {
        System.out.println("process");
    }

    @Override
    void end() {
        System.out.println("end");
    }
}
