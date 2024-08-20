import java.util.ArrayList;

public class SimpleSumOfPairs {
    public int solve(long n){

        int b;
        int highestQueersum=0;
        int quersumme;

        for (int a = 0; a<10; a++){
            b = (int) (n-a);

            quersumme = getQuersumme(a)+getQuersumme(b)-1;
            if (quersumme>highestQueersum){
                highestQueersum=quersumme;
            }


        }

        return highestQueersum;
    }

    public int getQuersumme(int a){
        int quersumme = 0;


        while (a>0){
             quersumme+= a%10;
             a /= 10;
        }

    return quersumme;
    }
}
