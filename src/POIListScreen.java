package src;

public class POIListScreen extends Screen {




  private POI[] list;
  private int numPOI;
  public POIListScreen(Screen parent, POI[] list, int numPOI) {
    this.parent = parent;
    this.list = list;
    this.numPOI = numPOI;
    this.title = "POIListScreen";
  }


  public void display() {
    
    String title = UIConstants.center("POIs") + "\n";
    title += UIConstants.DIV;

    
    int count = 0;
    String out = "(0) Back\n";
    for (;count < numPOI;count++)
      out += "(" + (count+1) + ") " + list[count].toString() + "\n";
    

    out += "(" + (count+1) + ")" + " Add POI"   + "\n";
    System.out.println(title+out);
  }



  public int isValid(String input) {
    try {
      int i = Integer.parseInt(input);
      if (i >= 0 && i <= this.numPOI+1) {
        return i;
      }
      return -1;
    } catch (Exception e) {
      return -1;
    }
  }


  public void addPOI(POI poi,int index) {
    
    list[index] = poi;
    if (index == numPOI)
      numPOI++;
  }

  public Screen next(String input) {

    int index;
    if ((index = isValid(input)) < 0) 
      return this;

    if (index == 0) {
      this.parent.updatePOIList(this.list,numPOI);
      return this.parent;
    }
    
    POI poi;

    if (index-1 == numPOI) {
      poi = new POI();
    } else {
      poi = list[index-1];
    }


    return new EditPOIScreen(this,poi,index-1);

    

  }
  
}
