package datamanagement;
public interface IStudentUnitRecord
{
  public Integer getStudentID();



  public String getUnitCode();



  public void setAssignmentGrade1(float mark);



  public float getAssignmentGrade1();



  public void setAssignmentGrade2(float mark);



  public float getAssignmentGrade2();



  public void setExam(float mark);



  public float getExam();



  public float getTotal();
}