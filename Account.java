
import java.util.LinkedList;
import java.util.Scanner;


public class Account {
	String name;
	String dateOfBirth;
	LinkedList<String> Medicines;
	Report aReport;

	public Account(String name, String dateOfBirth, LinkedList<String> Medicines, Report aReport) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.Medicines = Medicines;
		this.aReport = aReport;

	}
}