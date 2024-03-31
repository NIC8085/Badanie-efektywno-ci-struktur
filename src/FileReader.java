
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class FileReader {
    static Array myArray = new Array();
    static LinkedList myLikedList = new LinkedList();
    static DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();
    static long start_time = System.currentTimeMillis();
    static long end_time = System.currentTimeMillis();
    static int getValue;
    static int exc_time = 0;
    static int wantedSize = 100000;
    static File plik = new File("src/file.txt");
    public static void main(String[] args) throws FileNotFoundException {
        addingToArrayByFile();
        addingToLinkedListByFile();
        addingToDoublyListByFile();
    }
    public static void addingToArrayByFile() throws FileNotFoundException {
        Scanner readFile;
        readFile = new Scanner(plik);
        start_time = System.currentTimeMillis();
        for (int i = 0; i<wantedSize; i++){
            while(readFile.hasNext()){
                getValue = readFile.nextInt();
                myArray.add(i, getValue);
            }
        }
        end_time = System.currentTimeMillis();
        exc_time = (int)(end_time-start_time);
        System.out.println("\nCzas dodawania do tablicy od początku wynosi: "+exc_time+" ms");
    }
    public static void addingToLinkedListByFile() throws FileNotFoundException {
        Scanner readFile;
        readFile = new Scanner(plik);
        start_time = System.currentTimeMillis();
        for (int i = 0; i<wantedSize; i++) {
            while (readFile.hasNext()) {
                getValue = readFile.nextInt();
                myLikedList.add(i, getValue);
            }
        }
        end_time = System.currentTimeMillis();
        exc_time = (int)(end_time-start_time);
        System.out.println("\nCzas dodawania do listy jednokierunkowej od początku wynosi: "+exc_time+" ms");
    }
    public static void addingToDoublyListByFile() throws FileNotFoundException {
        Scanner readFile;
        readFile = new Scanner(plik);
        int index = 0;
        start_time = System.currentTimeMillis();
        for (int i = 0; i<wantedSize; i++) {
            while (readFile.hasNext()) {
                getValue = readFile.nextInt();
                myDoublyLinkedList.add(index, getValue);
            }
        }
        end_time = System.currentTimeMillis();
        exc_time = (int)(end_time-start_time);
        System.out.println("\nCzas dodawania do listy dwukierunkowej od początku wynosi: "+exc_time+" ms");
    }
}
