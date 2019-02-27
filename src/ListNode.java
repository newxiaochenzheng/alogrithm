public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(8);
//        ListNode l2 = new ListNode(1);
//        ListNode p = addTwoNumbers(l1, l2);
//        while (p != null) {
//            System.out.println(p.val);
//            p = p.next;
//        }
//        IPerson person = new PersonImpl();
//        System.out.println(person.val);
//        person.read();
//        person = new AnimalImpl();
//        person.read();
        System.out.println(Math.round(1.2f));
        System.out.println(Math.round(1.5f));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode h = new ListNode(0);
        ListNode p = h;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            p = p.next;
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return h.next;
    }

    public static int sumMethods(int step) {
        if (step < 1) {
            return 0;
        }
        if (step <= 2) {
            return step;
        }
        int temp = 0;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= step; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }


}

interface IPerson {
    int val = 1;

    void read();
}

class PersonImpl implements IPerson {

    @Override
    public void read() {
        System.out.println("personImpl:"+val);
    }
}

class AnimalImpl implements IPerson {
    @Override
    public void read() {
        System.out.println("AnimalImpl"+val);
    }
}