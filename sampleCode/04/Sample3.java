import java.io.*;

class Sample3
{
   public static void main(String[] args) throws IOException
   {
      System.out.println("®”‚ğ2‚Â“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B");

      BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

      String str1 = br.readLine();
      String str2 = br.readLine();

      int num1 = Integer.parseInt(str1);
      int num2 = Integer.parseInt(str2);

      System.out.println("‚½‚µZ‚ÌŒ‹‰Ê‚Í" + (num1+num2) + "‚Å‚·B");
   }
}
