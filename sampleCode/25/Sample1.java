import java.sql.*;

public class Sample1
{
   public static void main(String args[])
   {
      try{
         //接続の準備
         String url = "jdbc:derby:cardb;create=true";
         String usr = "";
         String pw = "";

         //データベースへの接続
         Connection cn = DriverManager.getConnection(url, usr, pw);

         //問い合わせの準備
         DatabaseMetaData dm = cn.getMetaData();
         ResultSet tb = dm.getTables(null, null, "車表", null);

         Statement st = cn.createStatement();

         String qry1 = "CREATE TABLE 車表(番号 int, 名前 varchar(50))";
         String[] qry2 = {"INSERT INTO 車表 VALUES (2, '乗用車')",
                          "INSERT INTO 車表 VALUES (3, 'オープンカー')",
                          "INSERT INTO 車表 VALUES (4, 'トラック')"};
         String qry3 = "SELECT * FROM 車表";

         if(!tb.next()){
            st.executeUpdate(qry1);
            for(int i=0; i<qry2.length; i++){
               st.executeUpdate(qry2[i]);
            }
         }        

         //問い合わせ
         ResultSet rs = st.executeQuery(qry3);

         //データの取得
         ResultSetMetaData rm = rs.getMetaData();
         int cnum = rm.getColumnCount();
         while(rs.next()){
            for(int i=1; i<=cnum; i++){
                System.out.print(rm.getColumnName(i) +  ":"+ rs.getObject(i) + "  ");
            }
            System.out.println("");
         }

         //接続のクローズ
         rs.close();
         st.close();
         cn.close();
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }
}