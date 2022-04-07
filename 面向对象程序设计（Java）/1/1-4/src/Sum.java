import java.util.Scanner;

public class Sum {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please input your number:");
        int number = sc.nextInt();
        int lenTemp = number;
        int sum = 0;
        int len = 0;
        while(lenTemp>0) {
            lenTemp /= 10;
            len++;
        }
        for(int i=len-1;i>=0;i--) {
            int temp = (int) (number/Math.pow(10,i));
            number -= temp*Math.pow(10,i);
            sum += temp;
        }
        System.out.println(sum);
    }
}
