// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Array myArray = new Array();
    static LinkedList myLikedList = new LinkedList();
    static Scanner scanner = new Scanner(System.in);
    private static int chosenStructure;
    private static int chosenOperation;
    private static int givenIndex;
    private static int givenValue;


    public static void main(String[] args){
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
        while (true){
            if (whichOperation == 1){
                System.out.println("Podaj wartość do dodania:");
                givenValue = scanner.nextInt();
                System.out.println("Podaj index dodania:");
                givenIndex = scanner.nextInt();

                if (givenIndex > myArray.array.length || givenIndex < 0){
                    System.out.println("Podano wartość spoza zakresu!");
                }
                else {
                    break;
                }


            } else if (whichOperation == 3) {
                System.out.println("Podaj wartość do wyszukania:");
                givenValue = scanner.nextInt();
                break;
            } else {
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
            case 2 -> usingFunctionsSinglyLinkedList();
            //case 3 -> usingFunctionsDoublyLinkedList();
        }
    }
    private static void usingFunctionsArray(){
        switch (chosenOperation) {
            case 1 -> {
                myArray.add(givenIndex,givenValue);
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
    private static void usingFunctionsSinglyLinkedList(){
        switch (chosenOperation) {
            case 1 -> {
                myLikedList.add(givenValue);
                myLikedList.print();
                System.out.println(" ");
                choosingOperation();
                usingFunctionsSinglyLinkedList();
            }
            case 2 -> {
                myLikedList.remove(givenValue);
                myLikedList.print();
                System.out.println(" ");
                choosingOperation();
                usingFunctionsSinglyLinkedList();
            }
            case 3 -> {
                myLikedList.search(givenValue);
                choosingOperation();
                usingFunctionsSinglyLinkedList();
            }
        }
    }


    // Co robi -> Podawanie wartości -> Strukture




}
//{}
