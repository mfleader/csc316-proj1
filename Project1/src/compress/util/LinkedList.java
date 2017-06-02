package compress.util;

/**
* This class models the state and behavior of a Linked List Stack
* @author Matthew F. Leader
*/
public class LinkedList {

	/** the first element in the collection */
    private Node front;
    /** size of the list */
    private int size;

    /**
     * Construct a Linked List
     */
    public LinkedList() {
    	front = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
    	return size;
    }

    /**
     * Add an item to the front, or if it is already on the list, then move
     * element the containing data equal to the parameter to the front.
     * @param data
     *              the data to add to the list
     */
    public void add(String data) {
    	if (front == null) {
    		front = new Node(data, null);
    		} else {
                front = new Node(data, front);
            }
            size++;
        }

    /**
     * Find a String on the list.
     *  @param data
     *  the String to look for on the list
     *  @return if the String is on the list, then return the index,
     *  otherwise return -1
     *  */
    public int find(String data) {
            int index = -1;
            for (Node k = front; k != null; k = k.next) {
                index++;
                if (k.data.equals(data)) {
                    return index;
                }
            }
            return -1;
        }

        /**
         * Remove a Node with the given data, if it exists
         * @param data
         *              the data to remove from the list
         * @return the Node removed from the list
         */
        private String remove(String data) {
            Node current = front;
            Node previous = null;
            while (current != null && !current.data.equals(data)) {
                previous = current;
                current = current.next;
            }
            if (current != null) {
                if (current == front) {
                    front = front.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.data;
            }
            return null;
        }

        /**
         * Convert the Linked List to an array
         * @return an array of the objects on the List
         */
        public String[] toArray() {
            String[] array = null;
            if (!isEmpty()) {
                array = new String[size];
                int k = 0;
                Node current = front;
                while (k < size && current != null) {
                    array[k] = current.data;
                    k++;
                    current = current.next;
                }
            }
            return array;
        }

        public String get(int index) {
            Node current = front;
            for (int k = 0; k < index; k++) {
                current = current.next;
            }
            if (current != null) {
                return current.data;
            }
            return null;
        }


        /**
         * Remove a Node at a given index
         * @param index
         *              the index of the element to remove from the list
         * @return the Node removed from the list
         */
        private Node remove(int index) {
            return null;
        }



        /**
         * This class models the state and behavior of a Node in the
         * LinkedList.
         */
        private class Node {

            /** the data within the element */
    		private String data;
    		/** a reference to the next element in the list */
    		private Node next;

            /**
             * Constructs a Node given data and a pointer to the next element.
             * @param data
             *              the data in this element
             * @param next
             *              the pointer to the next element
             */
            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }

            /**
             * Constructs a Node with null pointers
             * @param data
             *              the data in this element
             */
            public Node(String data) {
                this(data, null);
            }
        }
    

}
