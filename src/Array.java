import java.util.Arrays;

public class Array {
    public int[] array = new int[0];
    public static int size = 0;

    public void add(int index,int value) {
        System.out.println(Arrays.toString(array));

        int j = 0;
        size++;
        int[] newArray = new int[array.length + 1];

        for(int i = 0; i<size; i++){
            if (i==index){
                newArray[i] = value;
                j++;
            }
            else {
                newArray[i] = array[i-j];
            }
        }
        array = newArray;
        System.out.println(Arrays.toString(array));
    }
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indeks poza zakresem");
        }
        return array[index];
    }

    public void search(int value){
        boolean isitThere = false;
        for(int i = 0; i < size;i++){
            if(get(i)==value) {
                isitThere = true;
                break;
            }
        }
        if(isitThere){
            System.out.println("\n");
            System.out.println("Ta wartość znajduje się w tablicy");
            System.out.println("\n");
        }
        else {
            System.out.println("\n");
            System.out.println("Takiej wartoście nie ma w tablicy");
            System.out.println("\n");
        }
    }

    public void remove(int value){
        int counter = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i]==value){
                counter++;
            }
        }
        int[] helpArray = new int[array.length-counter];
        int j = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] != value){
                helpArray[i-j]=array[i];
                System.out.println("nig");
            }else {
                j++;
            }

        }
        array=helpArray;
        size-=counter;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "Array{" +
                "array=" + Arrays.toString(array) +
                ", size=" + array.length +
                '}';
    }
}
//{}