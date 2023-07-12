package decorator;

public class Main {
    public static void main(String[] args) {
        Shape shape = new RedDecorator(new Circle());
        shape.draw();
        Shape shape1 = new RedDecorator(new Square());
        shape1.draw();
    }
}

interface Shape{
    void draw();
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape: Square");
    }
}

abstract class Decorator implements Shape{
    protected Shape shape;
    public void draw(){
        decorator();
        this.shape.draw();
    }
    abstract void decorator();
}

class RedDecorator extends Decorator{
    public RedDecorator(Shape shape){
        this.shape = shape;
    }

    @Override
    void decorator() {
        System.out.println("color: Red");
    }
}