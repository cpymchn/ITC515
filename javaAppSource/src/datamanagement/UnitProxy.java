package datamanagement;
public class UnitProxy
  implements IUnit
{
  private String unitCode_;
  private String unitName_;
  UnitManager    unitManager_;



  public UnitProxy(String unitCode, String unitName) {
    this.unitCode_ = unitCode;
    this.unitName_ = unitName;
    this.unitManager_ = UnitManager.UM();
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
	this.unitManager_ .getUnit(this.unitCode_).setPassCutoff(cutoff);
  }



  public float getCreditCutoff()
  {
    return this.unitManager_ .getUnit(this.unitCode_).getCreditCutoff();
  }



  public void setCreditCutoff(float cutoff)
  {
	this.unitManager_ .getUnit(this.unitCode_).setCreditCutoff(cutoff);
  }



  public float getCreditCutoff()
  {
    return um.getUnit(this.unitCode_).getCreditCutoff();
  }



  public void setDistinctionCutoff(float cutoff)
  {
	  this.unitManager_.getUnit(this.unitCode_).setDistinctionCutoff(cutoff);
  }



  public float getDistinctionCuttoff()
  {
    return this.unitManager_.getUnit(this.unitCode_).getDistinctionCuttoff();
  }



  public void setHighDistinctionCutoff(float cutoff)
  {
	  this.unitManager_.getUnit(this.unitCode_).setHighDistinctionCutoff(cutoff);
  }



  public float getHighDistinctionCutoff()
  {
    return this.unitManager_.getUnit(this.unitCode_).getHighDistinctionCutoff();
  }



  public void setAeCutoff(float cutoff)
  {
	  this.unitManager_.getUnit(this.unitCode_).setAeCutoff(cutoff);
  }



  public float getAeCutoff()
  {
    return this.unitManager_.getUnit(this.unitCode_).getAeCutoff();
  }



  public String getGrade(float assignmentGrade1, float assignmentGrade2, float exam)
  {
    return this.unitManager_.getUnit(this.unitCode_).getGrade(assignmentGrade1, assignmentGrade2, exam);
  }



  public void addStudentRecord(IStudentUnitRecord record)
  {
	  this.unitManager_.getUnit(this.unitCode_).addStudentRecord(record);
  }



  public IStudentUnitRecord getStudentRecord(int s)
  {
    return this.unitManager_.getUnit(this.unitCode_).getStudentRecord(s);
  }



  public StudentUnitRecordList listStudentRecords()
  {
    return this.unitManager_.getUnit(this.unitCode_).listStudentRecords();
  }



  public int getAssignment1Weight()
  {
    return this.unitManager_.getUnit(this.unitCode_).getAssignment1Weight();
  }



  public int getAssignmentg2Weight()
  {
    return this.unitManager_.getUnit(this.unitCode_).getAssignmentg2Weight();
  }



  public int getExamWeight()
  {
    return this.unitManager_.getUnit(this.unitCode_).getExamWeight();
  }



  public void setAssessmentWeights(int assignmentGrade1Weight, int assignmentGrade2Weight, int examWeigt)
  {
	  this.unitManager_.getUnit(this.unitCode_).setAssessmentWeights(assignmentGrade1Weight, assignmentGrade2Weight, examWeigt);
  }
}