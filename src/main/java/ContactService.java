import java.util.*;

public class ContactService {

  private String uniqueId;

  {
    uniqueId = UUID.randomUUID().toString().substring(
        0, Math.min(toString().length(), 10));
  }

  private List<Contact> contactList = new ArrayList<>();

  ContactService() { contactList.add(new Contact(uniqueId)); }

  ContactService(String firstName) {
    contactList.add(new Contact(uniqueId, firstName));
  }

  ContactService(String firstName, String lastName) {
    contactList.add(new Contact(uniqueId, firstName, lastName));
  }

  ContactService(String firstName, String lastName, String phoneNumber) {
    contactList.add(new Contact(uniqueId, firstName, lastName, phoneNumber));
  }

  ContactService(String firstName, String lastName, String phoneNumber,
                 String address) {
    contactList.add(
        new Contact(uniqueId, firstName, lastName, phoneNumber, address));
  }

  @SuppressWarnings("unused")
  public Contact newContact() {
    Contact contact = new Contact(newUniqueId());
    contactList.add(contact);
    return contact;
  }

  public void deleteContact(Contact contact) { contactList.remove(contact); }

  @SuppressWarnings("unused")
  public void updateFirstName(Contact contact, String firstName) {
    contact.updateFirstName(firstName);
  }

  @SuppressWarnings("unused")
  public void updateLastName(Contact contact, String lastName) {
    contact.updateLastName(lastName);
  }

  @SuppressWarnings("unused")
  public void updatePhoneNumber(Contact contact, String phoneNumber) {
    contact.updatePhoneNumber(phoneNumber);
  }

  @SuppressWarnings("unused")
  public void updateAddress(Contact contact, String address) {
    contact.updateAddress(address);
  }

  public List<Contact> getContactList() { return contactList; }

  private String newUniqueId() {
    return uniqueId = UUID.randomUUID().toString().substring(
               0, Math.min(toString().length(), 10));
  }
}
