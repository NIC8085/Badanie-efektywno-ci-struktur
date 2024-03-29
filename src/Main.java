// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Array myArray = new Array();
    static LinkedList myLikedList = new LinkedList();
    static DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();
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

                if (chosenStructure==1){
                    if (givenIndex>=0 && givenIndex <= Array.size){
                        break;
                    }
                } else if (chosenStructure==2) {
                    if (givenIndex>=0 && givenIndex <= LinkedList.size){
                        break;
                    }
                }
                else {
                    if (givenIndex>=0 && givenIndex<= DoublyLinkedList.size){
                        System.out.println(DoublyLinkedList.size);
                        break;
                    }
                }
                System.out.println("Podano wartość spoza zakresu!");

            } else if (whichOperation == 2) {
                System.out.println("Podaj wartość do usunięcia:");
                givenValue= scanner.nextInt();
                break;

            } else {
                System.out.println("Podaj wartość do wyszukania:");
                givenValue = scanner.nextInt();
                break;
            }
        }
    }


    private static void usingFunctions(){
        choosingStructure();
        switch (chosenStructure) {
            case 1 -> usingFunctionsArray();
            case 2 -> usingFunctionsSinglyLinkedList();
            case 3 -> usingFunctionsDoublyLinkedList();
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
    private static void usingFunctionsDoublyLinkedList(){
        switch (chosenOperation) {
            case 1 -> {
                myDoublyLinkedList.add(givenIndex, givenValue);
                myDoublyLinkedList.print();
                System.out.println(" ");
                choosingOperation();
                usingFunctionsDoublyLinkedList();
            }
            case 2 -> {
                myDoublyLinkedList.remove(givenValue);
                myDoublyLinkedList.print();
                System.out.println(" ");
                choosingOperation();
                usingFunctionsDoublyLinkedList();
            }
            case 3 -> {
                myDoublyLinkedList.search(givenValue);
                myDoublyLinkedList.print();
                System.out.println(" ");
                choosingOperation();
                usingFunctionsDoublyLinkedList();
            }
        }
    }


    // Co robi -> Podawanie wartości -> Strukture




}
//{}
