package work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**----------------------------------------------------------------------*
 *■■■UsingTableSampleクラス■■■
 *概要：サーブレット
 *詳細：HTML文書（HTMLテーブル作成Sample画面）を出力する。
 *----------------------------------------------------------------------**/

public class UsingTableSample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsingTableSample() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//投稿内容のリスト
		List<String> postContentList = new ArrayList<String>();
		postContentList.add("1番目の投稿");
		postContentList.add("2番目の投稿");
		postContentList.add("3番目の投稿");
		postContentList.add("4番目の投稿");
		postContentList.add("5番目の投稿");

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");

		//出力用のストリームの取得
		PrintWriter out = response.getWriter();

		//HTML文書（HTMLテーブル作成Sample画面）の出力
		out.println(    "<html>                                               ");
		out.println(    "<head>                                               ");
		out.println(    "  <title>HTMLテーブル作成Sample</title> ");
		out.println(    "</head>                                              ");
		out.println(    "<body>                                               ");
		out.println(    "  <h2>HTMLテーブル作成Sample</h2>       ");

		//--------------▼テーブルの作成▼--------------

		out.println(    "  <table class=\"list\" border=1 id=\"TABLE\">       "); //tableタグ：テーブル全体を表す
		out.println(    "    <tr bgcolor=\"#c0c0c0\">                         "); //  trタグ：1行分の情報を表す（1行目）
		out.println(    "      <th>投稿No.</th>                               "); //    thタグ：見出しを表す（1列目）
		out.println(    "      <th>投稿内容</th>                              "); //    thタグ：見出しを表す（2列目）
		out.println(    "    </tr>                                            "); //  trタグ（閉じ）

		for (int i = 0; i < postContentList.size(); i++) {

			int rowNo = i + 1;   //投稿Noの設定

			out.println("    <tr>                                             "); //  trタグ：1行分の情報を表す（2行目以降）
			out.println("      <td>" + rowNo                  + "</td>        "); //    tdタグ：データを表す（1列目）
			out.println("      <td>" + postContentList.get(i) + "</td>        "); //    tdタグ：データを表す（2列目）
			out.println("    </tr>                                            "); //  trタグ（閉じ）
		}

		out.println(    "  </table>                                           "); //tableタグ（閉じ）

		//--------------▲テーブルの作成▲--------------

		out.println(    "</body>                                              ");
		out.println(    "</html>                                              ");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
