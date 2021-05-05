package zuoshen.linked_list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.DoubleToLongFunction;

/**
 * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
 */
public class list_1 {
    public static void main(String[] args) {

    }

    public void printCommonPart(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                head2 = head2.next;
            } else {
                System.out.print(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    public Node removeLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
        } else if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public DoubleNode removeLastKthDoubleNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
            head.last = null;
        } else if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            DoubleNode newNode = cur.next.next;
            cur.next = newNode;
            if (newNode != null) {
                newNode.last = cur;
            }
        }
        return head;
    }


    public Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public Node removeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil((double) (a * n) / (double) b);
        if (n == 1) {
            head = head.next;
        } else if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }


    public Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node pre = null;
        Node pos = null;
        while (node1 != null) {
            len++;
            pre = len == from - 1 ? node1 : pre;
            pos = len == to + 1 ? node1 : pos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len){
            return head;
        }
        node1 = pre == null ? head : pre.next;
        Node node2 = node1.next;
        node1.next = pos;
        Node next = null;
        while(node2 != pos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if(pre != null){
            pre.next = node1;
            return head;
        }
        return node1;
    }


    public Node josephusKill(Node head, int m){
        if(head == null || head.next == null || m < 1){
            return head;
        }
        Node last = head;
        while(last.next != head){
            last = last.next;
        }
        int count = 0;
        while(last != head){
            if(++count == m){
                last.next = head.next;
                count = 0;
            }else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }



   public boolean isPalindromel(Node head){
       Stack<Node> stack = new Stack<>();
       Node cur = head;
       while(cur != null){
           stack.push(cur);
           cur = cur.next;
       }
       while(head != null){
           if(head.val != stack.pop().val){
               return false;
           }
           head = head.next;
       }
       return true;
   }

   public boolean isPailndrome2(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while(cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }
       Stack<Node> stack = new Stack<>();
       while(right != null){
            stack.push(right);
            right = right.next;
        }
       while(!stack.isEmpty()){
           if(stack.pop().val != head.val){
               return false;
           }
           head = head.next;
       }
       return true;
   }


public Node listPartition(Node head, int pivot){
        if(head == null){
            return head;
        }
        Node cur = head;
        int i = 0;
        while(cur != null){
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for(i = 0; i < nodeArr.length; i++){
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr,pivot);
        for(i = 1; i < nodeArr.length; i++){
            nodeArr[i-1].next = nodeArr[i];
        }
        nodeArr[i-1].next = null;
        return nodeArr[0];
}

    private void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while(index != big){
            if(nodeArr[index].val < pivot){
                swap(nodeArr,++small,index++);
            }else if (nodeArr[index].val == pivot){
                index++;
            }else {
                swap(nodeArr,--big,index);
            }
        }
    }
    public void swap(Node[] nodeArr,int a,int b){
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    public Node listPartition2(Node head,int pivot){
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = null;
            if(head.val < pivot){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }
            else if(head.val == pivot){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }
            else {
                if(bH == null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        if(sT != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if(eT != null){
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }

  public Node listPartition3(Node head,int pivot){
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = null;
            if(head.val < pivot){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }
            else if(head.val == pivot){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }
            else {
                if(bH == null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        if(sT != null){
            sT.next = eH;
            eT = eT == null ? sT :eT;
        }
        if(eT != null){
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH :bH;
  }

public Node copyListWithRand1(Node head){
    HashMap<Node, Node> map = new HashMap<Node, Node>();
    Node cur = head;
    while(cur != null){
        map.put(cur,new Node(cur.val));
        cur = cur.next;
    }
    cur = head;
    while(cur != null){
        map.get(cur).next = map.get(cur.next);
        map.get(cur).rand = map.get(cur.rand);
        cur = cur.next;
    }
    return map.get(head);

}

public Node copyListWithRand2(Node head){
        if(head == null){
            return head;
        }
        Node cur = head;
        Node next = null;
        while(cur != null){
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        while(cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next :null;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        while(cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
}

public Node copyListWithRand3(Node head){
        if(head == null){
            return head;
        }
        Node cur = head;
        Node next = null;
        while(cur != null){
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        while(cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        cur = head;
        Node res = head.next;
        while(cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next :null;
            cur = next;
        }
        return res;

}


public Node addLists(Node head1,Node head2){
        head1 = reverseList2(head1);
        head2 = reverseList2(head2);
        int ca = 0;
         int n1 = 0;
         int n2 = 0;
         int n = 0;
          Node c1 = head1;
          Node c2 = head2;
          Node node = null;
          Node pre = null;
          while(c1 != null || c2 != null){
              n1 = c1 != null ? c1.val : 0;
              n2 = c2 != null ? c2.val : 0;
              n = n1 + n2 + ca;
              pre = node;
              node = new Node(n%10);
              node.next = pre;
              ca = n / 10;
              c1 = c1 != null ? c1.next : null;
              c2 = c2 != null ? c2.next : null;
          }
          if(ca == 1){
              pre = node;
              node = new Node(1);
              node.next = pre;
          }
          reverseList2(head1);
          reverseList2(head2);
          return node;
}
public Node reverseList2(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
}


public Node getLoopNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while(n1 != n2){
            if(n2.next == null || n2.next.next == null){
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while(n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
}

public Node noLoop(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int len = 0;
        while(cur1.next != null){
            len++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            len--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;
        }
        cur1 = len > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        len = Math.abs(len);
        while(len != 0){
            len--;
            cur1 = cur1.next;
        }
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;

}


public Node bothLoop(Node head1,Node loop1, Node head2, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while(cur1 != null){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != null){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while(n != 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            cur1 = loop1.next;
            while (cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
}

public Node getIntersectNode(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1 == null &&loop2 == null){
            return noLoop(head1,head2);
        }
        if(loop1 != null && loop2 != null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;

}

public Node reverseKNodes(Node head,int k){
        if(k < 2){
            return head;
        }
        Node newHead = head;
        Node cur = head;
        Node pre = null;
        Node next = null;
        Stack<Node> stack = new Stack<>();
        while(cur != null){
            next = cur.next;
            stack.push(cur);
            if(stack.size() == k){
                pre = resign1(stack,pre,next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;

}


    /**
     * 这个函数的作用就是将left到right的链表翻转，不包括left和right
     * @param stack
     * @param left
     * @param right
     * @return
     */
    public Node resign1(Stack<Node> stack,Node left,Node right){
        Node cur = stack.pop();
        if(left != null){
            left.next = cur;
        }
        Node next = null;
        while(!stack.isEmpty()){
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;

}



}


class DoubleNode {
    int val;
    DoubleNode last;
    DoubleNode next;

    public DoubleNode(int val) {
        this.val = val;
    }
}

class Node {
    int val;
    Node next;
    Node rand;

    public Node(int val) {
        this.val = val;
    }
}
