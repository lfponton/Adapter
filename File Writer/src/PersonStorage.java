public interface PersonStorage
{
  void addPerson(Person person);
  Person getPerson(int socialSecurityNumber);
}
