/*-< 演習：Ex1_08_2 >---------------------------------
コメントの内容に従ってプログラムを作成してください。
----------------------------------------------------*/
class Ex1_08_2 {
	public static void main (String[] args) {
		
		/* 以下の配列を準備し、「トイプードル」が表示されるプログラムを作成してください。
		**     配列名    ：animals
		**     保持する値
		**        animals[0][0]：アメリカンショートヘア
		**        animals[0][1]：マンチカン
		**        animals[1][0]：ジャンガリアンハムスター
		**        animals[1][1]：ハリネズミ
		**        animals[2][0]：オカメインコ
		**        animals[2][1]：ブンチョウ
		**        animals[3][0]：ゴールデンレトリーバー
		**        animals[3][1]：トイプードル
		*/
		
		//animals配列を準備
		String[][] animals = {
		                       {"アメリカンショートヘア"   , "マンチカン"  } ,
		                       {"ジャンガリアンハムスター" , "ハリネズミ"  } ,
		                       {"オカメインコ"             , "ブンチョウ"  } ,
		                       {"ゴールデンレトリーバー"   , "トイプードル"}
		                     };
		
		//animals配列から「トイプードル」を取得、表示
		System.out.println(animals[3][1]);
		
	}
}
