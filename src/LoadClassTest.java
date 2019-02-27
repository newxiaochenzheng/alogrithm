public class LoadClassTest {
    public static void main(String[] args) throws Exception {
     Class clz =  Class.forName("A");
        System.out.println("before new instance");
     clz.newInstance();
    }
}

class A {
    static int a = 3;
    static InnerA sInnerA;

    {
        System.out.println("A block "+a);
    }

    static {
        System.out.println("A static block");
    }

    public A() {
        System.out.println("A constructor");
    }

    public void methodA() {
        System.out.println("method A");
    }

    static class InnerA {
        {
            System.out.println("innerA block");
        }

        static {
            System.out.println("innerA static block");
        }
        InnerA(){
            System.out.println("innerA constructor");
        }
    }
}
