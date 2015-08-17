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
	this.unitCode_ = unitCode;																	//	fixed variable names
	this.unitName_ = unitName;																	//	fixed variable names
    this.passCutoff_ = passCutoff;																//	fixed variable names
    this.creditCutoff_ = creditCutoff;															//	fixed variable names
    this.distinctionCutoff_ = distinctionCutoff;													//	fixed variable names
    this.highDistinctionCutoff_ = highDistinctionCutoff;											//	fixed variable names
    this.co5_ = f5;
    this.setAssessmentWeights(assignment1Weight, assignment2Weight, exam);						//	fixed variable names
    this.recordList_ = recordList == null ? new StudentUnitRecordList() : recordList;				//	fixed variable names
  }



  public String getUnitCode()
  {
    return this.unitCode_;																					//	fixed variable names
  }



  public String getUnitName()
  {
    return this.unitName_;																//	fixed variable names
  }



  public void setPassCutoff(float cutoff)
  {
    this.passCutoff_ = cutoff;																//	fixed variable names
  }



  public float getPassCutoff()
  {
    return this.passCutoff_;																//	fixed variable names
  }



  public void setCreditCutoff(float cutoff)
  {
    this.creditCutoff_ = cutoff;																//	fixed variable names
  }



  public float getCreditCutoff()
  {
    return this.creditCutoff_;																//	fixed variable names
  }



  public void setDistinctionCutoff(float cutoff)
  {
    this.distinctionCutoff_ = cutoff;																//	fixed variable names
  }



  public float getDistinctionCuttoff()
  {
    return this.distinctionCutoff_;																//	fixed variable names
  }



  public void setHighDistinctionCutoff(float cutoff)
  {
    this.highDistinctionCutoff_ = cutoff;																//	fixed variable names
  }



  public float getHighDistinctionCutoff()
  {
    return this.highDistinctionCutoff_;																//	fixed variable names
  }



  public void setAeCutoff(float cutoff)
  {
    this.co5_ = cutoff;																//	to do
  }



  public float getAeCutoff()
  {
    return this.co5_;
  }



  public void addStudentRecord(IStudentUnitRecord record)
  {
	  this.recordList_.add(record);									//	fixed variable names
  }



  public IStudentUnitRecord getStudentRecord(int studentID)								//	fixed variable names
  {
    for (IStudentUnitRecord record : this.recordList_) {								//	fixed variable names
      if (record.getStudentID() == studentID)								//	fixed variable names
        return record;								//	fixed variable names
    }
    return null;
  }



  public StudentUnitRecordList listStudentRecords()								//	fixed variable names
  {
    return this.recordList_;								//	fixed variable names
  }



  @Override
  public int getAssignment1Weight()
  {
    return this.assignment1Weight_;								//	fixed variable names
  }



  @Override
  public int getAssignment2Weight()
  {
    return this.assignment2Weight_;								//	fixed variable names
  }



  @Override
  public int getExamWeight()
  {
    return this.exam_;								//	fixed variable names
  }



  @Override
  public void setAssessmentWeights(int assignment1Weight, int assignment2Weight, int exam)								//	fixed variable names
  {
    if (assignment1Weight < 0 || assignment1Weight > 100 || assignment2Weight < 0 || assignment2Weight > 100 || exam < 0 || exam > 100) {								//	fixed variable names
      throw new RuntimeException(
          "Assessment weights cant be less than zero or greater than 100");
    }
    if (assignment1Weight + assignment2Weight + exam != 100) {								//	fixed variable names
      throw new RuntimeException("Assessment weights must add to 100");
    }
    this.assignment1Weight_ = assignment1Weight;								//	fixed variable names
    this.assignment2Weight_ = assignment2Weight;								//	fixed variable names
    this.exam_ = exam;								//	fixed variable names
  }



  public String getGrade(float assignment1Mark, float assignment2Mark, float exam) //Need to check this LOGIC think I stuffed it when changing variable names
  {
    float totalMark = assignment1Mark + assignment2Mark + exam;
    if (assignment1Mark < 0 || assignment1Mark > assignment1Weight_ || assignment2Mark < 0 || assignment2Mark > this.assignment2Weight_ || exam < 0 || exam > this.exam_) {
      throw new RuntimeException(
          "marks cannot be less than zero or greater than assessment weights");
    }
    if (totalMark < co5_) {
      return "FL";
    }
    else if (totalMark < this.passCutoff_)								//	fixed variable names
      return "AE";
    else if (totalMark < this.creditCutoff_)								//	fixed variable names
      return "PS";
    else if (totalMark < this.distinctionCutoff_)								//	fixed variable names
      return "CR";
    else if (totalMark < this.highDistinctionCutoff_)								//	fixed variable names
      return "DI";
    else
      return "HD";
  }
}