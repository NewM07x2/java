package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**----------------------------------------------------------------------*
 *■■■SearchSurveyBySatisfactionLevelクラス■■■
 *概要：サーブレット
 *詳細：HTML文書（満足度別アンケート結果検索画面）を出力する。
 *----------------------------------------------------------------------**/
public class SearchSurveyBySatisfactionLevel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchSurveyBySatisfactionLevel() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");  //文字コードをUTF-8で設定

		//出力用のストリームの取得
		PrintWriter out = response.getWriter();

		//HTML文書（満足度別アンケート結果検索画面）の出力

		out.println("<html>                                                                                  ");
		out.println("<head>                                                                                  ");
		out.println("  <title>満足度別アンケート結果検索</title>                                             ");
		out.println("</head>                                                                                 ");
		out.println("<body>                                                                                  ");
		out.println("  <h2>満足度別アンケート結果検索</h2>                                                   ");
		out.println("  <form action=\"ShowSurveyBySatisfactionLevel\" method=\"post\">                       ");
		out.println("    <p> 満足度：                                                                        ");
		out.println("      <select name=\"SATISFACTION_LEVEL\">                                              ");
		out.println("        <option value=\"5\">とても満足</option>                                         ");
		out.println("        <option value=\"4\">満足      </option>                                         ");
		out.println("        <option value=\"3\">普通      </option>                                         ");
		out.println("        <option value=\"2\">不満      </option>                                         ");
		out.println("        <option value=\"1\">とても不満</option>                                         ");
		out.println("      </select>                                                                         ");
		out.println("    </p>                                                                                ");
		out.println("    <input type=\"submit\" value=\"検索\">                                              ");
		out.println("  </form>                                                                               ");
		out.println("</body>                                                                                 ");
		out.println("</html>                                                                                 ");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
