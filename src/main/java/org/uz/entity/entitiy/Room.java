package org.uz.entity.entitiy;

import java.util.Date;

public class Room {
    public static Room[][] rooms = new Room[10][20];
    private Boolean free = true;
    private Date date;
    private Boolean active = true;
    private String bookedBy;

    static {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                rooms[i][j] = new Room(true, null, true, null);
            }
        }
    }

    public Room(Boolean free, Date date, Boolean active, String bookedBy) {
        this.free = free;
        this.date = date;
        this.active = active;
        this.bookedBy = bookedBy;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    @Override
    public String toString() {
        return "Room{" +
                "free=" + free +
                ", date=" + date +
                ", active=" + active +
                ", bookedBy='" + bookedBy + '\'' +
                '}';
    }
}
