import java.io.*;

class SampleP3
{
   public static void main(String[] args) throws IOException
   {
      System.out.println("文字列を入力してください。");

      BufferedReader br =
       new BufferedReader(new InputStreamReader(System.in));

      String str1 = br.readLine();

      System.out.println("aの挿入位置を整数で入力してください。");

      String str2 = br.readLine();
      int num = Integer.parseInt(str2);

      StringBuffer str3 = new StringBuffer(str1);
      str3.insert(num, 'a');

      System.out.println(str3 + "になりました。");
   }
}
