/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4969.ccd387f31 modeling language!*/



// line 32 "model.ump"
// line 71 "model.ump"
public class Test
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Test Attributes
  private String date;
  private String time;
  private String testLocation;
  private String testType;
  private boolean outcome;
  private String manufacturer;
  private String processingLab;
  private String processedDate;

  //Test Associations
  private Patient patient;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Test(String aDate, String aTime, String aTestLocation, String aTestType, boolean aOutcome, String aManufacturer, String aProcessingLab, String aProcessedDate, Patient aPatient)
  {
    date = aDate;
    time = aTime;
    testLocation = aTestLocation;
    testType = aTestType;
    outcome = aOutcome;
    manufacturer = aManufacturer;
    processingLab = aProcessingLab;
    processedDate = aProcessedDate;
    boolean didAddPatient = setPatient(aPatient);
    if (!didAddPatient)
    {
      throw new RuntimeException("Unable to create test due to patient. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(String aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setTime(String aTime)
  {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setTestLocation(String aTestLocation)
  {
    boolean wasSet = false;
    testLocation = aTestLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setTestType(String aTestType)
  {
    boolean wasSet = false;
    testType = aTestType;
    wasSet = true;
    return wasSet;
  }

  public boolean setOutcome(boolean aOutcome)
  {
    boolean wasSet = false;
    outcome = aOutcome;
    wasSet = true;
    return wasSet;
  }

  public boolean setManufacturer(String aManufacturer)
  {
    boolean wasSet = false;
    manufacturer = aManufacturer;
    wasSet = true;
    return wasSet;
  }

  public boolean setProcessingLab(String aProcessingLab)
  {
    boolean wasSet = false;
    processingLab = aProcessingLab;
    wasSet = true;
    return wasSet;
  }

  public boolean setProcessedDate(String aProcessedDate)
  {
    boolean wasSet = false;
    processedDate = aProcessedDate;
    wasSet = true;
    return wasSet;
  }

  public String getDate()
  {
    return date;
  }

  public String getTime()
  {
    return time;
  }

  public String getTestLocation()
  {
    return testLocation;
  }

  public String getTestType()
  {
    return testType;
  }

  public boolean getOutcome()
  {
    return outcome;
  }

  public String getManufacturer()
  {
    return manufacturer;
  }

  public String getProcessingLab()
  {
    return processingLab;
  }

  public String getProcessedDate()
  {
    return processedDate;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isOutcome()
  {
    return outcome;
  }
  /* Code from template association_GetOne */
  public Patient getPatient()
  {
    return patient;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPatient(Patient aPatient)
  {
    boolean wasSet = false;
    if (aPatient == null)
    {
      return wasSet;
    }

    Patient existingPatient = patient;
    patient = aPatient;
    if (existingPatient != null && !existingPatient.equals(aPatient))
    {
      existingPatient.removeTest(this);
    }
    patient.addTest(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Patient placeholderPatient = patient;
    this.patient = null;
    if(placeholderPatient != null)
    {
      placeholderPatient.removeTest(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "date" + ":" + getDate()+ "," +
            "time" + ":" + getTime()+ "," +
            "testLocation" + ":" + getTestLocation()+ "," +
            "testType" + ":" + getTestType()+ "," +
            "outcome" + ":" + getOutcome()+ "," +
            "manufacturer" + ":" + getManufacturer()+ "," +
            "processingLab" + ":" + getProcessingLab()+ "," +
            "processedDate" + ":" + getProcessedDate()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "patient = "+(getPatient()!=null?Integer.toHexString(System.identityHashCode(getPatient())):"null");
  }
}