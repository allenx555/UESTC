class Point{
        int x,y;
        Point(){
        this.x = 0;
        this.y = 0;
        }
        void setX(int a) {
        x = a;
        }
        void setY(int b) {
        y = b;
        }
        int[] getPoint() {
        int[] p = new int[2];
        p[0] = x;p[1] = y;
        return p;
        }
        void movePoint(int a,int b) {
        x = a;y = b;
        }
        }

public class TestPoint {
    public static void main(String []args) {
        Point p = new Point();
        p.setX(0);p.setY(0);
        p.movePoint(100,100);
        int[] temp = p.getPoint();
        System.out.println("("+temp[0]+","+temp[1]+")");
    }
}
