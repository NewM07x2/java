class Car implements Runnable
{
   private String name;

   public Car(String nm)
   {
      name = nm;
   }
   public void run()
   {
      for(int i=0; i<5; i++){
         try{
            Thread.sleep(1000);
            System.out.println(name + "‚Ìˆ—‚ð‚µ‚Ä‚¢‚Ü‚·B");
         }
         catch(InterruptedException e){}
      } 
   }
}

class SampleP3
{
   public static void main(String[] args)
   {
      Car car1 = new Car("1†ŽÔ");

      Thread th1 = new Thread(car1);
      th1.start();

      for(int i=0; i<5; i++){
         System.out.println("main()‚Ìˆ—‚ð‚µ‚Ä‚¢‚Ü‚·B");
      } 
   }
}
