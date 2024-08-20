package CountTheDevisibleNumbers;

public class CountTheDevisibleNumbers {
    public static long divisibleCount(long x, long y, long k) {

        long countY = y / k;

        long countX;
        if (x>0){
            countX= (x-1) / k;
        }else{
            countX=-1;
        }


        return countY - countX;
    }
}
