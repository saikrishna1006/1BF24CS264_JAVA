import java.util.Scanner;


class Wrongage extends Exception {
    public Wrongage(String msg) {
        super(msg);
    }
}

class Father {
    int fage;

    Father(int fage) throws Wrongage {
        if (fage < 0) {
            throw new Wrongage("Father's age can't be negative");
        }
        this.fage = fage;
    }
}


class Son extends Father {
    int sage;

    Son(int fage, int sage) throws Wrongage {
        super(fage); // call Father constructor
        if (sage < 0) {
            throw new Wrongage("Son's age can't be negative");
        }
        if (sage > fage) {
            throw new Wrongage("Son's age can't be greater than Father's age");
        }
        this.sage = sage;
    }

    void display(){
        System.out.println("Fathers age : "+fage+" Sons age : "+sage);
    }
}

public class Age{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            System.out.print("Enter Father's age: ");
            int fage = s.nextInt();

            System.out.print("Enter Son's age: ");
            int sage = s.nextInt();

            Son o = new Son(fage,sage);
            o.display();

        } catch (Wrongage e) {
            System.out.println(e.getMessage());
        }
    }
}