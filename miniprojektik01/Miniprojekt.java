
/*
 * Calculate number of clean windows.
 * Miniprojekt 1.A
 */
import java.lang.IllegalArgumentException;
import java.util.*;

public class Miniprojekt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int clean_windows = 0;
        int max_windows_by_one_worker = 0;
        int current_worker;

        System.out.println("Zadejte, kolik bylo brigadniku: ");
        int number_of_workers = sc.nextInt();
        if (number_of_workers < 0) {
            sc.close();
            throw new IllegalArgumentException("Pocet brigadniku nemuze byt zaporny!");
        }
        for (int i = 0; i < number_of_workers; i++) {
            System.out.println("Zadejte, kolik oken umyl brigadnik: ");
            current_worker = sc.nextInt();
            if (current_worker < 0) {
                sc.close();
                throw new IllegalArgumentException("Pocet oken nemuze byt zaporny!");
            }
            if (current_worker < 10) {
                System.out.println("Malo vykonny brigadnik, vyradit.");
            }
            if (max_windows_by_one_worker < current_worker) {
                max_windows_by_one_worker = current_worker;
            }
            clean_windows += current_worker;
        }

        sc.close();

        System.out.println("Bylo umyto " + clean_windows + " oken.");
        System.out.println("Nejvice bylo jednim brigarnikem umyto " + max_windows_by_one_worker + " oken.");
    }
}