package server.model;

import server.annotation.TargetFile;

@TargetFile(fileName = "object.json")
public class Object {

    private static long counter = 0L;
    private Long id;
    private long owner;
    private String characteristics;
    private String image;

    public Object(long owner, String characteristics, String image) {
        this.id = ++counter;
        this.owner = owner;
        this.characteristics = characteristics;
        this.image = image;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getOwne(){
        return owner;
    }
    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public void setOwner(long owner){
        this.owner = owner;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
