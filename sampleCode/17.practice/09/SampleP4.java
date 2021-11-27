class A
{
   A()
   {
      System.out.println("引数0のコンストラクタです。");
   }
   A(int a)
   {
      this();
      System.out.println("引数1のコンストラクタです。");
   }
}
class SampleP4
{
   public static void main(String[] args)
   {
      A a1 = new A();
      A a2 = new A(10);
   }
}