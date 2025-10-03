package junit.sample;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RandomsTest{

	@Test
	void testChoice() {
		List<String> options = new ArrayList<String>();
		options.add("A");
		options.add("B");
		Randoms sut = new Randoms();
		//スタブの設定

		assertEquals(sut.choice(options), "A");
	}

}
