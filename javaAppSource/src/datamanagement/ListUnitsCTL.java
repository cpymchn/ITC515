package datamanagement;
public class ListUnitsCTL
{
  private UnitManager unitManager_;					//	fixed variable names



  public ListUnitsCTL() {
	  this.unitManager_ = UnitManager.UM();					//	fixed variable names 
  }



  public void listUnits(IUnitLister lister)
  {
    lister.clearUnits();
    UnitMap units = this.unitManager_.getUnits();					//	fixed variable names
    for (String unitName : units.keySet()) {					//	fixed variable names
      lister.addUnit(units.get(unitName));					//	fixed variable names
    }
  }
}