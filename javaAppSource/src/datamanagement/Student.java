package datamanagement;
public class Student 
  implements IStudent
{
  private Integer               studentID_;     // change variable name
  private String                firstName_;     // change variable name
  private String                lastName_;     // change variable name
  private StudentUnitRecordList studentRecordUnitList_;     // change variable name



  public Student(Integer studentID, String fn, String lastName, StudentUnitRecordList studentRecordUnitList) {
    this.studentID_ = studentID;     // change variable name
    this.firstName_ = firstName;     // change variable name
    this.lastName_ = lastName;     // change variable name
    this.studentRecordUnitList_ = studentRecordUnitList == null ? new StudentUnitRecordList() : studentRecordUnitList;
  }



  public Integer getID()
  {
    return this.studentID_;     // change variable name
  }



  public String getFirstName()
  {
    return this.firstName_;     // change variable name
  }



  public void setFirstName(String firstName)
  {
    this.firstName_ = firstName;     // change variable name
  }



  public String getLastName()
  {
    return this.lastName_;     // change variable name
  }



  public void setLastName(String lastName)
  {
    this.lastName_ = lastName;     // change variable name
  }



  public void addUnitRecord(IStudentUnitRecord record)     // change variable name
  {
	this.studentRecordUnitList_.add(record);     // change variable name
  }



  public IStudentUnitRecord getUnitRecord(String unitCode)     // change variable name
  {
    for (IStudentUnitRecord record : studentRecordUnitList_){     // change variable name
      if (record.getUnitCode().equals(unitCode))     // change variable name
        return record;     // change variable name
    }
      return null;
  }



  public StudentUnitRecordList getUnitRecords()
  {
    return this.studentRecordUnitList_;       // change variable name
  }
}