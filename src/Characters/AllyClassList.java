package Characters;

import java.util.Scanner;

public class AllyClassList {
    private static final AllyClassList instance = new AllyClassList();

    public AllyClass createNewClass(){
        printClassList();
        int num;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number: ");
        num = sc.nextInt();

        switch (num){
            case 1:
                return new AllyClass.Warrior();
            case 2:
                return new AllyClass.Mage();
            default:
                System.out.println("Invalid");
                return createNewClass();
        }
    }

    public void printClassList(){
        System.out.println("What class should they be?");

        System.out.println("1. Warrior");
        System.out.println("2. Mage");
    }

    private AllyClassList(){}

    public static AllyClassList getInstance(){
        return instance;
    }

}
