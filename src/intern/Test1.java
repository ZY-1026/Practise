package intern;

/**
 * 尽管在输出中调用intern方法并没有什么效果，
 * 但是实际上后台这个方法会做一系列的动作和操作。
 * 在调用”ab”.intern()方法的时候会返回”ab”，
 * 但是这个方法会首先检查字符串池中是否有”ab”这个字符串，
 * 如果存在则返回这个字符串的引用，
 * 否则就将这个字符串添加到字符串池中，
 * 然会返回这个字符串的引用。
 **/

public class Test1 {
    public static void main(String[] args) {
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");
        System.out.println(str5.equals(str3));
        System.out.println(str5 == str3);
        System.out.println(str5.intern() == str3);
        System.out.println(str5.intern() == str4);

        System.out.println("...................................................................");
        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = "a" + "b";
        String e = "b";
        String f = "a" + e;
        System.out.println(b.intern() == a);
        System.out.println(b.intern() == c);
        System.out.println(b.intern() == d);
        System.out.println(b.intern() == f);
        System.out.println(b.intern() == a.intern());
    }
}
