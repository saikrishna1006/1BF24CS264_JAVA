import java.util.Scanner;
import java.lang.Math;
class quadratic
{
    public static void main(String []args)
    {
        int a,b,c;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the coefficinets of eaquation");
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        if(a==0)
        {
            System.out.println("Not a quadratic equation");
        }
        else 
        {
            double d,r1,r2;
            d = (b*b)-(4*a*c);
            if(d==0)
            {
                r1 = -b/(2*a);
                System.out.println("Roots are equal and real:"+r1+"and"+r1);
            }
            if(d<0)
            {
                System.out.println("Roots are imaginary");
            }
            if(d>0)
            {
                r1 = -b/(2*a);
                r2 = Math.sqrt(d/(2*a));
                System.out.println("Roots are R1="+r1+"+"+r2+" and R2="+r1+"-"+r2);
            }
        }
    }
}