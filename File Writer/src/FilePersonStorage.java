import java.io.*;

public class FilePersonStorage implements PersonStorage
{
  private File file;
  public FilePersonStorage()
  {
    file = new File("PersonStorage");

  }

  @Override public void addPerson(Person person)
  {
    FileWriter fileWriter;
    try {
      fileWriter = new FileWriter(file, true);
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }
    Person existingPerson = getPerson(person.getSocialSecurityNumber());
    if(existingPerson != null) throw new IllegalStateException("Person already exists");
    String toWrite = person.getSocialSecurityNumber() + ";" +
        person.getName() + ";" + person.getDateOfBirth() +"\n";
    try
    {
      fileWriter.append(toWrite);
      fileWriter.flush();
      fileWriter.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public Person getPerson(int socialSecurityNumber)
  {
    BufferedReader reader;
    try
    {
      reader = new BufferedReader(new FileReader(file));
      String line = reader.readLine();
      while(line != null) {
        String[] split = line.split(";");
        int tempSSN = Integer.parseInt(split[0]);
        if(socialSecurityNumber == Integer.parseInt(split[0]))
        {
          Person toReturn = new Person(split[1], split[2], tempSSN);
          return toReturn;
        }
        line = reader.readLine();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
