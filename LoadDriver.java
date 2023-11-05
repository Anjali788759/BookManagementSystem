public class LoadDriver {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loded");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
