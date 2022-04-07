class RectangleArea{
    double a,b;double s;
    RectangleArea(double a,double b){
        this.a = a;
        this.b = b;
        this.s = a*b;
    }
}

class TriangleArea{
    double a,b,c;double s;
    TriangleArea(double a,double b,double c){
        this.a = a;
        this.b = b;
        this.c = c;
        double p = (a+b+c)/2;
        this.s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}

public class Area {
    public static void main(String []args) {
        RectangleArea r1 = new RectangleArea(5,10);
        TriangleArea t1 = new TriangleArea(5,12,13);
        System.out.println(r1.s);
        System.out.println(t1.s);
    }
}
