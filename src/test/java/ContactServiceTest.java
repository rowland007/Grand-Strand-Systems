import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
      addressTest;
  protected String tooLongContactId, tooLongFirstName, tooLongLastName,
      tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

  @BeforeEach
  void setUp() {
    contactId = "1029384756";
    firstNameTest = "John";
    lastNameTest = "Smith";
    phoneNumberTest = "5553331234";
    addressTest = "1 Audrey Jersey City NJ 07305";
    tooLongContactId = "112233445566778899";
    tooLongFirstName = "John Jacob Jingle";
    tooLongLastName = "-heimer Schmidt";
    tooLongPhoneNumber = "55512341234";
    tooShortPhoneNumber = "1234567";
    tooLongAddress = "1 Audrey Zapp Drive, Jersey City, NJ 07305";
  }

  @Test
  void ContactServiceConstructorTest() {
    ContactService service = new ContactService();
    Assertions.assertNotNull(service.getContactList().get(0).getContactId());
  }

  @Test
  void ContactServiceConstructorIdLengthTest() {
    ContactService service = new ContactService();
    Assertions.assertTrue(
        service.getContactList().get(0).getContactId().length() <= 10);
  }

  @Test
  void ContactServiceConstructorFirstNameTest() {
    ContactService service = new ContactService(firstNameTest);
    Assertions.assertEquals(firstNameTest,
                            service.getContactList().get(0).getFirstName());
  }

  @Test
  void ContactServiceConstructorFullNameTest() {
    ContactService service = new ContactService(firstNameTest, lastNameTest);
    Assertions.assertEquals(firstNameTest,
                            service.getContactList().get(0).getFirstName());
    Assertions.assertEquals(lastNameTest,
                            service.getContactList().get(0).getLastName());
  }

  @Test
  void ContactServiceConstructorFullNameAndNumberTest() {
    ContactService service =
        new ContactService(firstNameTest, lastNameTest, phoneNumberTest);
    Assertions.assertEquals(firstNameTest,
                            service.getContactList().get(0).getFirstName());
    Assertions.assertEquals(lastNameTest,
                            service.getContactList().get(0).getLastName());
    Assertions.assertEquals(phoneNumberTest,
                            service.getContactList().get(0).getPhoneNumber());
  }

  @Test
  void ContactServiceConstructorIntializeEverythingTest() {
    ContactService service = new ContactService(firstNameTest, lastNameTest,
                                                phoneNumberTest, addressTest);
    Assertions.assertEquals(firstNameTest,
                            service.getContactList().get(0).getFirstName());
    Assertions.assertEquals(lastNameTest,
                            service.getContactList().get(0).getLastName());
    Assertions.assertEquals(phoneNumberTest,
                            service.getContactList().get(0).getPhoneNumber());
    Assertions.assertEquals(addressTest,
                            service.getContactList().get(0).getAddress());
  }

  @Test
  void newContactTest() {
    ContactService service = new ContactService();
    Contact tempContactObject = service.newContact();
    Assertions.assertNotEquals(tempContactObject.getContactId(),
                               service.getContactList().get(0).getContactId());
  }

  @Test
  void newContactUpdateTest() {
    ContactService service = new ContactService();
    Contact tempContactObject = service.newContact();
    Assertions.assertNotNull(tempContactObject.getContactId());
    Assertions.assertNull(tempContactObject.getFirstName());
    Assertions.assertNull(tempContactObject.getLastName());
    Assertions.assertNull(tempContactObject.getPhoneNumber());
    Assertions.assertNull(tempContactObject.getAddress());
    tempContactObject.updateFirstName(firstNameTest);
    tempContactObject.updateLastName(lastNameTest);
    tempContactObject.updatePhoneNumber(phoneNumberTest);
    tempContactObject.updateAddress(addressTest);
    Assertions.assertEquals(firstNameTest, tempContactObject.getFirstName());
    Assertions.assertEquals(lastNameTest, tempContactObject.getLastName());
    Assertions.assertEquals(phoneNumberTest,
                            tempContactObject.getPhoneNumber());
    Assertions.assertEquals(addressTest, tempContactObject.getAddress());
  }

  @Test
  void updateContactUpdateListTest() {
    ContactService service = new ContactService();
    Contact tempContactObject = service.newContact();
    Assertions.assertNotNull(tempContactObject.getContactId());
    Assertions.assertNull(tempContactObject.getFirstName());
    Assertions.assertNull(tempContactObject.getLastName());
    Assertions.assertNull(tempContactObject.getPhoneNumber());
    Assertions.assertNull(tempContactObject.getAddress());
    service.getContactList().get(0).updateFirstName(firstNameTest);
    service.getContactList().get(0).updateLastName(lastNameTest);
    service.getContactList().get(0).updatePhoneNumber(phoneNumberTest);
    service.getContactList().get(0).updateAddress(addressTest);
    Assertions.assertEquals(firstNameTest,
                            service.getContactList().get(0).getFirstName());
    Assertions.assertEquals(lastNameTest,
                            service.getContactList().get(0).getLastName());
    Assertions.assertEquals(phoneNumberTest,
                            service.getContactList().get(0).getPhoneNumber());
    Assertions.assertEquals(addressTest,
                            service.getContactList().get(0).getAddress());
  }

  @Test
  void multipleNewContactTest() {
    ContactService service = new ContactService(
        tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooLongAddress);
    Contact tempContact1 = service.newContact();
    Contact tempContact2 = service.newContact();
    Assertions.assertNotEquals(tempContact1.getContactId(),
                               service.getContactList().get(0).getContactId());
    Assertions.assertNotEquals(tempContact2.getContactId(),
                               service.getContactList().get(0).getContactId());
    Assertions.assertNotEquals(tempContact1.getContactId(),
                               tempContact2.getContactId());
    Assertions.assertTrue(service.getContactList().size() >= 2);
    Assertions.assertNotEquals(service.getContactList().get(0).getContactId(),
                               service.getContactList().get(1).getContactId());
    Assertions.assertNotEquals(service.getContactList().get(0).getContactId(),
                               service.getContactList().get(2).getContactId());
    Assertions.assertNotEquals(service.getContactList().get(1).getContactId(),
                               service.getContactList().get(2).getContactId());
  }

  @Test
  void deleteContactTest() {
    ContactService service = new ContactService(
        tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooLongAddress);
    Contact tempContact1 = service.newContact();
    Contact tempContact2 = service.newContact();
    service.getContactList().get(1).updateFirstName(firstNameTest);
    service.getContactList().get(1).updateLastName(lastNameTest);
    service.getContactList().get(1).updatePhoneNumber(phoneNumberTest);
    service.getContactList().get(1).updateAddress(addressTest);
    Assertions.assertEquals(tooLongFirstName,
                            service.getContactList().get(0).getFirstName());
    Assertions.assertEquals(tooLongLastName,
                            service.getContactList().get(0).getLastName());
    Assertions.assertEquals(tooLongPhoneNumber,
                            service.getContactList().get(0).getPhoneNumber());
    Assertions.assertEquals(tooLongAddress,
                            service.getContactList().get(0).getAddress());
    Assertions.assertEquals(firstNameTest,
                            service.getContactList().get(1).getFirstName());
    Assertions.assertEquals(lastNameTest,
                            service.getContactList().get(1).getLastName());
    Assertions.assertEquals(phoneNumberTest,
                            service.getContactList().get(1).getPhoneNumber());
    Assertions.assertEquals(addressTest,
                            service.getContactList().get(1).getAddress());
    service.deleteContact(service.getContactList().get(0));
    Assertions.assertEquals(firstNameTest,
                            service.getContactList().get(0).getFirstName());
    Assertions.assertEquals(lastNameTest,
                            service.getContactList().get(0).getLastName());
    Assertions.assertEquals(phoneNumberTest,
                            service.getContactList().get(0).getPhoneNumber());
    Assertions.assertEquals(addressTest,
                            service.getContactList().get(0).getAddress());
  }

  @Test
  void updateFirstNameTest() {
    ContactService service = new ContactService();
    service.updateFirstName(service.getContactList().get(0), firstNameTest);
    Assertions.assertEquals(firstNameTest,
                            service.getContactList().get(0).getFirstName());
  }

  @Test
  void updateLastNameTest() {
    ContactService service = new ContactService();
    service.updateLastName(service.getContactList().get(0), lastNameTest);
    Assertions.assertEquals(lastNameTest,
                            service.getContactList().get(0).getLastName());
  }

  @Test
  void updatePhoneNumberTest() {
    ContactService service = new ContactService();
    service.updatePhoneNumber(service.getContactList().get(0), phoneNumberTest);
    Assertions.assertEquals(phoneNumberTest,
                            service.getContactList().get(0).getPhoneNumber());
  }

  @Test
  void updateAddressTest() {
    ContactService service = new ContactService();
    service.updateAddress(service.getContactList().get(0), addressTest);
    Assertions.assertEquals(addressTest,
                            service.getContactList().get(0).getAddress());
  }
}
