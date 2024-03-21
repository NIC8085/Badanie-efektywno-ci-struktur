public class Array {
    private int[] array = new int[1];
    private int size = 0;

    public void add(int value) {
        if(size == array.length){
            int[] newArray = new int[array.length * 2];
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
            System.out.println("Ta wartość znajduje się w tablicy");
        }
        else {
            System.out.println("Takiej wartoście nie ma w tablicy");
        }
    }

    public int size() {
        return size;
    }
}
