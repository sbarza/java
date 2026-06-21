public class Test extends Outer.Inner {

    public Test(Outer outer) {
        outer.super();
    }

    public void print() {
        System.out.println(this.x);

        class A {
            int x = 50;

        }

        class B extends A {
            void print() {
                System.out.println("In " + getClass().getName() + " x = " + this.x);
            }
        }

        new B().print();
    }

    public static void main(String[] args) {
        Test t = new Test(new Outer());
        t.print();
    }
}
