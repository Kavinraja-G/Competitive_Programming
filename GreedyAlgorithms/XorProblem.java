package DSA_CodeChef;

import java.util.*;
public class XorProblem {
    public static void main(String[] args)
    {
        Scanner s =new Scanner(System.in);
        int test = s.nextInt();
        while (test-- >0) 
        {
            s.nextLine();
            StringBuilder ip = new StringBuilder(s.nextLine());
            int k = s.nextInt();
            int count = 0;
            
            for(int i=0;i<ip.length();i++)
            {
                if(ip.charAt(i)=='0')
                {
                    if(count<k){
                        ip.setCharAt(i, '1');
                        count++;
                    }
                }
                else if(ip.charAt(i)=='1' && count<k)
                    ip.setCharAt(i, '0');
                else
                {
                    ip.setCharAt(i, '0');
                }
            }
            System.out.println(ip);
        }
        s.close();
    }
}