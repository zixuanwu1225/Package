import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Address {
    private String streetNumber;
    private String streetName;
    private String aptNumber;
    private String city;
    private String state;
    private int zip;
    public Address(String streetNumber,String streetName,String aptNumber,String city,String state,int zip){
        this.streetNumber=streetNumber;
        this.streetName=streetName;
        this.aptNumber=aptNumber;
        this.city=city;
        this.state=state;
        this.zip=zip;
    }
    public Address(Address address){
        this.streetNumber=address.streetNumber;
        this.streetName=address.streetName;
        this.aptNumber=address.aptNumber;
        this.city= address.city;
        this.state= address.state;
        this.zip= address.zip;
    }
    public Address(String address){
        ArrayList<String> deliver = new ArrayList<String>();
        String[] delivery = address.split("\\,");
        deliver.addAll(Arrays.asList(delivery));
        this.streetNumber=deliver.get(0);
        this.streetName=deliver.get(1);
        this.aptNumber=deliver.get(2);
        this.city=deliver.get(3);
        this.state=deliver.get(4);
        this.zip=parseInt(deliver.get(5));
    }
}
