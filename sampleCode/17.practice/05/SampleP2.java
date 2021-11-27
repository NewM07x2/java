import java.io.*;

class SampleP2
{
   public static void main(String[] args) throws IOException
   {
      System.out.println("®”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B");

      BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

      String str = br.readLine();
      int res = Integer.parseInt(str);

      if((res % 2) == 0)
         System.out.println(res + "‚Í‹ô”‚Å‚·B");
      else
         System.out.println(res + "‚ÍŠï”‚Å‚·B");
   }
}
