class Node {
    int val;
    Node next;
    Node(int x){
        val = x;
        next = null;
    }
}

class Test{
    public static void main(String arg[]){
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        head.next.next.next.next.next = head;
        printList(head);
        System.out.println("insert at first");
        head = insertAtFirst(head,5);
        printList(head);
        System.out.println("insert at end");
        head =  insertAtLast(head, 60);
        printList(head);
        System.out.println("delete head");
        printList(deleteHead(head));
        System.out.println("delete Kth element from the Nodes");
        head = deleteKth(head,4);
        printList(head);
    }

    static Node insertAtFirst( Node head, int x){
        Node temp = new Node(x);
        if(head == null){
            temp.next =  temp;
            return temp;
        }
        else{
            temp.next = head.next;
            head.next = temp;
            int t = head.val;
            head.val = temp.val;
            temp.val = t;
        }
        return head;


    }
    static Node insertAtLast(Node head, int x){
        Node temp = new Node(x);
        if(head == null){
            temp.next = temp;
            return temp;
        }else{
            temp.next = head.next;
            head.next = temp;
            int t = temp.val;
            temp.val = head.val;
            head.val = t;
        }
        return temp;
    }
    static Node deleteHead(Node head){
        if(head == null) return null;
        if(head.next == null) return null;
        head.val = head.next.val;
        head.next = head.next.next;
        return head;

    }
    static Node deleteKth(Node head, int k){
        if(head == null) return null;
        if(k==1) return deleteHead(head);
        Node curr = head;
        for(int i =0; i< k-2; i++){
            curr = curr.next;

        }
        curr.next = curr.next.next;
        return head;

    }
    public static void printList(Node head){
        if(head == null){
            return;
        }
        Node r = head;
        do{
            System.out.print(r.val + " ");
            r=r.next;
        }
        while(r !=head);
        System.out.println();
    }

}

