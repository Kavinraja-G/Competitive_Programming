import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static boolean checkPrime(int n)
    {
        if(n<=1)
            return false;
        if(n==2 || n==3)
            return true;
        if(n % 2 == 0)
            return false;
        for (int i=2; i<= Math.sqrt(n);i++)
        {
            if(n%i == 0)
                return false;
        }
        return  true;
    }

    static int concatIntegers(ArrayList<Integer> primeArray, int l, int r)
    {
        String result = String.valueOf(primeArray.get(l))+String.valueOf(primeArray.get(r));
        return Integer.parseInt(result);
    }

    static long fibonacci(int l, int r, int count)
    {
        long first = (long)l;
        long second = (long)r;
        long third=0;
        for(int i=2; i<count; i++)
        {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int testCase = s.nextInt();
        while (testCase-- >0)
        {
            ArrayList<Integer> primeArray = new ArrayList<>();
            ArrayList<Integer> combinePrime = new ArrayList<>();
            int left = s.nextInt();
            int right = s.nextInt();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int countSize = 0;
            //Creating the ArrayList of Primes from the given range
            for(int el = left; el<=right; el++)
            {
                if(checkPrime(el))
                    primeArray.add(el);
            }
            //Create arrayList of all prime combinations
            for(int i=0;i<primeArray.size();i++)
            {
                for(int j=0;j<primeArray.size();j++)
                {
                    if(i!=j)
                    {
                        int temp = concatIntegers(primeArray,i,j);
                        if(checkPrime(temp) && !combinePrime.contains(temp))
                        {
                            combinePrime.add(temp);
                            countSize++;
                            if (temp > max) max = temp;
                            if (temp < min) min = temp;
                        }
                    }
                }
            }
            //Generate Fibonacci and find the last element
            long lastElement = fibonacci(min, max, countSize);
            System.out.println(lastElement);
        }
    }
}
