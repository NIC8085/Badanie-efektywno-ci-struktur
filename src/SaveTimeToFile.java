import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SaveTimeToFile {
    static long start_time = System.currentTimeMillis();
    static long end_time = System.currentTimeMillis();
    static Random rand = new Random();
    static int exc_time = 0;
    static int wantedSize = 100000;
    static FileWriter myWriter;
    static int howManyTest = 10;
    /*----------------------------Array----------------------------*/
    static int[] operationOnArrayStartTime = new int[howManyTest];
    static int[] operationOnArrayEndTime = new int[howManyTest];
    static int[] operationOnArrayRandomTime = new int[howManyTest];
    static int[] removeOnArrayStartTime = new int[howManyTest];
    static int[] removeOnArrayEndTime = new int[howManyTest];
    static int[] removeOnArrayRandomTime = new int[howManyTest];
    static int[] searchTimeArray = new int[howManyTest];
    /*----------------------------Linked List----------------------------*/
    static int[] operationOnLinkedStartTime = new int[howManyTest];
    static int[] operationOnLinkedEndTime = new int[howManyTest];
    static int[] operationOnLinkedRandomTime = new int[howManyTest];
    static int[] removeOnLinkedStartTime = new int[howManyTest];
    static int[] removeOnLinkedEndTime = new int[howManyTest];
    static int[] removeOnLinkedRandomTime = new int[howManyTest];
    static int[] searchTimeLinked = new int[howManyTest];
    /*----------------------------Doubly Linked List----------------------------*/
    static int[] operationOnDoublyStartTime = new int[howManyTest];
    static int[] operationOnDoublyEndTime = new int[howManyTest];
    static int[] operationOnDoublyRandomTime = new int[howManyTest];
    static int[] removeOnDoublyStartTime = new int[howManyTest];
    static int[] removeOnDoublyEndTime = new int[howManyTest];
    static int[] removeOnDoublyRandomTime = new int[howManyTest];
    static int[] searchTimeDoubly = new int[howManyTest];
    static {
        try {
            myWriter = new FileWriter("pomiar_czasu.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main() throws IOException {
        System.out.println("To może trochę potrwać daj temu chwilę");
        timeAddingToFile();
        System.out.println("Obliczanie dodawnia i usuwania jest już zrobione");
        timeSearchingToFile();
        System.out.println("Oblicznie wyszukiwania już zrobione");
        timeRemoveToFile();
        System.out.println("Wszystkie dane zostały przesłane do pliku pomiar_czasu.csv");
        myWriter.close();
        Main.mainMenu();
    }
    private static void timeRemoveToFile() throws IOException {
        myWriter.write("""
                \n Pomiar usuwanie z tablicy; Od poczatku; Od konca; w losowym miejscu; ;Pomiar usuwania z listy jednokierunkowej; Od poczatku; Od konca; w losowym miejscu ; ;Pomiar usuwania z listy dwukierunkowej; Od poczatku; Od konca; w losowym miejscu;
                """);
        for (int i = 0; i<howManyTest;i++) {
            String suma = "Pomiar "+ (i+1)+" :;"+ removeOnArrayStartTime[i]+" ;"+ removeOnArrayEndTime[i]+" ;"+ removeOnArrayRandomTime[i]+"; ;"+"Pomiar "+ (i+1)+" :;"+ removeOnLinkedStartTime[i]+" ;"+ removeOnLinkedEndTime[i]+" ;"+ removeOnLinkedRandomTime[i]+"; ;"+ "Pomiar "+ (i+1)+" :;"+ removeOnDoublyStartTime[i]+" ;"+ removeOnDoublyEndTime[i]+" ;"+ removeOnDoublyRandomTime[i]+" ;\n";
            myWriter.write(suma);
        }
    }
    public static void timeAddingToFile() throws IOException {
        addingToArrayFromStart();
        addingToArrayFromEnd();
        addingToArrayFromRandom();
        addingToLinkedListStart();
        addingToLinkedListEnd();
        addingToLinkedListRandom();
        addingToDoublyListStart();
        addingToDoublyListEnd();
        addingToDoublyListRandom();
        myWriter.write("""
                Pomiar dodawnia do tablicy; Od poczatku; Od konca; w losowym miejscu; ;Pomiar dodawnia do listy jednokierunkowej; Od poczatku; Od konca; w losowym miejscu ; ;Pomiar dodawnia do listy dwukierunkowej; Od poczatku; Od konca; w losowym miejscu;
                """);
        for (int i = 0; i<howManyTest;i++) {
            String suma = "Pomiar "+ (i+1)+" :;"+ operationOnArrayStartTime[i]+" ;"+ operationOnArrayEndTime[i]+" ;"+ operationOnArrayRandomTime[i]+"; ;"+"Pomiar "+ (i+1)+" :;"+ operationOnLinkedStartTime[i]+" ;"+ operationOnLinkedEndTime[i]+" ;"+ operationOnLinkedRandomTime[i]+"; ;"+ "Pomiar "+ (i+1)+" :;"+ operationOnDoublyStartTime[i]+" ;"+ operationOnDoublyEndTime[i]+" ;"+ operationOnDoublyRandomTime[i]+" ;\n";
            myWriter.write(suma);
        }
    }
    public static void timeSearchingToFile() throws IOException {
        searchArrayTime();
        searchLinkedTime();
        searchDoublyTime();
        myWriter.write("\n Pomiar szukania; Tablica;Lista Jednokierunowa; Lista Dwukierunkowa;\n");
        for(int i = 0; i<howManyTest;i++){
            String suma = "Pomiar "+ (i+1)+" :;"+ searchTimeArray[i]+" ;"+ searchTimeLinked[i] +" ;"+ searchTimeDoubly[i]+" ;\n";
            myWriter.write(suma);
        }
    }

    public static void searchArrayTime(){
        for(int j = 0; j<howManyTest;j++){
            Array myArray = new Array();
            start_time = System.currentTimeMillis();
            for(int i = 0; i<wantedSize; i++){
                myArray.search(i);
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            searchTimeArray[j] = exc_time;

        }
    }
    public static void searchLinkedTime(){
        for(int j = 0; j<howManyTest;j++){
            LinkedList myLinkedList = new LinkedList();
            start_time = System.currentTimeMillis();
            for(int i = 0; i<wantedSize; i++){
                myLinkedList.search(i);
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            searchTimeLinked[j] = exc_time;
        }
    }
    public static void searchDoublyTime(){
        for(int j = 0; j<howManyTest;j++){
            DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();
            start_time = System.currentTimeMillis();
            for(int i = 0; i<wantedSize; i++){
                myDoublyLinkedList.search(i);
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            searchTimeDoubly[j] = exc_time;
        }
    }
    public static void addingToArrayFromStart() {
        for(int j = 0; j<howManyTest;j++){
            Array myArray = new Array();
            start_time = System.currentTimeMillis();
            for(int i = 0; i<wantedSize; i++){
                myArray.add(i, i);
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            operationOnArrayStartTime[j] = exc_time;
            start_time = System.currentTimeMillis();
            for(int i = 0; i<wantedSize; i++){
                myArray.remove(myArray.get(0));
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            removeOnArrayStartTime[j] = exc_time;
        }
    }
    public static void addingToArrayFromEnd() {
        for(int j = 0; j<howManyTest;j++){
            Array myArray = new Array();
            start_time = System.currentTimeMillis();
            for(int i = 0; i < wantedSize; i++){
                myArray.add(myArray.size(), i);
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            operationOnArrayEndTime[j] = exc_time;
            start_time = System.currentTimeMillis();
            for(int i = myArray.size()-1; i >= 0;){
                myArray.removeFromEnd(myArray.get(i));
                i-=myArray.howLess;
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            removeOnArrayEndTime[j] = exc_time;
        }
    }
    public static void addingToArrayFromRandom() {
        for(int j = 0; j<howManyTest;j++){
            Array myArray = new Array();
            int randomIndex;
            start_time = System.currentTimeMillis();
            for(int i = 0; i < wantedSize; i++){
                randomIndex = rand.nextInt(myArray.size()+1);
                myArray.add(randomIndex, i);
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            operationOnArrayRandomTime[j] = exc_time;
            start_time = System.currentTimeMillis();
            while (myArray.size()!= 0){
                for(int i = 0; i<myArray.size(); i++){
                    randomIndex = rand.nextInt(myArray.size());
                    myArray.remove(myArray.get(randomIndex));
                }
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            removeOnArrayRandomTime[j] = exc_time;
        }
    }
    public static void addingToLinkedListStart() {
        for(int j = 0; j<howManyTest;j++){
            LinkedList myLikedList = new LinkedList();
            start_time = System.currentTimeMillis();
            for(int i = 0; i<wantedSize; i++){
                myLikedList.add(i, i);

            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            operationOnLinkedStartTime[j] = exc_time;
            start_time = System.currentTimeMillis();
            for(int i = 0; i < wantedSize; i++){
                myLikedList.remove(myLikedList.get(0));
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            removeOnLinkedStartTime[j] = exc_time;
        }
    }
    public static void addingToLinkedListEnd(){
        for(int j = 0; j<howManyTest;j++){
            LinkedList myLikedList = new LinkedList();
            start_time = System.currentTimeMillis();
            for(int i = 0; i < wantedSize; i++){
                myLikedList.add(LinkedList.size, i);
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            operationOnLinkedEndTime[j] = exc_time;
            start_time = System.currentTimeMillis();
            for(int i = LinkedList.size -1; i >= 0; i--){
                myLikedList.remove(myLikedList.get(i));
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            removeOnLinkedEndTime[j] = exc_time;
        }
    }
    public static void addingToLinkedListRandom(){
        for(int j = 0; j<howManyTest;j++){
            LinkedList myLikedList = new LinkedList();
            int randomIndex;
            start_time = System.currentTimeMillis();
            for(int i = 0; i < wantedSize; i++){
                randomIndex = rand.nextInt(LinkedList.size +1);
                myLikedList.add(randomIndex, i);
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            operationOnLinkedRandomTime[j] = exc_time;
            start_time = System.currentTimeMillis();
            for(int i = 0; i< wantedSize; i++){
                randomIndex = rand.nextInt(LinkedList.size);
                myLikedList.remove(myLikedList.get(randomIndex));
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            removeOnLinkedRandomTime[j] = exc_time;
        }
    }

    public static void addingToDoublyListStart(){
        for(int j = 0; j<howManyTest;j++){
            DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();
            start_time = System.currentTimeMillis();
            for(int i = 0; i<wantedSize; i++){
                myDoublyLinkedList.add(i, i);
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            operationOnDoublyStartTime[j] = exc_time;
            start_time = System.currentTimeMillis();
            for(int i = 0; i < wantedSize; i++){
                myDoublyLinkedList.remove(myDoublyLinkedList.get(0));
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            removeOnDoublyStartTime[j] = exc_time;
        }
    }
    public static void addingToDoublyListEnd(){
        for(int j = 0; j<howManyTest;j++){
            DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();
            start_time = System.currentTimeMillis();
            for(int i = 0; i < wantedSize; i++){
                myDoublyLinkedList.add(DoublyLinkedList.size, i);
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            operationOnDoublyEndTime[j] = exc_time;
            while(DoublyLinkedList.size > 0) {
                start_time = System.currentTimeMillis();
                for (int i = wantedSize - 1; i >= 0; i--) {
                    myDoublyLinkedList.removeFromEnd(myDoublyLinkedList.get(i));

                }
                end_time = System.currentTimeMillis();
                exc_time = (int) (end_time - start_time);
                removeOnDoublyEndTime[j] = exc_time;
            }
        }
    }
    public static void addingToDoublyListRandom(){
        for(int j = 0; j<10;j++){
            DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();
            int randomIndex;
            start_time = System.currentTimeMillis();
            for(int i = 0; i < wantedSize; i++){
                randomIndex = rand.nextInt(DoublyLinkedList.size +1);
                myDoublyLinkedList.add(randomIndex, i);
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            operationOnDoublyRandomTime[j] = exc_time;
            start_time = System.currentTimeMillis();
            for(int i = 0; i < wantedSize; i++){
                randomIndex = rand.nextInt(DoublyLinkedList.size);
                myDoublyLinkedList.remove(myDoublyLinkedList.get(randomIndex));
            }
            end_time = System.currentTimeMillis();
            exc_time = (int)(end_time-start_time);
            removeOnDoublyRandomTime[j] = exc_time;
        }
    }
}
