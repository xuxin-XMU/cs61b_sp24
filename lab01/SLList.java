public class SLList {
    public class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n){
                item = i;
                next = n;
            }
    }

    /** Creates an empty SLList. */
    /* public SLList(){
        IntNode first = null;
        size = 0;
    }
    */

    private IntNode sentinel;
    private int size;

    public SLList(){
        sentinel = new IntNode(63, null);
        size +=1;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x){
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** Retrieves the front item from the list. */
    public int getFirst(){
        return sentinel.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x){
        sentinel.next = new IntNode(x, null);
        size += 1;
    }

    /** Returns the size of the list that starts at IntNode p. */
    /*
    public static int size(IntNode p){

        if (p.next == null){
            return 1;
        }
        return 1 + size(p.next);
    }
    public int size(){
        return size(first);
    }
     */

    public int size(){
        return size;
    }

    /** Overrides toString method to return list elements as a string. */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        IntNode p = sentinel;
        while (p != null) {
            sb.append(p.item).append(" -> ");
            p = p.next;
        }
        sb.append("null"); // Marks the end of the list.
        return sb.toString();
    }


    public static void main(String[] args){
        SLList L = new SLList();
        L.addLast(20);
        System.out.println(L);
        System.out.println(L.size());
    }
}
