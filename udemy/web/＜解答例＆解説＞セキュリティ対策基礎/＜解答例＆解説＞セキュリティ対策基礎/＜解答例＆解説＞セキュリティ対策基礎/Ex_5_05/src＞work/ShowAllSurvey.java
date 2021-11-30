package work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**----------------------------------------------------------------------*
 *■■■ShowAllSurveyクラス■■■
 *概要：サーブレット
 *詳細：「survey」テーブルのデータを全件抽出して回答一覧画面を出力する。
 *----------------------------------------------------------------------**/
public class ShowAllSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowAllSurvey() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");

		//出力用のストリームの取得
		PrintWriter out = response.getWriter();

		//「survey」テーブルのデータを全件抽出
		List<SurveyDto> list  = new ArrayList<SurveyDto>();
		ShowAllSurveyBL logic = new ShowAllSurveyBL();
		list = logic.executeSelectSurvey();

		//HTML文書（回答一覧画面）の出力
		out.println(        "<html>                                                      ");
		out.println(        "  <head>                                                    ");
		out.println(        "    <title>回答一覧</title>                                 ");
		out.println(        "  </head>                                                   ");
		out.println(        "  <body>                                                    ");
		out.println(        "    <h2>アンケート回答一覧</h2>                             ");
		out.println(        "    <table class=\"surbey_list\" border=1>                  ");
		out.println(        "      <tr bgcolor=\"#c0c0c0\">                              ");
		out.println(        "        <th>名前</th>                                       ");
		out.println(        "        <th>年齢</th>                                       ");
		out.println(        "        <th>性別</th>                                       ");
		out.println(        "        <th>満足度</th>                                     ");
		out.println(        "        <th>ご意見・ご感想</th>                             ");
		out.println(        "        <th>回答時間</th>                                   ");
		out.println(        "      </tr>                                                 ");

		for (int i = 0; i < list.size(); i++) {
			SurveyDto dto = list.get(i);
			out.println(    "      <tr>                                                  ");
			out.println(    "        <td>" + replaceEscapeChar(dto.getName()) + "</td>"   );
			out.println(    "        <td>" + dto.getAge() + "</td>"                       );
			if (dto.getSex() == 1) {
				out.println("        <td>" + "オス" + "</td>"                             );
			} else {
				out.println("        <td>" + "メス" + "</td>"                             );
			}
			switch (dto.getSatisfactionLevel()) {
			case 1:
				out.println("        <td>" + "とても不満" + "</td>"                       );
				break;
			case 2:
				out.println("        <td>" + "不満" + "</td>"                             );
				break;
			case 3:
				out.println("        <td>" + "普通" + "</td>"                             );
				break;
			case 4:
				out.println("        <td>" + "満足" + "</td>"                             );
				break;
			case 5:
				out.println("        <td>" + "とても満足" + "</td>"                       );
				break;
			}

			out.println(    "        <td>" + replaceEscapeChar(dto.getMessage()) + "</td>");
			out.println(    "        <td>" + dto.getTime()    + "</td>"                   );
			out.println(    "      </tr>                                                 ");
		}
		out.println(        "    </table>                                                ");
		out.println(        "    <br>                                                    ");
		out.println(        "    <a href=\"InputSurvey\">回答画面に戻る</a>              ");
		out.println(        "  </body>                                                   ");
		out.println(        "</html>                                                     ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
		doGet(request, response);
	}

	/**----------------------------------------------------------------------*
	 *■■■replaceEscapeCharクラス■■■
	 *概要：文字列データのエスケープを行う
	 *----------------------------------------------------------------------**/
	private String replaceEscapeChar(String inputText) {

		String charAfterEscape = inputText ; //エスケープ後の文字列データ

		// 「&」を変換
		charAfterEscape = charAfterEscape.replace("&", "&amp;");
		// 「<」を変換
		charAfterEscape = charAfterEscape.replace("<", "&lt;");
		// 「>」を変換
		charAfterEscape = charAfterEscape.replace(">", "&gt;");
		// 「"」を変換
		charAfterEscape = charAfterEscape.replace("\"", "&quot;");
		// 「'」を変換
		charAfterEscape = charAfterEscape.replace("'", "&#039;");

		return charAfterEscape;
	}
}
