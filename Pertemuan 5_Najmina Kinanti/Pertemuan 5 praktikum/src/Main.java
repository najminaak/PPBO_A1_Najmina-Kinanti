import Package2.Account;
import Package.*;
//kalau ada class sama di beda package, hanya bisa di import satu

public class Main {
    public static void main(String[] args) {
        Account account1 = new Account();
        account1.username = "abcd";  //bisa diakses karena no modifier
        //account1.password = "zzzz";  //gak bisa karena private

        account1.setPassword("zzz");

        System.out.println(account1.getPassword());
        account1.printName();

        package1.Account account2 = new package1.Account();
        account2.email = "aaa@gmail.com";
    }
}