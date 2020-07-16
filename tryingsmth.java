package strat;
import java.util.Scanner;

// tryng to find the common factor

public class tryingsmth {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double one,two, select;

        do  {
            System.out.println("one and two:");
            one = sc.nextInt();
            two = sc.nextInt();


            if (one % two == 0) {
                System.out.println("divisible");
            }
            else if (two % one == 0) {
                System.out.println("divisible");
            }

            else {  // when the mod is not immediately divisible
                System.out.println("indivisible");
                System.out.println(one%two);
                System.out.println(two%one);

                double modst, modnd;
                while (true)  {
                    modst = one % two;
                    modnd = two % one;
                    one = modst;
                    two = modnd;
                    System.out.println(modst + "," + modnd);
                    if (modst == 1 || modnd == 1) {
                        System.out.println("actually indivisible");
                        break;
                    }
                    else if (modst == 0 || modnd == 0) {
                        double factor;
                        System.out.println("has common factor:");
                        if (modnd == 0) {
                            factor = modst;
                        }
                        else {
                            factor = modnd;
                        }
                        System.out.println(factor);
                        break;
                    }
                }
            }
            System.out.println("select");
            select = sc.nextInt();

        }
        while (select == 0);
    }
}
