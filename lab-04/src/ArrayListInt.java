public class ArrayListInt {

    private static final int DEFAULT_CAPACITY = 10;
    private int size = 10;
    private int[] data = new int[DEFAULT_CAPACITY];

    public ArrayListInt() { }

    public int size() {
        return size;
    }

    public int get(int i) {
        rangeCheck(i);
        return data[i];
    }

    public void set(int i, int v) {
        rangeCheck(i);
        data[i] = v;
    }

    public void add(int x) {
      if(size==data.length)
          grow();

      data[size++] = x;
    }

    public void add(int index, int x) {
        rangeCheck(index);

        if(size==data.length)
            grow();

        ++size; // Only needs to check the special condition size=index?
        for(int i=index; i<size-1; ++i)
            data[index+1] = data[index];
        data[index] = x;
    }

    public void remove(int index) {
        rangeCheck(index);
        --size;
        for(int i=index; i<size; ++i)
            data[index] = data[index+1];
    }

    private void grow() {
        int newCapacity = data.length + data.length/2;
        int[] newData = new int[newCapacity];

        for(int i=0; i<data.length; ++i)
            newData[i] = data[i];

        data = newData;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for(int i=0; i<size; ++i) {
            if(i!=0)
                result.append(", ");
            result.append(data[i]);
        }
        result.append("]");
        return result.toString();
    }

    private void rangeCheck(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("ArrayListInt: incorrect index: " + index);
    }
}
