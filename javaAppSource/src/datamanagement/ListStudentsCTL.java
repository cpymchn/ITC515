package datamanagement;
public class ListStudentsCTL
{
  private StudentManager studentManager_;



  public ListStudentsCTL() {
	  this.studentManager_ = StudentManager.get();
  }



  public void listStudents(IStudentLister lister, String unitCode)
  {
    lister.clearStudents();
    StudentMap students = this.studentManager_.getStudentsByUnit(unitCode);
    for (Integer id : students.keySet()) {
      lister.addStudent(students.get(id));
    }
  }
}