package org.example.je;


public class StringTest {
    public static void main(String[] args) {

        /**
         * 1. 字符串不可修改
         * 2. 乱码可能是因为文件编码不一致导致
         * 3. 首字母大小写 substring(beginIndex, endIndex), substring(beginIndex)
         *    使用 System.arrayCopy实现
         * 4. equals
         *    先判断内存地址, 然后判断 char[] value 字符数是否相同, 最后逐字符比较
         * 5. replace, 从遇到的第一个等于oldChar的字符开始替换、执行替换
         */
        String t = "test"; // String类是final, value[]也是final, 不会被修改
      //  t = "t2"; // 会重新生成新的地址、相当于copy了一份
        t.replace(t, "aa"); // 不会修改原值, 修改后的值可以接收
        System.out.println(t);

//        String t1 = t.substring(0, 1); // t
//        String t2 = t.substring(1); // 1,到end
//        System.out.println(t1);
//        System.out.println(t2);
//        System.out.println(t1.equals(t2));
//        t = t.replace('t', 'a');
//        t = t.replaceFirst("/t/a/g", t);
//        t = t.replaceAll("/t/a/g", t);
//        System.out.println(t);

        String str ="hello word !!";
        System.out.println("替换之前 :" + str);
        str = str.replace('l','d');
        System.out.println("替换所有字符 " + str);
        str = str.replaceAll("d","l");
        System.out.println("替换全部 :{}" + str);
        str = str.replaceFirst("l","");
        System.out.println("替换第一个 l :{}" + str);

    }
}
