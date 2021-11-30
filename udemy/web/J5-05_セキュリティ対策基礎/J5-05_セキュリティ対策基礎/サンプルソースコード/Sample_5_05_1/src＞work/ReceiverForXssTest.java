package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**----------------------------------------------------------------------*
 *■■■ReceiverForXssTestクラス■■■
 *概要：サーブレット
 *詳細：送信画面から受け取ったリクエストを元にHTML文書（受信画面）を出力する。
 *----------------------------------------------------------------------**/
public class ReceiverForXssTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReceiverForXssTest() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");     //文字コードをUTF-8で設定
		//リクエスト（受信データ）の文字コードを設定
		request.setCharacterEncoding("UTF-8");                  //文字コードをUTF-8で設定

		//出力用のストリームの取得
		PrintWriter out = response.getWriter();

		//リクエストパラメータの取得
		//  パラメータ：MESSAGE01（replaceEscapeCharメソッドで特殊文字をエスケープ処理してから取得）
		String sendTextEsc = replaceEscapeChar( request.getParameter("MESSAGE01") );
		//  パラメータ：MESSAGE02（加工せずに取得）
		String sendTextRaw = request.getParameter("MESSAGE02");

		//HTML文書（受信画面）の出力
		out.println("<html>                                             ");
		out.println("<head>                                             ");
		out.println("  <title>受信画面</title>                          ");
		out.println("</head>                                            ");
		out.println("<body>                                             ");
		out.println("  <h1>XSS対策のサンプル（受信画面）</h1>           ");
		out.println("  <hr width = \"600\" align = \"left\">            ");
		out.println("  <h2>①XSS対策（エスケープ処理）あり</h2>         ");
		out.println(   sendTextEsc                                       );
		out.println("  <hr width = \"600\" align = \"left\">            ");
		out.println("  <h2>②XSS対策なし</h2>                           ");
		out.println(   sendTextRaw                                       );
		out.println("  <a href=\"SenderForXssTest\">送信画面に戻る</a>  ");
		out.println("</body>                                            ");
		out.println("</html>                                            ");

	}

	//XSSに使用される特殊文字をエスケープ処理する
	private String replaceEscapeChar(String inputText) {

		// 「&」を変換して無害化
		inputText = inputText.replace("&", "&amp;");
		// 「<」を変換して無害化
		inputText = inputText.replace("<", "&lt;");
		// 「>」を変換して無害化
		inputText = inputText.replace(">", "&gt;");
		// 「"」を変換して無害化
		inputText = inputText.replace("\"", "&quot;");
		// 「'」を変換して無害化
		inputText = inputText.replace("'", "&#039;");

		return inputText;
	}
}