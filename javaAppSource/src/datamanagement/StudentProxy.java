package datamanagement;
public class StudentProxy
  implements IStudent
{
  private Integer        studentID_;
  private String         firstName_;
  private String         lastName_;
  private StudentManager studentManager_;



  public StudentProxy(Integer studentID, String firstName, String lastName) {
    this.studentID_ = studentID;
    this.firstName_ = firstName;
    this.lastName_ = lastName;
    this.studentManager_ = StudentManager.get();
  }



  public Integer getID()
  {
    return this.studentID_;
  }



  public String getFirstName()
  {
    return this.firstName_;
  }



  public String getLastName()
  {
    return this.lastName_;
  }



  public void setFirstName(String firstName)
  {
    this.studentManager_.getStudent(this.studentID_).setFirstName(firstName);
  }



  public void setLastName(String lastName)
  {
	  this.studentManager_.getStudent(this.studentID_).setLastName(lastName);
  }



  public void addUnitRecord(IStudentUnitRecord record)
  {
	  this.studentManager_.getStudent(this.studentID_).addUnitRecord(record);
  }



  public IStudentUnitRecord getUnitRecord(String unitCode)
  {
    return this.studentManager_.getStudent(this.studentID_).getUnitRecord(unitCode);
  }



  public StudentUnitRecordList getUnitRecords()
  {
    return this.studentManager_.getStudent(this.studentID_).getUnitRecords();
  }
}