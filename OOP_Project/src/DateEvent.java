import java.io.*;
public class DateEvent extends DateAndTime implements Serializable{
    private int ID;
    private String event;
    
    public DateEvent(){
        this.ID = 0;
        this.date = "";
        this.time = "";
        this.event = "";
    }
    
    public DateEvent(int ID, String date, String time, String event) {
        this.ID = ID;
        this.date = date;
        this.time = time;
        this.event = event;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getTime() {
        return time;
    }

    @Override
    public void setTime(String time) {
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
    
}
