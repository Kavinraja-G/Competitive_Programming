package Codevita;
import java.util.*;
public class monkey {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int test = s.nextInt();
        while(test-- >0)
        {
            int seconds = 0;
            int size = s.nextInt();
            int[] ip = new int[size+1];
            int[] cpy = new int[size+1];
            int[] idx = new int[size+1];
            int[] res = new int[size+1];
            ip[0] = idx[0] = cpy[0] = res[0] = 0;
            for(int i=1;i <size+1; i++)
            {    
                ip[i] = s.nextInt();
                idx[i] = i;
                cpy[i] = i;
            }
            while(!Arrays.equals(res, cpy))
            {
                for(int i=1;i<size+1;i++)
                {
                    res[ip[i]] = idx[i];
                }                
                seconds++;
                idx = res.clone();
                
            }
            System.out.println(seconds);
        }
    }
}