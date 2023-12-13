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
                return new AllyClass.Rogue();
            case 3:
                return new AllyClass.Mage();
            case 4:
                return new AllyClass.Healer();
            default:
                System.out.println("Invalid");
                return createNewClass();
        }
    }

    public void printClassList(){
        System.out.println("What class should they be?");

        System.out.println("1. Warrior");
        System.out.println("2. Rogue");
        System.out.println("3. Mage");
        System.out.println("4. Healer");
    }

    private AllyClassList(){}

    public static AllyClassList getInstance(){
        return instance;
    }

}
