import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {
    @Test
    void test000_Date0() {
        Date d1 = new Date();
        assertEquals("January 1, 1900", d1.toString());
    }

    @Test
    void testToString_01_06() {
        Date d_01 = new Date(1, 27, 2015);
        assertEquals("January 27, 2015", d_01.toString());

        Date d_02a = new Date(2, 28, 2000);
        assertEquals("February 28, 2000", d_02a.toString());

        Date d_02b = new Date(2, 29, 2000);
        assertEquals("February 29, 2000", d_02b.toString());

        Date d_03 = new Date(3, 1, 1900);
        assertEquals("March 1, 1900", d_03.toString());

        Date d_04 = new Date(4, 1, 2021);
        assertEquals("April 1, 2021", d_04.toString());

        Date d_05 = new Date(5, 31, 2022);
        assertEquals("May 31, 2022", d_05.toString());

        Date d_06 = new Date(6, 16, 1997);
        assertEquals("June 16, 1997", d_06.toString());
    }

    @Test
    void testInc() {
        Date d3 = new Date(2, 28, 2012);
        d3.inc();
        assertEquals("February 29, 2012", d3.toString());
        Date d2 = new Date(12, 27, 2015);
        d2.inc(7);
        assertEquals("January 3, 2016", d2.toString());
        Date d1 = new Date();
        d1.inc(43734);
        assertEquals("September 28, 2019", d1.toString());
    }

    @Test
    void isLeapYear() {
        Date d1 = new Date();
        assertFalse(d1.isLeapYear());
    }

    @Test
    void lastDayInMonth() {
        Date d1 = new Date();
        assertEquals(31, d1.lastDayInMonth());
        Date d2 = new Date(1, 12, 2000);
        d2.setDate(2, 28, 2012);
        assertEquals("February 28, 2012", d2.toString());
        assertEquals(29, d2.lastDayInMonth());
    }

    @Test
    void testEquals() {
        Date d3 = new Date(2, 28, 2012);
        d3.inc();
        Date d4 = new Date(2, 29, 2012);
        assertTrue(d3.equals(d4));
        Date d5 = new Date(2, 27, 2013);
        assertFalse(d3.equals(d5));
    }

    @Test
    void dayOfYear() {
        Date d1 = new Date(2, 29, 2012);
        assertEquals(60, d1.dayOfYear());
    }

    @Test
    void dayOfWeek() {
        Date d1 = new Date(2, 29, 2012);
        assertEquals(3, d1.dayOfWeek());
    }

    @Test
    void illegalDates() {
        assertThrows(IllegalArgumentException.class, () -> new Date(0, 9, 2022)); ////
        assertThrows(IllegalArgumentException.class, () -> new Date(13, 9, 2022)); ////
        assertThrows(IllegalArgumentException.class, () -> new Date(4, 31, 2022)); ////
        assertThrows(IllegalArgumentException.class, () -> new Date(2, 29, 1900)); ////
        assertThrows(IllegalArgumentException.class, () -> new Date(2, 0, 1900)); ////
    }

}
