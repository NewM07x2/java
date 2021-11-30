package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**----------------------------------------------------------------------*
 *■■■ExecuteLogoutクラス■■■
 *概要：サーブレット
 *詳細：HTML文書（ログアウト完了画面）を出力する。
 *----------------------------------------------------------------------**/
public class ExecuteLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteLogout() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");  //文字コードをUTF-8で設定

		//出力用のストリームの取得
		PrintWriter out = response.getWriter();

		//HTML文書（ログアウト完了画面）の出力
		out.println("<html>                                           ");
		out.println("<head>                                           ");
		out.println("  <title>ログアウト完了</title>                  ");
		out.println("</head>                                          ");
		out.println("<body>                                           ");
		out.println(" <h1>ログインSample①（ログアウト完了画面）</h1> ");
		out.println("  <p>ログアウトしました。</p>                    ");
		out.println("  <a href=\"Login\">ログイン画面に戻る</a>       ");
		out.println("</body>                                          ");
		out.println("</html>                                          ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
