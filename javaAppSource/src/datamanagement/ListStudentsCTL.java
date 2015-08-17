package datamanagement;
public class ListStudentsCTL
{
  private StudentManager studentManager_;								//	fixed variable names



  public ListStudentsCTL() {
	  this.studentManager_ = StudentManager.get();								//	fixed variable names
  }



  public void listStudents(IStudentLister lister, String unitCode)
  {
    lister.clearStudents();
    StudentMap students = this.studentManager_.getStudentsByUnit(unitCode);								//	fixed variable names
    for (Integer id : students.keySet()) {
      lister.addStudent(students.get(id));
    }
  }
}