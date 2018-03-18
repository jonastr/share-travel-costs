package com.sharetravelcosts.travels;


import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;


public class Travel {
    @Id
    public String id;

    public String userId;
    public String destination;
    @Transient
    public Date start;
    @Transient
    public Date end;

    public Travel() {}

    public Travel(String destination, Date start, Date end) {
    			this.destination = destination;
    			this.start = start;
    			this.end = end;
    }

    @Override
    public String toString() {
        return String.format(
                "Travel[id=%s, destination='%s', start='%s', end='%s']",
                id, destination, start, end);
    }
}