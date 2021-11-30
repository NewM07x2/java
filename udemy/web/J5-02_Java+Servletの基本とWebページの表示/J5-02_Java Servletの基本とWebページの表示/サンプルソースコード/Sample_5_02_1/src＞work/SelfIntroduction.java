package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelfIntroduction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SelfIntroduction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");  //文字コードをUTF-8で設定

		//出力用のストリームの取得
		PrintWriter out = response.getWriter();

		//HTML文書の出力
		out.println( "<html>                                                                       " );
		out.println( "<head>                                                                       " );
		out.println( "  <title>自己紹介</title>                                                    " );
		out.println( "</head>                                                                      " );
		out.println( "<body>                                                                       " );
		out.println( "  <h1>自己紹介ページ</h1>                                                    " );
		out.println( "  <h2>ＭＯＣＯ</h2>                                                          " );
		out.println( "  <img src=\"pictures/picture01_500x350.jpg\" width=\"250\" height=\"175\">  " );
		out.println( "  <hr width = \"400\" align = \"left\">                                      " );
		out.println( "  <p>・誕生　　　：2013年</p>                                                " );
		out.println( "  <p>・出身　　　：台湾</p>                                                  " );
		out.println( "  <p>・職業　　　：就活犬（接客、メンタルケア）</p>                          " );
		out.println( "  <p>・好きな数字：「1（ONE）」</p>                                          " );
		out.println( "  <p>・家族　　　：岡本</p>                                                  " );
		out.println( "  <img src=\"pictures/picture02_300x200.jpg\" width=\"150\" height=\"100\">  " );
		out.println( "</body>                                                                      " );
		out.println( "</html>                                                                      " );

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}