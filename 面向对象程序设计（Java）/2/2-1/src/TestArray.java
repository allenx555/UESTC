import java.util.*;

public class TestArray {
    public static void main(String []args) {
        int[] sim = new int[10];
        Random rand = new Random();
        for(int i=0;i<10;i++)
            sim[i] = rand.nextInt(100);
        for(int i=0;i<10;i++) {
            for(int j=i;j<10;j++) {
                if(sim[i]>sim[j]) {
                    int temp = sim[i];
                    sim[i] = sim[j];
                    sim[j] = temp;
                }
            }
        }
        for(int i=0;i<10;i++)
            System.out.print(sim[i]+"\t");
    }
}
