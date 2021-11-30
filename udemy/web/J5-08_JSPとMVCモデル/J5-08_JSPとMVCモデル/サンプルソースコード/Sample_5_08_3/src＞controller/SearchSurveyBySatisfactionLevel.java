package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

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

		//Viewにフォワード（フォワード先：search_survey_by_satisfaction_level.jsp）
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/search_survey_by_satisfaction_level.jsp");
		dispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
