class A
{
   A()
   {
      System.out.println("Aの引数0のコンストラクタです。");
   }
   A(int a)
   {
      System.out.println("Aの引数1のコンストラクタです。");
   }
}
class B extends A
{
   B()
   {
      System.out.println("Bの引数0のコンストラクタです。");
   }
   B(int b)
   {
      super(b);
      System.out.println("Bの引数1のコンストラクタです。");
   }
}

class SampleP3
{
   public static void main(String[] args)
   {
      B b1 = new B();
      B b2 = new B(10);
   }
}