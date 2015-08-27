package datamanagement;
public class Student 
  implements IStudent
{
  private Integer               studentID_;
  private String                firstName_;
  private String                lastName_;
  private StudentUnitRecordList studentRecordUnitList_;



  public Student(Integer studentID, String firstName, String lastName, StudentUnitRecordList studentRecordUnitList) {
    this.studentID_ = studentID;
    this.firstName_ = firstName;
    this.lastName_ = lastName;
    this.studentRecordUnitList_ = studentRecordUnitList == null ? new StudentUnitRecordList() : studentRecordUnitList;
  }



  public Integer getID()
  {
    return this.studentID_;
  }



  public String getFirstName()
  {
    return this.firstName_;
  }



  public void setFirstName(String firstName)
  {
    this.firstName_ = firstName;
  }



  public String getLastName()
  {
    return this.lastName_;
  }



  public void setLastName(String lastName)
  {
    this.lastName_ = lastName;
  }



  public void addUnitRecord(IStudentUnitRecord record)
  {
	this.studentRecordUnitList_.add(record);
  }



  public IStudentUnitRecord getUnitRecord(String unitCode)
  {
    for (IStudentUnitRecord record : studentRecordUnitList_){
      if (record.getUnitCode().equals(unitCode))
        return record;
    }
      return null;
  }



  public StudentUnitRecordList getUnitRecords()
  {
    return this.studentRecordUnitList_;
  }
}