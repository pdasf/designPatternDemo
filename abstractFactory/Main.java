package abstractFactory;

public class Main {
    public static void main(String[] args) {
        abstractFactory redCircle = new RedCircle();
        Color color = redCircle.getColor();
        Shape shape = redCircle.getShape();
        color.fill();
        shape.draw();
    }
}

interface abstractFactory{
    Color getColor();
    Shape getShape();
}

class RedCircle implements abstractFactory{
    @Override
    public Color getColor() {
        return new Red();
    }

    @Override
    public Shape getShape() {
        return new Circle();
    }
}

class GreenSquare implements abstractFactory{
    @Override
    public Color getColor() {
        return new Green();
    }

    @Override
    public Shape getShape() {
        return new Square();
    }
}

interface Shape{
    void draw();
}

interface Color{
    void fill();
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("this is circle");
    }
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("this is square");
    }
}

class Red implements Color{
    @Override
    public void fill() {
        System.out.println("this is Red");
    }
}

class Green implements Color{
    @Override
    public void fill() {
        System.out.println("this is Green");
    }
}