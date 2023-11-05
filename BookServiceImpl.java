import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookServiceInterface {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLACK = "\u001B[30m";

    Scanner sc=new Scanner(System.in);
    Validator validator=new Validator();
    List<Book> books=new ArrayList<>();
    private String bookid;

    @Override
    public void addBook() {
       String bookid=Validator.validateId();
       String Author=Validator.validateAuthorTitle("Author");
       String Title=Validator.validateAuthorTitle("Title");
       String year=Validator.validatePublishYear();
       Book book=new Book(bookid,Author,Title,year,"Available");
       books.add(book);
        System.out.println(GREEN+"BOOK ADDED SUCCESSFULLY !!!"+RESET);
    }

    @Override
    public void showAllBooks() {
        boolean flag = false;
        System.out.println("\n------------------------");
        System.out.format(CYAN + "%s%15s%15s%15s%15s", "ID", "TITLE", "AYTHOR", "PUBLISHYEAR" + RESET);
        System.out.println("\n---------------------------");
        for (Book book : books) {
            System.out.format("%s%15s%15s%15s%15s", book.getId(), book.getTitle());
            System.out.println();
            flag = true;
        }
        System.out.println("\n-------------------------------");
        if (flag == false) {
            System.out.println(RED + "THERE IS NO BOOK IN LIBRARY " + RESET);
        }
    }


    @Override
    public void showAllAvailableBooks() {
            boolean flag=false;
            System.out.println("\n------------------------");
            System.out.format(CYAN+"%s%15s%15s%15s%15s","ID","TITLE","AYTHOR","PUBLISHYEAR"+RESET);
            System.out.println("\n---------------------------");
            if(books.size()>0){
                for(Book book:books){
                    if(book.getStatus()=="Available"){
                        System.out.format("%s%15s%15s%15s%15s",book.getId(),book.getStatus());
                        System.out.println();
                        flag=true;
                    }
                }
            }
            else {
                System.out.println(RED+"THERE IS  NO BOOK IN LIBRARY "+RESET);
            }
            System.out.println("\n----------------------------");
            if(flag==false)
                System.out.println(RED+"THERE IS NO BOOK AVAILABLE IN LIBRARY"+RESET);
        }



    @Override
    public void borrowBooks() {
        String bookid = validator.validateId();
        boolean flag = false;
        for (Book book : books) {
            if (book.getId().equals(bookid) && book.getStatus().equals("Available")) {
                flag = true;
                System.out.println(GREEN + "BOOK BORROWED SUCCESSFULLY" + RESET);
                book.setStatus("not avaible");
                System.out.println("borrowed book details:" + book);
            }
        }
        if(flag==false)
            System.out.println(RED+"BOOK NOT AVAILABLE"+RESET);
    }
    @Override
    public void returnBooks() {
 boolean flag=false;
 for(Book book:books){

     if(book.getId().equals(bookid) && book.getStatus().equals("noy available")){
         flag = true;
         System.out.println(GREEN + "BOOK RETURNED SUCCESSFULLY" + RESET);
         book.setStatus("available");
         System.out.println("returned book details:" + book);
     }
 }
        if(flag==false)
            System.out.println(RED+"we cant return this book"+RESET);
    }



}
