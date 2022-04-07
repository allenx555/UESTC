abstract class Shape{
    int n;
    Shape(int n){
        this.n= n;
    }
    abstract double getArea();
}

class Triangle extends Shape{
    double a, b, c;
    Triangle(double a,double b,double c){
        super(3);
        this.a = a;
        this.b = b;
        this.c = c;
    }
    double getArea() {
        return (1.0/4.0)*Math.sqrt((a+b+c)*(a+b-c)*(a+c-b)*(b+c-a));
    }
}

class Rectangle extends Shape{
    double a, b;
    Rectangle(double a, double b){
        super(4);
        this.a = a;
        this.b = b;
    }
    double getArea() {
        return a*b;
    }
}

class Pillar{
    int n;
    double a, b, c;
    double s, h;
    Pillar(double a, double b, double c, double h){
        this.n = 3;
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }
    Pillar(double a, double b, double h){
        this.n = 4;
        this.a = a;
        this.b = b;
        this.h = h;
    }
    double getVolume() {
        if(n==3) {
            Triangle pillar = new Triangle(a, b, c);
            s = pillar.getArea();
        }
        if(n==4) {
            Rectangle pillar = new Rectangle(a, b);
            s = pillar.getArea();
        }
        return s*h;
    }
}

public class Test {
    public static void main(String []args) {
        Pillar pillar = new Pillar(3,4,5);
        System.out.println("n is :"+String.valueOf(pillar.n));
        System.out.println("a is :"+String.valueOf(pillar.a));
        System.out.println("b is :"+String.valueOf(pillar.b));
        System.out.println("Height is :"+String.valueOf(pillar.h));
        System.out.println("Volume is :"+String.valueOf(pillar.getVolume()));
    }
}
