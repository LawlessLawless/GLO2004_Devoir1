package QualiteDevoir.domain;

import QualiteDevoir.domain.enums.TriageType;
import QualiteDevoir.domain.enums.VisibleSymptom;

import static QualiteDevoir.domain.enums.TriageType.FIFO;

import java.util.ArrayList;

import QualiteDevoir.domain.Patient;

public class Clinic {
	
	private PatientSorter patientSorter;
	
	public ArrayList<Patient> getDoctorWaitLine() {
		return this.patientSorter.getDoctorWaitLine();
	}
	
	public ArrayList<Patient> getRadiologyWaitLine() {
		return this.patientSorter.getRadiologyWaitLine();
	}
	
    public Clinic(TriageType triageType) {   	   	
    	this.patientSorter = createPatientSorter(triageType);
    }
	
    public void sortPatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient newPatient = new Patient(name, gravity, visibleSymptom);      
        patientSorter.Sort(newPatient);        
    }
    
    public void DoctorReceiveNextPatient() {
    	this.patientSorter.removeMostPriorityPatientFromMedecin();
    }
    
    public void RadiologyReceiveNextPatient() {
    	this.patientSorter.removeMostPriorityPatientFromRadiology();
    }

	private PatientSorter createPatientSorter(TriageType triageType){
		if(triageType == FIFO) return new FIFOSorter();
		return new GravitySorter();
	}
}