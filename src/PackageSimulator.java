import java.util.ArrayList;

public class PackageSimulator {
    private int width=0;
    private int length=0;
    private int height=0;
    private int weight=0;
    private int zip1=0;
    private int zip2=0;

    ArrayList<Package> packages = new ArrayList<Package>();
    public ArrayList<Package> generatePackages(int amt){
        //max weight=70 lbs, size<130; length+girth; girth=2*height+2*width;
        for(int i=0;i<amt;i++){
            //zeroes are placeholders for now;Remove when done
            zip1=0;
            zip2=0;
            width=0;
            length=0;
            height=0;
            weight=0;
            Package pack = new Package(zip1,zip2,width,length,height,weight);
            packages.add(pack);
        }
        return packages;
    }
    public double generateTotalCost(){
        //return total cost of all packages inside "packages"
    }
    public String getSimulatioInfo(){
        //returns all simulation info as specified in beginning of document
    }
    public static void resetSimulation(){
        //removes all objects inside "packages" to be empty 
    }
}
