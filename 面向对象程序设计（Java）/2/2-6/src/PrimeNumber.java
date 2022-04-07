public class PrimeNumber {
    static void normal(int N){
        int n=2;
        int[] r = new int[N+1];
        for(int i=1;i<=N;i++)
            r[i]=1;
        while(n <= (int)Math.sqrt(N)){
            for(int i=n+1;i<=N;i++){
                if(r[i]==1&&i%n==0)
                    r[i]=0;
            }
            for(int i=n+1;i<=N;i++){
                if(r[i]==1){
                    n=i;
                    break;
                }
            }
        }
        for(int i=0;i<=N;i++)
            if(r[i]==1)
                System.out.print(String.valueOf(i)+' ');
    }
    public static void main(String []args) {
        normal(50);
    }
}
