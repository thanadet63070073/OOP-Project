import java.util.*;

public class DateAndTimeSorter implements Comparator<DateEvent>{
    public int compare(DateEvent o1, DateEvent o2) {
        String date1 = o1.getDate().substring(6)+"/"+o1.getDate().substring(3, 5)+"/"+o1.getDate().substring(0, 2)+"/"+o1.getTime();
        String date2 = o2.getDate().substring(6)+"/"+o2.getDate().substring(3, 5)+"/"+o2.getDate().substring(0, 2)+"/"+o2.getTime();
        
        return date1.compareToIgnoreCase(date2);
    }
}
