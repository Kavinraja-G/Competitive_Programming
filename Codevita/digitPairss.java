package Codevita;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class digitPairss {

    static String findBitScore(int val)
    {
        String res = "";
        ArrayList<Integer> digits = new ArrayList<>();
        while(val > 0)
        {
            digits.add(val%10);
            val /= 10;
        }
        res = Integer.toString(Collections.max(digits)*11 + Collections.min(digits)*7);
        if(res.length() == 3)
            res = res.substring(1,3);
        return res;
    }

    static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int size = s.nextInt();
        int[] ip = new int[size];
        String[] scores = new String[size];
        TreeMap<Character, Integer> oddpos = new TreeMap<>();
        TreeMap<Character, Integer> evenpos = new TreeMap<>();
        for(int i=0;i<size;i++)
        {    
            ip[i] = s.nextInt();
            scores[i] = findBitScore(ip[i]);
            if((i+1)%2 != 0)
            {    
                if(oddpos.containsKey(scores[i].charAt(0))) 
                    oddpos.put(scores[i].charAt(0), oddpos.get(scores[i].charAt(0)) +1); 
                else
                    oddpos.put(scores[i].charAt(0), 1);
            }
            else
            {
                if(evenpos.containsKey(scores[i].charAt(0))) 
                    evenpos.put(scores[i].charAt(0), evenpos.get(scores[i].charAt(0)) +1); 
                else
                    evenpos.put(scores[i].charAt(0), 1);                
            }
        }
        int[] freq = new int[10];
        for(Map.Entry<Character, Integer> odd : oddpos.entrySet())
        {
            int value = odd.getValue();
            if(value <= 1)
                value = 0;
            else if(value ==2)
                value = 1;
            else value = 2;
            freq[Integer.valueOf(odd.getKey().toString())] += value;
        }
        for(Map.Entry<Character, Integer> even : evenpos.entrySet())
        {
            int value = even.getValue();
            if(value <= 1)
                value = 0;
            else if(value ==2)
                value = 1;
            else value = 2;
            freq[Integer.valueOf(even.getKey().toString())] += value;
        }
        for(int i=0;i<10;i++)
        {    
            freq[i] = Math.min(freq[i], 2);
        }
        System.out.println(IntStream.of(freq).sum());
    }
}