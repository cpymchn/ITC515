package datamanagement;
public class ListUnitsCTL
{
  private UnitManager unitManager_;



  public ListUnitsCTL() {
	  this.unitManager_ = UnitManager.UM();
  }



  public void listUnits(IUnitLister lister)
  {
    lister.clearUnits();
    UnitMap units = this.unitManager_.getUnits();
    for (String unitName : units.keySet()) {
      lister.addUnit(units.get(unitName));
    }
  }
}