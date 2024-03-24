// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Array myArray = new Array();
    static Scanner scanner = new Scanner(System.in);
    private static int chosenStructure;
    private static int chosenOperation;
    private static int givenValue;


    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("file.txt");
        Scanner in = new Scanner(file);

        String zdanie = in.nextLine();
        System.out.println(zdanie);
        menu();
    }
    public static void menu(){
        try {
            usingFunctions();
        }catch (InputMismatchException e){
            System.out.println("Podano złą wartość");}
    }
    private static void choosingStructure(){
        while (true){
            System.out.println("Podaj na jakiej strukturze danych chcesz operować: \n 1 - Tablica \n 2 - Lista jednokierunkowa \n 3 - Lista dwukierunkowa");
            int odpowiedz = scanner.nextInt();
            if(odpowiedz==1 || odpowiedz==2 || odpowiedz==3){
                chosenStructure=odpowiedz;
                choosingOperation();
                break;
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
                break;
            } else if (odpowiedz==4) {
                choosingStructure();
            } else {
                System.out.println("Podałeś błędną wartość!\n");
            }
        }
    }

    private static void givingValue(int whichOperation){
        String[] names = {"dodania:","usunięcia:","wyszukania:"};
        while (true){
            if (whichOperation == 1 || whichOperation == 3){
                System.out.println("Podaj wartość do " + names[whichOperation-1]);
                givenValue = scanner.nextInt();
                break;
            }
            else {
                System.out.println("Podaj wartość do usunięcia:");
                int value = scanner.nextInt();
                if (value>=0 || value <= myArray.array.length){
                    givenValue = value;
                    break;
                }
                else {
                    System.out.println("Podano wartość spoza zakresu!");
                }
            }
        }
    }
    private static void usingFunctions(){
        choosingStructure();
        switch (chosenStructure) {
            case 1 -> usingFunctionsArray();
            //case 2 -> usingFunctionsSinglyLinkedList();
            //case 3 -> usingFunctionsDoublyLinkedList();
        }
    }private static void usingFunctionsArray(){
        switch (chosenOperation) {
            case 1 -> {
                myArray.add(givenValue);
                System.out.println(myArray.toString());
                choosingOperation();
                usingFunctionsArray();
            }
            case 2 -> {
                myArray.remove(givenValue);
                System.out.println(myArray.toString());
                choosingOperation();
                usingFunctionsArray();
            }
            case 3 -> {
                myArray.search(givenValue);
                choosingOperation();
                usingFunctionsArray();
            }
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
