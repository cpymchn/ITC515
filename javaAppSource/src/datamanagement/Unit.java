package datamanagement;
public class Unit
  implements IUnit
{
  private String                unitCode_;
  private String                unitName_;
  private float                 passCutoff_;
  private float                 creditCutoff_;
  private float                 distinctionCutoff_;
  private float                 highDistinctionCutoff_;
  private float                 co5_;  // this is for AE?? what does that mean
  private int                   assignment1Weight_, assignment2Weight_, exam_;
  private StudentUnitRecordList recordList_;



  public Unit(String unitCode, String unitName, float passCutoff, float creditCutoff, float distinctionCutoff, float highDistinctionCutoff,
      float f5, int assignment1Weight, int assignment2Weight, int exam, StudentUnitRecordList recordList) {
	this.unitCode_ = unitCode;
	this.unitName_ = unitName;
    this.passCutoff_ = passCutoff;
    this.creditCutoff_ = creditCutoff;
    this.distinctionCutoff_ = distinctionCutoff;
    this.highDistinctionCutoff_ = highDistinctionCutoff;
    this.co5_ = f5;
    this.setAssessmentWeights(assignment1Weight, assignment2Weight, exam);
    this.recordList_ = recordList == null ? new StudentUnitRecordList() : recordList;
  }



  public String getUnitCode()
  {
    return this.unitCode_;	
  }



  public String getUnitName()
  {
    return this.unitName_;
  }



  public void setPassCutoff(float cutoff)
  {
    this.passCutoff_ = cutoff;
  }



  public float getPassCutoff()
  {
    return this.passCutoff_;
  }



  public void setCreditCutoff(float cutoff)
  {
    this.creditCutoff_ = cutoff;
  }



  public float getCreditCutoff()
  {
    return this.creditCutoff_;
  }



  public void setDistinctionCutoff(float cutoff)
  {
    this.distinctionCutoff_ = cutoff;
  }



  public float getDistinctionCuttoff()
  {
    return this.distinctionCutoff_;
  }



  public void setHighDistinctionCutoff(float cutoff)
  {
    this.highDistinctionCutoff_ = cutoff;
  }



  public float getHighDistinctionCutoff()
  {
    return this.highDistinctionCutoff_;	
  }



  public void setAeCutoff(float cutoff)
  {
    this.co5_ = cutoff;
  }



  public float getAeCutoff()
  {
    return this.co5_;
  }



  public void addStudentRecord(IStudentUnitRecord record)
  {
	  this.recordList_.add(record);
  }



  public IStudentUnitRecord getStudentRecord(int studentID)
  {
    for (IStudentUnitRecord record : this.recordList_) {
      if (record.getStudentID() == studentID)
        return record;
    }
    return null;
  }



  public StudentUnitRecordList listStudentRecords()
  {
    return this.recordList_;
  }



  @Override
  public int getAssignment1Weight()
  {
    return this.assignment1Weight_;
  }



  @Override
  public int getAssignment2Weight()
  {
    return this.assignment2Weight_;
  }



  @Override
  public int getExamWeight()
  {
    return this.exam_;
  }



  @Override
  public void setAssessmentWeights(int assignment1Weight, int assignment2Weight, int exam)
  {
    if (assignment1Weight < 0 || assignment1Weight > 100 || assignment2Weight < 0 || assignment2Weight > 100 || exam < 0 || exam > 100) {
      throw new RuntimeException(
          "Assessment weights cant be less than zero or greater than 100");
    }
    if (assignment1Weight + assignment2Weight + exam != 100) {
      throw new RuntimeException("Assessment weights must add to 100");
    }
    this.assignment1Weight_ = assignment1Weight;
    this.assignment2Weight_ = assignment2Weight;
    this.exam_ = exam;
  }



  public String getGrade(float assignment1Mark, float assignment2Mark, float exam) // Need to check this LOGIC think I stuffed it when changing variable names
  {
    float totalMark = assignment1Mark + assignment2Mark + exam;
    if (assignment1Mark < 0 || assignment1Mark > assignment1Weight_ || assignment2Mark < 0 || assignment2Mark > this.assignment2Weight_ || exam < 0 || exam > this.exam_) {
      throw new RuntimeException(
          "marks cannot be less than zero or greater than assessment weights");
    }
    if (totalMark < co5_) {
      return "FL";
    }
    else if (totalMark < this.passCutoff_)
      return "AE";
    else if (totalMark < this.creditCutoff_)
      return "PS";
    else if (totalMark < this.distinctionCutoff_)
      return "CR";
    else if (totalMark < this.highDistinctionCutoff_)
      return "DI";
    else
      return "HD";
  }
}