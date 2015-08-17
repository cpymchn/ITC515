package datamanagement;
public class StudentUnitRecordProxy
  implements IStudentUnitRecord
{
  private Integer                  studentID_;
  private String                   unitCode_;
  private StudentUnitRecordManager studentUnitRecordManager_;



  public StudentUnitRecordProxy(Integer studentID, String unitCode) {
    this.studentID_ = studentID;
    this.unitCode_ = unitCode;
    this.studentUnitRecordManager_ = StudentUnitRecordManager.instance();
  }



  public Integer getStudentID()
  {
    return this.studentID_;
  }



  public String getUnitCode()
  {
    return this.unitCode_;
  }



  public void setAssignmentGrade1(float mark)
  {
	  this.studentUnitRecordManager_.getStudentUnitRecord(this.studentID_, this.unitCode_).setAssignmentGrade1(mark);
  }



  public float getAssignmentGrade1()
  {
    return this.studentUnitRecordManager_.getStudentUnitRecord(this.studentID_, this.unitCode_).getAssignmentGrade1();
  }



  public void setAssignmentGrade2(float mark)
  {
	  this.studentUnitRecordManager_.getStudentUnitRecord(this.studentID_, this.unitCode_).setAssignmentGrade2(mark);
  }



  public float getAssignmentGrade2()
  {
    return this.studentUnitRecordManager_.getStudentUnitRecord(this.studentID_, this.unitCode_).getAssignmentGrade2();
  }



  public void setExam(float mark)
  {
	  this.studentUnitRecordManager_.getStudentUnitRecord(this.studentID_, this.unitCode_).setExam(mark);
  }



  public float getExam()
  {
    return this.studentUnitRecordManager_.getStudentUnitRecord(this.studentID_, this.unitCode_).getExam();
  }



  public float getTotal()
  {
    return this.studentUnitRecordManager_.getStudentUnitRecord(this.studentID_, this.unitCode_).getTotal();
  }
}