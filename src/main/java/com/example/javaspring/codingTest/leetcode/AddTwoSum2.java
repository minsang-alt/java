package com.example.javaspring.codingTest.leetcode;

public class AddTwoSum2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 임시 노드 선언 => 새롭게 만들어진 리스트의 첫번째 노드를 기억하기 위한 노드이다
        ListNode node = new ListNode(0);

        // 임시 노드를 첫 번째 노드로 선언
        ListNode root = node;

        // 자릿수의 합(sum), 자리올림수(carry), 나머지(remainder)
        int sum, carry = 0, remainder;

        // 모든 연결리스트를 끝까지 순회하고, 자리올림수도 0이 될 때까지 진행
        while (l1 != null || l2 != null || carry != 0) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            //자리값 (나머지를 이용) 예를들어 5+8 이면 13인데 3은 자리값. 1은 carry(자리 올림수)
            remainder = (sum + carry) % 10;

            carry = (sum + carry) / 10;
            node.next = new ListNode(remainder);

            //계산할 노드를 다음으로 이동
            node = node.next;
        }

        //아까 첫번째 노드의 임시노드를 가르키는 root에서 다음으로 이동하고 리턴
        return root.next;
    }


}
