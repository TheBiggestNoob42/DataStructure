import java.util.Scanner;

public class Add_Tester {
    public static void main(String... args) throws Exception {
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter in a postfix equation ===>> ");
        String str = input.nextLine();
        Adder add = new Adder(str);
        System.out.println("The result is: " + add.solve());

        do {
            System.out.println();
            System.out.print("Please enter in a equation ===>> ");
            str = input.nextLine();
            InfixAdder add1 = new InfixAdder(str);
            System.out.println("The result is: " + add1.solve());
            System.out.print("\nDo you want to continue(y/n): ");
        }while(input.nextLine().toUpperCase().equals("Y"));
    }
}
