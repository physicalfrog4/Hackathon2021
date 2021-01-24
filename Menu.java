import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
	Scanner keyboard = new Scanner(System.in);
	LinkedList<Account> listOfUsers;

	public Menu (LinkedList<Account> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}
	
	// the Start Menu
	public void Start()  {
		String inputName;
		String inputDOB;
		System.out.println("Type First and Last name of User");	
		inputName = keyboard.nextLine();
		for(int i=0; i < listOfUsers.size();i++) {
			if  (inputName.equals( listOfUsers.get(i).name)) {
				System.out.println("Found Account, please enter Date of Birth (MM/DD/YYYY)");		
				inputDOB = keyboard.nextLine();
				if (inputDOB .equals(listOfUsers.get(i).dateOfBirth)) {
					this.selectionMenu(listOfUsers.get(i));			
				}
			}
		}
	}
	
	//Menu to select to access data or to enter new data
	public void selectionMenu(Account aPerson) {
		double decision;
		System.out.println("Type 1 to access account data");
		System.out.println("Type 2 to enter new data");
		decision = keyboard.nextDouble();
		if(decision == 1) {
			this.Screen(aPerson);
		}
		if(decision == 2) {
			this.enterData(aPerson);
		}
	}
	
	//Results for when a user wants to access their data
	public void Screen(Account aPerson) {

		System.out.println("Account Accessed. Report for " + aPerson.name);
		System.out.println();
		for(int i=0; i< aPerson.aReport.datesCollected.size();i++) {
			System.out.println(aPerson.aReport.datesCollected.get(i));
			if(aPerson.aReport.allMedications.get(i).equals( new LinkedList<String>())) {
				System.out.println("no medications");
			}
			else {
				System.out.println("medications: " + aPerson.aReport.allMedications.get(i));
			}
			if(aPerson.aReport.fasts.get(i) == true) {
				System.out.println("Fasted.");
			}
			if(aPerson.aReport.fasts.get(i) == false) {
				System.out.println("Did not Fast.");
			}
			System.out.println("e1 level: " + aPerson.aReport.e1List.get(i));
			System.out.println("e2 level: " + aPerson.aReport.e2List.get(i));
			System.out.println("e3 level: " + aPerson.aReport.e3List.get(i));
			System.out.println();
		}

		System.out.println("Would you like to see an Anaylisis from the past " + aPerson.aReport.datesCollected.size() + " lab reports?" );
		System.out.println("Type 'Yes' or 'No'");
		if(keyboard.next().equals("Yes")) {
			this.Anaylisis(aPerson);
		}

	}

	// analysis of the data
	public void Anaylisis(Account aPerson) {
		System.out.println("Average Readings");
		System.out.println("Average reading of e1: " + aPerson.aReport.findAverage(aPerson.aReport.e1List));
		System.out.println("Average reading of e2: " + aPerson.aReport.findAverage(aPerson.aReport.e2List));
		System.out.println("Average reading of e3: " + aPerson.aReport.findAverage(aPerson.aReport.e3List));
		System.out.println();
		System.out.println("Report on Dangerous Levels");
		aPerson.aReport.isLevelDangerous(aPerson.aReport.e1List);
		aPerson.aReport.isLevelDangerous(aPerson.aReport.e2List);
		aPerson.aReport.isLevelDangerous(aPerson.aReport.e3List);
		System.out.println();
	}

	//creates a list of medications to be added to a report
	public LinkedList<String> addMedications( LinkedList<String> meds){
		String med = keyboard.next();
		if(med.equals("finished")){
			System.out.println("Medications Recorded");
		}
		else {
			meds.add(med);
			this.addMedications( meds);

		}
		return meds;
	}
	
	//allows user to enter data
	public void enterData(Account aPerson) {
		String newDate;
		LinkedList<String> meds = new LinkedList<String>();
		boolean fasted = false;
		double e1;
		double e2;
		double e3;
		System.out.println("What was the date the test was taken (MM/DD/YYYY)");
		newDate = keyboard.next();
		System.out.println("What medication are you on? Please list on at a time and type 'finished' when you entered all of your medications");
		meds = this.addMedications( meds);

		System.out.println("Were you fasting? Type 'Yes' or 'No'");
		String fastAnswer = keyboard.next();
		if(fastAnswer.equals("Yes")) {
			fasted = true;
		}

		System.out.println("What was the e1 reading");
		e1 = keyboard.nextDouble();
		System.out.println("What was the e2 reading");
		e2= keyboard.nextDouble();
		System.out.println("What was the e3 reading");
		e3 = keyboard.nextDouble();
		BloodTest newTest = new BloodTest(newDate, meds,fasted, e1, e2, e3);
		aPerson.aReport.addToReport(newTest);
		this.selectionMenu(aPerson);
	}

}