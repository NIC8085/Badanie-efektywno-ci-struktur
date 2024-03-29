import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TimeMenu {
    static Array myArray = new Array();
    static LinkedList myLikedList = new LinkedList();
    static DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();
    static Random rand = new Random();
    static Scanner scanner = new Scanner(System.in);
    private static int chosenStructure;
    private static int chosenOperation;
    private static int chosenRemove;
    private static int chosenAdding;
    static long start_time = System.currentTimeMillis();
    static long end_time = System.currentTimeMillis();
    static int exc_time = 0;
    static int wantedSize = 100000;

    public static void main(String[] args){
        timemenu();
    }
    public static void timemenu(){
        while(true){
            usingFunctionsTime();
        }
    }
    private static void choosingStructureTime(){
        while (true){
            System.out.println("Podaj na jakiej strukturze danych chcesz operować: \n 1 - Tablica \n 2 - Lista jednokierunkowa \n 3 - Lista dwukierunkowa \n 4. Wróć");
            int odpowiedz = scanner.nextInt();
            if(odpowiedz == 1 || odpowiedz == 2 || odpowiedz == 3){
                chosenStructure = odpowiedz;
                choosingOperationTime();
                break;
            }
            else if (odpowiedz == 4) {

            }
            else {
                System.out.println("Podałeś błędną wartość!\n");
            }
        }
    }
    private static void choosingOperationTime(){
        while (true) {
            System.out.println("Jaką operację chcesz wykonać: \n 1 - Dodawanie \n 2 - Usuwanie \n 3 - Wyszukiwanie \n 4. Wróć");
            int odpowiedz = scanner.nextInt();
            if (odpowiedz == 1 ) {
                choosingAddingType();
                chosenOperation=odpowiedz;
                break;
            } else if (odpowiedz == 2) {
                choosingRemoveType();
                chosenOperation=odpowiedz;
                break;
            }
            if (odpowiedz == 3) {
                chosenOperation=odpowiedz;
            } else if (odpowiedz == 4) {
                choosingStructureTime();
            } else {
                System.out.println("Podałeś błędną wartość!\n");
            }
        }
    }
    private static void choosingRemoveType(){
        System.out.println("Jak chesz usuwać elemnty: \n 1 - Od początku \n 2 - Od końca \n 3 - w losowym miejscu \n 4. Wróć");
        int odpowiedz = scanner.nextInt();
        switch (odpowiedz){
            case 1 -> chosenRemove = 1;
            case 2 -> chosenRemove = 2;
            case 3 -> chosenRemove = 3;
            case 4 -> choosingOperationTime();
        }
        testingUsingFunctionsArray();
    }
    private static void choosingAddingType(){
        System.out.println("Jak chesz dodawać elementy: \n 1 - Od początku \n 2 - Od końca \n 3 - w losowym miejscu \n 4. Wróć");
        int odpowiedz = scanner.nextInt();
        switch (odpowiedz){
            case 1 -> chosenAdding = 1;
            case 2 -> chosenAdding = 2;
            case 3 -> chosenAdding = 3;
            case 4 -> choosingOperationTime();
        }
        testingUsingFunctionsArray();
    }
    private static void usingFunctionsTime(){
        choosingStructureTime();
        switch (chosenStructure) {
            case 1 -> testingUsingFunctionsArray();
            case 2 -> testingUsingFunctionsSinglyLinkedList();
            //case 3 -> testingUsingFunctionsDoublyLinkedList();
        }
    }
    private static void testingUsingFunctionsArray(){
        int randomValue = 0;
        switch (chosenOperation) {
            case 1 -> {
                switch (chosenAdding){
                    case 1 -> {
                        start_time = System.currentTimeMillis();
                        for(int i = 0; i<100000; i++){
                            randomValue = rand.nextInt(10000);
                            myArray.add(i, i);
                        }
                        end_time = System.currentTimeMillis();
                        int exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas dodawania do tablicy od początku wynosi: "+exc_time+"ms");
                    }
                    case 2 -> {
                        start_time = System.currentTimeMillis();
                        for(int i = 0; i < wantedSize; i++){
                            myArray.add(myArray.size(), i);
                        }
                        end_time = System.currentTimeMillis();
                        int exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas dodawania do tablicy od końca wynosi: "+exc_time+"ms");
                    }
                    case 3 ->{
                        int randomIndex;
                        start_time = System.currentTimeMillis();
                        while (myArray.size()!= 0){
                            for(int i = 0; i < wantedSize; i++){
                                randomIndex = rand.nextInt(myArray.size()+1);
                                myArray.add(randomIndex, i);
                            }
                        }
                        System.out.println(Arrays.toString(myArray.array));
                        end_time = System.currentTimeMillis();
                        int exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas dodawania do tablicy w losowym momęcie wynosi: "+exc_time+"ms");
                    }
                }
            }
            case 2 -> {
                switch (chosenRemove){
                    case 1 -> {
                        start_time = System.currentTimeMillis();
                        for(int i = 0; i<myArray.size(); i++){
                            myArray.removeFromEnd(myArray.get(i));
                        }
                        end_time = System.currentTimeMillis();
                        int exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas usuwania do tablicy od początku wynosi: "+exc_time+"ms");
                    }
                    case 2 -> {
                        while(myArray.size() > 0){
                            start_time = System.currentTimeMillis();
                            for(int i = myArray.size()-1; i >= 0;){
                                //System.out.println(i);
                                myArray.remove(myArray.get(i));
                                i-=myArray.howLess;
                            }
                            end_time = System.currentTimeMillis();
                            int exc_time = (int)(end_time-start_time);
                            System.out.println(Arrays.toString(myArray.array));
                            System.out.println("\nCzas usuwania do tablicy od końca wynosi: "+exc_time+"ms");
                        }
                    }
                    case 3 ->{
                        int randomIndex;
                        start_time = System.currentTimeMillis();
                        while (myArray.size()!= 0){
                            for(int i = 0; i<myArray.size(); i++){
                                randomIndex = rand.nextInt(myArray.size());
                                myArray.remove(myArray.get(randomIndex));
                            }
                        }
                        end_time = System.currentTimeMillis();
                        int exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas usuwania do tablicy w losowym momęcie wynosi: "+exc_time+"ms");
                    }
                }
            }
            case 3 -> {
                start_time = System.currentTimeMillis();
                for(int i = 0; i<100000; i++){
                    randomValue = rand.nextInt(100000);
                    myArray.search(randomValue);
                }
                end_time = System.currentTimeMillis();
                int exc_time = (int)(end_time-start_time);
                System.out.println("\nCzas szukania w tablicy wynosi: "+exc_time+"ms");
            }
        }
    }
    private static void testingUsingFunctionsSinglyLinkedList(){
        int randomValue = 0;
        switch (chosenOperation) {
            case 1 -> {
                start_time = System.currentTimeMillis();
                for(int i = 0; i<100000; i++){
                    randomValue = rand.nextInt(100000);
                    myLikedList.add(i, randomValue);
                }
                end_time = System.currentTimeMillis();
                int exc_time = (int)(end_time-start_time);
                System.out.println("Czas dodawania do listyjednokierunkowej wynosi: "+exc_time+"ms");
            }
            case 2 -> {
                switch (chosenRemove){
                    case 1 -> {
                        start_time = System.currentTimeMillis();
                        for(int i = 0; i < LinkedList.size; i++){
                            myLikedList.remove(myArray.get(i));
                        }
                        end_time = System.currentTimeMillis();
                        int exc_time = (int)(end_time-start_time);
                        System.out.println("Czas usuwania do tablicy od początku wynosi: "+exc_time+"ms");
                    }
                    case 2 -> {
                        while(myArray.size() > 0){
                            start_time = System.currentTimeMillis();
                            for(int i = 0; i < myArray.size(); i++){
                                myArray.remove(myArray.get(i));
                            }
                            end_time = System.currentTimeMillis();
                            int exc_time = (int)(end_time-start_time);
                            System.out.println("Czas usuwania do tablicy od końca wynosi: "+exc_time+"ms");
                        }
                    }
                    case 3 ->{
                        int randomIndex;
                        start_time = System.currentTimeMillis();
                        while (LinkedList.size != 0){
                            for(int i = 0; i< LinkedList.size; i++){
                                randomIndex = rand.nextInt(LinkedList.size);
                                myArray.remove(myArray.get(randomIndex));
                            }
                        }
                        end_time = System.currentTimeMillis();
                        int exc_time = (int)(end_time-start_time);
                        System.out.println("Czas usuwania do tablicy w losowym momęcie wynosi: "+exc_time+"ms");
                        System.out.println(myArray.toString());
                    }
                }
            }
            case 3 -> {
                start_time = System.currentTimeMillis();
                for(int i = 0; i<100000; i++){
                    randomValue = rand.nextInt(100000);
                    myArray.search(randomValue);
                }
                end_time = System.currentTimeMillis();
                int exc_time = (int)(end_time-start_time);
                System.out.println("Czas szukania w tablicy wynosi: "+exc_time+"ms");
            }
        }
    }
}
