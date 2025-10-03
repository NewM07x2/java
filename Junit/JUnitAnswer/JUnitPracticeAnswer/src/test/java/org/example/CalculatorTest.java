package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class CalculatorTest {

    private Calculator cal;

    @BeforeEach
    public void setUp() {
        //オブジェクトを生成
        cal = new Calculator();
    }

    @Test
    public void testAdd() {
        assumeTrue("DEV".equals(System.getenv("ENV")));
        //期待値
        int expected = 5;
        //実測値
        int actual = cal.add(3, 2);
        //期待値と実測値の比較
        assertEquals(actual, expected);
    }

    @Test
    public void testSub() {
        assumingThat("DEV".equals(System.getenv("ENV")), () -> {
            //期待値
            int expected = 1;
            //実測値
            int actual = cal.sub(3, 2);
            //期待値と実測値の比較
            assertEquals(actual, expected);
        });
    }

    @Test
    public void testMul() {

        //期待値
        int expected = 6;
        //実測値
        int actual = cal.mul(3, 2);
        //期待値と実測値の比較
        assertEquals(actual, expected);
    }

    @Nested
    public class DivTest {
        @Test
        public void testDiv() {

            //期待値
            float expected = 1.5f;
            //実測値
            float actual = cal.div(3, 2);
            //期待値と実測値の比較
            assertEquals(actual, expected);
        }

        @Test
        @Tag("Exception")
        public void testDivException() {
            assertThrows(IllegalArgumentException.class, () -> cal.div(3, 0));
        }

        @Disabled
        @Test
        @Tag("Exception")
        void testDivException2() {

            try {
                cal.div(3, 0);
                fail();
            } catch (IllegalArgumentException e) {
                //成功
            }
        }
    }

    //	@Disabled
    @Nested
    public class TaxPriceTest {

        @Test
        public void testTaxPrice() {

            int expected = 110;
            int actual = cal.taxPrice(100);
            assertEquals(expected, actual);
        }

        @Test
        @Tag("Exception")
        public void testTaxPriceException() {

            assertThrows(IllegalArgumentException.class, () -> cal.taxPrice(-100));

            //メッセージの確認
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> cal.taxPrice(-100));
            assertEquals("価格は0円以上にしてください", e.getMessage());
        }

        @ParameterizedTest
        @CsvSource({
                "8, 100, 108",
                "8, 3000, 3240",
                "10, 50, 55",
                "8, 50, 54",
                "5, 50, 52"
        })
        public void testTaxPriceParameterized(int rate, int price, int expected) {
            int actual = cal.taxPrice(rate, price);
            assertEquals(expected, actual);
        }
    }
}
