package Console;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consultation extends Patient {

    //localDateTime stores both date and time unlike Local date which stores only the date
    private int No;
    private LocalDate consultationDate;
    private LocalTime consultationStartTime;
    private LocalTime consultationEndTime;
    private String consultationID;
    private String additionalNote;
    private String securityCode;
    private double cost;




    public Consultation(int No, String inputFirstName, String inputSurName, LocalDate inputDateOfBirth, String inputContactNumber, int inputPatientID, String inputConsultationID, LocalTime inputConsultationStartTime, LocalTime inputConsultationEndTime, LocalDate inputConsultationDate, String inputAdditionalNotes, double inputCost, String inputSecurityCode) {
        super(inputFirstName, inputSurName, inputDateOfBirth, inputContactNumber);
        this.No = No;
        this.consultationDate = inputConsultationDate;
        this.consultationStartTime = inputConsultationStartTime;
        this.consultationEndTime = inputConsultationEndTime;
        this.consultationID = inputConsultationID;
        this.additionalNote = inputAdditionalNotes;
        this.cost = inputCost;
        this.securityCode = inputSecurityCode;
    }

    //getters and setters
    //consultation date

    public int getNo() {
        return No;
    }

    public void setNo(int newNo){
        this.No = newNo;
    }

    public LocalDate getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(LocalDate newInputConsultationDate) {
        this.consultationDate = newInputConsultationDate;
    }
    //consultation time
    public LocalTime getConsultationStartTime() {
        return consultationStartTime;
    }

    public void setConsultationStartTime(LocalTime newConsultationStartTime) {
        this.consultationStartTime = newConsultationStartTime;
    }
    //consultation slot
    public String getConsultationID() {
        return consultationID;
    }

    public void setConsultationID(String newConsultationID) {
        this.consultationID = newConsultationID;
    }
    //consultation note
    public String getAdditionalNote() {
        return additionalNote;
    }

    public void setAdditionalNote(String newAdditionalNote) {
        this.additionalNote = newAdditionalNote;
    }

    public void setConsultationEndTime(LocalTime newInputConsultationEndTime) {
        this.consultationEndTime = newInputConsultationEndTime;
    }

    public LocalTime getConsultationEndTime() {
        return consultationEndTime;
    }

    public double getCost() {return cost;}

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String newInputSecurityCode) {
        this.securityCode = newInputSecurityCode;
    }

    @Override
    public String toString() {
        return  "01.First Name          : " + this.getFirstName() + '\n' +
                "02.Surname             : " + this.getSurName() + '\n' +
                "03.Date-of-Birth       : " + this.getDateOfBirth() + '\n' +
                "04.Contact Number      : " + this.getContactNumber() + '\n' +
                "05.Patient-ID          : " + this.getPatientID() + '\n' +
                "06.Consultation-Date   : " + this.getConsultationDate() +'\n'+
                "07.Start-Time          : " + this.getConsultationStartTime() +'\n'+
                "08.End-Time            : " + this.getConsultationEndTime() +'\n'+
                "09.Consulted-Doctor    : " + this.getConsultationID() +'\n'+
                "10.Cost for Consulation: " + this.getCost() +'\n'+
                "11.Additional Note     : \n " + this.getAdditionalNote() +'\n';
    }
}
