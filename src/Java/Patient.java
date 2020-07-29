/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4969.ccd387f31 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 61 "model.ump"
public class Patient
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Patient Attributes
  private String name;
  private String address;
  private String phoneNumber;
  private int healthNumber;

  //Patient Associations
  private List<Test> tests;
  private List<Symptom> symptoms;
  private List<Patient> contactList;
  private List<Patient> patients;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Patient(String aName, String aAddress, String aPhoneNumber, int aHealthNumber)
  {
    name = aName;
    address = aAddress;
    phoneNumber = aPhoneNumber;
    healthNumber = aHealthNumber;
    tests = new ArrayList<Test>();
    symptoms = new ArrayList<Symptom>();
    contactList = new ArrayList<Patient>();
    patients = new ArrayList<Patient>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneNumber(String aPhoneNumber)
  {
    boolean wasSet = false;
    phoneNumber = aPhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setHealthNumber(int aHealthNumber)
  {
    boolean wasSet = false;
    healthNumber = aHealthNumber;
    wasSet = true;
    return wasSet;
  }

  /**
   * Patient[] contacts;
   * Symptom[] sympts;
   */
  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public int getHealthNumber()
  {
    return healthNumber;
  }
  /* Code from template association_GetMany */
  public Test getTest(int index)
  {
    Test aTest = tests.get(index);
    return aTest;
  }

  public List<Test> getTests()
  {
    List<Test> newTests = Collections.unmodifiableList(tests);
    return newTests;
  }

  public int numberOfTests()
  {
    int number = tests.size();
    return number;
  }

  public boolean hasTests()
  {
    boolean has = tests.size() > 0;
    return has;
  }

  public int indexOfTest(Test aTest)
  {
    int index = tests.indexOf(aTest);
    return index;
  }
  /* Code from template association_GetMany */
  public Symptom getSymptom(int index)
  {
    Symptom aSymptom = symptoms.get(index);
    return aSymptom;
  }

  public List<Symptom> getSymptoms()
  {
    List<Symptom> newSymptoms = Collections.unmodifiableList(symptoms);
    return newSymptoms;
  }

  public int numberOfSymptoms()
  {
    int number = symptoms.size();
    return number;
  }

  public boolean hasSymptoms()
  {
    boolean has = symptoms.size() > 0;
    return has;
  }

  public int indexOfSymptom(Symptom aSymptom)
  {
    int index = symptoms.indexOf(aSymptom);
    return index;
  }
  /* Code from template association_GetMany */
  public Patient getContactList(int index)
  {
    Patient aContactList = contactList.get(index);
    return aContactList;
  }

  public List<Patient> getContactList()
  {
    List<Patient> newContactList = Collections.unmodifiableList(contactList);
    return newContactList;
  }

  public int numberOfContactList()
  {
    int number = contactList.size();
    return number;
  }

  public boolean hasContactList()
  {
    boolean has = contactList.size() > 0;
    return has;
  }

  public int indexOfContactList(Patient aContactList)
  {
    int index = contactList.indexOf(aContactList);
    return index;
  }
  /* Code from template association_GetMany */
  public Patient getPatient(int index)
  {
    Patient aPatient = patients.get(index);
    return aPatient;
  }

  public List<Patient> getPatients()
  {
    List<Patient> newPatients = Collections.unmodifiableList(patients);
    return newPatients;
  }

  public int numberOfPatients()
  {
    int number = patients.size();
    return number;
  }

  public boolean hasPatients()
  {
    boolean has = patients.size() > 0;
    return has;
  }

  public int indexOfPatient(Patient aPatient)
  {
    int index = patients.indexOf(aPatient);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTests()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Test addTest(String aDate, String aTime, String aTestLocation, String aTestType, boolean aOutcome, String aManufacturer, String aProcessingLab, String aProcessedDate)
  {
    return new Test(aDate, aTime, aTestLocation, aTestType, aOutcome, aManufacturer, aProcessingLab, aProcessedDate, this);
  }

  public boolean addTest(Test aTest)
  {
    boolean wasAdded = false;
    if (tests.contains(aTest)) { return false; }
    Patient existingPatient = aTest.getPatient();
    boolean isNewPatient = existingPatient != null && !this.equals(existingPatient);
    if (isNewPatient)
    {
      aTest.setPatient(this);
    }
    else
    {
      tests.add(aTest);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTest(Test aTest)
  {
    boolean wasRemoved = false;
    //Unable to remove aTest, as it must always have a patient
    if (!this.equals(aTest.getPatient()))
    {
      tests.remove(aTest);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTestAt(Test aTest, int index)
  {  
    boolean wasAdded = false;
    if(addTest(aTest))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTests()) { index = numberOfTests() - 1; }
      tests.remove(aTest);
      tests.add(index, aTest);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTestAt(Test aTest, int index)
  {
    boolean wasAdded = false;
    if(tests.contains(aTest))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTests()) { index = numberOfTests() - 1; }
      tests.remove(aTest);
      tests.add(index, aTest);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTestAt(aTest, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSymptoms()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addSymptom(Symptom aSymptom)
  {
    boolean wasAdded = false;
    if (symptoms.contains(aSymptom)) { return false; }
    symptoms.add(aSymptom);
    if (aSymptom.indexOfPatient(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSymptom.addPatient(this);
      if (!wasAdded)
      {
        symptoms.remove(aSymptom);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeSymptom(Symptom aSymptom)
  {
    boolean wasRemoved = false;
    if (!symptoms.contains(aSymptom))
    {
      return wasRemoved;
    }

    int oldIndex = symptoms.indexOf(aSymptom);
    symptoms.remove(oldIndex);
    if (aSymptom.indexOfPatient(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSymptom.removePatient(this);
      if (!wasRemoved)
      {
        symptoms.add(oldIndex,aSymptom);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSymptomAt(Symptom aSymptom, int index)
  {  
    boolean wasAdded = false;
    if(addSymptom(aSymptom))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSymptoms()) { index = numberOfSymptoms() - 1; }
      symptoms.remove(aSymptom);
      symptoms.add(index, aSymptom);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSymptomAt(Symptom aSymptom, int index)
  {
    boolean wasAdded = false;
    if(symptoms.contains(aSymptom))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSymptoms()) { index = numberOfSymptoms() - 1; }
      symptoms.remove(aSymptom);
      symptoms.add(index, aSymptom);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSymptomAt(aSymptom, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfContactList()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addContactList(Patient aContactList)
  {
    boolean wasAdded = false;
    if (contactList.contains(aContactList)) { return false; }
    contactList.add(aContactList);
    if (aContactList.indexOfPatient(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aContactList.addPatient(this);
      if (!wasAdded)
      {
        contactList.remove(aContactList);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeContactList(Patient aContactList)
  {
    boolean wasRemoved = false;
    if (!contactList.contains(aContactList))
    {
      return wasRemoved;
    }

    int oldIndex = contactList.indexOf(aContactList);
    contactList.remove(oldIndex);
    if (aContactList.indexOfPatient(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aContactList.removePatient(this);
      if (!wasRemoved)
      {
        contactList.add(oldIndex,aContactList);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addContactListAt(Patient aContactList, int index)
  {  
    boolean wasAdded = false;
    if(addContactList(aContactList))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfContactList()) { index = numberOfContactList() - 1; }
      contactList.remove(aContactList);
      contactList.add(index, aContactList);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveContactListAt(Patient aContactList, int index)
  {
    boolean wasAdded = false;
    if(contactList.contains(aContactList))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfContactList()) { index = numberOfContactList() - 1; }
      contactList.remove(aContactList);
      contactList.add(index, aContactList);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addContactListAt(aContactList, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatients()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPatient(Patient aPatient)
  {
    boolean wasAdded = false;
    if (patients.contains(aPatient)) { return false; }
    patients.add(aPatient);
    if (aPatient.indexOfContactList(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPatient.addContactList(this);
      if (!wasAdded)
      {
        patients.remove(aPatient);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePatient(Patient aPatient)
  {
    boolean wasRemoved = false;
    if (!patients.contains(aPatient))
    {
      return wasRemoved;
    }

    int oldIndex = patients.indexOf(aPatient);
    patients.remove(oldIndex);
    if (aPatient.indexOfContactList(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPatient.removeContactList(this);
      if (!wasRemoved)
      {
        patients.add(oldIndex,aPatient);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPatientAt(Patient aPatient, int index)
  {  
    boolean wasAdded = false;
    if(addPatient(aPatient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatients()) { index = numberOfPatients() - 1; }
      patients.remove(aPatient);
      patients.add(index, aPatient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePatientAt(Patient aPatient, int index)
  {
    boolean wasAdded = false;
    if(patients.contains(aPatient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatients()) { index = numberOfPatients() - 1; }
      patients.remove(aPatient);
      patients.add(index, aPatient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPatientAt(aPatient, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=tests.size(); i > 0; i--)
    {
      Test aTest = tests.get(i - 1);
      aTest.delete();
    }
    ArrayList<Symptom> copyOfSymptoms = new ArrayList<Symptom>(symptoms);
    symptoms.clear();
    for(Symptom aSymptom : copyOfSymptoms)
    {
      aSymptom.removePatient(this);
    }
    ArrayList<Patient> copyOfContactList = new ArrayList<Patient>(contactList);
    contactList.clear();
    for(Patient aContactList : copyOfContactList)
    {
      aContactList.removePatient(this);
    }
    ArrayList<Patient> copyOfPatients = new ArrayList<Patient>(patients);
    patients.clear();
    for(Patient aPatient : copyOfPatients)
    {
      aPatient.removeContactList(this);
    }
  }

  // line 14 "model.ump"
   public String toString(){
    String returner = "";
    returner = returner+"Name: "+this.getName()+"\nAddress: "+this.getAddress()+"\nPhone: "+this.getPhoneNumber()+"\nHealth Number: "+this.getHealthNumber()+"\nTests completed:";
    List<Test> testsDone = this.getTests();
      for(Test tester: testsDone){
        returner=returner+"\n"+tester.getTestType()+", "+tester.getDate()+", "+Boolean.toString(tester.getOutcome());
      }
    return returner;
  }

  // line 23 "model.ump"
   public static  void main(String [] args){
    Thread.currentThread().setUncaughtExceptionHandler(new UmpleExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new UmpleExceptionHandler());
    Patient pat = new Patient("Pat the Patient", "123 Testing Street", "9055092222",1234);
    Test testOne = new VirusTest("July 1st", "12:01", "Markham Stouffville Hosptial","Virus",false,"Morton Biochemical", "Markham Stouffville Labs","July 3rd",pat);
    Test testTwo = new AntibodyTest("July 2nd", "14:36", "Ottawa General Hosptial","Antibody",false,"Morton Biochemical", "Ottawa General Labs","July 2nd", pat);
    pat.addTest(testOne);
    pat.addTest(testTwo);
    System.out.println(pat.toString());
  }

  public static class UmpleExceptionHandler implements Thread.UncaughtExceptionHandler
  {
    public void uncaughtException(Thread t, Throwable e)
    {
      translate(e);
      if(e.getCause()!=null)
      {
        translate(e.getCause());
      }
      e.printStackTrace();
    }
    public void translate(Throwable e)
    {
      java.util.List<StackTraceElement> result = new java.util.ArrayList<StackTraceElement>();
      StackTraceElement[] elements = e.getStackTrace();
      try
      {
        for(StackTraceElement element:elements)
        {
          String className = element.getClassName();
          String methodName = element.getMethodName();
          boolean methodFound = false;
          int index = className.lastIndexOf('.')+1;
          try {
            java.lang.reflect.Method query = this.getClass().getMethod(className.substring(index)+"_"+methodName,new Class[]{});
            UmpleSourceData sourceInformation = (UmpleSourceData)query.invoke(this,new Object[]{});
            for(int i=0;i<sourceInformation.size();++i)
            {
              // To compensate for any offsets caused by injected code we need to loop through the other references to this function
              //  and adjust the start / length of the function.
              int functionStart = sourceInformation.getJavaLine(i) + (("main".equals(methodName))?3:1);
              int functionEnd = functionStart + sourceInformation.getLength(i);
              int afterInjectionLines = 0;
              //  We can leverage the fact that all inject statements are added to the uncaught exception list 
              //   before the functions that they are within
              for (int j = 0; j < i; j++) {
                if (sourceInformation.getJavaLine(j) - 1 >= functionStart &&
                    sourceInformation.getJavaLine(j) - 1 <= functionEnd &&
                    sourceInformation.getJavaLine(j) - 1 <= element.getLineNumber()) {
                    // A before injection, +2 for the comments surrounding the injected code
                    if (sourceInformation.getJavaLine(j) - 1 == functionStart) {
                        functionStart += sourceInformation.getLength(j) + 2;
                        functionEnd += sourceInformation.getLength(j) + 2;
                    } else {
                        // An after injection
                        afterInjectionLines += sourceInformation.getLength(j) + 2;
                        functionEnd += sourceInformation.getLength(j) + 2;
                    }
                }
              }
              int distanceFromStart = element.getLineNumber() - functionStart - afterInjectionLines;
              if(distanceFromStart>=0&&distanceFromStart<=sourceInformation.getLength(i))
              {
                result.add(new StackTraceElement(element.getClassName(),element.getMethodName(),sourceInformation.getFileName(i),sourceInformation.getUmpleLine(i)+distanceFromStart));
                methodFound = true;
                break;
              }
            }
          }
          catch (Exception e2){}
          if(!methodFound)
          {
            result.add(element);
          }
        }
      }
      catch (Exception e1)
      {
        e1.printStackTrace();
      }
      e.setStackTrace(result.toArray(new StackTraceElement[0]));
    }
  //The following methods Map Java lines back to their original Umple file / line    
    public UmpleSourceData Patient_toString(){ return new UmpleSourceData().setFileNames("model.ump").setUmpleLines(13).setJavaLines(569).setLengths(7);}
    public UmpleSourceData Patient_main(){ return new UmpleSourceData().setFileNames("model.ump").setUmpleLines(22).setJavaLines(580).setLengths(6);}

  }
  public static class UmpleSourceData
  {
    String[] umpleFileNames;
    Integer[] umpleLines;
    Integer[] umpleJavaLines;
    Integer[] umpleLengths;
    
    public UmpleSourceData(){
    }
    public String getFileName(int i){
      return umpleFileNames[i];
    }
    public Integer getUmpleLine(int i){
      return umpleLines[i];
    }
    public Integer getJavaLine(int i){
      return umpleJavaLines[i];
    }
    public Integer getLength(int i){
      return umpleLengths[i];
    }
    public UmpleSourceData setFileNames(String... filenames){
      umpleFileNames = filenames;
      return this;
    }
    public UmpleSourceData setUmpleLines(Integer... umplelines){
      umpleLines = umplelines;
      return this;
    }
    public UmpleSourceData setJavaLines(Integer... javalines){
      umpleJavaLines = javalines;
      return this;
    }
    public UmpleSourceData setLengths(Integer... lengths){
      umpleLengths = lengths;
      return this;
    }
    public int size(){
      return umpleFileNames.length;
    }
  }
}