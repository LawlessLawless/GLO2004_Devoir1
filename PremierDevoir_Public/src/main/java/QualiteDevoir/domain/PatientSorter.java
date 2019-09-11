package QualiteDevoir.domain;

import java.util.ArrayList;

public interface PatientSorter {
	
	public ArrayList<Patient> getRadiologyWaitLine();
	
	public ArrayList<Patient> getDoctorWaitLine();
	
	public void removeMostPriorityPatientFromRadiology();
	
	public void removeMostPriorityPatientFromMedecin();
	
	public void Sort(Patient patient);
}
