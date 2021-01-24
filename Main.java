
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		//initialized variables
		String dob1 ="02/11/2002";
		LinkedList<String> aMeds = new LinkedList<String>();
		LinkedList<String> bMeds = new LinkedList<String>();
		bMeds.add("Cryselle");
		Report aReport = new Report(new LinkedList<String>(),new LinkedList<LinkedList>(), new LinkedList<Boolean>(), new LinkedList<Double>(),new LinkedList<Double>(),new LinkedList<Double>() );
		LinkedList<Account> Users = new LinkedList<Account>();
		Account Alison = new Account( "Alison McNicholas",  dob1,bMeds, aReport);
		Users.add(Alison);
		Menu Comp1 = new Menu(Users);
		
		//BloodTest1
		String d1 = "05/20/2020";
		double e11 = 88;
		double e21 = 7.8;
		double e31 = 15;
		BloodTest Test1AM = new BloodTest(d1,aMeds,true,e11,e21,e31);
		
		//BloodTest2
		String d2 = "01/08/2021";
		double e12 = 140;
		double e22 = 8.2;
		double e32 = 30;
		BloodTest Test2AM = new BloodTest(d2,bMeds,false,e12,e22,e32);

		//BloodTest3
		String d3 ="01/15/2021";
		double e13 = 90;
		double e23 = 10.5;
		double e33 = 67;
		BloodTest Test3AM = new BloodTest(d3,aMeds,true,e13,e23,e33);

		//Report
		aReport.addToReport(Test1AM);
		aReport.addToReport(Test2AM);
		aReport.addToReport(Test3AM);

		Comp1.Start();

	}
}

