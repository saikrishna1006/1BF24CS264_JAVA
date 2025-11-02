import java.util.Scanner;

class Books{
    String name;
    String author;
    int price;
    int pages;

    Books(String name, String author, int price, int pages){
        this.name=name;
        this.author=author;
        this.price=price;
        this.pages=pages;
    }

    public String toString(){
        String name, author, price, pages;
        
        name = "\nBook name: " + this.name + "\n";
        author = "Author name: " + this.author + "\n";
        price = "Price: " + this.price + "\n";
        pages = "Number of pages: " + this.pages + "\n";

        return name + author + price + pages;
    }

}

class BookDetails{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        String name;
        String author;
        int price;
        int pages;

        System.out.println("Number of books to enter: ");
        n=sc.nextInt();
        
        Books[] b = new Books[n];

        for (int i=0; i<n; i++){
            System.out.println("Enter book name: ");
            name=sc.nextLine();
            sc.nextLine();
            System.out.println("Enter author name: ");
            author=sc.nextLine();
            sc.nextLine();
            System.out.println("Enter book price: ");
            price=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter total number of pages: ");
            pages=sc.nextInt();
            sc.nextLine();
            b[i]= new Books(name,author,price,pages);
        }

        for (int i=0; i<n; i++){
            String s="Book "+(i+1)+" details are :"+b[i];
            System.out.println(s);
        }

    }
}