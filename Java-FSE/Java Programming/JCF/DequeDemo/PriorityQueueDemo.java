/*
 * Priority Queue maintains the natural ordering of the elements (for primitives lowest first).
 * It keeps the most prior element on the head according to natural ordering or custom comparator.
 */

 /*
  * Priority Queue is implemented using Min-Heap. In min-heap the value of the parent is less than or equal to the children.
  * So in min heap the insertion and deletion takes a time complexity of O(logn)
  * But the peek operation takes a time complexity of O(1)
  */

import java.util.PriorityQueue;

class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a,b) -> b-a);

        pq1.add(42);
        pq1.add(7);
        pq1.add(19);
        pq1.add(3);
        pq1.add(25);
        pq1.add(14);
        pq1.add(8);
        pq1.add(31);
        pq1.add(1);
        pq1.add(17);

        System.out.println(pq1);

        while(!pq1.isEmpty()){
            System.out.println(pq1.remove());
        }
    }
}