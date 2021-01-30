public class Contact {

  private final String contactId;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;

  Contact() { this(null, null, null, null, null); }

  Contact(String contactId) {
    this.contactId = contactId;
    this.firstName = null;
    this.lastName = null;
    this.phoneNumber = null;
    this.address = null;
  }

  Contact(String contactId, String firstName) {
    this.contactId = contactId;
    this.firstName = firstName;
    this.lastName = null;
    this.phoneNumber = null;
    this.address = null;
  }

  Contact(String contactId, String firstName, String lastName) {
    this.contactId = contactId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = null;
    this.address = null;
  }

  Contact(String contactId, String firstName, String lastName,
          String phoneNumber) {
    this.contactId = contactId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.address = null;
  }

  Contact(String contactId, String firstName, String lastName,
          String phoneNumber, String address) {
    this.contactId = contactId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }

  @SuppressWarnings("unused")
  public final String getContactId() {
    return contactId;
  }

  @SuppressWarnings("unused")
  public final String getFirstName() {
    return firstName;
  }

  @SuppressWarnings("unused")
  public final String getLastName() {
    return lastName;
  }

  @SuppressWarnings("unused")
  public final String getPhoneNumber() {
    return phoneNumber;
  }

  @SuppressWarnings("unused")
  public final String getAddress() {
    return address;
  }

  @SuppressWarnings("unused")
  public void updateFirstName(String firstName) {
    if (firstName == null || firstName.length() > 10) {
      throw new IllegalArgumentException(
          "Unable to update first name because it is either longer than 10 characters or empty");
    } else {
      this.firstName = firstName;
    }
  }

  @SuppressWarnings("unused")
  public void updateLastName(String lastName) {
    if (lastName == null || lastName.length() > 10) {
      throw new IllegalArgumentException(
          "Unable to update last name because it is either longer than 10 characters or empty");
    } else {
      this.lastName = lastName;
    }
  }

  @SuppressWarnings("unused")
  public void updatePhoneNumber(String phoneNumber) {
    if (phoneNumber.length() != 10) {
      throw new IllegalArgumentException(
          "Phone number length invalid. Ensure it is 10 digits.");
    } else {
      this.phoneNumber = phoneNumber;
    }
  }

  @SuppressWarnings("unused")
  public void updateAddress(String address) throws NullPointerException {
    if (address.length() > 30) {
      throw new IllegalArgumentException(
          "Address length is invalid. Ensure it is shorter than 30 characters.");
    } else {
      this.address = address;
    }
  }
}
