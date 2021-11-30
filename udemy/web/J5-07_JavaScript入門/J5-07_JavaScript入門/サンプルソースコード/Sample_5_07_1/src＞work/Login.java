package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**----------------------------------------------------------------------*
 *■■■Loginクラス■■■
 *概要：サーブレット
 *詳細：HTML文書（ログイン画面）を出力する。
 *----------------------------------------------------------------------**/
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");  //文字コードをUTF-8で設定

		//出力用のストリームの取得
		PrintWriter out = response.getWriter();

		//セッションからユーザーデータを取得
		HttpSession session           = request.getSession();
		UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");

		//ログイン状態によって表示画面を振り分ける
		// ※ログイン状態はセッション上からユーザーデータを取得できたか否かで判断
		//    ユーザーデータを取得できた　　　→既にログインされている
		//    ユーザーデータを取得できなかった→まだログインされていない
		if (userInfoOnSession != null) {
			//ログイン済：ホーム画面へ転送
			response.sendRedirect("Home");
		}else{
			//未ログイン：HTML文書（ログイン画面）の出力
			out.println("<html>                                                                                                           ");
			out.println("<head>                                                                                                           ");
			out.println("  <title>ログイン画面</title>                                                                                    ");

			out.println("  <script type = \"text/javascript\">                                                                            ");
			out.println("    console.log( \"▼----headタグ内での動作確認----▼\" );                                                       ");
			out.println("    console.log( \"HTMLは上から順にブラウザに読み込まれていきます。\" );                                         ");
			out.println("    console.log( \"scriptタグ内のJavaScript処理も上から順に実行されます。\" );                                   ");
			out.println("    console.log( \"▽まだID「ID_USER_ID」の要素は読み込まれていないため値を取得できない（エラー）\" );           ");
			out.println("    console.log( document.getElementById(\"ID_USER_ID\").name                   );                               ");
			out.println("  </script>                                                                                                      ");

			out.println("</head>                                                                                                          ");
			out.println("<body>                                                                                                           ");
			out.println("  <h1>ログインSample（入力チェック①）</h1>                                                                      ");
			out.println("  <form action=\"ExecuteLogin\" method=\"post\" name=\"FORM_LOGIN_INFO\">                                        ");
			out.println("    <p>ユーザーID：                                                                                              ");
			out.println("      <br>                                                                                                       ");
			out.println("      <input type=\"text\" name=\"USER_ID\" maxlength=\"20\" id=\"ID_USER_ID\">                                  ");
			out.println("    </p>                                                                                                         ");
			out.println("    <p>パスワード：<br>                                                                                          ");
			out.println("      <input type=\"password\" name=\"PASSWORD\" maxlength=\"20\" id=\"ID_PASSWORD\">                            ");
			out.println("    </p>                                                                                                         ");
			out.println("    <input type=\"submit\" value=\"ログイン\" id=\"ID_SUBMIT\" onclick=\"return preCheck()\" >                   ");
			out.println("  </form>                                                                                                        ");

			out.println("  <script type = \"text/javascript\">                                                                            ");
			out.println("    console.log( \"▼----bodyタグ内での動作確認----▼\" );                                                       ");
			out.println("    console.log( \"▽getElementById以外の要素の取得方法\" );                                                     ");
			out.println("    console.log( \" getElementById    ：\" + document.getElementById(\"ID_USER_ID\").name                   );   ");
			out.println("    console.log( \" elements[INDEX]   ：\" + document.forms[0].elements[0].name                             );   ");
			out.println("    console.log( \" elements[name属性]：\" + document.forms[\"FORM_LOGIN_INFO\"].elements[\"USER_ID\"].name );   ");
			out.println("    console.log( \" name（略記）      ：\" + document.FORM_LOGIN_INFO.USER_ID.name                          );   ");
			out.println("                                                                                                                 ");
			out.println("    function preCheck(){                                                                                         ");
			out.println("      var elmUserId   = document.getElementById(\"ID_USER_ID\");                                                 ");
			out.println("      var elmPassword = document.getElementById(\"ID_PASSWORD\");                                                ");
			out.println("      var canSubmit = true;                                                                                      ");
			out.println("      if(elmUserId.value == \"\" || elmPassword.value == \"\"){                                                  ");
			out.println("        alert(\"入力漏れの項目があります。\");                                                                   ");
			out.println("        canSubmit = false;                                                                                       ");
			out.println("      }                                                                                                          ");
			out.println("      return canSubmit;                                                                                          ");
			out.println("    }                                                                                                            ");
			out.println("  </script>                                                                                                      ");

			out.println("</body>                                                                                                          ");
			out.println("</html>                                                                                                          ");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
