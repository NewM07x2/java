import java.io.*;

class SampleP5
{
   public static void main(String[] args) throws IOException
   {
      System.out.println("2ˆÈã‚Ì®”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B");

      BufferedReader br =
       new BufferedReader(new InputStreamReader(System.in));

      String str = br.readLine();
      int num = Integer.parseInt(str);

       for(int i=2; i<=num; i++){
          if(i == num){
             System.out.println(num + "‚Í‘f”‚Å‚·B");
           }
           else if(num % i == 0){
             System.out.println(num + "‚Í‘f”‚Å‚Í‚ ‚è‚Ü‚¹‚ñB");
             break;
           }
       }
   }
}