ArrayList Methods:





* **boolean add(E e):**

  * Appends the specified element to the end of this list. Returns true
* **void add(int index, E element):**

  * Inserts the specified element at the specified position in this list. Throws: IndexOutOfBoundsException
* **public boolean addAll(Collection<? extends E> c):**

  * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's Iterator. The behavior of this operation is undefined if the specified collection is modified while the operation is in progress. (This implies that the behavior of this call is undefined if the specified collection is this list, and this list is nonempty.). Returns: true if this list changed as a result of the call. Throws: NullPointerException – if the specified collection is null.
* **E set(int index, E element):**

  * Replaces the element at the specified position in this list with the specified element. Returns: the element previously at the specified position. Throws: IndexOutOfBoundsException
* **E remove(int index):**

  * Removes the element at the specified position in this list. Returns: the element that was removed from the list. Throws: IndexOutOfBoundsException
* **public boolean remove(Object o):**

  * Removes the first occurrence of the specified element from this list, if it is present. If the list does not contain the element, it is unchanged. More formally, removes the element with the lowest index i such that Objects.equals(o, get(i)) (if such an element exists). Returns true if this list contained the specified element (or equivalently, if this list changed as a result of the call)
* **public boolean removeAll(Collection<?> c)**:

  * Removes from this list all of its elements that are contained in the specified collection. Returns: true if this list changed as a result of the call. Throws: ClassCastException – if the class of an element of this list is incompatible with the specified collection (optional). NullPointerException – if this list contains a null element and the specified collection does not permit null elements (optional), or if the specified collection is null.
* **public boolean retainAll(Collection<?> c):**

  * Retains only the elements in this list that are contained in the specified collection. In other words, removes from this list all of its elements that are not contained in the specified collection. Returns: true if this list changed as a result of the call. Throws ClassCastException – if the class of an element of this list is incompatible with the specified collection (optional). Throws NullPointerException – if this list contains a null element and the specified collection does not permit null elements (optional), or if the specified collection is null
* **public void clear():**

  * Removes all of the elements from this list. The list will be empty after this call returns
* **public ArrayList(Collection<? extends E> c):**

  * Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator. Throws: NullPointerException if the specified collection is null
* **public E get(int index):**

  * Returns the element at the specified position in this list. Throws: IndexOutOfBoundsException
* **public boolean contains(Object o):**

  * Returns true if this list contains the specified element. More formally, returns true if and only if this list contains at least one element e such that Objects.equals(o, e)
* **public int indexOf(Object o):**

  * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element. More formally, returns the lowest index i such that Objects.equals(o, get(i)), or -1 if there is no such index.
* **public int lastIndexOf(Object o):**

  * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element. More formally, returns the highest index i such that Objects.equals(o, get(i)), or -1 if there is no such index.
* **public boolean isEmpty():**

  * Returns true if this list contains no elements
* **public void sort(Comparator<? super E> c):**

  * Sorts the elements of the list according to the order induced by the specified Comparator





Obs.:

* Transfomation: Arrays -> List

  * Arrays.asList():

    * **public static <T> List<T> asList(T... a):**

      * Returns a fixed-size list backed by the specified array. Changes made to the array will be visible in the returned list, and changes made to the list will be visible in the array. The returned list is Serializable and implements RandomAccess.The returned list implements the optional Collection methods, except those that would change the size of the returned list. Those methods leave the list unchanged and throw UnsupportedOperationException. If the specified array's actual component type differs from the type parameter T, this can result in operations on the returned list throwing an ArrayStoreException. Throws: NullPointerException – if the specified array is null
* List.of():

  * **static <E> List<E> of(E... elements):**

    * Returns an unmodifiable list containing an arbitrary number of elements.



* Transfomation: List -> Array

  * **public <T> T\[] toArray(T\[] a):**

    * This method takes one argument which should be an instance of a typed array. This method return an array of the same type. If the length of the array we pass has more elements than the list, extra elements will be filled with the default values for the type. If the length of the array we pass has less elements than the list, the method will still return an array, with the same number of elements in it, as the list





