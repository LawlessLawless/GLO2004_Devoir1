package QualiteDevoir.domain;

import java.util.Objects;

import QualiteDevoir.domain.enums.VisibleSymptom;

public class Patient {
	
	private String patientName;
	private int gravity;
	private VisibleSymptom visibleSymptom;
	private boolean needsRadiology;
	private int priorityToRadiology;
	
	public boolean isNeedingRadiology() {
		return needsRadiology;
	} 
	
	public String getPatientName() {
		return patientName;
	}   
	
	public VisibleSymptom getVisibleSymptom() {
		return visibleSymptom;
	}
	
	public int getRadiologyPriority() {
		return priorityToRadiology;
	}
	
	public int getPriorityToMedecin() {
		return gravity;
	}

	public void setPriorityToMedecin(int priorityToMedecin) {
		this.gravity = priorityToMedecin;
	}
	
    public Patient(String patientName, int gravity, VisibleSymptom visibleSymptom) {
    	this.patientName = patientName;
    	this.gravity = gravity;
    	this.visibleSymptom = visibleSymptom;
    	this.needsRadiology = patientNeedRadiology(visibleSymptom); 
    	this.priorityToRadiology = visibleSymptom == VisibleSymptom.SPRAIN ? 1 : 
    		(visibleSymptom == VisibleSymptom.BROKEN_BONE ? 2 : 3);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Patient)) {
            return false;
        }

        Patient other = (Patient) obj;
        return Objects.equals(getPatientName(), other.getPatientName()) && 
        		Objects.equals(gravity, other.gravity) &&
        		Objects.equals(getVisibleSymptom(), other.getVisibleSymptom());
    }

	private boolean patientNeedRadiology(VisibleSymptom visibleSymptom) {
		if(visibleSymptom == VisibleSymptom.BROKEN_BONE || visibleSymptom == VisibleSymptom.SPRAIN) {
    		return true;
    	}    
		return false;
	}
}