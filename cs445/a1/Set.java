/*Andrew Sivaprakasam
  CS0441
  Assignment 1
  Description: This is an implementation of the SetInterface ADT
*/

package cs445.a1;

import java.util.Arrays;

public class Set<E> implements SetInterface<E> {
    private E[] contents;
    private int size;
    private static final int DEFAULT_CAPACITY = 20;

    public Set() {
        this(DEFAULT_CAPACITY);
    }

    public Set(int initialCapacity) {

       E[] tempSet = (E[]) new Object[initialCapacity];
        contents = tempSet;
        size = 0;
    }

    public Set(E[] contents2) {
        this(DEFAULT_CAPACITY);
        for (int i = 0; i < contents2.length; i++) {

                add(contents2[i]);

        }

    }

    public int getCurrentSize() {
        return size;
    }

    public boolean isEmpty() {

        boolean empty = false;

        if (size == 0) {
            empty = true;
        }

        return empty;
    }

    //Does NOT throw a SetFullException error because it is NOT FIXED CAPACITY
    public boolean add(E elem) throws IllegalArgumentException{
        boolean result = true;
        if(elem == null){
            result = false;
            throw new IllegalArgumentException("Invalid entry");
        }
        else {
            if (size >= contents.length) {
                contents = Arrays.copyOf(contents, contents.length * 2);
            }

            if (!contains(elem)) {
                contents[size] = elem;
                size++;
            }
        }
        return result;
    }

    public E remove() {

        E result = removeEntry(size - 1);
        return result;

    }

    public boolean remove(E anEntry) throws IllegalArgumentException{

        if(anEntry == null){
            throw new IllegalArgumentException("This does not exist. ");
        }
        else {
            int index = getIndexOf(anEntry);
            E result = removeEntry(index);
            return anEntry != null && anEntry.equals(result);
        }
    }

    public void clear() {
        for (int i = 0; i < contents.length; i++) {
            contents[i] = null;
        }

        size = 0;
    }

    public boolean contains(E entry) throws IllegalArgumentException{

            boolean contain = false;
            if(entry == null){
                throw new IllegalArgumentException();
            }

            else {
                for (int i = 0; i < size; i++) {

                    if (contents[i] == entry) {

                        contain = true;

                    }

                }
            }
            return contain;

            //throw new IllegalArgumentException("string");
    }

    //Note: this exports an Array of type OBJECT, so client must convert this
    public E[] toArray() {

        E[] output;
        output = Arrays.copyOf(contents,size);

        return output;

    }


    private int getIndexOf(E anEntry) {
        int where = -1;
        boolean found = false;
        int index = 0;

        while (!found && (index < size)) {
            if (anEntry != null && anEntry.equals(contents[index])) {
                found = true;
                where = index;
            }
            index++;
        }

        return where;
    }

    //Other methods I used
    private E removeEntry(int givenIndex) {
        E result = null;

        if (!isEmpty() && (givenIndex >= 0)) {
            // Entry to remove
            result = contents[givenIndex];
            int lastIndex = size - 1;
            // Replace entry to remove with last entry
            contents[givenIndex] = contents[lastIndex];
            // Remove reference to last entry
            contents[lastIndex] = null;
            size--;
        }

        return result;
    }


}