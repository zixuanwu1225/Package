public class Package {
    private Address origin;
    private Address destination;
    int weight;//cannot be less than 1/10 of a lbs.
    //cannot have dimensions less than 2 inches
    int length;
    int width;
    int height;
    int zip1=0;
    int zip2=0;

    public Package(int zip1,int zip2,int width,int length,int height,int weight){
        this.width=width;
        this.length=length;
        this.height=height;
        this.weight=weight;
    }

    public Address getOrigin() {
        return origin;
    }

    public Address getDestination() {
        return destination;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getWeight() {
        return weight;
    }
}
