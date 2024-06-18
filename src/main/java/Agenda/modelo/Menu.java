package Agenda.modelo;

import java.util.Scanner;

public class Menu {
  public void menu(){
    int limite = 10;
    int optionUser = 0;
    Agenda agenda = new Agenda();
    Contact contact1 = new Contact("Sara", 123456789);
    Contact contact2 = new Contact("Sara", 45165465);
    
    Scanner scanner = new Scanner(System.in);
    
    //Menú opciones para la agenda teléfónica
    System.out.println("--------------------------------\n" +
            "Bienvenid@ a tu agenda telefónica\n" +
            "Ingresa la cantidad de contactos que quieres añadir a la agenda.");
    limite = scanner.nextInt();
    scanner.nextLine();
    
    do{
      System.out.println("Menú de opciones:\n" +
              "1. Añadir contacto.\n" +
              "2. Eliminar Contacto.\n" +
              "3. Buscar contacto.\n" +
              "4. Listar contactos.\n" +
              "5. Verificar si existe un contacto.\n" +
              "6. Verificar agenda llena.\n" +
              "7. Verificar espacios libres en agenda.\n" +
              "8. Salir.");
      optionUser = scanner.nextInt();
    }while(optionUser == 8);
    
    agenda.setLimite(limite);
    
    agenda.addContact(contact1);
    agenda.listarContacts();
    agenda.searchContact("Sara");
    
    scanner.close();
  }
}
