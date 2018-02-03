package DTO;

public class Network
{
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    int id;

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    String name;

    public Country getCountry() {
        return this.country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }
    Country country;

}
