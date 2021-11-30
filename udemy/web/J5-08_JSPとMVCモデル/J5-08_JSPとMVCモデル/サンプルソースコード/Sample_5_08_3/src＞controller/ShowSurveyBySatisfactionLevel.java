package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.BusinessLogic;
import model.SurveyDto;

import javax.servlet.RequestDispatcher;
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

		//リクエストパラメータを取得
		String receivePrmSatLv     = request.getParameter("SATISFACTION_LEVEL");         //リクエストパラメータ（SATISFACTION_LEVEL）

		//「survey」テーブルからデータを全件抽出
		List<SurveyDto> surveyDtoList = new ArrayList<SurveyDto>();                      //アンケートリスト格納用ArrayList
		BusinessLogic   logic         = new BusinessLogic();
		surveyDtoList = logic.executeSelectSurveyBySatisfactionLevel( receivePrmSatLv ); //アンケートリストの抽出＆取得

		//アンケートリストをリクエストスコープに保存
		request.setAttribute( "SURVEY_LIST_BY_SATISFACTION_LEVEL" , surveyDtoList );

		//Viewにフォワード（フォワード先：show_survey_by_satisfaction_level.jsp）
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/show_survey_by_satisfaction_level.jsp");
		dispatch.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
