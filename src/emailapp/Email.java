package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity = 500;
	private int defaultPasswordLength = 8;
	private String alternateEmail;
	private String companySuffix = "03teamstack.com";
	
	// Constructor to receive first and last name
	public Email(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		// Call a method asking for the department - return the department
		this.department = setDepartment();
		// Call a method to generate a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is : " + this.password);
		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}
	
	//Ask for department
	private String setDepartment() {
		System.out.print("New employee: " + firstName + " \nDepartment Codes: \n 1. Sales \n 2. Development \n 3. Accounting \n 0. None \n Enter the department code : ");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int depChoice =  in.nextInt();
		if (depChoice == 1) { return "Sales"; }
		else if (depChoice == 2) { return "Development"; }
		else if (depChoice == 3) { return "Accounting"; }
		else { return "" ;}
		}
	
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
		char[] password = new char[length];
		for (int i=0; i<length; i++)
		{
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
			}
		return new String(password);
	}
	
	// Set the mailbox Capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
	}
	
	// Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailBoxCapacity() { return mailBoxCapacity; }
	public String getAlternateEmail() { return alternateEmail; }
	public String getPassword() { return password; }
	
	public String showInfo() {
		return "DISPLAY NAME : " + 	firstName + " " + lastName + 
				"\nCOMPANY EMAIL : " + email + 
				"\nMAILBOX CAPACITY : " + mailBoxCapacity + "mb" ;
	}
	
	
}

