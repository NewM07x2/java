<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"      %>
<%@ page import="model.SurveyDto"      %>

<%--
-------------------------------------------------------------------------------------------------
■■■ファイル名：show_survey_by_satisfaction_level.jsp■■■
概要：JSP
詳細：「survey」テーブルから条件に合致するデータを抽出し、HTML文書（回答一覧画面）を出力する。
　　　＜条件＞満足度が選択されたものと一致
-------------------------------------------------------------------------------------------------
--%>

<%
//「survey」テーブルからデータを全件抽出
List<SurveyDto> surveyDtoList = (List<SurveyDto>)request.getAttribute("SURVEY_LIST_BY_SATISFACTION_LEVEL");

%>

<html>
  <head>
    <title>回答一覧</title>
  </head>
  <body>
    <h2>アンケート回答一覧</h2>
    <table class="surbey_list" border=1>
      <tr bgcolor="#c0c0c0">
        <th>名前</th>
        <th>年齢</th>
        <th>性別</th>
        <th>満足度</th>
        <th>ご意見・ご感想</th>
        <th>回答時間</th>
      </tr>

<%
for (int i = 0; i < surveyDtoList.size(); i++) {

	//本ループのターゲットとなるDTO（1行分のアンケート結果）をセット
	SurveyDto dto = surveyDtoList.get(i);

%>
      <tr>
        <td><%= dto.getName() %></td>
        <td><%= dto.getAge() %></td>
<%
	//出力内容の分岐（性別）
	switch( dto.getSex() ){
		case 1:
%>
        <td>オス</td>
<%
			break;
		case 2:
%>
        <td>メス</td>
<%
			break;
	}
%>
<%
	//出力内容の分岐（満足度）
	switch( dto.getSatisfactionLevel() ) {
		case 1:
%>
        <td>とても不満</td>
<%
			break;
		case 2:
%>
        <td>不満</td>
<%
			break;
		case 3:
%>
        <td>普通</td>
<%
			break;
		case 4:
%>
        <td>満足</td>
<%
			break;
		case 5:
%>
        <td>とても満足</td>
<%
			break;
	}
%>
        <td><%= dto.getMessage() %></td>
        <td><%= dto.getTime() %></td>
      </tr>
<%
}
%>
    </table>
    <br>
    <a href="<%=request.getContextPath()%>/SearchSurveyBySatisfactionLevel">検索画面に戻る</a>
  </body>
</html>
