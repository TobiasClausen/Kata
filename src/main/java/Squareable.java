public class Squareable {
    public static int countSquareable(int n){
        int count=0;
        int ungerade=1;

        if (n%2==0){
            ungerade = n/2;
        }else {
            ungerade = (n+1)/2;
        }

        for (int i = 4; i<=n;i+=4){
            count++;
        }

        return ungerade+count;
    }
}
