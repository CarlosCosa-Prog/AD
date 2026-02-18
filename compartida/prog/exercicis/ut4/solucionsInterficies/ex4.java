/* 4. Utilitzant List.replaceAll(UnaryOperator o) substitueix en el Vector de l'exercici anterior cada Integer per un enter resultant de fer la operació mòdul 10. Per exemple, 5467 es quedarà en 7 */

import java.util.*;

public class ex4
{
     public static void main(String args[])
    {
        Vector<Integer> v = new Vector<Integer>();

        for (String s: args)
            v.add(Integer.parseInt(s));

        for (Integer i: v)
            System.out.println(i);

        v.removeIf(i -> i.intValue() < 0);

        System.out.println("Després d'esborrar negatius");
         for (Integer i: v)
            System.out.println(i);
            
        v.replaceAll(i -> i%10);
        
        System.out.println("Després de transformar amb MOD");
         for (Integer i: v)
            System.out.println(i);
    }
}
