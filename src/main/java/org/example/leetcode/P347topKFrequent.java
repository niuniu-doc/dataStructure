package org.example.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import java.util.LinkedList;
import java.util.TreeMap;

public class P347topKFrequent {
    private class Freq implements Comparable<Freq> {
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            if (this.freq < o.freq)
                return -1;
            else if (this.freq > o.freq)
                return 1;
            else
                return 0;
        }
    }

    class Solution {
        private class FreqComparator implements Comparator<Freq> {
            @Override
            public int compare(Freq o1, Freq o2) {
                return o1.freq - o2.freq;
            }
        }
        public int[] topKFrequent(int[] nums, int k)  {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }

            // Java 优先级队列默认是最小堆
            PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());
            for (int key : map.keySet()) {
                if (pq.size() < k)
                    pq.add(new Freq(key, map.get(key)));
                else if (map.get(key) > pq.peek().freq) {
                    pq.remove();
                    pq.offer(new Freq(key, map.get(key)));
                }
            }
            LinkedList<Integer> res = new LinkedList<>();
            while (!pq.isEmpty()) {
                res.add(pq.remove().e);
            }

            int[] ret = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                ret[i] = res.get(i);
            }
            return ret;
        }
    }
}
