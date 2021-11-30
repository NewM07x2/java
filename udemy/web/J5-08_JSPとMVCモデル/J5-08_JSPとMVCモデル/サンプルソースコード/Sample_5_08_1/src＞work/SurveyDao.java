package work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;

/**----------------------------------------------------------------------*
 *■■■SurveyDaoクラス■■■
 *概要：DAO（「survey」テーブル）
 *----------------------------------------------------------------------**/
public class SurveyDao {
	//-------------------------------------------
	//データベースへの接続情報
	//-------------------------------------------

	//JDBCドライバの相対パス
	//※バージョンによって変わる可能性があります（MySQL5系の場合は「com.mysql.jdbc.Driver」）
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	//接続先のデータベース
	//※データベース名が「test_db」でない場合は該当の箇所を変更してください
	String JDBC_URL    = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";

	//接続するユーザー名
	//※ユーザー名が「test_user」でない場合は該当の箇所を変更してください
	String USER_ID     = "test_user";

	//接続するユーザーのパスワード
	//※パスワードが「test_pass」でない場合は該当の箇所を変更してください
	String USER_PASS   = "test_pass";


	//----------------------------------------------------------------
	//メソッド
	//----------------------------------------------------------------

	/**----------------------------------------------------------------------*
	 *■doSelectBySatisfactionLevelメソッド
	 *概要　：「survey」テーブルからアンケートデータを全件抽出する
	 *引数　：なし
	 *戻り値：抽出リスト（List<SurveyDto>型）
	 *----------------------------------------------------------------------**/
	public List<SurveyDto> doSelectBySatisfactionLevel( String sl) {

		//-------------------------------------------
		//JDBCドライバのロード
		//-------------------------------------------
		try {
			Class.forName(DRIVER_NAME);       //JDBCドライバをロード＆接続先として指定
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//-------------------------------------------
		//SQL発行
		//-------------------------------------------

		//JDBCの接続に使用するオブジェクトを宣言
		//※finallyブロックでも扱うためtryブロック内で宣言してはいけないことに注意
		Connection        con = null ;   // Connection（DB接続情報）格納用変数
		PreparedStatement ps  = null ;   // PreparedStatement（SQL発行用オブジェクト）格納用変数
		ResultSet         rs  = null ;   // ResultSet（SQL抽出結果）格納用変数

		//抽出リスト（List<SurveyDto>型）格納用変数
		//※最終的にreturnするため、tryブロック内で宣言してはいけないことに注意
		List<SurveyDto> selectDataList = new ArrayList<SurveyDto>();

		try {

			//-------------------------------------------
			//接続の確立（Connectionオブジェクトの取得）
			//-------------------------------------------
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);

			//-------------------------------------------
			//SQL文の送信 ＆ 結果の取得
			//-------------------------------------------

			//発行するSQL文の生成（SELECT）
			StringBuffer buf = new StringBuffer();
			buf.append(" SELECT                   ");
			buf.append("   NAME,                  ");
			buf.append("   AGE,                   ");
			buf.append("   SEX,                   ");
			buf.append("   SATISFACTION_LEVEL,    ");
			buf.append("   MESSAGE,               ");
			buf.append("   TIME                   ");
			buf.append(" FROM                     ");
			buf.append("   SURVEY                 ");
			buf.append(" WHERE                    ");
			buf.append("   SATISFACTION_LEVEL = ? ");
			buf.append(" ORDER BY                 ");
			buf.append("   TIME                   ");

			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());

			//パラメータをセット
			ps.setString(1, sl);

			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeQuery();

			//--------------------------------------------------------------------------------
			//ResultSetオブジェクトから全件抽出して抽出リスト（List<SurveyDto>型）に格納
			//--------------------------------------------------------------------------------
			while (rs.next()) {

				//DTO（「survey」テーブル）の生成
				SurveyDto dto = new SurveyDto();

				//ResultSetから1行分のレコード情報をDTOへ登録
				dto.setName( rs.getString( "NAME" ) );
				dto.setAge( rs.getInt( "AGE" ) );
				dto.setSex( rs.getInt( "SEX" ) );
				dto.setSatisfactionLevel( rs.getInt( "SATISFACTION_LEVEL" ) );
				dto.setMessage( rs.getString( "MESSAGE" ) );
				dto.setTime( rs.getTimestamp( "TIME" ) );

				//抽出リスト（List<SurveyDto>型）に格納
				selectDataList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			//-------------------------------------------
			//接続の解除
			//-------------------------------------------

			//ResultSetオブジェクトの接続解除
			if (rs != null) {    //接続が確認できている場合のみ実施
				try {
					rs.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//PreparedStatementオブジェクトの接続解除
			if (ps != null) {    //接続が確認できている場合のみ実施
				try {
					ps.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//Connectionオブジェクトの接続解除
			if (con != null) {    //接続が確認できている場合のみ実施
				try {
					con.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		//抽出リストを戻す
		return selectDataList;

	}
}
