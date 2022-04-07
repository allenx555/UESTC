public class Fibonacci {
    public static int fib(int num) {
        if(num == 1 | num == 2) {
            return 1;
        }
        else {
            return fib(num-1) + fib(num-2);
        }
    }

    public static void main(String []args) {
        for(int i=2;i<20;i++) {
            System.out.print(fib(i));
            System.out.print('\t');
            if(i==10) System.out.println();
        }
    }
}
