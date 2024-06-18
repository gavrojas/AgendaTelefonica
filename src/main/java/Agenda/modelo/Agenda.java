package Agenda.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agenda {
  private List<Contact> contactList;
  private Map<String, Integer> mapearContact = new HashMap<>();
  private int limite;
  
  //Constructor
  public Agenda(){
    this.contactList = new ArrayList<>();
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
    if (fullAgenda(getLimite()) == false && contactExists(contact) == false ){
      contactList.add(contact);
      mapearContact.put(contact.getName(), contact.getPhone());
    } else{
      System.out.println("No puedes añadir un nuevo contacto");
    }
  }
  
  //Verificar si contacto existe
  public boolean contactExists (Contact contact){
    if(mapearContact.containsKey(contact.getName())){
      System.out.printf("\nEl contacto con nombre \"%s\" ya existe\n", contact.getName());
      return true;
    } else {
      return false;
    }
    
  }
  
  //Listar todos los contactos
  public void listarContacts(){
    int i = 1;
    System.out.println("--------------------------------------");
    for (Contact contact: contactList){
      System.out.printf("Contacto %d: nombre: %s, teléfono %d\n", i, contact.getName(), contact.getPhone());
      i++;
    }
    System.out.println("--------------------------------------");
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
  public void deleteContact(Contact contact){
    if (contactExists(contact) == true ){
      contactList.remove(contact);
      mapearContact.remove(contact.getName(), contact.getPhone());
      System.out.println("Constacto eliminado exitosamente");
    } else{
      System.out.println("No puedes eliminar este contacto, no existe");
    }
  }
  
  //Revisar si la agenda está llena
  public boolean fullAgenda(int limite){
    if( contactList.size() == limite){
      System.out.println("La agenda se encuentra llena");
      return true;
    } else{
      return false;
    }
  }
  
  //Revisar cuántos contactos hay disponibles para agregar en agenda.
  public int freeSpaces(int limite){
    return limite - contactList.size();
  }
  
}
