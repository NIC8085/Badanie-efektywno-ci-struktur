import java.util.Arrays;

public class Array {
    public int[] array = new int[0];
    public int howLess;
    public void add(int index,int value) {
        int j = 0;
        int[] helpArray = new int[array.length + 1];

        for(int i = 0; i<array.length+1; i++){
            if (i==index){
                helpArray[i] = value;
                j++;
            }
            else {
                helpArray[i] = array[i-j];
            }
        }
        array = helpArray;
    }
    public int get(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Indeks poza zakresem");
        }
        return array[index];
    }

    public boolean search(int value){
        boolean isItThere = false;
        for(int i = 0; i < array.length;i++){
            if(get(i)==value) {
                isItThere = true;
                break;
            }
        }
        if(isItThere){
            return isItThere;
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
        int j = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] != value){
                helpArray[i-j]=array[i];
            }else {
                j++;
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
        int j = helpArray.length-1;
        for(int i = array.length-1; i >= 0; i--){
            if (array[i] != value){
                helpArray[j]=array[i];
                j--;
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