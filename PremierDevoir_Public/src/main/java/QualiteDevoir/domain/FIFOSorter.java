package QualiteDevoir.domain;

import java.util.ArrayList;

import QualiteDevoir.domain.enums.VisibleSymptom;

class FIFOSorter implements PatientSorter {
	
	private ArrayList<Patient> doctorWaitLine;
	private ArrayList<Patient> radiologyWaitLine;
	
	public ArrayList<Patient> getRadiologyWaitLine() {
		return radiologyWaitLine;
	}
	
	public ArrayList<Patient> getDoctorWaitLine() {
		return doctorWaitLine;
	}
	
	public FIFOSorter() {
		doctorWaitLine = new ArrayList<Patient>();
		radiologyWaitLine = new ArrayList<Patient>();
	}

	public void Sort(Patient patient) {
		if(patient.isNeedingRadiology()) {			
			addSortedPatientToRadiology(patient);		
		}
		
		addPatientToMedecin(patient);
	}
	
	public void removeMostPriorityPatientFromRadiology() {
		radiologyWaitLine.remove(0);
	}
	
	public void removeMostPriorityPatientFromMedecin() {
		doctorWaitLine.remove(0);
	}
		
	private void addPatientToMedecin(Patient patient) {
		VisibleSymptom symptom =  patient.getVisibleSymptom();
		if(symptom == VisibleSymptom.MIGRAINE || symptom == VisibleSymptom.SPRAIN) {
			patient.setPriorityToMedecin(1);
			addSortedPatientToMedecin(patient);
		}
		else if(patient.getVisibleSymptom() == VisibleSymptom.FLU) {
			patient.setPriorityToMedecin(2);
			addSortedPatientToMedecin(patient);
		}
		else {
			addSortedPatientToMedecin(patient);
		}
	}
	
	private void addSortedPatientToMedecin(Patient patient) {
		doctorWaitLine.add(patient);
		bubbleSortDoctor();
	}

	private void addSortedPatientToRadiology(Patient patient) {
		radiologyWaitLine.add(patient);
		bubbleSortRadiology();
	}
	
	private void bubbleSortRadiology() { 
         int waitLineLength = radiologyWaitLine.size();
         Patient patientAClasser;
         for(int index = 0; index < waitLineLength; index++) {
        	 for(int j=1; j < (waitLineLength-index); j++){  
                 if(radiologyWaitLine.get(j-1).getRadiologyPriority() > radiologyWaitLine.get(j).getRadiologyPriority()){  
                	 patientAClasser = radiologyWaitLine.get(j-1);  
                	 radiologyWaitLine.set(j-1, radiologyWaitLine.get(j));  
                	 radiologyWaitLine.set(j, patientAClasser);  
                }               
        	 }  
         }         
	}
	
	private void bubbleSortDoctor() { 
        int waitLineLength = doctorWaitLine.size();
        Patient patientAClasser;
        for(int index = 0; index < waitLineLength; index++) {
       	 for(int j=1; j < (waitLineLength-index); j++){  
                if(doctorWaitLine.get(j-1).getPriorityToMedecin() > doctorWaitLine.get(j).getPriorityToMedecin()){  
               	 patientAClasser = doctorWaitLine.get(j-1);  
               	doctorWaitLine.set(j-1, doctorWaitLine.get(j));  
               	doctorWaitLine.set(j, patientAClasser);  
               }               
       	 }  
        }         
	}
}