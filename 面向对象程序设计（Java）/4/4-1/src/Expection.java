public class Expection {
    public Expection() {
        try {
            try {
                try {
                    int a[] = new int[2];
                    a[1]= 1/0;
                    a[4]= 1;
                }catch(IndexOutOfBoundsException e) {
                    System.err.println("Exception msg:"+e.getMessage());
                    System.err.println("Exception string:"+e.toString());
                    e.printStackTrace();
                }
            }catch(ArithmeticException e) {
                System.err.println("Exception msg:"+e.getMessage());
                System.err.println("Exception string:"+e.toString());
                e.printStackTrace();
            }
        }catch(NullPointerException e) {
            System.err.println("Exception msg:"+e.getMessage());
            System.err.println("Exception string:"+e.toString());
            e.printStackTrace();
        }
    }
    public static void main(String []args) {
        new Expection();
    }
}
