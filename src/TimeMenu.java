import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TimeMenu {
    private static final Array myArray = new Array();
    private static final LinkedList myLikedList = new LinkedList();
    private static final DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();
    private static final Random rand = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static int chosenStructure;
    private static int chosenOperation;
    public static int chosenMethod;
    private static int chosenGenerateMethod;
    private static int chosenAdding;
    private static int chosenRemove;
    private static int chosenRandomRange;
    private static int chosenRandomStartRange;
    private static int chosenRandomEndRange;
    private static long start_time = System.currentTimeMillis();
    private static long end_time = System.currentTimeMillis();
    private static int exc_time = 0;
    private static int wantedSize;
    private static int randomIndex;
    private static int odpowiedz;
    private static int getValue;
    private boolean back;

    public static void timemenu() throws FileNotFoundException {
        while(true){
            choosingStructureTime();
        }
    }
    private static void choosingStructureTime() throws FileNotFoundException {
        odpowiedz = 0;
        while (true){
            System.out.println("Podaj na jakiej strukturze danych chcesz operować: \n 1 - Tablica \n 2 - Lista jednokierunkowa \n 3 - Lista dwukierunkowa \n 4. Wróć");
            odpowiedz = scanner.nextInt();
            if(odpowiedz == 1 || odpowiedz == 2 || odpowiedz == 3){
                chosenStructure = odpowiedz;
                choosingOperationTime(); //
                break;
            }
            else if (odpowiedz == 4) {
                Main.mainMenu();
            }
            else {
                System.out.println("Podałeś błędną wartość!\n");
            }
        }
    }
    private static void choosingOperationTime() throws FileNotFoundException {
        odpowiedz = 0;
        while (true) {
            System.out.println("Jaką operację chcesz wykonać: \n 1 - Dodawanie \n 2 - Usuwanie \n 3 - Wyszukiwanie \n 4. Wróć");
            odpowiedz = scanner.nextInt();
            if (odpowiedz == 1 ) {
                chosenOperation=odpowiedz;
                choosingAddingMethod();
                break;
            } else if (odpowiedz == 2) {
                chosenOperation=odpowiedz;
                choosingRemoveType();
                break;
            }
            if (odpowiedz == 3) {
                chosenOperation=odpowiedz;
                break;
            } else if (odpowiedz == 4) {
                choosingStructureTime();
            } else {
                System.out.println("Podałeś błędną wartość!\n");
            }
        }
        usingFunctionsTime();
    }
    private static void choosingAddingMethod() throws FileNotFoundException {
        while (true){
            odpowiedz = 0;
            System.out.println("Jaką metodą chcesz dodać elementy: \n 1 - Z pliku \n 2 - Generowane \n 3 - Wróć");
            odpowiedz = scanner.nextInt();
            if (odpowiedz == 1){
                    chosenMethod = 1;
                    wantedSize=0;
                    Scanner readFile;
                    readFile = new Scanner(FileReader.plik);
                    while (readFile.hasNext()){
                        if(readFile.nextLine() != null){
                            wantedSize++;
                        }
                    }
                    if (wantedSize<=0){
                        System.out.println("Plik posiada niewystarczającą liczbę wierszy!\n");
                    }
                    else {
                        break;
                    }
            } else if (odpowiedz == 2) {
                chosenMethod = 2;
                while (true){
                    System.out.println("Podaj ile liczb chcesz dodać:");
                    odpowiedz = scanner.nextInt();
                    if(odpowiedz<=0){
                        System.out.println("Podano zbyt małą wartość!\n");
                    }
                    else {
                        wantedSize = odpowiedz;
                        choosingIfRandomlyGenerated(); //1 dół
                        break;
                    }
                }
                break;
            }
            else if (odpowiedz == 3){
                choosingOperationTime(); //1 góra
                break;
            }
            else {
                System.out.println("Podano niepoprawną wartość\n");
            }
        }
        choosingAddingType();
    }
    private static void choosingIfRandomlyGenerated() throws FileNotFoundException {
        odpowiedz = 0;
        while (true){
            System.out.println("Jakie liczby mają być generowane:\n 1 - Uporządkowane (np. 0-999)\n 2 - Losowe\n 3 - Wróć");
            odpowiedz = scanner.nextInt();
            if(odpowiedz <= 0 || odpowiedz > 3){
                System.out.println("Podano niepoprawną wartość!\n");
            } else if (odpowiedz == 3) {
                choosingAddingMethod();
            } else if (odpowiedz == 2){
                choosingRandomNumberRange(); //1 dół
                break;
            }
            else {
                break;
            }
        }
        chosenGenerateMethod = odpowiedz;
    }
    private static void choosingRandomNumberRange(){
        while (true){
            chosenRandomStartRange = 0;
            chosenRandomEndRange = 0;
            System.out.println("Podaj zakres generowanych liczb: \n Od:");
            chosenRandomStartRange = scanner.nextInt();
            System.out.println(" Do:");
            chosenRandomEndRange = scanner.nextInt();
            chosenRandomRange = chosenRandomEndRange - chosenRandomStartRange;
            if (chosenRandomRange<0){
                System.out.println("Podano zły zakres liczb\n");
            }
            else {
                chosenRandomRange++;
                break;
            }
        }
    }
    private static void choosingAddingType() throws FileNotFoundException {
        odpowiedz = 0;
        System.out.println("Jak chesz dodawać elementy: \n 1 - Od początku \n 2 - Od końca \n 3 - w losowym miejscu \n 4. Wróć");
        odpowiedz = scanner.nextInt();
        switch (odpowiedz){
            case 1 -> chosenAdding = 1;
            case 2 -> chosenAdding = 2;
            case 3 -> chosenAdding = 3;
            case 4 -> choosingOperationTime(); //4 góra
        }
    }
    private static void choosingRemoveType() throws FileNotFoundException {
        odpowiedz = 0;
        System.out.println("Jak chesz usuwać elemnty: \n 1 - Od początku \n 2 - Od końca \n 3 - w losowym miejscu \n 4. Wróć");
        odpowiedz = scanner.nextInt();
        switch (odpowiedz){
            case 1 -> chosenRemove = 1;
            case 2 -> chosenRemove = 2;
            case 3 -> chosenRemove = 3;
            case 4 -> choosingOperationTime(); //4 góra
        }
    }
    private static void usingFunctionsTime() throws FileNotFoundException {
        switch (chosenStructure) {
            case 1 -> testingUsingFunctionsArray();
            case 2 -> testingUsingFunctionsSinglyLinkedList();
            case 3 -> testingUsingFunctionsDoublyLinkedList();
        }
    }
    private static void testingUsingFunctionsArray() throws FileNotFoundException {
        int randomValue;
        switch (chosenOperation) {
            case 1 -> {
                switch (chosenAdding){
                    case 1 -> {
                        switch (chosenMethod){
                            case 1 -> {
                                Scanner readFile;
                                readFile = new Scanner(FileReader.plik);
                                start_time = System.currentTimeMillis();
                                for (int i = 0; i<wantedSize; i++){
                                    if (readFile.hasNext()){
                                        getValue = readFile.nextInt();
                                        myArray.add(i, getValue);
                                    }
                                }
                                end_time = System.currentTimeMillis();
                                exc_time = (int)(end_time-start_time);
                            }
                            case 2 -> {
                                switch (chosenGenerateMethod){
                                    case 1 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i<wantedSize; i++){
                                            myArray.add(i, i);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                    case 2 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i<wantedSize; i++){
                                            randomValue = rand.nextInt(chosenRandomRange);
                                            myArray.add(i, randomValue + chosenRandomStartRange);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                }
                            }
                        }
                        System.out.println(Arrays.toString(myArray.array));
                        System.out.println("\nCzas dodawania do tablicy od początku wynosi: "+exc_time+"ms");
                        System.out.println(myArray.array.length);
                    }
                    case 2 -> {
                        switch (chosenMethod){
                            case 1 -> {
                                Scanner readFile;
                                readFile = new Scanner(FileReader.plik);
                                start_time = System.currentTimeMillis();
                                for (int i = 0; i<wantedSize; i++){
                                    if (readFile.hasNext()){
                                        getValue = readFile.nextInt();
                                        myArray.add(myArray.size(), getValue);
                                    }
                                }
                                end_time = System.currentTimeMillis();
                                exc_time = (int)(end_time-start_time);
                            }
                            case 2 -> {
                                switch (chosenGenerateMethod){
                                    case 1 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i < wantedSize; i++){
                                            myArray.add(myArray.size(), i);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                    case 2 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i < wantedSize; i++){
                                            randomValue = rand.nextInt(chosenRandomEndRange);
                                            myArray.add(myArray.size(), randomValue + chosenRandomStartRange);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                }
                            }
                        }
                        System.out.println(Arrays.toString(myArray.array));
                        System.out.println("\nCzas dodawania do tablicy od końca wynosi: "+exc_time+"ms");
                    }
                    case 3 ->{
                        switch (chosenMethod){
                            case 1 -> {
                                Scanner readFile;
                                readFile = new Scanner(FileReader.plik);
                                start_time = System.currentTimeMillis();
                                for (int i = 0; i<wantedSize; i++){
                                    if (readFile.hasNext()){
                                        randomIndex = rand.nextInt(myArray.size()+1);
                                        getValue = readFile.nextInt();
                                        myArray.add(randomIndex, getValue);
                                    }
                                }
                                end_time = System.currentTimeMillis();
                                exc_time = (int)(end_time-start_time);
                            }
                            case 2 -> {
                                switch (chosenGenerateMethod){
                                    case 1 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i < wantedSize; i++){
                                            randomIndex = rand.nextInt(myArray.size()+1);
                                            myArray.add(randomIndex, i);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                    case 2 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i < wantedSize; i++){
                                            randomIndex = rand.nextInt(myArray.size()+1);
                                            randomValue = rand.nextInt(chosenRandomRange);
                                            myArray.add(randomIndex, randomValue + chosenRandomStartRange);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                }

                            }
                        }
                        System.out.println(Arrays.toString(myArray.array));
                        System.out.println("\nCzas dodawania do tablicy w losowym momęcie wynosi: "+exc_time+"ms");
                    }
                }
                chosenAdding = 0;
            }
            case 2 -> {
                switch (chosenRemove){
                    case 1 -> {
                        start_time = System.currentTimeMillis();
                        while (myArray.size()!=0) {
                            myArray.remove(myArray.get(0));
                        }
                        end_time = System.currentTimeMillis();
                        exc_time = (int)(end_time-start_time);
                        System.out.println(Arrays.toString(myArray.array));
                        System.out.println("\nCzas usuwania do tablicy od początku wynosi: "+exc_time+"ms");
                    }
                    case 2 -> {
                        while(myArray.size() > 0){
                            start_time = System.currentTimeMillis();
                            for(int i = myArray.size()-1; i >= 0;){
                                myArray.removeFromEnd(myArray.get(i));
                                i-=myArray.howLess;
                            }
                            end_time = System.currentTimeMillis();
                            exc_time = (int)(end_time-start_time);
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
                        exc_time = (int)(end_time-start_time);
                        System.out.println(Arrays.toString(myArray.array));
                        System.out.println("\nCzas usuwania do tablicy w losowym momęcie wynosi: "+exc_time+"ms");
                    }
                }
                chosenRemove = 0;
            }
            case 3 -> {
                start_time = System.currentTimeMillis();
                for(int i = 0; i<wantedSize; i++){
                    randomValue = rand.nextInt(chosenRandomRange);
                    System.out.println(myArray.search(randomValue + chosenRandomStartRange));
                }
                end_time = System.currentTimeMillis();
                exc_time = (int)(end_time-start_time);
                System.out.println("\nCzas szukania w tablicy wynosi: "+exc_time+"ms");
            }
        }
    }
    private static void testingUsingFunctionsSinglyLinkedList() throws FileNotFoundException {
        int randomValue;
        switch (chosenOperation) {
            case 1 -> {
                switch (chosenAdding){
                    case 1 -> {
                        switch (chosenMethod){
                            case 1 -> {
                                Scanner readFile;
                                readFile = new Scanner(FileReader.plik);
                                start_time = System.currentTimeMillis();
                                for (int i = 0; i<wantedSize; i++){
                                    if (readFile.hasNext()){
                                        getValue = readFile.nextInt();
                                        myLikedList.add(i, getValue);
                                    }
                                }
                                end_time = System.currentTimeMillis();
                                exc_time = (int)(end_time-start_time);
                            }
                            case 2 -> {
                                switch (chosenGenerateMethod){
                                    case 1 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i<wantedSize; i++){
                                            myLikedList.add(i, i);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                    case 2 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i<wantedSize; i++){
                                            randomValue = rand.nextInt(chosenRandomRange);
                                            myLikedList.add(i, randomValue + chosenRandomStartRange);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                }
                            }
                        }
                        myLikedList.print();
                        System.out.println("\nCzas dodawania do listyjednokierunkowej od początku wynosi: "+exc_time+"ms");
                    }
                    case 2 -> {
                        switch (chosenMethod){
                            case 1 -> {
                                Scanner readFile;
                                readFile = new Scanner(FileReader.plik);
                                start_time = System.currentTimeMillis();
                                for (int i = 0; i<wantedSize; i++){
                                    if (readFile.hasNext()){
                                        getValue = readFile.nextInt();
                                        myLikedList.add(LinkedList.size, getValue);
                                    }
                                }
                                end_time = System.currentTimeMillis();
                                exc_time = (int)(end_time-start_time);
                            }
                            case 2 -> {
                                switch (chosenGenerateMethod){
                                    case 1 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i < wantedSize; i++){
                                            myLikedList.add(LinkedList.size, i);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                    case 2 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i < wantedSize; i++){
                                            randomValue = rand.nextInt(chosenRandomRange);
                                            myLikedList.add(LinkedList.size, randomValue + chosenRandomStartRange);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                }
                            }
                        }
                        myLikedList.print();
                        System.out.println("\nCzas dodawania do listyjednokierunkowej od końca wynosi: "+exc_time+"ms");
                    }
                    case 3 ->{
                        switch (chosenMethod){
                            case 1 -> {
                                Scanner readFile;
                                readFile = new Scanner(FileReader.plik);
                                start_time = System.currentTimeMillis();
                                for (int i = 0; i<wantedSize; i++){
                                    if (readFile.hasNext()){
                                        randomIndex = rand.nextInt(LinkedList.size+1);
                                        getValue = readFile.nextInt();
                                        myLikedList.add(randomIndex, getValue);
                                    }
                                }
                                end_time = System.currentTimeMillis();
                                exc_time = (int)(end_time-start_time);
                            }
                            case 2 -> {
                                switch (chosenGenerateMethod){
                                    case 1 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i < wantedSize; i++){
                                            randomIndex = rand.nextInt(LinkedList.size +1);
                                            myLikedList.add(randomIndex, i);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                    case 2 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i < wantedSize; i++){
                                            randomIndex = rand.nextInt(LinkedList.size +1);
                                            randomValue = rand.nextInt(chosenRandomRange);
                                            myLikedList.add(randomIndex, randomValue + chosenRandomStartRange);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                }
                            }
                        }
                        myLikedList.print();
                        System.out.println("\nCzas dodawania do listyjednokierunkowej w losowym momęcie wynosi: "+exc_time+"ms");
                    }
                }
                chosenAdding = 0;
            }
            case 2 -> {
                switch (chosenRemove){
                    case 1 -> {
                        start_time = System.currentTimeMillis();
                        for(int i = 0; i < wantedSize; i++){
                            myLikedList.remove(myLikedList.get(0));
                        }
                        end_time = System.currentTimeMillis();
                        exc_time = (int)(end_time-start_time);
                        myLikedList.print();
                        System.out.println("\nCzas usuwania do listyjednokierunkowej od początku wynosi: "+exc_time+"ms");
                    }
                    case 2 -> {
                        //start_time = System.currentTimeMillis();
                        System.out.println("\nNie wiemy jak można usuwać od końca po liście jednokierunkowej według wartości \n");
                        //end_time = System.currentTimeMillis();
                        //exc_time = (int)(end_time-start_time);
                        //myLikedList.print();
                        //System.out.println("\nCzas usuwania do listyjednokierunkowej od końca wynosi: "+exc_time+"ms");
                    }
                    case 3 ->{
                        int randomIndex;
                        start_time = System.currentTimeMillis();
                        for(int i = 0; i< wantedSize; i++){
                            randomIndex = rand.nextInt(LinkedList.size);
                            myLikedList.remove(myLikedList.get(randomIndex));
                        }
                        end_time = System.currentTimeMillis();
                        exc_time = (int)(end_time-start_time);
                        myLikedList.print();
                        System.out.println("\nCzas usuwania do listyjednokierunkowej w losowym momęcie wynosi: "+exc_time+"ms");
                    }
                }
                chosenRemove = 0;
            }
            case 3 -> {
                start_time = System.currentTimeMillis();
                for(int i = 0; i<wantedSize; i++){
                    randomValue = rand.nextInt(chosenRandomRange);
                    myLikedList.search(randomValue+chosenRandomStartRange);
                }
                end_time = System.currentTimeMillis();
                exc_time = (int)(end_time-start_time);
                System.out.println("\nCzas szukania w listyjednokierunkowej wynosi: "+exc_time+"ms");
            }
        }
    }
    private static void testingUsingFunctionsDoublyLinkedList() throws FileNotFoundException {
        int randomValue;
        switch (chosenOperation) {
            case 1 -> {
                switch (chosenAdding){
                    case 1 -> {
                        switch (chosenMethod){
                            case 1 -> {
                                Scanner readFile;
                                readFile = new Scanner(FileReader.plik);
                                start_time = System.currentTimeMillis();
                                for (int i = 0; i<wantedSize; i++){
                                    if (readFile.hasNext()){
                                        getValue = readFile.nextInt();
                                        myDoublyLinkedList.add(i, getValue);
                                    }
                                }
                                end_time = System.currentTimeMillis();
                                exc_time = (int)(end_time-start_time);
                            }
                            case 2 -> {
                                switch (chosenGenerateMethod){
                                    case 1 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i<wantedSize; i++){
                                            myDoublyLinkedList.add(i, i);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                    case 2 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i<wantedSize; i++){
                                            randomValue = rand.nextInt(chosenRandomRange);
                                            myDoublyLinkedList.add(i, randomValue + chosenRandomStartRange);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                }
                            }
                        }
                        myDoublyLinkedList.print();
                        System.out.println("\nCzas dodawania do listydwukierunkowej od początku wynosi: "+exc_time+"ms");
                    }
                    case 2 -> {
                        switch (chosenMethod){
                            case 1 -> {
                                Scanner readFile;
                                readFile = new Scanner(FileReader.plik);
                                start_time = System.currentTimeMillis();
                                for (int i = 0; i<wantedSize; i++){
                                    if (readFile.hasNext()){
                                        getValue = readFile.nextInt();
                                        myArray.add(i, getValue);
                                    }
                                }
                                end_time = System.currentTimeMillis();
                                exc_time = (int)(end_time-start_time);
                            }
                            case 2 -> {
                                switch (chosenGenerateMethod){
                                    case 1 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i < wantedSize; i++){
                                            myDoublyLinkedList.add(DoublyLinkedList.size, i);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                    case 2 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i < wantedSize; i++){
                                            randomValue = rand.nextInt(chosenRandomRange);
                                            myDoublyLinkedList.add(DoublyLinkedList.size, randomValue + chosenRandomStartRange);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                }

                            }
                        }
                        myDoublyLinkedList.print();
                        System.out.println("\nCzas dodawania do listydwukierunkowej od końca wynosi: "+exc_time+"ms");
                    }
                    case 3 ->{
                        switch (chosenMethod){
                            case 1 -> {
                                Scanner readFile;
                                readFile = new Scanner(FileReader.plik);
                                start_time = System.currentTimeMillis();
                                for (int i = 0; i<wantedSize; i++){
                                    if (readFile.hasNext()){
                                        randomIndex = rand.nextInt(DoublyLinkedList.size +1);
                                        getValue = readFile.nextInt();
                                        myDoublyLinkedList.add(randomIndex, getValue);
                                    }
                                }
                                end_time = System.currentTimeMillis();
                                exc_time = (int)(end_time-start_time);
                            }
                            case 2 -> {
                                switch (chosenGenerateMethod){
                                    case 1 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i < wantedSize; i++){
                                            randomIndex = rand.nextInt(DoublyLinkedList.size +1);
                                            myDoublyLinkedList.add(randomIndex, i);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                    case 2 -> {
                                        start_time = System.currentTimeMillis();
                                        for(int i = 0; i < wantedSize; i++){
                                            randomIndex = rand.nextInt(DoublyLinkedList.size +1);
                                            randomValue = rand.nextInt(chosenRandomRange);
                                            myDoublyLinkedList.add(randomIndex, randomValue + chosenRandomStartRange);
                                        }
                                        end_time = System.currentTimeMillis();
                                        exc_time = (int)(end_time-start_time);
                                    }
                                }
                            }
                        }
                        System.out.println("\nCzas dodawania do listydwukierunkowej w losowym momęcie wynosi: "+exc_time+"ms");
                    }
                }
                chosenAdding = 0;
            }
            case 2 -> {
                switch (chosenRemove){
                    case 1 -> {
                        System.out.println(DoublyLinkedList.size);
                        start_time = System.currentTimeMillis();
                        for(int i = 0; i < wantedSize; i++){
                            myDoublyLinkedList.remove(myDoublyLinkedList.get(0));
                        }
                        end_time = System.currentTimeMillis();
                        myDoublyLinkedList.print();
                        exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas usuwania do listydwukierunkowej od początku wynosi: "+exc_time+"ms");
                    }
                    case 2 -> {
                        while(DoublyLinkedList.size > 0){
                            start_time = System.currentTimeMillis();
                            for(int i = wantedSize-1; i >= 0; i--){
                                myDoublyLinkedList.removeFromEnd(myDoublyLinkedList.get(i));
                            }
                            end_time = System.currentTimeMillis();
                            exc_time = (int)(end_time-start_time);
                            myDoublyLinkedList.print();
                            System.out.println("\nCzas usuwania do listydwukierunkowej od końca wynosi: "+exc_time+"ms");
                        }
                    }
                    case 3 ->{
                        int randomIndex;
                        start_time = System.currentTimeMillis();
                        for(int i = 0; i < wantedSize; i++){
                            randomIndex = rand.nextInt(DoublyLinkedList.size);
                            myDoublyLinkedList.remove(myDoublyLinkedList.get(randomIndex));
                        }
                        end_time = System.currentTimeMillis();
                        exc_time = (int)(end_time-start_time);
                        myDoublyLinkedList.print();
                        System.out.println("\nCzas usuwania do listydwukierunkowej w losowym momęcie wynosi: "+exc_time+"ms");
                    }
                }
                chosenRemove = 0;
            }
            case 3 -> {
                start_time = System.currentTimeMillis();
                for(int i = 0; i<wantedSize; i++){
                    randomValue = rand.nextInt(chosenRandomRange);
                    myDoublyLinkedList.search(randomValue+chosenRandomStartRange);
                }
                end_time = System.currentTimeMillis();
                exc_time = (int)(end_time-start_time);
                System.out.println("\nCzas szukania w listydwukierunkowej wynosi: "+exc_time+"ms");
            }
        }
    }
}