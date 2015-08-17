package datamanagement;
public interface IUnit
{
  public String getUnitCode();



  public String getUnitName();



  public float getPassCutoff();						//Changed method name



  public void setPassCutoff(float cutoff);			//Changed method name



  public float getCreditCutoff();					//Changed method name



  public void setCreditCutoff(float cutoff);		//Changed method name



  public float getDistinctionCuttoff();				//Changed method name



  public void setDistinctionCutoff(float cutoff);	//Changed method name



  public float getHighDistinctionCutoff();			//Changed method name



  public void setHighDistinctionCutoff(float cutoff);//Changed method name



  public float getAeCutoff();



  public void setAeCutoff(float cutoff);



  public int getAssignment1Weight();				//Changed method name



  public int getAssignment2Weight();				//Changed method name



  public int getExamWeight();



  public void setAssessmentWeights(int assignmentGrade1Weight, int assignmentGrade2Weight, int examWeigt);//Made integers more readable and change method name



  public String getGrade(float assignmentGrade1, float assignmentGrade2, float exam); //Made integers more readable



  public void addStudentRecord(IStudentUnitRecord record);



  public IStudentUnitRecord getStudentRecord(int studentID);



  public StudentUnitRecordList listStudentRecords();
}