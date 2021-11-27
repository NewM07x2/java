class Car extends Thread
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

            sleep(1000);
            System.out.println(name + "‚Ìˆ—‚ð‚µ‚Ä‚¢‚Ü‚·B");

         }
         catch(InterruptedException e){}
      } 
   }
}

class Sample3
{
   public static void main(String[] args)
   {
      Car car1 = new Car("1†ŽÔ");
      car1.start();

      for(int i=0; i<5; i++){

         System.out.println("main()‚Ìˆ—‚ð‚µ‚Ä‚¢‚Ü‚·B");

      }
   }
}
