import java.time.Year;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    public static final String RED="\u001B[31m";
    public static final String RESET="\u001B[0m";
    private static Pattern ID_PATTERN = Pattern.compile("^\\d{1,4}$");
    private static Pattern AuthorTitle_Pattern = Pattern.compile("^[a-zA-Z]+$");
    private static Pattern PublishYear_Pattern= Pattern.compile("^\\d{4}$");
    static Scanner sc=new Scanner(System.in);
    public static String validateId(){
        String bookid;
 while(true){
     System.out.println("enter book id");
     bookid =sc.nextLine();
     if(!ID_PATTERN.matcher(bookid).matches()){
         System.out.println(RED+"sorry ! please enter valid id"+RESET);
     }else{
         break;
     }

 }
    return bookid;
    }
    public static String validateAuthorTitle(String input){
        String result;
        while(true){
           if(input=="Title"){
               System.out.println("enter title");
           }else{
               System.out.println("enter Author");
           }
           result=sc.nextLine();
           if(!AuthorTitle_Pattern.matcher(result).matches()){
               System.out.println(RED+"please enter valid"+input+RESET);
           }else{
               break;
           }
        }
        return result;
    }

    public static String validatePublishYear(){
        String year;
        while(true){
            System.out.println("enter publish year of book");
            year=sc.nextLine();
            if(!PublishYear_Pattern.matcher(year).matches()){
                System.out.println(RED+"ENTER VALID  PUBLISH YEAR"+RESET);
            }else{
                break;
            }
        }
        return year;
    }





}
