// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    private static int chosenStructure;
    private static int chosenOperation;

    //int[] names = {}; //tu powinna być dwuwymiarowa tablica funkcji
    private static void choosingStructure(){
        while (true){
            System.out.println("Podaj na jakiej strukturze danych chcesz operować: \n 1 - Tablica \n 2 - Lista jednokierunkowa \n 3 - Lista dwukierunkowa");
            int odpowiedz = scanner.nextInt();
            if(odpowiedz==1 || odpowiedz==2 || odpowiedz==3){
                chosenStructure=odpowiedz;
                choosingOperation();
            }
            else {
                System.out.println("Podałeś błędną wartość!\n");
            }
        }
    }
    private static void choosingOperation(){
        while (true) {
            System.out.println("Jaką operację chcesz wykonać: \n 1 - Dodawanie \n 2 - Usuwanie \n 3 - Wyszukiwanie \n 4. Wróć");
            int odpowiedz = scanner.nextInt();
            if (odpowiedz == 1 || odpowiedz == 2 || odpowiedz == 3) {
                chosenOperation=odpowiedz;
                givingValue(odpowiedz);
            } else if (odpowiedz==4) {
                choosingStructure();
                break;
            } else {
                System.out.println("Podałeś błędną wartość!\n");
            }
        }
    }
    private static int givingValue(int whichOperation){
        String[] names = {"dodania:","usunięcia:","wyszukania:"};
        while (true){
            System.out.println("Podaj wartość do " + names[whichOperation-1]);
            return scanner.nextInt();
        }

    }
    private static void usingFunctions(){
        choosingStructure();
    }
    private static void usingStructure(){

    }
    public static void main(String[] args) {
        try {
            usingFunctions();
        }catch (InputMismatchException e){
            System.out.println("Podano złą wartość");
        }
    }
    // Co robi -> Podawanie wartości -> Strukture


    public static void menu(){

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