package Console;

import java.time.LocalDate;

public class Patient extends Person {
    private int patientID;

    public Patient(String inputFirstName, String inputSurName, LocalDate inputDateOfBirth, String inputContactNumber, int inputPatientID) {
        super(inputFirstName, inputSurName, inputDateOfBirth, inputContactNumber);
        this.patientID = inputPatientID;
    }

    public Patient(String inputFirstName, String inputSurName, LocalDate inputDateOfBirth, String inputContactNumber) {
        super(inputFirstName, inputSurName, inputDateOfBirth, inputContactNumber);
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int newPatientID) {
        this.patientID = newPatientID;
    }

}
