package datamanagement;
public class cgCTL
{
  cgUI    CGUI;
  String  cuc_              = null;
  Integer currentStudentID_ = null;
  boolean changed_          = false;



  public cgCTL() {
  }



  public void execute()
  {
    CGUI = new cgUI(this);
    CGUI.setState1(false);
    CGUI.setState2(false);
    CGUI.setState3(false);
    CGUI.setState4(false);
    CGUI.setState5(false);
    CGUI.setState6(false);
    CGUI.Refresh3();
    ListUnitsCTL luCTL = new ListUnitsCTL();
    luCTL.listUnits(CGUI);
    CGUI.setVisible(true);
    CGUI.setState1(true);
  }



  public void unitSelected(String unitCode)						//made variable easier to read
  {
    if (unitCode.equals("NONE"))
      CGUI.setState2(false);
    else {
      ListStudentsCTL lsCTL = new ListStudentsCTL();
      lsCTL.listStudents(CGUI, unitCode);
      this.cuc_ = unitCode;
      CGUI.setState2(true);
    }
    CGUI.setState3(false);
  }



  public void studentSelected(Integer studentId) 				//made variable easier to read
  {
    this.currentStudentID_ = studentId;
    if (this.currentStudentID_.intValue() == 0) {
      CGUI.Refresh3();
      CGUI.setState3(false);
      CGUI.setState4(false);
      CGUI.setState5(false);
      CGUI.setState6(false);
    } 
    else {
      IStudent student = StudentManager.get().getStudent(studentId);	//made variable easier to read
      IStudentUnitRecord record = student.getUnitRecord(this.cuc_);			//made variable easier to read
      CGUI.setRecord(record);											//made variable easier to read
      CGUI.setState3(true);
      CGUI.setState4(true);
      CGUI.setState5(false);
      CGUI.setState6(false);
      this.changed_ = false;
    }
  }



  public String checkGrade(float f, float g, float h)			//these can be made easier
  {
    IUnit unit = UnitManager.UM().getUnit(this.cuc_);					//made variable easier to read
    String grade = unit.getGrade(f, g, h);							//made variable easier to read
    CGUI.setState4(true);
    CGUI.setState5(false);
    if (this.changed_) {
      CGUI.setState6(true);
    }
    return grade;
  }



  public void enableChangeMarks()
  {
    CGUI.setState4(false);
    CGUI.setState6(false);
    CGUI.setState5(true);
    this.changed_ = true;
  }



  public void saveGrade(float assignmentGrade1, float assignmentGrade2, float exam)//made variable easier to read
  {
    IStudent student = StudentManager.get().getStudent(this.currentStudentID_);	//made variable easier to read
    IStudentUnitRecord record = student.getUnitRecord(this.cuc_);					//made variable easier to read
    record.setAssignmentGrade1(assignmentGrade1);											//made variable easier to read
    record.setAssignmentGrade2(assignmentGrade2);											//made variable easier to read
    record.setExam(exam);
    StudentUnitRecordManager.instance().saveRecord(record);					//made variable easier to read
    CGUI.setState4(true);
    CGUI.setState5(false);
    CGUI.setState6(false);
  }
}