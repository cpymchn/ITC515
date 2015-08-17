package datamanagement;
public class StudentUnitRecord
  implements IStudentUnitRecord
{
  private Integer studentID_;																			//Fixed variable name
  private String  unitCode_;																				//Fixed variable name
  private float   assignmentGrade1_, assignmentGrade2_, exam_;												//Fixed variable name



  public StudentUnitRecord(Integer studentID, String unitCode, float assignmentGrade1, 
	  float assignmentGrade2, float exam) {																//Fixed variable name
    this.studentID_ = studentID;
    this.unitCode_ = unitCode;
    this.setAssignmentGrade1(assignmentGrade1);
    this.setAssignmentGrade2(assignmentGrade2);
    this.setExam(exam);
  }



  public Integer getStudentID()
  {
    return this.studentID_;																				//Fixed variable name
  }



  public String getUnitCode()
  {
    return this.unitCode_;																				//Fixed variable name
  }



  public void setAssignmentGrade1(float assignmentGrade1)											//Fixed method name	and variable names	
  {
    if (assignmentGrade1 < 0 || assignmentGrade1 > UnitManager.UM().getUnit(unitCode).getAssignmentGrade1Weight()) {
      throw new RuntimeException(
          "Mark cannot be less than zero or greater than assessment weight");
    }
    this.assignmentGrade1_ = assignmentGrade1;
  }



  public float getAssignmentGrade1()												//Fixed method name	and variable names	
  {
    return this.assignmentGrade1_;
  }



  public void setAssignmentGrade2(float assignmentGrade2)											//Fixed method name	and variable names						
  {
    if (assignmentGrade2 < 0 || assignmentGrade2 > UnitManager.UM().getUnit(unitCode).getAssignmentGrade2Weight()) {	//	fixed variable names
      throw new RuntimeException(
          "Mark cannot be less than zero or greater than assessment weight");
    }
    this.assignmentGrade2_ = assignmentGrade2;											//	fixed variable names
  }



  public float getAssignmentGrade2()												//Fixed method name	and variable names	
  {
    return this.assignmentGrade2_;
  }



  public void setExam(float exam)														//	fixed variable names	
  {
    if (exam < 0 || exam > UnitManager.UM().getUnit(unitCode).getExamWeight()) {
      throw new RuntimeException(
          "Mark cannot be less than zero or greater than assessment weight");
    }
    this.exam_ = exam;																		//	fixed variable names	
  }



  public float getExam()
  {
    return this.exam_;																		//	fixed variable names	
  }



  public float getTotal()
  {
    return this.assignmentGrade1_ + this.assignmentGrade2_ + this.exam_;									//	fixed variable names
  }
}