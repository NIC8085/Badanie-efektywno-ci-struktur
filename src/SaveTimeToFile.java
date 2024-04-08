import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class SaveTimeToFile {
    static long start_time = System.nanoTime();
    static long end_time = System.nanoTime();
    static int avg = 0;
    static Random rand = new Random();
    static int exc_time = 0;
    static int wantedSize = 10000;
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
            avg = 0;
            Array myArray = new Array();
            for(int i = 0; i<wantedSize; i++) {
                start_time = System.nanoTime();
                myArray.search(i);
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time - start_time);
                avg += exc_time;
            }
            searchTimeArray[j] = avg/wantedSize;
        }
    }
    public static void searchLinkedTime(){
        for(int j = 0; j<howManyTest;j++){
            avg = 0;
            LinkedList myLinkedList = new LinkedList();
            for(int i = 0; i<wantedSize; i++){
                start_time = System.nanoTime();
                myLinkedList.search(i);
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            searchTimeLinked[j] = avg/wantedSize;
        }
    }
    public static void searchDoublyTime(){
        for(int j = 0; j<howManyTest;j++){
            avg = 0;
            DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();
            for(int i = 0; i<wantedSize; i++){
                start_time = System.nanoTime();
                myDoublyLinkedList.search(i);
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            searchTimeDoubly[j] = avg/wantedSize;
        }
    }
    public static void addingToArrayFromStart() {
        for(int j = 0; j<howManyTest;j++){
            avg = 0;
            Array myArray = new Array();
            for(int i = 0; i<wantedSize; i++){
                start_time = System.nanoTime();
                myArray.add(i, i);
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            operationOnArrayStartTime[j] = avg/wantedSize;
            avg = 0;
            for(int i = 0; i<wantedSize; i++){
                start_time = System.nanoTime();
                myArray.remove(myArray.get(0));
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            removeOnArrayStartTime[j] = avg/wantedSize;
        }
    }
    public static void addingToArrayFromEnd() {
        for(int j = 0; j<howManyTest;j++){
            avg = 0;
            Array myArray = new Array();
            for(int i = 0; i < wantedSize; i++){
                start_time = System.nanoTime();
                myArray.add(myArray.size(), i);
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            operationOnArrayEndTime[j] = avg/wantedSize;
            avg = 0;
            for(int i = myArray.size()-1; i >= 0;){
                start_time = System.nanoTime();
                myArray.removeFromEnd(myArray.get(i));
                i-=myArray.howLess;
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            removeOnArrayEndTime[j] = avg/wantedSize;
        }
    }
    public static void addingToArrayFromRandom() {
        for(int j = 0; j<howManyTest;j++){
            avg = 0;
            Array myArray = new Array();
            int randomIndex;
            for(int i = 0; i < wantedSize; i++){
                start_time = System.nanoTime();
                randomIndex = rand.nextInt(myArray.size()+1);
                myArray.add(randomIndex, i);
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            operationOnArrayRandomTime[j] = avg/wantedSize;
            avg = 0;
            while (myArray.size()!= 0){
                start_time = System.nanoTime();
                for(int i = 0; i<myArray.size(); i++){
                    randomIndex = rand.nextInt(myArray.size());
                    myArray.remove(myArray.get(randomIndex));
                    end_time = System.nanoTime();
                    exc_time = Math.toIntExact(end_time-start_time);
                    avg += exc_time;
                }
                removeOnArrayRandomTime[j] = avg/wantedSize;
            }

        }
    }
    public static void addingToLinkedListStart() {
        for(int j = 0; j<howManyTest;j++){
            avg = 0;
            LinkedList myLikedList = new LinkedList();
            for(int i = 0; i<wantedSize; i++){
                start_time = System.nanoTime();
                myLikedList.add(i, i);
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            operationOnLinkedStartTime[j] = avg/wantedSize;
            avg = 0;
            for(int i = 0; i < wantedSize; i++){
                start_time = System.nanoTime();
                myLikedList.remove(myLikedList.get(0));
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            removeOnLinkedStartTime[j] = avg/wantedSize;
        }
    }
    public static void addingToLinkedListEnd(){
        for(int j = 0; j<howManyTest;j++){
            avg = 0;
            LinkedList myLikedList = new LinkedList();
            for(int i = 0; i < wantedSize; i++){
                start_time = System.nanoTime();
                myLikedList.add(LinkedList.size, i);
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            operationOnLinkedEndTime[j] = avg/wantedSize;
            avg = 0;
            for(int i = LinkedList.size -1; i >= 0; i--){
                start_time = System.nanoTime();
                myLikedList.remove(myLikedList.get(i));
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            removeOnLinkedEndTime[j] = avg/wantedSize;
        }
    }
    public static void addingToLinkedListRandom(){
        for(int j = 0; j<howManyTest;j++){
            avg = 0;
            LinkedList myLikedList = new LinkedList();
            int randomIndex;
            for(int i = 0; i < wantedSize; i++){
                start_time = System.nanoTime();
                randomIndex = rand.nextInt(LinkedList.size +1);
                myLikedList.add(randomIndex, i);
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            operationOnLinkedRandomTime[j] = avg/wantedSize;
            avg = 0;
            for(int i = 0; i< wantedSize; i++){
                start_time = System.nanoTime();
                randomIndex = rand.nextInt(LinkedList.size);
                myLikedList.remove(myLikedList.get(randomIndex));
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            removeOnLinkedRandomTime[j] = avg/wantedSize;
        }
    }

    public static void addingToDoublyListStart(){
        for(int j = 0; j<howManyTest;j++){
            avg = 0;
            DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();
            for(int i = 0; i<wantedSize; i++){
                start_time = System.nanoTime();
                myDoublyLinkedList.add(i, i);
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            operationOnDoublyStartTime[j] = avg/wantedSize;
            avg = 0;
            for(int i = 0; i < wantedSize; i++){
                start_time = System.nanoTime();
                myDoublyLinkedList.remove(myDoublyLinkedList.get(0));
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            removeOnDoublyStartTime[j] = avg/wantedSize;
        }
    }
    public static void addingToDoublyListEnd(){
        for(int j = 0; j<howManyTest;j++){
            avg = 0;
            DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();
            for(int i = 0; i < wantedSize; i++){
                start_time = System.nanoTime();
                myDoublyLinkedList.add(DoublyLinkedList.size, i);
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            operationOnDoublyEndTime[j] = avg/wantedSize;
            avg = 0;
            while(DoublyLinkedList.size > 0) {
                start_time = System.nanoTime();
                for (int i = wantedSize - 1; i >= 0; i--) {
                    myDoublyLinkedList.removeFromEnd(myDoublyLinkedList.get(i));
                    end_time = System.nanoTime();
                    exc_time = Math.toIntExact (end_time - start_time);
                    avg += exc_time;
                }
                removeOnDoublyEndTime[j] = avg/wantedSize;
            }
        }
    }
    public static void addingToDoublyListRandom(){
        for(int j = 0; j<howManyTest;j++){
            avg = 0;
            DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();
            int randomIndex;
            for(int i = 0; i < wantedSize; i++){
                randomIndex = rand.nextInt(DoublyLinkedList.size +1);
                start_time = System.nanoTime();
                myDoublyLinkedList.add(randomIndex, i);
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            operationOnDoublyRandomTime[j] = avg/wantedSize;
            avg = 0;
            for(int i = 0; i < wantedSize; i++){
                randomIndex = rand.nextInt(DoublyLinkedList.size);
                start_time = System.nanoTime();
                myDoublyLinkedList.remove(myDoublyLinkedList.get(randomIndex));
                end_time = System.nanoTime();
                exc_time = Math.toIntExact(end_time-start_time);
                avg += exc_time;
            }
            removeOnDoublyRandomTime[j] = avg/wantedSize;
        }
    }
}
