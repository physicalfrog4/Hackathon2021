
import java.util.LinkedList;

public class Report{
	LinkedList<String> datesCollected;
	LinkedList<LinkedList> allMedications;
	LinkedList<Boolean> fasts;
	LinkedList<Double> e1List;
	LinkedList<Double> e2List;
	LinkedList<Double> e3List; 
	LinkedList<BloodTest> Reports;

	public Report(LinkedList<String> datesCollected,LinkedList<LinkedList> allMedications,LinkedList<Boolean> fasts, LinkedList<Double> e1List, LinkedList<Double> e2List, LinkedList<Double> e3List) {
		this.datesCollected =new LinkedList<String>();
		this.allMedications = allMedications;
		this.fasts = fasts;
		this.e1List = e1List;
		this.e2List = e2List;
		this.e3List = e3List;
	}

//adds a BloodTest to a report in an Account
	public void addToReport(BloodTest aTest) {
		datesCollected.add(aTest.date);
		allMedications.add(aTest.medications);
		fasts.add(aTest.fasting);
		e1List.add(aTest.e1);
		e2List.add(aTest.e2);
		e3List.add(aTest.e3);

	}
	//finds the average in the list of enzymes
	public double findAverage(LinkedList<Double> aList) {
		double sum = 0;
		for(int i = 0; i < aList.size(); i++) {
			sum =   aList.get(i) + sum ;
		}
		return sum/aList.size();
	}

//determines if the reading is dangerous depending on which enzyme is high or low
	public void isLevelDangerous(LinkedList<Double> List) {
		for(int i = 0; i < List.size(); i++) {
			String dateCollected = this.datesCollected.get(i);
			double e1High = 110;
			double e1Low = 80;
			double e2High =10;
			double e2Low =5;
			double e3High = 200;
			double e3Low = 60;

			if (List.equals(e1List)){
				if(e1List.get(i) > e1High) {
					System.out.println("For " + dateCollected + " e1 levels are high: " + e1List.get(i) + " Should be less than " +e1High + ".");
				}
				if(e1List.get(i) < e1Low) {
					System.out.println("For " + dateCollected + " e1 levels are low: " + e1List.get(i) + " Should be greater than "+ e1Low +"." );
				}
			}
			if (List.equals(e2List)){
				if(e2List.get(i) > 10) {
					System.out.println("For " + dateCollected + " e2 levels are high: " + e2List.get(i) + " Should be less than " +e2High + ".");
				}
				if(e2List.get(i) < 5) {
					System.out.println("For " + dateCollected + " e2 levels are low: " + e2List.get(i)+ " Should be greater than " + e2Low + ".");
				}
			}
			if (List.equals(e3List)){
				if(e3List.get(i) > e3High) {
					System.out.println("For " + dateCollected + " e3 levels are high: " + e3List.get(i) + " Should be less than " +e3High + ".");
				}
				if(e3List.get(i) < e3Low) {
					System.out.println("For " + dateCollected + " e3 levels are low: " + e3List.get(i)+ " Should be greater than " + e3Low + ".");
				}
			}

		}
	}

}

