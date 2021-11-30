package work;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**----------------------------------------------------------------------*
 *■■■ExecuteLoginクラス■■■
 *概要：サーブレット
 *詳細：「user_info」テーブルからユーザー入力値と合致するユーザーデータを抽出し、リダイレクトする。
 *　　　＜リダイレクト先＞合致データあり（ログインOK）：Homeサーブレット
 *　　　　　　　　　　　　合致データなし（ログインNG）：Loginサーブレット（前画面に戻る）
 *----------------------------------------------------------------------**/
public class ExecuteLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");     //文字コードをUTF-8で設定
		//リクエスト（受信データ）の文字コードを設定
		request.setCharacterEncoding("UTF-8");                  //文字コードをUTF-8で設定

		//リクエストパラメータからユーザー入力値を取得
		String userId   = request.getParameter("USER_ID");      //リクエストパラメータ（USER_ID）
		String passWord = request.getParameter("PASSWORD");     //リクエストパラメータ（PASSWORD）

		//「user_info」テーブルからユーザー入力値と合致するユーザーデータ（UserInfoDto型）を抽出
		// ※合致するデータがなかった場合、各フィールドがnullのDTOを得る
		BusinessLogic logic = new BusinessLogic();
		UserInfoDto   dto   = logic.executeSelectUserInfo(userId, passWord);

		//ユーザーデータの抽出成功/失敗に応じて表示させる画面を振り分ける
		if (dto.getUserId() != null) {

			//ユーザーデータの抽出に成功：ログインOKとしてHomeサーブレットへリダイレクト
			// ※URLにパラメータ（変数名：user_name／値：「user_info」テーブルから抽出したユーザー名）を埋め込む
			// ※URLにパラメータを埋め込む際はエンコード設定が必要
			String encodeUserName = URLEncoder.encode(dto.getUserName(), "UTF-8");
			response.sendRedirect("Home?user_name=" + encodeUserName);

		} else {

			//ユーザーデータの抽出に失敗：ログインNGとしてログイン画面へ転送
			response.sendRedirect("Login");

		}
	}

}
