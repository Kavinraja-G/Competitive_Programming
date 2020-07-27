package Codevita;

import java.util.*;
public class swayamvar
{
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        Queue<Character> bride = new LinkedList<>();
        Queue<Character> groom = new LinkedList<>();
        int n = s.nextInt();
        s.nextLine();
        String brideip = s.nextLine();
        String groomip = s.nextLine();
        int pairs = 0;
        int idx = 0;
        while(idx <n)
        {
            bride.add(brideip.charAt(idx));
            groom.add(groomip.charAt(idx));
            idx++;
        }
        
        while(!bride.isEmpty() || !groom.isEmpty())
        {
            System.out.println(bride + " " + groom);
            if(bride.peek() == groom.peek())
            {
                bride.poll();
                groom.poll();
                pairs++;
            }
            else
            {
                groom.add(groom.poll());
                if(!groom.contains(bride.peek()))
                    break;
            }
        }
        System.out.print(Math.abs(pairs-n));
    }
}