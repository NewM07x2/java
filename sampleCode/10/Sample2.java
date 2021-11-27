import java.io.*;

class Sample2
{
   public static void main(String[] args) throws IOException
   {
      System.out.println("‰pš‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B");

      BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

      String str = br.readLine();

      String stru = str.toUpperCase();
      String strl = str.toLowerCase();

      System.out.println("‘å•¶š‚É•ÏŠ·‚·‚é‚Æ" + stru + "‚Å‚·B");
      System.out.println("¬•¶š‚É•ÏŠ·‚·‚é‚Æ" + strl + "‚Å‚·B");
   }
}
