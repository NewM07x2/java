package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**----------------------------------------------------------------------*
 *■■■SenderForXssTestクラス■■■
 *概要：サーブレット
 *詳細：HTML文書（送信画面）を出力する。
 *----------------------------------------------------------------------**/
public class SenderForXssTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SenderForXssTest() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");  //文字コードをUTF-8で設定

		//出力用のストリームの取得
		PrintWriter out = response.getWriter();

		//HTML文書（送信画面）の出力
		out.println("<html>                                                    ");
		out.println("<head>                                                    ");
		out.println("  <title>送信画面</title>                                 ");
		out.println("</head>                                                   ");
		out.println("<body>                                                    ");
		out.println( " <h1>XSS対策のサンプル（送信画面）</h1>                  ");
		out.println("  <form action=\"ReceiverForXssTest\" method=\"post\">    ");
		out.println("    <p>①XSS対策あり                                      ");
		out.println("      <br>                                                ");
		out.println("      <input type=\"text\" name=\"MESSAGE01\" size=\"80\">");
		out.println("    </p>                                                  ");
		out.println("    <p>②XSS対策なし                                      ");
		out.println("      <br>                                                ");
		out.println("      <input type=\"text\" name=\"MESSAGE02\" size=\"80\">");
		out.println("    </p>                                                  ");
		out.println("    <input type=\"submit\" value=\"受信画面へ\">          ");
		out.println("  </form>                                                 ");
		out.println("</body>                                                   ");
		out.println("</html>                                                   ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
