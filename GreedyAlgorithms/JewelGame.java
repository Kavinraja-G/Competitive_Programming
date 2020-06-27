package DSA_CodeChef;

import java.util.Scanner;

public class JewelGame {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        while(test-- >0)
        {
            StringBuilder ip = new StringBuilder(s.nextLine());
            s.close();
            int count = 0,i=0;
            while(i < ip.length()-1)
            {
                if(ip.charAt(i) == ip.charAt(i+1))
                {
                    ip.delete(i, i+2);
                    count++;
                    if(i>=1)
                        i--;
                }
                else
                    i++;
            }
            System.out.println(count);
        }
    }
}