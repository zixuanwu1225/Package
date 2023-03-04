public class PostageCaluculator {
    //add 10 cents for each 1/10 of a lbs
    //Divide diff in country codes by 100 then add to final cost
    //Note: country code = first 3 digits of zip
    private double cost=3.75;
    private double costOfTenthOfPound=0.05;
    private double costOfExtraInch=0;
    private double finalCost = 0;
    public double calculatePostage(int zip1, int zip2, double weight, double length, double height, double width){
        finalCost = this.cost;
        int countryCode1 = (zip1 - (zip1%100))/100;
        int countryCode2 = (zip2 - (zip2%100))/100;
        double zipCodeCost = 0;
        double weightCost = 0;
        if (weight > 40) {
            weightCost=(400 * 0.05) + ( ((weight - 40) /.1) * 0.1);
        }
        else{
            weightCost = (weight/0.1)*costOfTenthOfPound;
        }

        double sizeCost=0;
        zipCodeCost=Math.abs(countryCode1-countryCode2);
        if(costIfExceedingSize(length,width,height)){
            sizeCost+=((length + width + height) - 36) * .1;
        }
        else {
            sizeCost = 0;
        }
        finalCost+=zipCodeCost+weightCost+sizeCost;
        return  finalCost;
    }
    public double calculatePostage(Address origin, Address destination,double weight, double length, double height, double width){
        finalCost = this.cost;
        int countryCode1 = (origin.zipcode() - (origin.zipcode()%100))/100;
        int countryCode2 = (destination.zipcode() - (destination.zipcode()%100))/100;
        double zipCodeCost = 0;
        double weightCost = 0;
        if (weight > 40) {
            weightCost=(400 * 0.05) + ( ((weight - 40) /.1) * 0.1);
        }
        else{
            weightCost = (weight/0.1)*costOfTenthOfPound;
        }

        double sizeCost=0;
        zipCodeCost=Math.abs(countryCode1-countryCode2);
        if(costIfExceedingSize(length,width,height)){
            sizeCost+=((length + width + height) - 36) * .1;
        }
        else {
            sizeCost = 0;
        }
        finalCost+=zipCodeCost+weightCost+sizeCost;
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
        if(costIfExceedingSize(pack.getLength(),pack.getWidth(),pack.getHeight())){
            sizeCost+=((pack.getLength() + pack.getWidth() + pack.getHeight()) - 36) * .1;
        }
        else {
            sizeCost = 0;
        }
        finalCost+=zipCodeCost+weightCost+sizeCost;
        return  finalCost;
    }
    public static boolean costIfExceedingSize(double length, double width, double height) {
        if (length + width + height > 36){
            return true;
        }
        return false;
    }
    //can add extra methods if needed
}
