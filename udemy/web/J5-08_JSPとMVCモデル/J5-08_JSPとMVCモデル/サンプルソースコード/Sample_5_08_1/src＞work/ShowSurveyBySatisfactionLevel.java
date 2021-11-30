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
 *■■■ShowSurveyBySatisfactionLevelクラス■■■
 *概要：サーブレット
 *詳細：「survey」テーブルから条件に合致するデータを抽出し、HTML文書（回答一覧画面）を出力する。
 *　　　＜条件＞満足度が選択されたものと一致
 *----------------------------------------------------------------------**/
public class ShowSurveyBySatisfactionLevel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowSurveyBySatisfactionLevel() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");

		//リクエストパラメータを取得
		String receivePrmSatLv     = request.getParameter("SATISFACTION_LEVEL");         //リクエストパラメータ（SATISFACTION_LEVEL）

		//「survey」テーブルからデータを全件抽出
		List<SurveyDto> surveyDtoList = new ArrayList<SurveyDto>();                      //アンケートリスト格納用ArrayList
		BusinessLogic   logic         = new BusinessLogic();
		surveyDtoList = logic.executeSelectSurveyBySatisfactionLevel( receivePrmSatLv ); //アンケートリストの抽出＆取得

		//出力用のストリームの取得
		PrintWriter out = response.getWriter();

		//HTML文書（回答一覧画面）を出力
		out.println(            "<html>                                                              ");
		out.println(            "  <head>                                                            ");
		out.println(            "    <title>回答一覧</title>                                         ");
		out.println(            "  </head>                                                           ");
		out.println(            "  <body>                                                            ");
		out.println(            "    <h2>アンケート回答一覧</h2>                                     ");
		out.println(            "    <table class=\"surbey_list\" border=1>                          ");
		out.println(            "      <tr bgcolor=\"#c0c0c0\">                                      ");
		out.println(            "        <th>名前</th>                                               ");
		out.println(            "        <th>年齢</th>                                               ");
		out.println(            "        <th>性別</th>                                               ");
		out.println(            "        <th>満足度</th>                                             ");
		out.println(            "        <th>ご意見・ご感想</th>                                     ");
		out.println(            "        <th>回答時間</th>                                           ");
		out.println(            "      </tr>                                                         ");

		for (int i = 0; i < surveyDtoList.size(); i++) {

			//本ループのターゲットとなるDTO（1行分のアンケート結果）をセット
			SurveyDto dto = surveyDtoList.get(i);

			out.println(        "      <tr>                                                          ");
			out.println(        "        <td>" + dto.getName()          + "</td>                     ");
			out.println(        "        <td>" + dto.getAge()           + "</td>                     ");

			//出力内容の分岐（性別）
			switch( dto.getSex() ){
				case 1:
					out.println("        <td>" + "オス"                 + "</td>                     ");
					break;
				case 2:
					out.println("        <td>" + "メス"                 + "</td>                     ");
					break;
			}

			//出力内容の分岐（満足度）
			switch( dto.getSatisfactionLevel() ) {
				case 1:
					out.println("        <td>" + "とても不満"           + "</td>                     ");
					break;
				case 2:
					out.println("        <td>" + "不満"                 + "</td>                     ");
					break;
				case 3:
					out.println("        <td>" + "普通"                 + "</td>                     ");
					break;
				case 4:
					out.println("        <td>" + "満足"                 + "</td>                     ");
					break;
				case 5:
					out.println("        <td>" + "とても満足"           + "</td>                     ");
					break;
			}

			out.println(        "        <td>" + dto.getMessage()       + "</td>                     ");
			out.println(        "        <td>" + dto.getTime()          + "</td>                     ");
			out.println(        "      </tr>                                                         ");
		}

		out.println(            "    </table>                                                        ");
		out.println(            "    <br>                                                            ");
		out.println(            "    <a href=\"SearchSurveyBySatisfactionLevel\">検索画面に戻る</a>  ");
		out.println(            "  </body>                                                           ");
		out.println(            "</html>                                                             ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
