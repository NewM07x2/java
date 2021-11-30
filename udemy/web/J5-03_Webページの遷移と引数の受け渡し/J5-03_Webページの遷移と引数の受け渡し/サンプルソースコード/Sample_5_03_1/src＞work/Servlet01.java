package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet01() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");  //文字コードをUTF-8で設定

		//出力用のストリームの取得
		PrintWriter out = response.getWriter();

		//HTML文書の出力
		out.println("<html>                                           ");
		out.println("<head>                                           ");
		out.println("  <title>画面01</title>                          ");
		out.println("</head>                                          ");
		out.println("<body>                                           ");
		out.println("  <p>(1)フォーム通信を使う</p>                   ");
		out.println("  <form action=\"Servlet02-url\" method=\"get\"> ");
		out.println("    <p>次のボタンを押すと画面02に移動します</p>  ");
		out.println("    <input type=\"submit\" value=\"画面02へ\">   ");
		out.println("  </form>                                        ");
		out.println("  <br>                                           ");
		out.println("  <p>(2)リンクを使う</p>                         ");
		out.println("  <a href=\"Servlet02-url\">画面02へ</a>         ");
		out.println("</body>                                          ");
		out.println("</html>                                          ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
