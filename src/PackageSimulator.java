import java.text.DecimalFormat;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class PackageSimulator {
    private double width=0;
    private double length=0;
    private double height=0;
    private double weight=0;
    private int zip1=0;
    private int zip2=0;
    private double cost=3.75;
    private double costOfTenthOfPound=0.05;
    private double costOfExtraInch=0;
    private double finalCost = 0;

    ArrayList<Package> packages = new ArrayList<Package>();
    public ArrayList<Package> generatePackages(int amt){
        //max weight=70 lbs, size<130;=length+girth; girth=2*height+2*width;
        for(int i=0;i<amt;i++){
            //zeroes are placeholders for now;Remove when done
            zip1=genZip();
            zip2=genZip();
            width=((Math.random()*40)+2);
            length=((Math.random()*40)+2);
            height=((Math.random()*40)+2);
            weight=((Math.random()*70)+2);
            Package pack = new Package(zip1,zip2,width,length,height,weight);
            packages.add(pack);
        }
        return packages;
    }
    public int genZip(){
        DecimalFormat d = new DecimalFormat("000");
        String zip = "";
        zip += d.format((int) (Math.random() * 995) + 5);
        zip += "01";
        return (parseInt(zip));
    }
    public double generateTotalCost(){
        double cost = 3.75;
        double finalCost = 0;
        for(Package p:packages){
            int countryCode1 = (p.getOrigin() - (p.getOrigin()%100))/100;
            int countryCode2 = (p.getDestination() - (p.getDestination()%100))/100;
            double zipCodeCost = 0;
            double weightCost = 0;
            if (p.getWeight() > 40) {
                weightCost=(400 * 0.05) + ( ((p.getWeight() - 40) /.1) * 0.1);
            }
            else{
                weightCost = (p.getWeight()/0.1)*0.05;
            }

            double sizeCost=0;
            zipCodeCost=Math.abs(countryCode1-countryCode2);
            if(PostageCaluculator.costIfExceedingSize(p.getLength(),p.getWidth(),p.getHeight())){
                sizeCost+=((p.getLength() + p.getWidth() + p.getHeight()) - 36) * .1;
            }
            else {
                sizeCost = 0;
            }
            finalCost+=zipCodeCost+weightCost+sizeCost;
        }
        return  finalCost;
    }
    public double calculatePostage(Package pack){
        finalCost = this.cost;
        int countryCode1 = (pack.getOrigin() - (pack.getOrigin()%100))/100;
        int countryCode2 = (pack.getDestination() - (pack.getDestination()%100))/100;
        double zipCodeCost = 0;
        double weightCost = 0;
        if (pack.getWeight() > 40) {
            weightCost=(400 * 0.05) + ( ((pack.getWeight() - 40) /.1) * 0.1);
        }
        else{
            weightCost = (pack.getWeight()/0.1)*costOfTenthOfPound;
        }

        double sizeCost=0;
        zipCodeCost=Math.abs(countryCode1-countryCode2);
        if(PostageCaluculator.costIfExceedingSize(pack.getLength(),pack.getWidth(),pack.getHeight())){
            sizeCost+=((pack.getLength() + pack.getWidth() + pack.getHeight()) - 36) * .1;
        }
        else {
            sizeCost = 0;
        }
        finalCost+=zipCodeCost+weightCost+sizeCost;
        return  finalCost;
    }
    public void getSimulatioInfo(){
        int packageNumber = 1;
        for (int i=0;i<packages.size();i++){
            System.out.println("Package "+packageNumber+":------------------------------------");
            System.out.println("Weight: "+packages.get(i).getWeight());
            System.out.println("Height: "+packages.get(i).getHeight());
            System.out.println("Length: "+packages.get(i).getLength());
            System.out.println("Width: "+packages.get(i).getWidth());
            System.out.println("Origin: 123 Random Street Apt 3C,City,State"+packages.get(i).getOrigin());
            System.out.println("Destination: 123 Random Street Apt 3C,City,State"+packages.get(i).getDestination());
            System.out.println("Cost: "+calculatePostage(packages.get(i)));
            System.out.println();
            packageNumber++;
        }
        System.out.println("------------------------------------");
        System.out.println("Total Cost: "+generateTotalCost());
    }
    public void resetSimulation(){
        packages = new ArrayList<Package>();
    }
}
