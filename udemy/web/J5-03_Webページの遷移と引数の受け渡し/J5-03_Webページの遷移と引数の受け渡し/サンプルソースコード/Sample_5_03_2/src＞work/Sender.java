package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**----------------------------------------------------------------------*
 *■■■Senderクラス■■■
 *概要：サーブレット
 *詳細：HTML文書（送信画面）を出力する。
 *----------------------------------------------------------------------**/
public class Sender extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sender() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");  //文字コードをUTF-8で設定

		//出力用のストリームの取得
		PrintWriter out = response.getWriter();

		//HTML文書（送信画面）の出力
		out.println("<html>                                                                   ");
		out.println("<head>                                                                   ");
		out.println("  <title>送信画面</title>                                                ");
		out.println("</head>                                                                  ");
		out.println("<body>                                                                   ");
		out.println("  <p>入力内容が受信画面に送られます。</p>                                ");
		out.println("  <form action=\"Receiver\" method=\"post\">                             ");
		out.println("    <p>                                                                  ");
		out.println("    <label>名前　　：<input type=\"text\" name=\"NAME\"></label>         ");
		out.println("    </p>                                                                 ");
		out.println("    <p>                                                                  ");
		out.println("    <label>犬種　　：</label>                                            ");
		out.println("    <select name=\"DOG_TYPE\">                                           ");
		out.println("    <option value=\"S\">シバイヌ</option>                                ");
		out.println("    <option value=\"T\">トイプードル</option>                            ");
		out.println("    <option value=\"G\">ゴールデンレトリバー</option>                    ");
		out.println("    <option value=\"O\">その他</option>                                  ");
		out.println("    </select>                                                            ");
		out.println("    </p>                                                                 ");
		out.println("    <p>                                                                  ");
		out.println("    <label>性別　　：</label>                                            ");
		out.println("    <input type=\"radio\" name=\"GENDER\" value=\"1\">オス               ");
		out.println("    <input type=\"radio\" name=\"GENDER\" value=\"2\">メス               ");
		out.println("    </p>                                                                 ");
		out.println("    <p>                                                                  ");
		out.println("    <label>誕生日　：<input type=\"date\" name=\"BIRTHDAY\"></label>     ");
		out.println("    </p>                                                                 ");
		out.println("    <p>                                                                  ");
		out.println("    <label>毛色　　：<input type=\"color\" name=\"COLOR\"></label>       ");
		out.println("    </p>                                                                 ");
		out.println("    <p>                                                                  ");
		out.println("    <label>ひとこと：</label>                                            ");
		out.println("    <br>                                                                 ");
		out.println("    <textarea name=\"COMMENT\" rows=\"4\" cols=\"40\"></textarea>        ");
		out.println("    </p>                                                                 ");
		out.println("    <p>                                                                  ");
		out.println("    <label><input type=\"submit\" value=\"受信画面へ\"></label>          ");
		out.println("    </p>                                                                 ");
		out.println("  </form>                                                                ");
		out.println("</body>                                                                  ");
		out.println("</html>                                                                  ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
