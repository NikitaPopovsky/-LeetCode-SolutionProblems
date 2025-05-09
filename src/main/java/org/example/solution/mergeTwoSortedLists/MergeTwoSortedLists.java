package org.example.solution.mergeTwoSortedLists;

import java.util.*;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Аккуратное но долгое решение
        if (list1 == null && list2 == null) {
            return null;
        }
        ArrayList<Integer> generalList = new ArrayList<>();

        addToGeneralList(generalList, list1);
        addToGeneralList(generalList, list2);

        Collections.sort(generalList);

        return createResultListNide (generalList);
    }

    private static void addToGeneralList (ArrayList<Integer> generalList, ListNode node) {
        if (node == null) {
            return;
        }
        boolean nextNotEmpty = true;
        ListNode curNode = node;

        while (nextNotEmpty) {
            generalList.add(curNode.val);
            curNode = curNode.next;
            nextNotEmpty = curNode != null;
        }

    }

    private static ListNode createResultListNide (ArrayList<Integer> generalList) {
        ListNode resultNode = new ListNode();
        ListNode curNode = resultNode;
        int size = generalList.size() - 1;
        for (int i = 0; i <= size ; i++ ) {
            curNode.val = generalList.get(i);
            if (i != size) {
                curNode.next = new ListNode();
                curNode = curNode.next;
            }
        }

        return resultNode;
    }
}
