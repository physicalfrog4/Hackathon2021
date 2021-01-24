
import java.util.LinkedList;

public class BloodTest {
	String date;
	LinkedList<String> medications;
	boolean fasting;
	double e1;
	double e2;
	double e3;

	public BloodTest(String date, LinkedList<String> medications,boolean fasting, double e1, double e2, double e3) {
		this.date = date;
		this.medications = medications;
		this.fasting = fasting;
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
	}
}
