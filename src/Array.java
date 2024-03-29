import java.util.Arrays;

public class Array {
    public int[] array = new int[0];
    public int howLess;
    public void add(int index,int value) {
        int j = 0;
        int[] newArray = new int[array.length + 1];

        for(int i = 0; i<array.length+1; i++){
            if (i==index){
                newArray[i] = value;
                j++;
            }
            else {
                newArray[i] = array[i-j];
            }
        }
        array = newArray;
    }
    public int get(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Indeks poza zakresem");
        }
        return array[index];
    }

    public boolean search(int value){
        boolean isitThere = false;
        for(int i = 0; i < array.length;i++){
            if(get(i)==value) {
                isitThere = true;
                break;
            }
        }
        if(isitThere){
            return isitThere;
        }
        return false;
    }

    public void remove(int value){
        int counter = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i]==value){
                counter++;
            }
        }
        int[] helpArray = new int[array.length-counter];
        howLess = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] != value){
                helpArray[i-howLess]=array[i];
            }else {
                howLess++;
            }
        }
        array=helpArray;
    }
    public void removeFromEnd(int value){
        int counter = 0;
        for(int i = array.length-1; i >= 0; i--){
            if (array[i]==value){
                counter++;
            }
        }
        int[] helpArray = new int[array.length-counter];
        howLess = 0;
        for(int i = array.length-1; i >= 0; i--){
            if (array[i] != value){
                helpArray[i-howLess]=array[i];
            }else {
                howLess++;
            }

        }
        array=helpArray;
    }

    public int size() {
        return array.length;
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