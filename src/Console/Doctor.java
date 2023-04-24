package Console;

import java.time.LocalDate;

public class Doctor extends Person {
    String licenceNumber;
    String specialisation;

    public Doctor(String inputFirstName, String inputSurName, LocalDate inputDateOfBirth, String inputContactNumber, String inputLicenceNumber, String inputSpecialisation) {
        super(inputFirstName, inputSurName, inputDateOfBirth, inputContactNumber);
        this.licenceNumber = inputLicenceNumber;
        this.specialisation = inputSpecialisation;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    @Override
    public String toString() {
        return  "01.Name             : " + this.getFirstName() + '\n' +
                "02.SurName          : " + this.getSurName() + '\n' +
                "03.Date-of-Birth    : " + this.getDateOfBirth() + '\n' +
                "04.Mobile-No        : " + this.getContactNumber() + '\n' +
                "05.MedicalLicence   : " + licenceNumber + '\n' +
                "06.Specialisation   : " + specialisation +'\n';
    }


}
