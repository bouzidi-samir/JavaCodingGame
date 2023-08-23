package Palyndrome;

import java.util.*;

public class Solution {

    private int index;

    public Solution() {
        this.index = 0;
    }

    public int multiWithoutOperator(int x, int y) {

        int ret= 0;
        boolean isNeg = false;

        if ( x == 0 || y == 0)
            return 0;
        if ( x == 1 )
            return y;
        if ( y == 1 )
            return x;

        if (x < 0 && y > 0  || x > 0 && y < 0 ) {
            isNeg = true;
        }
        x = Math.abs(x);
        y = Math.abs(y);
    System.out.println(isNeg);
        for (int i = 0 ; i < y; i++ ) {
            ret = ret + x;
        }
        return  isNeg ? (ret - ret -ret) : ret;
    }


    public String reversString(String str) {

        String result = "";

        for (int i = str.length() - 1; i >= 0; i--)
            result=  result + str.charAt(i);

        return result;
    }


    public int computeClosestToZero(int[] ts) {
        if (ts == null || ts.length == 0) {
            throw new IllegalArgumentException("The input array must not be null or empty.");
        }

        int closestTemperature = ts[0];

        for (int temperature : ts) {
            if (Math.abs(temperature) < Math.abs(closestTemperature) ||
                    (Math.abs(temperature) == Math.abs(closestTemperature) && temperature > closestTemperature)) {
                closestTemperature = temperature;
            }
        }

        return closestTemperature;
    }

    public static int[] featureDuplicate(int[] dataArray) {
        // Create a LinkedHashSet to store unique values while preserving the order
        LinkedHashSet<Integer> uniqueValuesSet = new LinkedHashSet<>();

        // Add elements from the dataArray to the LinkedHashSet
        for (int value : dataArray) {
            uniqueValuesSet.add(value);
        }

        // Convert the LinkedHashSet back to an array
        int[] resultArray = new int[uniqueValuesSet.size()];
        int index = 0;
        for (int value : uniqueValuesSet) {
            resultArray[index++] = value;
        }

        return resultArray;
    }

    public class NetworkTraversal {
        public static int findLastNodeID(int startNodeId, int[] fromIds, int[] toIds) {
            // Create a map to represent the network as an adjacency list
            Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
            for (int i = 0; i < fromIds.length; i++) {
                int from = fromIds[i];
                int to = toIds[i];
                adjacencyList.putIfAbsent(from, new ArrayList<>());
                adjacencyList.get(from).add(to);
            }

            // Set to keep track of visited nodes during the traversal
            Set<Integer> visitedNodes = new HashSet<>();

            // Call the DFS method to find the last node ID
            return dfs(startNodeId, adjacencyList, visitedNodes);
        }

        private static int dfs(int currentNode, Map<Integer, List<Integer>> adjacencyList, Set<Integer> visitedNodes) {
            if (visitedNodes.contains(currentNode)) {
                // We encountered a loop, return the ID of the current node
                return currentNode;
            }

            // Mark the current node as visited
            visitedNodes.add(currentNode);

            // Traverse the neighbors of the current node recursively
            List<Integer> neighbors = adjacencyList.getOrDefault(currentNode, new ArrayList<>());
            int lastNode = currentNode;
            for (int neighbor : neighbors) {
                lastNode = dfs(neighbor, adjacencyList, visitedNodes);
            }

            return lastNode;
        }

        public static void main(String[] args) {
            int[] fromIds = {1, 2, 3, 4};
            int[] toIds = {2, 3, 4, 1};
            int startNodeId = 1;

            int lastNodeID = findLastNodeID(startNodeId, fromIds, toIds);
            System.out.println("Last Node ID: " + lastNodeID);
        }


    }
}