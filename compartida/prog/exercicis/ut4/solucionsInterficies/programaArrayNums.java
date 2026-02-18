import java.util.*;

class arrayNums implements Iterable<Double>
{
    private double nums[];

    public arrayNums()
    {
        nums = new double[2];
    }
    public arrayNums(int mida)
    {
        nums = new double[mida];
    }

    public void carregaIncremental(int valorInicial, int increment)
    {
        for (int i = 0 ; i < nums.length ; i++)
            nums[i] = valorInicial + i*increment;
    }

    public Iterator<Double> iterator()
    {
        return new Iterator<Double>()
        {
            int i=0;
            public boolean hasNext()
            {
                if (i < nums.length)
                    return true;
                else
                    return false;
            }
            public Double next()
            {
                double aux = nums[i];
                i++;
                return Double.valueOf(aux);
            }
        };
    }
}

public class programaArrayNums
{
    public static void main(String args[])
    {
        arrayNums ae = new arrayNums(4);
        ae.carregaIncremental(5,5);
        for(Double n: ae)
            System.out.println(n);
    }
}
