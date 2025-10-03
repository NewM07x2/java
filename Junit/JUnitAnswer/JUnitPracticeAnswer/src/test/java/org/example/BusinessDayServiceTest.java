package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BusinessDayServiceTest {

    @Test
    public void testIsBusinessDay() {
    	BusinessDayService service = new BusinessDayService();
        boolean actual = service.isBusinessDay(LocalDate.of(2022, 10, 20));

        assertTrue(actual);
    }


    @Test
    public void testHolidayIsNotBusinessDay() {
    	BusinessDayService service = new BusinessDayService();
        // 祝日
    	boolean actual = service.isBusinessDay(LocalDate.of(2022, 11, 3));
        assertFalse(actual);
    }

    @Test
    public void testSaturdayIsNotBusinessDay() {
    	BusinessDayService service = new BusinessDayService();
        // 土曜日
    	boolean actual = service.isBusinessDay(LocalDate.of(2022, 12, 17));
        assertFalse(actual);
    }

    @Test
    public void testSundayIsNotBusinessDay() {
    	BusinessDayService service = new BusinessDayService();
        // 日曜日
    	boolean actual = service.isBusinessDay(LocalDate.of(2022, 12, 25));
        assertFalse(actual);
    }

    @Test
    void testGetNextBusinessDayIsNull() {
    	BusinessDayService service = new BusinessDayService();
        LocalDate actual = service.getNextBusinessDay(LocalDate.of(2022, 8, 11), 5);
        assertNull(actual);
    }

    @Test
    void testGetNextBusinessDay() {
    	BusinessDayService service = new BusinessDayService();
    	LocalDate expected = LocalDate.of(2022, 9, 26);
        LocalDate actual = service.getNextBusinessDay(LocalDate.of(2022, 9, 23), 5);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void testGetBusinessDayArray() {
    	BusinessDayService service = new BusinessDayService();
    	LocalDate[] expected = new LocalDate[]{
                LocalDate.of(2022, 10, 7),
                LocalDate.of(2022, 10, 11),
                LocalDate.of(2022, 10, 12)
            };
        LocalDate[] actual = service.getBusinessDayArray(LocalDate.of(2022, 10, 7), 5);

        assertArrayEquals(expected,actual);
    }

    @Test
    void testGetBusinessDayList() {
    	BusinessDayService service = new BusinessDayService();
    	List<LocalDate> expected = Arrays.asList(
                LocalDate.of(2022, 10, 7),
                LocalDate.of(2022, 10, 11),
                LocalDate.of(2022, 10, 12)
            );
        List<LocalDate> actual = service.getBusinessDayList(LocalDate.of(2022, 10, 7), 5);

        assertIterableEquals(expected,actual);
    }
}
