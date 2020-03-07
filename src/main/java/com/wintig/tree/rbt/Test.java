package com.wintig.tree.rbt;

import com.wintig.queue.LinkedListQueue;
import com.wintig.queue.Queue;

/**
 * @Description
 * @Author wintig
 * @Create 2018-11-23 下午7:56
 */
public class Test {

    private static Queue<String> queue = new LinkedListQueue<String>();

    public static void change(Bottle bottle5, Bottle bottle6) {


        Integer subtractCapacity = bottle6.add(bottle5.currentCapacity);

        if (bottle5.currentCapacity != 3) {
            queue.enqueue("5 -> 6");
            return;
        }

    }


    /**
     * 出现3，一定是，主动排水的瓶子是满的，对方是不满不空。
     */
    public static void main(String[] args) {

        Bottle Bottle5 = new Bottle(5);
        Bottle Bottle6 = new Bottle(6);

        // 暴利解法1，先装满5
        Bottle5.init();
        change(Bottle5, Bottle6);

    }


}

class Bottle {

    // 当前容量
    public Integer currentCapacity;

    // 杯子最大容量
    public Integer maxCapacity;

    // 可接受的容量
    public Integer acceptCapacity;

    // 倒水
    public void subtract(Bottle bottle) {

    }

    // 加水
    public Integer add(Integer capacity) {

        Integer subtractCapaticy = 0;


        if (capacity > this.acceptCapacity) {

            subtractCapaticy = this.acceptCapacity;
            this.currentCapacity = maxCapacity;
            this.acceptCapacity = 0;

        } else if (capacity < this.acceptCapacity){

            subtractCapaticy = capacity;
            this.currentCapacity += subtractCapaticy;
            this.acceptCapacity = this.maxCapacity - this.currentCapacity;
        }

        return subtractCapaticy;
    }

    // 装满书
    public void init() {
        this.currentCapacity = maxCapacity;
        this.acceptCapacity = 0;
    }

    public Bottle(Integer maxCapacity) {
        this.currentCapacity = 0;
        this.acceptCapacity = 0;
        this.maxCapacity = maxCapacity;
    }
}