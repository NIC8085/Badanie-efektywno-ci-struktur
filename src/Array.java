import java.util.Arrays;

public class Array {
    public int[] array = new int[1];
    private int size = 0;

    public void add(int value) {
        if(size == array.length){
            int[] newArray = new int[array.length + 1];
            for(int i = 0; i<size; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = value;
        size++;
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