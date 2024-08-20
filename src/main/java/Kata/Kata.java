package Kata;

import java.util.*;
public class Kata {
    public static long nextSmaller(long n) {
        //Put your lovely code here ฅ(≈>ܫ<≈)
        char[] digits = Long.toString(n).toCharArray();
        int length = digits.length;

        int pivot = -1;
        for (int i = length - 2; i >= 0; i--) {
            if (digits[i] > digits[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) return -1;

        int swapCandidate = -1;
        for (int i = length - 1; i > pivot; i--) {
            if (digits[i] < digits[pivot]) {
                if (swapCandidate == -1 || digits[i] > digits[swapCandidate]) {
                    swapCandidate = i;
                }
            }
        }

        char temp = digits[pivot];
        digits[pivot] = digits[swapCandidate];
        digits[swapCandidate] = temp;

        Arrays.sort(digits, pivot + 1, length);
        for (int i = pivot + 1, j = length - 1; i < j; i++, j--) {
            temp = digits[i];
            digits[i] = digits[j];
            digits[j] = temp;
        }

        if (digits[0] == '0') return -1;

        long result = Long.parseLong(new String(digits));

        return result;
    }
}
