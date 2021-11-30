package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**----------------------------------------------------------------------*
 *■■■Homeクラス■■■
 *概要：サーブレット
 *詳細：ExecuteLoginから受け取ったリクエストを元にHTML文書（ホーム画面）を出力する。
 *----------------------------------------------------------------------**/
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Home() {
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

		//リクエストパラメータを取得
		String userName = request.getParameter("user_name");

		//HTML文書（ホーム画面）を出力
		out.println("<html>                                                           ");
		out.println("<head>                                                           ");
		out.println("  <title>ホーム画面</title>                                      ");
		out.println("</head>                                                          ");
		out.println("<body>                                                           ");
		out.println(" <h1>ログインSample①（ホーム画面）</h1>                         ");
		out.println("  <p>ログインしました。</p>                                      ");
		out.println("  <p>ようこそ <b>" + userName + "</b> さん</p>                   ");
		out.println("  <p>========================================</p> ");
		out.println("  <br>                                                           ");
		out.println("  <p>～～～お見せするようなコンテンツはございません。～～～</p>  ");
		out.println("  <br>                                                           ");
		out.println("  <p>========================================</p> ");
		out.println("  <br>                                                           ");
		out.println("  <a href=\"ExecuteLogout\">ログアウトする</a>                   ");
		out.println("</body>                                                          ");
		out.println("</html>                                                          ");
	}

}
