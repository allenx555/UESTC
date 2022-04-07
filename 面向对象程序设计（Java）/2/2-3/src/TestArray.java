import java.util.*;

class ArraySort{
    int[] sim;
    int size;
    ArraySort(int size) {
        this.size = size;
        sim = new int[size];
        Random rand = new Random();
        for(int i=0;i<size;i++) sim[i] = rand.nextInt(100);
    }
    void setOrder() {
        for(int i=0;i<size;i++) {
            for(int j=i;j<10;j++) {
                if(sim[i]>sim[j]) {
                    int temp = sim[i];
                    sim[i] = sim[j];
                    sim[j] = temp;
                }
            }
        }
    }
}

public class TestArray{
    public static void main(String []args) {
        int size = 10;
        ArraySort test = new ArraySort(size);
        test.setOrder();
        for(int i=0;i<size;i++)
            System.out.print(test.sim[i]+"\t");
    }
}
