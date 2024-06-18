package Agenda.modelo;
import java.util.Scanner;

public class Menu {
  public void menu(){
    //Definición de variables
    int limite = 10;
    int optionUser;
    String rtaLimite;
    String nuevoName;
    
    //Instanciando agenda
    Agenda agenda = new Agenda();
    
    Scanner scanner = new Scanner(System.in);
    
    //Menú opciones para la agenda teléfónica
    System.out.println("--------------------------------\nBienvenid@ a tu agenda telefónica\n¿Quieres añadir un límite para tu agenda? Coloca s para SI, o n para NO");
    rtaLimite = scanner.nextLine();
    
    //Definiendo tamaño de la agenda
    switch (rtaLimite){
      case "s":
        System.out.println("Ingresa la cantidad de contactos que quieres que tu agenda tenga.");
        limite = scanner.nextInt();
        scanner.nextLine();
        break;
      case "n":
        System.out.println("El tamaño por defecto será 10.");
        break;
      default:
        System.out.println("Opción errónea, recuerda: coloca s para SI, o n para NO ");
    }
    
    //Seteando límite agenda
    agenda.setLimite(limite);
    
    //Menú de opciones de la agenda.
    do{
      System.out.println("******************************");
      System.out.println("Menú de opciones:\n" +
              "1. Añadir contacto.\n" +
              "2. Eliminar Contacto.\n" +
              "3. Buscar contacto.\n" +
              "4. Listar contactos.\n" +
              "5. Verificar si existe un contacto.\n" +
              "6. Verificar agenda llena.\n" +
              "7. Verificar espacios libres en agenda.\n" +
              "8. Salir.\n" +
              "\nIngresa la opción que deseas: ");
      optionUser = scanner.nextInt();
      scanner.nextLine();
      
      switch (optionUser){
        case 1:
          System.out.println("Ingresa el nombre del nuevo contacto: ");
          nuevoName = scanner.nextLine();
          
          System.out.println("Ingresa el teléfono del nuevo contacto: ");
          int nuevoPhone = scanner.nextInt();
          scanner.nextLine();
          
          Contact nuevoContact = new Contact(nuevoName, nuevoPhone);
          agenda.addContact(nuevoContact);
          break;
        case 2:
          System.out.println("Ingresa el nombre del contacto a eliminar: ");
          nuevoName = scanner.nextLine();
          agenda.deleteContact(nuevoName);
          break;
        case 3:
          System.out.println("Ingresa el nombre del contacto a buscar: ");
          nuevoName = scanner.nextLine();
          agenda.searchContact(nuevoName);
          break;
        case 4:
          agenda.listarContacts();
          break;
        case 5:
          System.out.println("Ingresa el nombre del contacto para verificar si existe: ");
          nuevoName = scanner.nextLine();
          agenda.contactExists(nuevoName);
          break;
        case 6:
          agenda.fullAgenda();
          break;
        case 7:
          agenda.freeSpaces();
          break;
        case 8:
          System.out.println("Saliendo de la agenda...");
          break;
        default:
          System.out.println("Opción errónea.");
      }
      
    }while(optionUser != 8); // Ejecución de menú hasta que el usuario elija opción: Salir.
    
    scanner.close();
  }
}
