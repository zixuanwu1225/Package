public class Package {
    private Address origin;
    private Address destination;
    double weight;//cannot be less than 1/10 of a lbs.
    //cannot have dimensions less than 2 inches
    double length;
    double width;
    double height;
    int zip1=0;
    int zip2=0;

    public Package(int zip1,int zip2,double width,double length,double height,double weight){
        this.width=width;
        this.length=length;
        this.height=height;
        this.weight=weight;
        this.zip1=zip1;
        this.zip2 = zip2;
    }
    public boolean packageCheck(Package pack){
        if(pack.getWidth()<2){
            return false;
        }
        if(pack.getLength()<2){
            return false;
        }
        if(pack.getHeight()<2){
            return false;
        }
        if(pack.getWeight()<0.1){
            return false;
        }
        return true;
    }

    public int getOrigin() {
        return zip1;
    }

    public int getDestination() {
        return zip2;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }
}
