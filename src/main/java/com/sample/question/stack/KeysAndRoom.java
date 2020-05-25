package com.sample.question.stack;

import java.util.*;

/*
There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1,
and each room may have some keys to access the next room.

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1]
 where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0).

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:

Input: [[1],[2],[3],[]]
Output: true
Explanation:
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
Example 2:

Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
 */
public class KeysAndRoom {


    boolean canVisitAllRoomBfs(List<List<Integer>> rooms){
        int roomCount = rooms.size();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited.add(0);
        while(!q.isEmpty()){
            List<Integer> keys = rooms.get(q.poll());
            for(Integer i: keys){
                if(!visited.contains(i)){
                    q.add(i);
                    visited.add(i);
                }
            }
        }
        return roomCount == visited.size();

    }

    boolean canVisitAllRoomDfs(List<List<Integer>>rooms){
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(0);

        //At the beginning, we have a todo list "stack" of keys to use.
        //'seen' represents at some point we have entered this room.
        while (!stack.isEmpty()) { // While we have keys...
            int node = stack.pop(); // Get the next key 'node'
            for (int nei: rooms.get(node)) // For every key in room # 'node'...
                if (!seen[nei]) { // ...that hasn't been used yet
                    seen[nei] = true; // mark that we've entered the room
                    stack.push(nei); // add the key to the todo list
                }
        }

        for (boolean v: seen)  // if any room hasn't been visited, return false
            if (!v) return false;
        return true;

    }

    /*
    time complexity is O(N+E) N is no of room and E is total key
    space complexity is O(N) for stack
     */
}
