package datamanagement;
public interface IUnit
{
  public String getUnitCode();



  public String getUnitName();



  public float getPassCutoff();	



  public void setPassCutoff(float cutoff);



  public float getCreditCutoff();



  public void setCreditCutoff(float cutoff);



  public float getDistinctionCuttoff();



  public void setDistinctionCutoff(float cutoff);



  public float getHighDistinctionCutoff();



  public void setHighDistinctionCutoff(float cutoff);



  public float getAeCutoff();



  public void setAeCutoff(float cutoff);



  public int getAssignment1Weight();



  public int getAssignment2Weight();



  public int getExamWeight();



  public void setAssessmentWeights(int assignmentGrade1Weight, int assignmentGrade2Weight, int examWeigt);



  public String getGrade(float assignmentGrade1, float assignmentGrade2, float exam);



  public void addStudentRecord(IStudentUnitRecord record);



  public IStudentUnitRecord getStudentRecord(int studentID);



  public StudentUnitRecordList listStudentRecords();
}