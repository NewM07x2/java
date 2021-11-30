package model;

import java.util.ArrayList;
import java.util.List;


/**----------------------------------------------------------------------*
 *■■■BusinessLogicクラス■■■
 *概要：ビジネスロジック（アンケートデータの登録）
 *----------------------------------------------------------------------**/
public class BusinessLogic {

	/**----------------------------------------------------------------------*
	 *■executeSelectSurveyBySatisfactionLevelメソッド
	 *概要　：対象のアンケートリストを抽出する
	 *引数　：満足度
	 *戻り値：アンケートリスト（List<SurveyDto>型）
	 *----------------------------------------------------------------------**/
	public List<SurveyDto> executeSelectSurveyBySatisfactionLevel( String sl ) {

		//アンケートリスト（ArrayList<SurveyDto>型）
		List<SurveyDto> surveyList = new ArrayList<SurveyDto>();

		//DAOクラスをインスタンス化＆アンケートリストを抽出するよう依頼
		SurveyDao dao = new SurveyDao();
		surveyList = dao.doSelectBySatisfactionLevel( sl );

		return surveyList;
	}

}
