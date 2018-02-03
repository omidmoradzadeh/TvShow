package DTO;

public class Country
{
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    String name;

    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    String code;

    public String getTimezone() {
        return this.timezone;
    }
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    String timezone;

}
