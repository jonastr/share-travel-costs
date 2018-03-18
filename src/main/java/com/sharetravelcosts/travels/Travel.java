package com.sharetravelcosts.travels;


import java.text.SimpleDateFormat;
import org.springframework.data.annotation.Id;


public class Travel {
    @Id
    public String id;

    public String userId;
    public String destination;
    public SimpleDateFormat start;
    public SimpleDateFormat end;

    public Travel() {}

    public Travel(String destination, SimpleDateFormat start, SimpleDateFormat end) {
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