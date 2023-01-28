import java.util.*;

public class idSorter implements Comparator<DateEvent>{

    @Override
    public int compare(DateEvent o1, DateEvent o2) {
        return Long.valueOf(o1.getID()).compareTo(Long.valueOf(o2.getID()));
    }
    
}
