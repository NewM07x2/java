//ログインデータを保存するためのテーブルを作成するSQL

CREATE TABLE TEST_DB.USER_INFO (
  USER_ID               VARCHAR(20) NOT NULL PRIMARY KEY,
  USER_NAME             VARCHAR(20) NOT NULL ,
  PASSWORD              VARCHAR(20) NOT NULL 
);

INSERT INTO TEST_DB.USER_INFO (USER_ID, USER_NAME, PASSWORD) VALUES ("uzuz001", "MOCO", "mocomoco");
#自分の名前のユーザーも作ってみて下さい。