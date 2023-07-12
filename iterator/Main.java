package iterator;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Integer[] exam = {1,2,3,4,5,6};
        ListExam<Integer> list = new ListExam<>(exam);
        for (Integer i:list){
            System.out.println(i);
        }
    }
}

class ListExam<T> implements Iterable<T>{
    private T[] data;

    public ListExam(T... e){
        this.data = Arrays.copyOf(e,e.length);
    }

    @Override
    public Iterator<T> iterator() {
        return new ListExamIter(data.length);
    }

    public class ListExamIter implements Iterator<T>{
        private int index;

        public ListExamIter(int len){
            index = len;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return data[this.index];
        }
    }
}
