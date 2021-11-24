import javax.xml.crypto.Data;

/**
 * 基礎コード
 */
public class sample {
    public static void main(String[] args) {
        System.out.println("-- start --");
        Person person = new Person();
        person.name = "まさと";
        person.age = 12;
        // System.out.println("名前：" + person.name);
        // System.out.println("年齢：" + person.age);

        System.out.println("-- end --");
    }
}


class Person{
    String name;
    int age;

}