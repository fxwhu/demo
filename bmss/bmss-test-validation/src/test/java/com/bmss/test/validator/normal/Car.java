package com.bmss.test.validator.normal;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by fengxuan1 on 2017/3/28.
 */
public class Car {

    @NotBlank
    private String manufacturer;

    @NotNull
    @Size(min=2, max = 14)
    private String licensePalte;

    @Min(2)
    private int seatCount;

    @NotNull
    @Valid
    private Person person;




    public Car(String manufacturer, String licensePalte, int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePalte = licensePalte;
        this.seatCount = seatCount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLicensePalte() {
        return licensePalte;
    }

    public void setLicensePalte(String licensePalte) {
        this.licensePalte = licensePalte;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
