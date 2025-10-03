package junit.sample;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	Calculator cal;

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
		assumingThat("DEV".equals(System.getenv("ENV")),() -> {
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

}
