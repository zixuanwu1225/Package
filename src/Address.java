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
        int aptIndent = 0;
        String[] delivery = address.split("\\,");
        deliver.addAll(Arrays.asList(delivery));
        if (delivery.length > 5) {
            aptIndent = 1;
            this.aptNumber = delivery[2].replace(",", "");
        }
        this.streetNumber=deliver.get(0);
        this.streetName=deliver.get(1);
        this.city=deliver.get(3+aptIndent);
        this.state=deliver.get(4+aptIndent);
        this.zip=parseInt(deliver.get(5+aptIndent));
    }
    public void zipcode(int zipcode) {
        this.zip = zipcode;
    }
    public int zipcode() {
        return this.zip;
    }

    public void state(String state) {
        this.state = state;
    }
    public String state() {
        return this.state;
    }

    public void city(String city) {
        this.city = city;
    }
    public String city() {
        return this.city;
    }

    public void apartmentNumber(String apartmentNumber) {
        this.aptNumber = apartmentNumber;
    }
    public String apartmentNumber() {
        return this.aptNumber;
    }

    public void streetName(String streetName) {
        this.streetName = streetName;
    }
    public String streetName() {
        return this.streetName;
    }

    public void streetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
    public String streetNumber() {
        return this.streetNumber;
    }

    public String toString() {
        return this.streetNumber + " " + this.streetName + " " + this.aptNumber + ", " + this.city
                + ", " + this.state + " " + this.zip;
    }
}
