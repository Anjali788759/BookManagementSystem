import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookServiceInterface service = new BookServiceImpl();

        do {
            System.out.println("Welcome to book Management System");
            System.out.println("1. ADD BOOK\n");
            System.out.println("2. Show all Books\n");
            System.out.println("3. Show all Available Books\n");
            System.out.println("4. Borrow BOOK\n");
            System.out.println("5. Return BOOK\n");
            System.out.println("6. Exit\n");
            System.out.println("Enter your choice");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    service.addBook();
                    break;
                case 2:
                    service.showAllBooks();
                    break;
                case 3:
                    service.showAllAvailableBooks();
                    break;
                case 4:
                    service.borrowBooks();
                    break;
                case 5:
                    service.returnBooks();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Application closed");
            }
        }while(true);
    }
}








