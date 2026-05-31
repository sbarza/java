**LinkedList Methods:**



* Besides List interface, LinkedList also implements the **Queue** and **Stack** methods as well. So, all methods seen in the ArrayList are implemented in the LinkedList, as well.



* **Queue is a First-In, First-Out (FIFO) Data Collection**

  * offer(): Inserts at tail  (we offer it onto the queue)
  * poll(): Removes From head (we poll the queue)



* Single-ended queues always process elements from the start (head) of the queue
* Double-ended queues allow access to both the start (head) and end (tail) of the queue
* A LinkedList can be uses as a double-ended queue.



* **Stack is a Last-In, First-Out (LIFO) Data Collection**

  * push(): Inserts at top of stack (we push it onto the stack)
  * pop(): Removes from the top of stack (we pop it from the stack)
* A LinkedList can be used as a stack as well





* **LinkedList's exclusive methods**

  * **public void addFirst(E e):**

    * Inserts the specified element at the beginning of this list.
  * **public void addLast(E e):**

    * Appends the specified element to the end of this list. *This method is equivalent to add.*
  * **public E remove():**

    * Retrieves and removes the head (first element) of this list. Returns the head of this list. Throws NoSuchElementException – if this list is empty
  * **public E removeFirst():**

    * Removes and returns the first element from this list. Returns the first element from this list. Throws NoSuchElementException – if this list is empty. *This method is equivalent to remove().*
  * **public E removeLast():**

    * Removes and returns the last element from this list. Returns the last element from this list. Throws NoSuchElementException – if this list is empty
  * **public E getFirst():**

    * Returns the first element in this list. Throws NoSuchElementException – if this list is empty
  * **public E getLast():**

    * Returns the last element in this list. Throws: NoSuchElementException – if this list is empty



* **Queue methods:**

  * **public boolean offer(E e):**

    * Adds the specified element as the tail (last element) of this list. Returns true
  * **public boolean offerFirst(E e):**

    * Inserts the specified element at the front of this list. Returns true
  * **public boolean offerLast(E e):**

    * Inserts the specified element at the end of this list. *This method is equivalent to offer().*
  * **public E poll():**

    * Retrieves and removes the head (first element) of this list. Returns the head of this list, or null if this list is empty
  * **public E pollFirst():**

    * Retrieves and removes the first element of this list, or returns null if this list is empty. Returns the first element of this list, or null if this list is empty. *This method is equivalent to poll()*
  * **public E pollLast():**

    * Retrieves and removes the last element of this list, or returns null if this list is empty. Returns the last element of this list, or null if this list is empty
  * **public E element():**

    * Retrieves, but does not remove, the head (first element) of this list. Returns: the head of this list. Throws: NoSuchElementException – if this list is empty 



* **Stack methods:**

  * **public void push(E e):**

    * Pushes an element onto the stack represented by this list. In other words, inserts the element at the front of this list. This method is equivalent to addFirst.
    * **public E pop():**

      * Pops an element from the stack represented by this list. In other words, removes and returns the first element of this list. *This method is equivalent to removeFirst()*. Returns: the element at the front of this list (which is the top of the stack represented by this list). Throws: NoSuchElementException – if this list is empty
    * **public E peek():**

      * Retrieves, but does not remove, the head (first element) of this list. Returns: the head of this list, or null if this list is empty
    * **public E peekFirst():**

      * Retrieves, but does not remove, the first element of this list, or returns null if this list is empty. Returns the first element of this list, or null if this list is empty
    * **public E peekLast():**

      * Retrieves, but does not remove, the last element of this list, or returns null if this list is empty. Returns the last element of this list, or null if this list is empty



