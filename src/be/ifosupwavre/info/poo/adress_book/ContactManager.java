package be.ifosupwavre.info.poo.adress_book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ContactManager {
	private List<Contact> contacts = new ArrayList<>();
	
	public boolean addContact(Contact contact){
		if (!contacts.contains(contact)) {
			return contacts.add(contact);
		} else {
			return false;
		}
		
	}
	
	public boolean deleteContact(Contact contact){
		if (contacts.contains(contact)) {
			return contacts.remove(contact);
		} else {
			return false;
		}
	}
	
	public boolean deleteContact(int index){
		if (contacts.contains(index)) {
			contacts.remove(index);
			return true;
		} else {
			return false;
		}
	}
	
	public List<Contact> getContacts() {
		return contacts;
	}
	
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	List<Contact> filter(String name, int zipcode){
		/*Predicate predicate = new Predicate<Contact>() {
			@Override
			public boolean test(Contact contact) {
				return false;
			}
			
			@Override
			public Predicate<Contact> and(Predicate<? super Contact> other) {
				return null;
			}
			
			@Override
			public Predicate<Contact> negate() {
				return null;
			}
			
			@Override
			public Predicate<Contact> or(Predicate<? super Contact> other) {
				return null;
			}
		}*/
		Predicate<Contact> predicate = null;
		if (name != null) {
			predicate = contact ->
					contact.getFirstName().contains(name) ||
					contact.getLastName().contains(name);
		}
		if (zipcode != 0) {
			predicate = contact ->
					contact.getZipcode() == zipcode;
		}
		
		if (predicate == null) {
			predicate = Objects::nonNull;
		}
		return contacts.parallelStream().filter(predicate).collect(Collectors.toList());
	}
}
