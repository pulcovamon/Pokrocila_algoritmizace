package test01;
/*
 * Test Monika Pulocova
 */
import java.util.*;

public class Test {
    private static int loadSequence() {
        Scanner scanner = new Scanner(System.in);

        int currentNumber;
        ArrayList<Integer> mySequence = new ArrayList<Integer>();
        while (true) {
            System.out.println("Insert an integer. If 0 inserted, program will finish.");
            try  {
                currentNumber = scanner.nextInt();
            } catch (InputMismatchException ex) {
                ex.printStackTrace();
                scanner.close();
                return -1;
            }
            if (currentNumber == 0) break;
            mySequence.add(currentNumber);
        }
        
        int lastNumber = mySequence.get(mySequence.size()-1);
        ArrayList<Integer> mySequence2 = new ArrayList<Integer>();
        for (int i = 0; i < mySequence.size(); i++) {
            mySequence2.add(mySequence.get(i) * lastNumber);
        }

        System.out.println(mySequence);
        System.out.println(mySequence2);

        scanner.close();
        return 0;
    }

    public static void main(String[] args) {
        loadSequence();
    }
}