package server.model;

import server.annotation.TargetFile;

@TargetFile(fileName = "auction.json")
public class Auction {

    private static long counter = 0L;
    private Long id;
    private Object object;
    private double minPrice;
    private int duration;

    public Auction(Object object, double minPrice, int duration) {
        this.id = ++counter;
        this.object = object;
        this.minPrice = minPrice;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Object getObject() { return object; }

    public void setObject(Object object) { this.object = object; }

    public double getMinPrice() { return minPrice; }

    public void setMinPrice(double minPrice) { this.minPrice = minPrice; }

    public int getDuration() { return duration; }

    public void setDuration(int duration) { this.duration = duration; }
}
