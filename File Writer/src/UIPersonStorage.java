import java.util.Scanner;

public class UIPersonStorage
{
  private PersonStorage storage;

  public UIPersonStorage(PersonStorage storage)
  {
    this.storage = storage;
  }

  public void startUI() {
    while (true)
    {
      Scanner in = new Scanner(System.in);
      System.out.println("Choose option:");
      System.out.println("1: add Person");
      System.out.println("2: get Person");

      String choice = in.nextLine();
      try
      {
        int choiceValue = Integer.parseInt(choice);
        if (choiceValue == 1)
        {
          System.out.println("Name:");
          String name = in.nextLine();
          System.out.println("SSN:");
          String ssnString = in.nextLine();
          int ssn = Integer.parseInt(ssnString);
          System.out.println("Date of birth:");
          String dob = in.nextLine();
          Person toAdd = new Person(name, dob, ssn);
          storage.addPerson(toAdd);
        }
        else if (choiceValue == 2)
        {
          System.out.println("SSN:");
          String ssnString = in.nextLine();
          int ssn = Integer.parseInt(ssnString);
          Person person = storage.getPerson(ssn);
          System.out.println(person);
        }
        else
        {
          System.out.println("Invalid choice");
        }
      } catch(NumberFormatException e) {
        System.out.println("Invalid choice");
      }
    }
  }
}
