package Console;

import java.time.LocalDate;

public abstract class Person {
    private String firstName;
    private String surName;
    private LocalDate dateOfBirth;
    private String contactNumber;

    public Person(String inputFirstName, String inputSurName, LocalDate inputDateOfBirth, String inputContactNumber){
        this.firstName = inputFirstName;
        this.surName = inputSurName;
        this.dateOfBirth = inputDateOfBirth;
        this.contactNumber = inputContactNumber;
    }

    //getters
    public String getFirstName() {return firstName;}
    public String getSurName() {return surName;}
    public LocalDate getDateOfBirth() {return dateOfBirth;}
    public String getContactNumber() {return contactNumber;}

    //setters
    public void setFirstName(String newFirstName) {this.firstName = newFirstName;}
    public void setSurName(String newSurName) {this.surName = newSurName;}
    public void setDateOfBirth(LocalDate newDateOfBirth) {this.dateOfBirth = newDateOfBirth;}
    public void setContactNumber(String newContactNumber) {this.contactNumber = newContactNumber;}
}

