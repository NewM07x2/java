class MyPoint
{
   private int x;
   private int y;

   public MyPoint()
   {
      x = 0;
      y = 0;
   }
   public MyPoint(int px, int py)
   {
      x = px;
      y = py;
   }
   public void setX(int px)
   {
      if(px >= 0 && px <=100)
         x = px;
   }
   public void setY(int py)
   {
      if(py >= 0 && py <=100)
         y = py;
   }
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
}

class SampleP5
{
   public static void main(String[] args)
   {
      MyPoint p1;
      p1 = new MyPoint();
      p1.setX(10);
      p1.setY(5);

      int px1 = p1.getX();
      int py1 = p1.getY();
      
      System.out.println("p1のX座標は" + px1 + "Y座標は" + py1 + "でした。");

      MyPoint p2;
      p2 = new MyPoint(20,10);

      int px2 = p2.getX();
      int py2 = p2.getY();

      System.out.println("p2のX座標は" + px2 + "Y座標は" + py2 + "でした。");
   }
}
