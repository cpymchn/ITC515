package datamanagement;
public interface IStudentUnitRecord
{
  public Integer getStudentID();



  public String getUnitCode();



  public void setAssignmentGrade1(float mark);		//Fixed method name



  public float getAssignmentGrade1();				//Fixed method name



  public void setAssignmentGrade2(float mark);		//Fixed method name



  public float getAssignmentGrade2();				//Fixed method name



  public void setExam(float mark);



  public float getExam();



  public float getTotal();
}