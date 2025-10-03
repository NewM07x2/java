package junit.sample;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class DateExampleTest{

	@Test
	public void testSetMessage() {
		DateExample sut = new DateExample();
		sut.setMessage();
		assertEquals("現在時刻:"+LocalDateTime.now(),sut.getMessage());
	}


}
