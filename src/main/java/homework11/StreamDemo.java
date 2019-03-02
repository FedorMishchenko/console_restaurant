package homework11;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    @NotNull
    public  List<User> list() {
        User user1 = new User(new User.Builder().id(new UUID(1L,3L)).name("Bill")
                .email("bill@email").age(19).salary(250)
                .address(new User.Address().country("USA").city("New York")
                        .street("Avenue12").house(256).flat(12)));
        User user2 = new User(new User.Builder().id().name("Tom")
                .email("tom@email").age(27).salary(189)
                .address(new User.Address().country("USA").city("New York")
                        .street("Avenue8").house(13).flat(9)));
        User user3 = new User(new User.Builder().id().name("Jack")
                .email("jack@email").age(31).salary(280)
                .address(new User.Address().country("USA").city("New York")
                        .street("Avenue2").house(112).flat(89)));
        User user4 = new User(new User.Builder().id().name("Sara")
                .age(21).salary(200)
                .address(new User.Address().country("Canada").city("Toronto")
                        .street("Avenue12").house(258).flat(4)));
        return Arrays.asList(user1, user2, user3, user1, user4);
    }
    private  List<User> findAllUserNamesWithoutRepeat(@NotNull List<User> users) {
        return users.stream().distinct().collect(Collectors.toList());
    }

    @NotNull
    @Contract(pure = true)
    private  Set<String> findUserNamesUniqueInArray(User[] users) {
        Set<String> names = new HashSet<>();
        Set<User> tmp = Stream.of(users)
                .collect(Collectors.toSet());
        for (User u : tmp) {
            names.add(u.getName());
        }
        return names;
    }

    @NotNull
    private  Integer findMinAge(User[] users) {
        return Stream.of(users)
                .min(new AgeComparator()).get().getAge();
    }

    @NotNull
    private  Integer findMaxAge(User[] users) {
        return Stream.of(users)
                .max(new AgeComparator()).get().getAge();
    }

    private static LongSummaryStatistics findSumOfSalariesForAllUsers(@NotNull List<User> list) {
        return list
                .stream()
                .collect(Collectors.summarizingLong(User::getSalary));

    }
    private  List<User> findUsersWhereAgeBetweenAndNameContainsSymbol(
            Integer fromAge, Integer toAge, String symbol){
        return list()
                .stream()
                .filter(x -> x.getAge() < toAge && x.getAge() > fromAge)
                .filter(x -> x.getName().contains(symbol))
                .collect(Collectors.toList());
    }
    private  List<User> deleteAllUsersWhereEmailIsNull(User [] users){
        return Stream.of(users)
                .filter(x -> x.getEmail()!= null)
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        StreamDemo x = new StreamDemo();
        print("All Users:");
        System.out.printf("%9s%21s%n", "","--------------------------");
        for (User user : x.list()) {
            System.out.printf("%10s%15s%10s%n", "|",user.getName(),"|");
            System.out.printf("%10s%15s%10s%n", "|",user.getEmail(),"|");
            System.out.printf("%10s%15s%10s%n", "|",user.getAge(),"|");
            System.out.printf("%10s%15s%10s%n", "|",user.getSalary(),"|");
            System.out.printf("%9s%21s%n", "","--------------------------");
        }
        User[] arr = (User[]) x.list().toArray();
        print("Find all User's names without repeat: ");
        System.out.printf("%9s%21s%n", "","--------------------------");
        for (User user : x.findAllUserNamesWithoutRepeat(x.list())) {
            System.out.printf("%10s%15s%10s%n", "|",user.getName(),"|");
        }

        System.out.printf("%9s%21s%n", "","--------------------------");
        System.out.printf("%-30s%n","User's names unique in array: ");
        System.out.printf("%9s%20s%n", "","--------------------------");
        for (String name : Objects.requireNonNull(x.findUserNamesUniqueInArray(arr))) {
            /*print(name);*/
            System.out.printf("%10s%15s%10s%n", "|",name,"|");
        }
        System.out.printf("%9s%21s%n", "","--------------------------");

        System.out.printf("%30s%n","Min User age = " + x.findMinAge(arr));
        System.out.printf("%30s%n","Max User age = " + x.findMaxAge(arr));
        int i = 0;
        format(i, 80);

        print('\n' + findSumOfSalariesForAllUsers(x.list()).toString());
        print('\n' + "User's salaries sum = " + findSumOfSalariesForAllUsers(x.list()).getSum());
        i = 0;
        format(i, 80);
        print('\n' + "Find Users where age between and name contains symbol:" + '\n');
        for (User user:x.findUsersWhereAgeBetweenAndNameContainsSymbol(18,31,"B")){
            print(user.toString());
        }
        i = 0;
        format(i, 80);
        print('\n' + "Delete all Users where email is null:");
        for(User user: x.deleteAllUsersWhereEmailIsNull(arr)){
            print(user.getName() + ": " + user.getEmail());
        }
        i = 0;
        format(i, 40);
    }

    private static void format(int i, int i2) {
        while (i < i2) {
            System.out.print("-");
            i++;
        }
    }

    private static void print(String str) {
        System.out.println(str);
    }

    private static class AgeComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }
}
