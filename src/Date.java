public class Date {
    static final String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static final int[] monthLengths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int year;
    private int month;
    private int day;

    public Date() {
        day = 1;
        month = 1;
        year = 1900;
    }

    public Date(int month, int day, int year) {
        setDate(month, day, year);
    }

    public void setDate(int month, int day, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month is wrong");
        } else if (day < 1 || day > lastDayInMonth()) {
            throw new IllegalArgumentException("Day is wrong");
        }
    }

    @Override
    public String toString() {
        return monthNames[month - 1] + " " + day + ", " + year;
    }

    public boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public int lastDayInMonth() {
        if (month == 2 && isLeapYear()) {
            return 29;
        }
        return monthLengths[month - 1];
    }

    public void inc() {
        int biggerDay = day + 1;
        int biggerMonth = month;
        int biggerYear = year;
        if (biggerDay > lastDayInMonth()) {
            biggerDay = 1;
            biggerMonth++;
            if (biggerMonth > 12) {
                biggerMonth = 1;
                biggerYear++;
            }
        }
        setDate(biggerMonth, biggerDay, biggerYear);
    }

    public void inc(int enlargement) {
        for (int i = 0; i < enlargement; i++) {
            inc();
        }
    }

    public boolean equals(Date other) {
        return this.day == other.day && this.month == other.month && this.year == other.year;
    }

    public int dayOfYear() {
        int days = day;
        for (int i = 1; i < month; i++) {
            days += monthLengths[i - 1];
            if (i == 2 && isLeapYear()) {
                days++;
            }
        }
        return days;
    }

    public int dayOfWeek() {
        int daysSince = 0;
        Date current = new Date();
        for (int y = 1900; y < year; y++) {
            current.setDate(1, 1, y);
            daysSince += current.isLeapYear() ? 366 : 365;
        }
        for (int m = 1; m < month; m++) {
            daysSince += monthLengths[m - 1];
            if (m == 2 && isLeapYear()) {
                daysSince++;
            }
        }
        daysSince += day - 1;
        return Math.floorMod(daysSince + 1, 7);
    }
}