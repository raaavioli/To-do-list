package se.kth.olieri.todolist.ListBackend;

import java.util.HashMap;

public class Date implements Comparable<Date> {
    private final HashMap<Integer, Integer> daysOfMonth = new HashMap<Integer, Integer>() {{
            put(1, 31);
            put(2, 28);
            put(3, 31);
            put(4, 30);
            put(5, 31);
            put(6, 30);
            put(7, 31);
            put(8, 31);
            put(9, 30);
            put(10, 31);
            put(11, 30);
            put(12, 31);
    }};

    private int year;
    private int month;
    private int date;

    public Date(int year, int month, int date){
        this.date = checkValidity(year, month, date);
        this.year = year;
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.date = checkValidity(year, this.month, this.date);
        this.year = year;
    }

    public void setMonth(int month) {
        this.date = checkValidity(this.year, month, this.date);
        this.month = month;
    }

    public void setDate(int date) {
        this.date = checkValidity(this.year, this.month, date);
    }

    private int checkValidity(int year, int month, int date){
        if(year < 3000 && year > 2000){
            for (int i = 1; i <= daysOfMonth.keySet().size(); i++) {
                if(i == month && date > 0){
                    if(date <= daysOfMonth.get(i)) {
                        return date;
                    }else if(i == 2 && year%4 == 0){
                        return daysOfMonth.get(i)+1;
                    }else{
                        return daysOfMonth.get(i);
                    }
                }else if(i == month){
                    throw new IllegalArgumentException("Date '"+date+"' is not a valid input");
                }
            }
            throw new IllegalArgumentException("Month '"+month+"' is not a valid input");
        }else {
            throw new IllegalArgumentException("Year '"+year+"' is not a valid input");
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(year);
        sb.append("-");
        if(month < 10){
            sb.append("0");
            sb.append(month);
        }else{
            sb.append(month);
        }
        sb.append("-");
        if(date < 10){
            sb.append("0");
            sb.append(date);
        }else{
            sb.append(date);
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Date o) {
        int yearCompare = Integer.compare(o.getYear(), year);
        int monthCompare = Integer.compare(o.getMonth(), month);
        int dayCompare = Integer.compare(o.getDate(), date);

        return yearCompare == 0 ? (monthCompare == 0 ? dayCompare : monthCompare) : yearCompare;

    }
}
