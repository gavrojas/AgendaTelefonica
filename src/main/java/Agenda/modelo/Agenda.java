package Agenda.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agenda {
  private final List<Contact> contactList;
  private final Map<String, Integer> mapearContact;
  private int limite;
  
  //Constructor
  public Agenda(){
    this.contactList = new ArrayList<>();
    this.mapearContact = new HashMap<>();
  }
  
  //Métodos getter y setter
  public int getLimite() {
    return limite;
  }
  
  public void setLimite(int limite) {
    this.limite = limite;
  }
  
  //Métodos propios
  
  //Añadir contacto
  public void addContact (Contact contact){
    if (contactList.size() < getLimite() && mapearContact.get(contact.getName()) == null ){
      contactList.add(contact);
      mapearContact.put(contact.getName(), contact.getPhone());
      System.out.println("Contacto añadido exitosamente");
    } else{
      System.out.println("No puedes añadir un nuevo contacto, ");
      if(contactList.size() >= getLimite()){
        fullAgenda();
      } else if (mapearContact.get(contact.getName()) != null) {
        contactExists(contact.getName());
      }
    }
  }
  
  //Verificar si contacto existe
  public void contactExists (String name){
    if (mapearContact.get(name) == null){
      System.out.println("El contacto no existe");
    } else{
      System.out.println("El contacto existe");
    }
    
  }
  
  //Listar todos los contactos
  public void listarContacts(){
    int i = 1;
    System.out.println("--------------------------------------");
    System.out.println("\t\tAgenda telefónica");
    System.out.println("--------------------------------------");
    for (Contact contact: contactList){
      System.out.printf("Contacto %d: nombre: %s, teléfono %d\n", i, contact.getName(), contact.getPhone());
      i++;
    }
    System.out.println("--------------------------------------------------");
  }
  
  //Buscar un contacto por su nombre
  public void searchContact(String name){
    if (mapearContact.get(name) == null){
      System.out.println("El contacto no existe");
    } else{
      for (Contact contact: contactList){
        if(contact.getName().equals(name)) {
          System.out.printf("El teléfono de %s es %d\n", contact.getName(), contact.getPhone());
          break;
        }
      }
    }
  }
  
  //Borrar un contacto
  public void deleteContact(String name){
    boolean contactoDeleted = contactList.removeIf(contact -> contact.getName().equals(name));
    if(contactoDeleted){
      System.out.println("Contacto eliminado exitosamente.");
    }else{
      System.out.println("El contacto no existe, no lo puedes eliminar.");
    }
  }
  
  //Revisar si la agenda está llena
  public void fullAgenda(){
    if( contactList.size() == getLimite()){
      System.out.println("La agenda se encuentra llena");
    } else{
      freeSpaces();
    }
  }
  
  //Revisar cuántos contactos hay disponibles para agregar en agenda.
  public void freeSpaces(){
    System.out.printf("Tienes %d espacios disponibles para añadir contactos\n", getLimite()  - contactList.size());
  }
  
}
