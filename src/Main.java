// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    private static int choosingStructure(){
        while (true){
            System.out.println("Podaj na jakiej struktórze danych chcesz operować: \n 1 - Tablica \n 2 - Lista jednokierunkowa \n 3 - Lista dwukierunkowa");
            int odpowiedz = scanner.nextInt();
            if(odpowiedz==1 || odpowiedz==2 || odpowiedz==3){
                return odpowiedz;
            }
            else {
                System.out.println("Podałeś błędną wartość\n");
            }
        }
    }
    public static void main(String[] args) {
        Array dupa = new Array();
        dupa.add(10);
        dupa.add(20);
        dupa.add(30);

        // Wyświetlanie elementów tablicy
        for (int i = 0; i < dupa.size(); i++) {
            System.out.println(dupa.get(i));
        }
        dupa.search(20);
    }


    private  int choosingOperation(){
        System.out.println("Jaką operację chcesz wykonać: \n 1 - Dodawanie \n 2 - Usuwanie \n 3 - Wyszukiwanie");
        int odpowiedz = scanner.nextInt();
        if(odpowiedz==1){
            System.out.println("Podaj wartość do dodania:");
            odpowiedz = scanner.nextInt();
        } else if (odpowiedz==2) {
            System.out.println("Podaj wartość do usunięcia:");
            odpowiedz = scanner.nextInt();
        } else if (odpowiedz==3) {
            System.out.println("Podaj wartość do wyszukania:");
            odpowiedz = scanner.nextInt();
        }
        return odpowiedz;
    }
    public static void menu(){


        try {
            // Co robi -> Podawanie wartości -> Strukture
            //

        } catch (InputMismatchException e) {
            System.out.println("zla wartosc");
        }


        /*
        if (odpowiedz == 1) {

            odpowiedz = scanner.nextInt();
            while (true){
                if (odpowiedz==1 || odpowiedz==2 || odpowiedz==3){

                    break;
                }
                else {
                    System.out.println("Podałeś błędną wartość");
                }
            }

        } else if (odpowiedz==2) {
            linkedlist();
        } else if (odpowiedz==3){
            doublylinkedlist();
        }
        else{
            System.out.println("Podałeś błędny wartość");
            menu();
        }

         */
    }

    public static void array(int value){
        int[] array = new int[1];
        array[0]=value;
        System.out.println(Arrays.toString(array));
    }
    public static void linkedlist(){
        System.out.println("To jest lista jednokierunkowa");
    }
    public static void doublylinkedlist(){
        System.out.println("To jest lista dwukierunkowa");
    }
}
//{}