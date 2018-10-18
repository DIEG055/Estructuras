/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 *
 * @author juan.castro
 */
public class MyClock implements Comparable<MyClock> {
    
    private int hours;
    
    private int minutes;
    
    private int seconds;

    public MyClock() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    public MyClock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }
    
    

    @Override
    public int compareTo(MyClock o) {
        if (this.hours > o.getHours())
            return 1;
        else if (this.hours < o.getHours())
            return -1;
        else if(this.minutes > o.getMinutes())
            return 1;
        else if(this.minutes < o.getMinutes())
            return -1;
        else if(this.seconds > o.getSeconds())
            return 1;
        else if(this.seconds < o.getSeconds())
            return -1;
        else
            return 0;
                    
    }
    
    
    
}
