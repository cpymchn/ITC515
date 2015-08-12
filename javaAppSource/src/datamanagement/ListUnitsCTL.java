package datamanagement;
public class ListUnitsCTL
{
  private UnitManager um;



  public ListUnitsCTL() {
    um = UnitManager.UM();
  }



  public void listUnits(IUnitLister lister)
  {
    lister.clearUnits();
    UnitMap units = um.getUnits();
    for (String s : units.keySet())
      lister.addUnit(units.get(s)); // #Query... is this for statement in the correct form? Rule66
  }
}