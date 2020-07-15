package org.example.je;

import java.util.HashSet;
import java.util.Set;


public class A {
    private B b = new B();

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("a");
        set.add("b");
        set.add("c");
        System.out.println(String.join(",", set));


        // com.ichinait.service.validate.impl.CurrentBookingStartValidate@3e125afa
        // com.ichinait.service.validate.impl.CancelOrderRuleValidator$$EnhancerBySpringCGLIB$$16ec700e
//        A a = new A();
//        long num = 4321;
//        long ret = a.b.test(num);
//        System.out.println(ret);
    }
}

class B {
    private int a = 1234;
    static long C=111;
    public long test(long num) {
        long ret = this.a + C + num;
        return ret;
    }
}