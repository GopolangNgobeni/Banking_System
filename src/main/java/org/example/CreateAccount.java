package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;

import java.util.Scanner;
import java.io.IOException;

public class CreateAccount {
    String fullName ;
    String surName ;
    String emailAddress;
    int idNumber;
    int cellNumber;
    String Occupation;
    int monthlyIncome;
    String accountType;

    String street;
    String town;
    String city;
    int postalCode;


    String color;
    String pSchool;
    int pinNumber;

    Scanner details = new Scanner(System.in);

    public void getFullName() {
        System.out.println("Personal details required");
        System.out.println("Enter full names (as per Official ID): ");
        fullName = details.nextLine();
    }

    public void getSurname() {
        System.out.println("Enter Surname: ");
        surName = details.nextLine();

    }
    public void getIdNumber() {

        System.out.println("Enter your Social Security Numbers (identity number)");
        idNumber = details.nextInt();

    }
    public void getCellNumber() {
        System.out.println("--Enter your Contact details--");
        System.out.println("Enter your cellphone number: ");
        cellNumber = details.nextInt();

    }
    public void getEmailAddress() {
        System.out.println("Enter your EmailAddress: ");
        emailAddress = details.nextLine();
        details.nextLine();


    }

    public void getAddress(){
        System.out.println("--Enter your Address Details--");
        System.out.println("Enter street name and number: ");
        street = details.nextLine();
        System.out.println("Enter the name of your town: ");
        town = details.nextLine();
        System.out.println("Enter the name of your city: ");
        city = details.nextLine();
        System.out.println("Enter your postal code \n" +
                "eg 0400");
        postalCode = details.nextInt();
        details.nextLine();


    }
    public void getOccupation(){

        System.out.println("Enter your Occupation: ");
        System.out.println("eg Software Engineer , Student, Self-employed ect...");
        Occupation = details.nextLine();

    }

    public void getIncome(){
        System.out.println("Enter your monthly earnings: ");
        System.out.println("eg R 5000");
        monthlyIncome = details.nextInt();
        details.nextLine();

    }

    public void accountType(){
        System.out.println("Please select account type: ");
        System.out.println("--Enter Cheque ar Savings--");
        accountType = details.nextLine();


    }
    public void createPin(){
        System.out.println("Enter any 4 digits to save as your account pin");
        pinNumber = details.nextInt();
        System.out.println("pin saved");
        details.nextLine();
    }
    public void securityQuestions(){
        System.out.println("--Answer the following security questions for account recovery.--");
        System.out.println("What is your favourite colour? ");
        color = details.nextLine();
        System.out.println("Which primary school did you got to?");
        pSchool = details.nextLine();


    }

    public void savePersonalDetails() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonNode = objectMapper.createObjectNode();
        ObjectNode personalDetails = objectMapper.createObjectNode();
        ObjectNode contactDetails = objectMapper.createObjectNode();
        ObjectNode address = objectMapper.createObjectNode();
        ObjectNode security = objectMapper.createObjectNode();

        personalDetails.put("Name", fullName);
        personalDetails.put("SurName", surName);
        personalDetails.put("Identity Number" ,idNumber);
        contactDetails.put("Cellphone Number", cellNumber);
        contactDetails.put("EmailAddress", emailAddress);
        personalDetails.put("Occupation", Occupation);
        personalDetails.put("Monthly_Income", "R" + monthlyIncome);
        personalDetails.put("Account_Type", accountType);
        address.put("Street",street);
        address.put("Town",town);
        address.put("City",city);
        address.put("PostalCode",postalCode);
        security.put("AccountPin: ", pinNumber);
        security.put("Favourite_Color", color);
        security.put("Primary_School", pSchool);

        jsonNode.set("PERSONAL_DETAILS",personalDetails );
        personalDetails.set("ADDRESS",address);
        personalDetails.set("CONTACT_DETAILS",contactDetails);
        personalDetails.set("SECURITY_COMPLIENCE_ANSWERS",security);
        ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
        writer.writeValue(new File("PersonalData.json"),jsonNode);
        System.out.println(accountType+ "Account Successfully Created..");
    }



    public void openAccount(){
            try{
            CreateAccount call = new CreateAccount();
            call.getFullName();
            call.getSurname();
            call.getIdNumber();
            call.getCellNumber();
            call.getEmailAddress();
            call.getAddress();
            call.getOccupation();
            call.getIncome();
            call.accountType();
            call.createPin();
            call.securityQuestions();
            call.savePersonalDetails();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
