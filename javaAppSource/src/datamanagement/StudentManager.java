package datamanagement;
import org.jdom.*;
import java.util.List;
public class StudentManager
{
  private static StudentManager                 self_ = null;
  private StudentMap                            studentMap_;
  private java.util.HashMap<String, StudentMap> hashMap_;



  public static StudentManager get()
  {
    if (self_ == null)
      self_ = new StudentManager();
    return self_;
  }



  private StudentManager() {
    this.studentMap_ = new StudentMap();
    this.hashMap_ = new java.util.HashMap<>();
  }



  public IStudent getStudent(Integer id)
  {
    IStudent is = this.hashMap_.get(id);
    return is != null ? is : createStudent(id);
  }



  @SuppressWarnings("unchecked")
  private Element getStudentElement(Integer id)
  {
    for (Element el : (List<Element>) XMLManager.getXML().getDocument()
        .getRootElement().getChild("studentTable").getChildren("student")) {
      if (id.toString().equals(el.getAttributeValue("sid")))
        return el;
    }  
    return null;
  }



  private IStudent createStudent(Integer id)
  {
    IStudent is;
    Element el = getStudentElement(id);
    if (el != null) {
      StudentUnitRecordList rlist = StudentUnitRecordManager.instance()
          .getRecordsByStudent(id);
      is = new Student(new Integer(el.getAttributeValue("sid")),
          el.getAttributeValue("fname"), el.getAttributeValue("lname"), rlist);
      sm.put(is.getID(), is);
      return is;
    }
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }



  private IStudent createStudentProxy(Integer id)
  {
    Element el = getStudentElement(id);
    if (el != null)
      return new StudentProxy(id, el.getAttributeValue("fname"),
          el.getAttributeValue("lname"));
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }



  public StudentMap getStudentsByUnit(String uc)
  {
    StudentMap s = this.hashMap_.get(uc);
    if (s != null) {
      return s;
    }
    s = new StudentMap();
    IStudent is;
    StudentUnitRecordList ur = StudentUnitRecordManager.instance()
        .getRecordsByUnit(uc);
    for (IStudentUnitRecord S : ur) {
      is = createStudentProxy(new Integer(S.getStudentID()));
      s.put(is.getID(), is);
    }
    this.hashMap_.put(uc, s);
    return s;
  }
}