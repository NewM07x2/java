import java.io.*;

class SampleP2
{
   public static void main(String[] args) throws IOException
   {
      System.out.println("•¶š—ñ‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B");

      BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

      String str1 = br.readLine();
      StringBuffer str2 = new StringBuffer(str1);
      str2.reverse();

      System.out.println(str1 + "‚ğ‹t‡‚É‚·‚é‚Æ" + str2 + "‚Å‚·B");
   }
}
