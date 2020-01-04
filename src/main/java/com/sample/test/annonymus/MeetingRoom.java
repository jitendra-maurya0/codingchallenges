package com.sample.test.annonymus;

import com.sample.test.interview.array.MeetingRooms;
import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_sv;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * given interval find if person can attend all meeting or not
 * e.g [[0,30],[5,10],[15,20]]
 * [s1,e1]
 * s1->starting time
 * e1-> ending time
 */
public class MeetingRoom {



    public static void main(String[] args) {
        Interval i1 = new Interval(0.0,30.0);
        Interval i2 = new Interval(5.0,10.0);
        Interval i3 = new Interval(15.0,20.0);
        // test case for platform
        Interval t1 = new Interval(9.00,9.10);
        Interval t2 = new Interval(9.40,12.00);
        Interval t3 = new Interval(9.50,11.20);
        Interval t4 = new Interval(11.00,11.30);
        Interval t5 = new Interval(15.00,19.00);
        Interval t6 = new Interval(18.00,20.00);
        Interval[]arr = {i1,i2,i3};
        Interval[]platforms = {t1,t2,t3,t4,t5,t6};
        MeetingRoom meetingRoom = new MeetingRoom();
        System.out.println(meetingRoom.canAttend(arr));
        System.out.println(meetingRoom.getMinRoom(arr));
        System.out.println(meetingRoom.minPlateformRequired(platforms));
    }

    public int getMinRoom(Interval[]intervals){
        Arrays.sort(intervals,Comparator.comparingDouble(i->i.startTime));
        PriorityQueue<Double> queue = new PriorityQueue<>();
        int count=0;
        for (Interval i:intervals){
            if(queue.isEmpty()){
                count++;
                queue.offer(i.endTime);
            }else{
                if(i.startTime >= queue.peek()){
                    queue.poll();
                }else{
                    count++;
                }
                queue.add(i.endTime);
            }
        }
        return count;
    }

    public int minPlateformRequired(Interval[]intervals){

        Arrays.sort(intervals,Comparator.comparingDouble(i->i.startTime));
        PriorityQueue<Double> q = new PriorityQueue<>();
        int count =0;
        for (Interval i: intervals) {

            if(q.isEmpty()){
                count++;
                q.add(i.endTime);
            }else{
                if(i.startTime >= q.peek()){
                    q.poll();
                }else{
                    count++;
                }
            }
        }
        return count;

    }

    private boolean canAttend(Interval[] arr) {
        Arrays.sort(arr, Comparator.comparingDouble(i->i.startTime));
        for (int i = 0; i <arr.length-1 ; i++) {
            if(arr[i].endTime > arr[i+1].startTime){
                return false;
            }
        }
        return true;
    }


}

class Interval{
    Double startTime;
    Double endTime;
    public Interval(Double startTime, Double endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Double getEndTime() {
        return endTime;
    }

    public void setEndTime(Double endTime) {
        this.endTime = endTime;
    }

    public Double getStartTime() {
        return startTime;
    }

    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }
}
