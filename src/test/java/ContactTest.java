import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
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
  void contactTest() {
    Contact contact = new Contact();
    Assertions.assertNull(contact.getContactId());
    Assertions.assertNull(contact.getFirstName());
    Assertions.assertNull(contact.getLastName());
    Assertions.assertNull(contact.getPhoneNumber());
    Assertions.assertNull(contact.getAddress());
  }

  @Test
  void contactIdConstructorTest() {
    Contact contact = new Contact(contactId);
    Assertions.assertEquals(contactId, contact.getContactId());
    Assertions.assertNull(contact.getFirstName());
    Assertions.assertNull(contact.getLastName());
    Assertions.assertNull(contact.getPhoneNumber());
    Assertions.assertNull(contact.getAddress());
  }

  @Test
  void contactIdAndFirstNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest);
    Assertions.assertEquals(contactId, contact.getContactId());
    Assertions.assertEquals(firstNameTest, contact.getFirstName());
    Assertions.assertNull(contact.getLastName());
    Assertions.assertNull(contact.getPhoneNumber());
    Assertions.assertNull(contact.getAddress());
  }

  @Test
  void contactIdAndFullNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
    Assertions.assertEquals(contactId, contact.getContactId());
    Assertions.assertEquals(firstNameTest, contact.getFirstName());
    Assertions.assertEquals(lastNameTest, contact.getLastName());
    Assertions.assertNull(contact.getPhoneNumber());
    Assertions.assertNull(contact.getAddress());
  }

  @Test
  void contactIdFullNamePhoneNumberConstructorTest() {
    Contact contact =
        new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
    Assertions.assertEquals(contactId, contact.getContactId());
    Assertions.assertEquals(firstNameTest, contact.getFirstName());
    Assertions.assertEquals(lastNameTest, contact.getLastName());
    Assertions.assertEquals(phoneNumberTest, contact.getPhoneNumber());
    Assertions.assertNull(contact.getAddress());
  }

  @Test
  void allTheProperThingsConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest,
                                  phoneNumberTest, addressTest);
    Assertions.assertEquals(contactId, contact.getContactId());
    Assertions.assertEquals(firstNameTest, contact.getFirstName());
    Assertions.assertEquals(lastNameTest, contact.getLastName());
    Assertions.assertEquals(phoneNumberTest, contact.getPhoneNumber());
    Assertions.assertEquals(addressTest, contact.getAddress());
  }

  @Test
  void updateFirstNameTest() {
    Contact contact = new Contact();
    Assertions.assertNull(contact.getFirstName());
    contact.updateFirstName(firstNameTest);
    Assertions.assertEquals(firstNameTest, contact.getFirstName());
  }

  @Test
  void updateFirstNameTooLongNullTest() {
    Contact contact = new Contact();
    Assertions.assertNull(contact.getFirstName());
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(tooLongFirstName));
    Assertions.assertNull(contact.getFirstName());
  }

  @Test
  void updateFirstNameTooLongTest() {
    Contact contact = new Contact(contactId, firstNameTest);
    Assertions.assertEquals(firstNameTest, contact.getFirstName());
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(tooLongFirstName));
    Assertions.assertEquals(firstNameTest, contact.getFirstName());
  }

  @Test
  void updateFirstNameNullTest() {
    Contact contact = new Contact(contactId, firstNameTest);
    Assertions.assertEquals(firstNameTest, contact.getFirstName());
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(null));
    Assertions.assertEquals(firstNameTest, contact.getFirstName());
  }

  @Test
  void updateLastNameTest() {
    Contact contact = new Contact();
    Assertions.assertNull(contact.getLastName());
    contact.updateLastName(lastNameTest);
    Assertions.assertEquals(lastNameTest, contact.getLastName());
  }

  @Test
  void updateLastNameTooLongNullTest() {
    Contact contact = new Contact();
    Assertions.assertNull(contact.getLastName());
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(tooLongLastName));
    Assertions.assertNull(contact.getLastName());
  }

  @Test
  void updateLastNameTooLongTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
    Assertions.assertEquals(lastNameTest, contact.getLastName());
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(tooLongLastName));
    Assertions.assertEquals(lastNameTest, contact.getLastName());
  }

  @Test
  void updateLastNameNullTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
    Assertions.assertEquals(lastNameTest, contact.getLastName());
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(null));
    Assertions.assertEquals(lastNameTest, contact.getLastName());
  }

  @Test
  void updatePhoneNumberTooLongTest() {
    Contact contact =
        new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
    Assertions.assertEquals(phoneNumberTest, contact.getPhoneNumber());
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> contact.updatePhoneNumber(tooLongPhoneNumber));
    Assertions.assertEquals(phoneNumberTest, contact.getPhoneNumber());
  }

  @Test
  void updatePhoneNumberTooShortTest() {
    Contact contact =
        new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
    Assertions.assertEquals(phoneNumberTest, contact.getPhoneNumber());
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> contact.updatePhoneNumber(tooShortPhoneNumber));
    Assertions.assertEquals(phoneNumberTest, contact.getPhoneNumber());
  }

  @Test
  void updateAddressTooLongTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest,
                                  phoneNumberTest, addressTest);
    Assertions.assertEquals(addressTest, contact.getAddress());
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> contact.updateAddress(tooLongAddress));
    Assertions.assertEquals(addressTest, contact.getAddress());
  }
}
