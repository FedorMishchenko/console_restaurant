package restaurant.ui;

 public class Format {

    public void format(String... s) {
        System.out.printf("%9s%-20s%n", " ", "----------------------------");
        for (String str : s) {
            System.out.printf("%15s%-20s%2s%n", "|     ", str, "|");
        }
        System.out.printf("%9s%-20s%n", " ", "----------------------------");
    }
}
