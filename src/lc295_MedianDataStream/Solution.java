package lc295_MedianDataStream;
/*
  Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

  For example,
  [2,3,4], the median is 3

  [2,3], the median is (2 + 3) / 2 = 2.5

  Design a data structure that supports the following two operations:

  void addNum(int num) - Add a integer number from the data stream to the data structure.
  double findMedian() - Return the median of all elements so far.


  Example:

  addNum(1)
  addNum(2)
  findMedian() -> 1.5
  addNum(3)
  findMedian() -> 2


  Follow up:

  If all integer numbers from the stream are between 0 and 100, how would you optimize it?
  If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> big;


    /** initialize your data structure here. */
    public MedianFinder() {
        this.small = new PriorityQueue<>(Collections.reverseOrder());
        this.big = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (big.size() == 0 || num >= big.peek()) {
            big.add(num);
            if (big.size() - 1 > small.size()) {
                small.add(big.poll());
            }
        } else {
            small.add(num);
            if (small.size() - 1 > big.size()) {
                big.add(small.poll());
            }
        }

    }

    public double findMedian() {
        if (small.size() > big.size()) {
            return small.peek();
        } else if (big.size() > small.size()) {
            return big.peek();
        } else if (small.size() == 0) {
            return 0;
        } else {
            return (big.peek() + small.peek()) * 0.5;
        }
    }
}
