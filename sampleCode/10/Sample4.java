import java.io.*;

class Sample4
{
   public static void main(String[] args) throws IOException
   {
      System.out.println("•¶š—ñ‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B");

      BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

      String str1 = br.readLine();

      System.out.println("’Ç‰Á‚·‚é•¶š—ñ‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B");

      String str2 = br.readLine();

      StringBuffer sb = new StringBuffer(str1);
      sb.append(str2);
      
      System.out.println(str1 + "‚É" + str2 + "‚ğ’Ç‰Á‚·‚é‚Æ" + sb + "‚Å‚·B");
   }
}
