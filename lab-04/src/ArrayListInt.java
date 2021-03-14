public class ArrayListInt {

    private static final int DEFAULT_CAPACITY = 10;
    private int[] data = new int[DEFAULT_CAPACITY];
    private int size;

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
          ensureCapacity();

      data[size] = x;
      ++size;
    }

    public void add(int index, int x) {
        rangeCheck(index);

        if(size==data.length)
            ensureCapacity();

        ++size;
        // Overwriting problem
        for(int i=size-1; i>index; --i)
            data[i] = data[i-1];

        data[index] = x;
    }

    public void remove(int index) {
        rangeCheck(index);
        if(size>0) {
            --size;
            for(int i = index; i < size; ++i)
                data[i] = data[i + 1];
        }
    }

    private void ensureCapacity() {
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
