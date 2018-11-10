import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/find-a-pair-swapping-which-makes-sum-of-two-arrays-same/
 *
 * Given two arrays of integers, find a pair of values (one value from each array) that you can swap to give the two arrays the same sum.
 *
 * Input : A[] = {4, 1, 2, 1, 1, 2}
 B[] = (3, 6, 3, 3)
 Output : {1, 3}
 Sum of elements in A[] = 11
 Sum of elements in B[] = 15
 To get same sum from both arrays, we
 can swap following values:
 1 from A[] and 3 from B[]

 Input: A[] = {5, 7, 4, 6} = 22
 B[] = {1, 2, 3, 8} = 14
 Output: 6 2
 */
public class SwapIntegers {

    public static void main(String args[]){
        //System.out.println(findPair3(new int[]{5, 7, 4, 6}, new int[] {1, 2, 3, 8}));
        System.out.println(findPair3(new int[]{4, 1, 2, 1, 1, 2}, new int[] {3, 6, 3, 3}));
    }

    private static int sum(int[] arr){
        int sum=0;
        for(int i=0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    // inefficient o(n^2)
    private static Pair<Integer, Integer> findPair3(int[] a, int[] b){
        int aSum = sum(a);
        int bSum = sum(b);

        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(aSum+b[j]-a[i] == bSum+a[i]-b[j]){
                    return new Pair<>(a[i], b[j]);
                }
            }
        }
        return null;
    }

    // semi-efficient o(nlogn)
    private static Pair<Integer, Integer> findPair2(int [] a, int[] b){
        if(a==null || b == null){
            throw new IllegalArgumentException("Bad input");
        }
        if(a.length==0 && b.length == 0){
            return null;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int aSum = sum(a);
        int bSum = sum(b);
        int i=0;
        int j=0;
        while(true) {
            if (i == a.length-1 && j == b.length-1) {
                if((aSum + b[j] - a[i]) == (bSum + a[i] - b[j])){
                    return new Pair(a[i], b[j]);
                }
                return null;
            }
            if ((aSum + b[j] - a[i]) == (bSum + a[i] - b[j])) {
                return new Pair(a[i], b[j]);
            }
            if (((aSum + b[j] - a[i]) > (bSum + a[i] - b[j]) || j == b.length-1)) {
                i++;
            } else {
                j++;
            }
        }
    }

    // efficient o(n)
    private static Pair<Integer, Integer> findPair1(int [] a, int[] b){
        if(a==null || b == null){
            throw new IllegalArgumentException("Bad input");
        }
        if(a.length==0 && b.length == 0){
            return null;
        }
        int aSum=sum(a);
        int bSum=sum(b);

        int diffSum = bSum - aSum;
        int sumDiffToFind = diffSum/2;

        Set<Integer> set = new HashSet<>();
        for (int i=0;i<b.length;i++){
           set.add(b[i]);
        }

        for(int i=0;i<a.length;i++){
            if(set.contains(a[i]+sumDiffToFind)){
                return new Pair(a[i], a[i]+sumDiffToFind);
            }
        }

        return null;
    }

}
