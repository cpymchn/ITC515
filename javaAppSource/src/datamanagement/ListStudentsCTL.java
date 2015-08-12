package datamanagement;
public class ListStudentsCTL
{
  private StudentManager sm;



  public ListStudentsCTL() {
    sm = StudentManager.get();
  }



  public void listStudents(IStudentLister lister, String unitCode)
  {
    lister.clearStudents();
    StudentMap students = sm.getStudentsByUnit(unitCode);
    for (Integer id : students.keySet())
      lister.addStudent(students.get(id)); // #Query... is this for statement in the correct form? Rule66
  }
}