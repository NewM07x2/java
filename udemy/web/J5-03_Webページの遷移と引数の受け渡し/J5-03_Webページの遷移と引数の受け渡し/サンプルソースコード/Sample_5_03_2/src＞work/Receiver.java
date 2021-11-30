package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**----------------------------------------------------------------------*
 *■■■Receiverクラス■■■
 *概要：サーブレット
 *詳細：送信画面から受け取ったリクエストを元にHTML文書（受信画面）を出力する。
 *----------------------------------------------------------------------**/

public class Receiver extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Receiver() {
		super();
	}

	//※doGetメソッドではHTTP通信時の文字コードが指定できない仕様のため、
	//　引数を送る場合はdoPostメソッドを利用する。
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");     //文字コードをUTF-8で設定
		//リクエスト（受信データ）の文字コードを設定
		request.setCharacterEncoding("UTF-8");                  //文字コードをUTF-8で設定

		//リクエストパラメータを取得
		String receiveParameterName     = request.getParameter("NAME");      //リクエストパラメータ（NAME）
		String receiveParameterDogType  = request.getParameter("DOG_TYPE");  //リクエストパラメータ（DOG_TYPE）
		String receiveParameterGender   = request.getParameter("GENDER");    //リクエストパラメータ（GENDER）
		String receiveParameterBirthday = request.getParameter("BIRTHDAY");  //リクエストパラメータ（BIRTHDAY）
		String receiveParameterColor    = request.getParameter("COLOR");     //リクエストパラメータ（COLOR）
		String receiveParameterComment  = request.getParameter("COMMENT");   //リクエストパラメータ（COMMENT）

		//出力用のストリームの取得
		PrintWriter out = response.getWriter();

		//HTML文書（受信画面）の出力
		out.println("<html>                                                                    ");
		out.println("<head>                                                                    ");
		out.println("  <title>受信画面</title>                                                 ");
		out.println("</head>                                                                   ");
		out.println("<body>                                                                    ");
		out.println("  <p>以下の内容が送られてきました。</p>                                   ");
		out.println("  <p>                                                                     ");
		out.println("  ▼name属性『NAME』として受け取った値<br>" + receiveParameterName         );
		out.println("  </p>                                                                    ");
		out.println("  <p>                                                                     ");
		out.println("  ▼name属性『DOG_TYPE』として受け取った値<br>" + receiveParameterDogType  );
		out.println("  </p>                                                                    ");
		out.println("  <p>                                                                     ");
		out.println("  ▼name属性『GENDER』として受け取った値<br>" + receiveParameterGender     );
		out.println("  </p>                                                                    ");
		out.println("  <p>                                                                     ");
		out.println("  ▼name属性『BIRTHDAY』として受け取った値<br>" + receiveParameterBirthday );
		out.println("  </p>                                                                    ");
		out.println("  <p>                                                                     ");
		out.println("  ▼name属性『COLOR』として受け取った値<br>" + receiveParameterColor       );
		out.println("  </p>                                                                    ");
		out.println("  <p>                                                                     ");
		out.println("  ▼name属性『COMMENT』として受け取った値<br>" + receiveParameterComment   );
		out.println("  </p>                                                                    ");
		out.println("  <a href=\"Sender\">送信画面に戻る</a>                                   ");
		out.println("</body>                                                                   ");
		out.println("</html>                                                                   ");
	}
}
