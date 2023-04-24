package Console;

import GUI.GUI;
import java.io.*;
import java.lang.System;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    public static ArrayList<Doctor> doctorDetails = new ArrayList<>(10);
    public static ArrayList<Consultation> consult = new ArrayList <>();
    Scanner myObj1 = new Scanner(System.in);

    public static void main(String[] args)  {
        WestminsterSkinConsultationManager myManager = new WestminsterSkinConsultationManager();
        while (true) {
            try {
                System.out.println("-".repeat(10) + " Westminster Skin Consultation Manager " + "-".repeat(10));
                System.out.println("\n");
                System.out.println("""
                        1. Add a new doctor
                        2. Delete a doctor
                        3. Print the list of the doctors
                        4. Save to a file
                        5. Read data from saved file
                        6. Load data from saved file
                        7. GUI
                        8. Exit""");
                System.out.println("\n");

                Scanner myObj1 = new Scanner(System.in);
                System.out.print("Please enter the relevant option number : ");
                int option1 = myObj1.nextInt();

                switch (option1) {
                    case 1 -> {
                        myManager.addDoctor();
                        break;
                    }
                    case 2 -> {
                        myManager.deleteDoctor();
                        break;
                    }
                    case 3 -> {
                        myManager.printDoctorList();
                        break;
                    }
                    case 4 -> {
                        myManager.saveToList();
                        break;
                    }
                    case 5 -> {
                        myManager.readFile();
                        break;
                    }
                    case 6 -> {
                        myManager.loadFile();
                        break;
                    }
                    case 7 -> {
                        new GUI();
                    }
                    case 8 -> {
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Please enter a valid option number.");
                        main(null);
                    }
                }
            } catch (Exception x) {
                System.out.println("The option you entered was invalid.");
                main(null);
            }
        }
    }

    @Override
    public void addDoctor() {
        if (doctorDetails.size() != 10) {

            System.out.print("\nEnter doctor's first name : ");
            String inputFirstName = myObj1.next();
            while (true) {
                if (inputFirstName.matches("[A-Z][a-z]*")) {
                    break;
                } else {
                    System.out.println("Something went wrong.");
                    System.out.print("Enter doctor's first name : ");
                    inputFirstName = myObj1.next();
                }
            }

            System.out.print("\nEnter doctor's surname : ");
            String inputSurName = myObj1.next();
            while (true) {
                if (inputSurName.matches("[A-Z][a-z]*")) {
                    break;
                } else {
                    System.out.println("Something went wrong.");
                    System.out.print("Enter doctor's surname : ");
                    inputSurName = myObj1.next();
                }
            }

            LocalDate inputDateOfBirth;
            while (true) {
                try {
                    System.out.print("\nEnter doctor's date of birth (YYYY-MM-DD) : ");
                    inputDateOfBirth = LocalDate.parse(myObj1.next());
                    break;
                } catch (Exception e) {
                    System.out.println("Please enter the date in the given format.");
                }
            }

            System.out.print("\nEnter doctor's contact number : ");
            String inputContactNumber = myObj1.next();
            while (true) {
                if (inputContactNumber.matches("\\d+")) {
                    break;
                } else {
                    System.out.println("Something went wrong.");
                    System.out.print("Enter doctor's contact number : ");
                    inputContactNumber = myObj1.next();
                }
            }

            System.out.print("\nEnter doctor's licence number : ");
            String inputLicenceNumber = myObj1.next();
            while (true) {
                if (inputLicenceNumber.matches("\\d+")) {
                    break;
                } else {
                    System.out.print("Please enter a valid licence number : ");
                    inputLicenceNumber = myObj1.next();
                }
            }

            String inputSpecialisation;
            System.out.println("\nSelect doctor's specialisation by entering the relevant number.");
            while (true) {
                System.out.print("""
                        1. Cosmetic Dermatology
                        2. Medical Dermatology
                        3. Paediatric Dermatology
                        Your selection : """);
                String option3 = myObj1.next();
                if (option3.equals("1")) {
                    inputSpecialisation = "Cosmetic Dermatology";
                    break;
                } else if (option3.equals("2")) {
                    inputSpecialisation = "Medical Dermatology";
                    break;
                } else if (option3.equals("3")) {
                    inputSpecialisation = "Paediatric Dermatology";
                    break;
                } else {
                    System.out.println("Please enter a valid option number.");
                }
            }

            doctorDetails.add(new Doctor(inputFirstName, inputSurName, inputDateOfBirth, inputContactNumber, inputLicenceNumber, inputSpecialisation));
            System.out.println("Doctor's details added successfully.");

        } else {
            System.out.println("Maximum number of doctors have been added.");
        }
        main(null);

    }

    @Override
    public void deleteDoctor() {
        if (doctorDetails.size() != 0) {
            try {
                System.out.print("Enter the medical licence number:");
                String checkLicence = myObj1.next();
                for (Doctor doctor : doctorDetails) {
                    if (checkLicence.equals(doctor.getLicenceNumber())) {
                        doctorDetails.remove(doctor);
                        System.out.println("Doctor deleted successfully.");
                        main(null);
                    } else {
                        continue;
                    }
                }
            }
            catch (Exception x) {
                System.out.println("The licence number you entered was invalid.");
                main(null);
            }
        } else {
            System.out.println("\nDoctors list is empty.");
            main(null);
        }
    }

    @Override
    public void printDoctorList() {
        try {
            if (doctorDetails.isEmpty()) {
                System.out.println("\nDoctors list is empty.");
                main(null);
            } else {
                System.out.println("");
                System.out.println("-".repeat(10) + "Doctors List" + "-".repeat(10));
                doctorDetails.sort(Comparator.comparing(Doctor::getFirstName));
                for (Doctor doctor : doctorDetails) {
                    System.out.println("Name : " + doctor.getFirstName());
                    System.out.println("surname : " + doctor.getSurName());
                    System.out.println("Date of Birth : " + String.format("%1$tb %1$te, %1$tY", doctor.getDateOfBirth()));
                    System.out.println("Contact Number : " + doctor.getContactNumber());
                    System.out.println("Specialisation : " + doctor.getSpecialisation());
                    System.out.println("Medical Licence Number : " + doctor.getLicenceNumber());
                    System.out.println("");
                }

            }
            main(null);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveToList() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Doctor_Details.txt"));
            for (Doctor doctor : doctorDetails) {
                writer.write(doctor.getFirstName() + "\n" + doctor.getSurName() + "\n" + doctor.getDateOfBirth() + "\n" + doctor.getContactNumber() + "\n" + doctor.getLicenceNumber() + "\n" + doctor.getSpecialisation() + "\n\n");
            }
            System.out.println("Successfully saved to file.");
            writer.close();
            main(null);
        } catch (IOException e) {
            System.out.println("Something went wrong.");
            main(null);
        }
    }

    @Override
    public void readFile() {
        try {
            String line ;
            BufferedReader reader  = new BufferedReader(new FileReader("Doctor_Details.txt"));
            while ((line= reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
            main(null);
        }catch (IOException e){
            System.out.println("Something went wrong.");
            main(null);
        }
    }
    
    @Override
    public void loadFile() {
        try {
            String temp;
            ArrayList<String> tempArray = new ArrayList<>(10);
            BufferedReader tempObj = new BufferedReader(new FileReader("Doctor_Details.txt"));
            while ((temp = tempObj.readLine()) != null) {
                if (temp.equals("")) {
                    continue;
                } else {
                    tempArray.add(temp);}
            }
            if(tempArray.size()==0){
                System.out.println("\nNo records found.");
            }
            while(true) {
                if(tempArray.size()==0){
                    break;
                }else{
                    doctorDetails.add(new Doctor(tempArray.get(0), tempArray.get(1), LocalDate.parse(tempArray.get(2)), tempArray.get(3), tempArray.get(4), tempArray.get(5)));
                    tempArray.subList(0, 6).clear();
                }
            }
            main(null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong.");;
        }
    }
}



