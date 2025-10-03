package junit;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AccountDaoTest {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/sample?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "pass";
    private static final String SCHEMA = "sample";

    private static IDatabaseTester dbTester;

    @BeforeAll
    public static void before() throws Exception {

        // ☆ MySQLの設定を反映させるためにgetConnectionメソッドをオーバーライド
        dbTester = new JdbcDatabaseTester(
                DRIVER_NAME, CONNECTION_URL, USER, PASSWORD, SCHEMA) {
            @Override
            public IDatabaseConnection getConnection() throws Exception {
                IDatabaseConnection con = super.getConnection();
                con.getConfig().setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new MySqlMetadataHandler());
                return con;
            }
        };

        //テーブルに初期化用のデータを投入する処理を記述する
//        IDataSet dataSet =
//                new FlatXmlDataSetBuilder().build(new File("src/test/resources/data/init.xml"));
//
//        dbTester.setDataSet(dataSet);
//        dbTester.setSetUpOperation(DatabaseOperation.REFRESH);

        dbTester.onSetup();
    }

    @AfterAll
    public static void after() throws Exception {
        dbTester.setTearDownOperation(DatabaseOperation.NONE);
        dbTester.onTearDown();
    }

    @Test
    public void searchTest(){

        //ID"1"を指定してsearchメソッドを呼び出し、テストを実行する

    }

    @Test
    public void insertTest() throws Exception {

        //ID"3",PASS"pass3"でオブジェクトを生成して、insertするテスト
    }
}
