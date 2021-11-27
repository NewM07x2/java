import java.io.*;

class SampleP4
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

      int ans = Math.min(num1, num2);

      System.out.println(num1 + "‚Æ" + num2 + "‚Ì‚¤‚¿¬‚³‚¢‚Ù‚¤‚Í" + ans + "‚Å‚·B");
   }
}
