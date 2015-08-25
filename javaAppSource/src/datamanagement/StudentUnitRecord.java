package datamanagement;
public class StudentUnitRecord
  implements IStudentUnitRecord
{
  private Integer studentID_;
  private String  unitCode_;
  private float   assignmentGrade1_, assignmentGrade2_, exam_;



  public StudentUnitRecord(Integer studentID, String unitCode, float assignmentGrade1, 
	  float assignmentGrade2, float exam) {
    this.studentID_ = studentID;
    this.unitCode_ = unitCode;
    this.setAssignmentGrade1(assignmentGrade1);
    this.setAssignmentGrade2(assignmentGrade2);
    this.setExam(exam);
  }



  public Integer getStudentID()
  {
    return this.studentID_;
  }



  public String getUnitCode()
  {
    return this.unitCode_;
  }



  public void setAssignmentGrade1(float assignmentGrade1)	
  {
    if (assignmentGrade1 < 0 || assignmentGrade1 > UnitManager.UM().getUnit(this.unitCode_).getAssignment1Weight()) {
      throw new RuntimeException(
          "Mark cannot be less than zero or greater than assessment weight");
    }
    this.assignmentGrade1_ = assignmentGrade1;
  }



  public float getAssignmentGrade1()
  {
    return this.assignmentGrade1_;
  }



  public void setAssignmentGrade2(float assignmentGrade2)				
  {
    if (assignmentGrade2 < 0 || assignmentGrade2 > UnitManager.UM().getUnit(this.unitCode_).getAssignment2Weight()) {
      throw new RuntimeException(
          "Mark cannot be less than zero or greater than assessment weight");
    }
    this.assignmentGrade2_ = assignmentGrade2;
  }



  public float getAssignmentGrade2()
  {
    return this.assignmentGrade2_;
  }



  public void setExam(float exam)
  {
    if (exam < 0 || exam > UnitManager.UM().getUnit(this.unitCode_).getExamWeight()) {
      throw new RuntimeException(
          "Mark cannot be less than zero or greater than assessment weight");
    }
    this.exam_ = exam;
  }



  public float getExam()
  {
    return this.exam_;
  }



  public float getTotal()
  {
    return this.assignmentGrade1_ + this.assignmentGrade2_ + this.exam_;
  }
}