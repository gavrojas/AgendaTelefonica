package Agenda.test;
import Agenda.modelo.Agenda;
import Agenda.modelo.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AgendaTest {
  private Agenda agendaTesting;
  private Contact nuevoContact;
  
  @BeforeEach
  void setUp(){
    agendaTesting = new Agenda();
    nuevoContact = new Contact("Yineth", 65416);
    agendaTesting.setLimite(2);
    System.out.println("-------------------------------\nIniciando test\n");
  }
  
  //Verificar que añadir una tarea se ve reflejado en lo espacios libres.
  @Test
  void testAddContact(){
    agendaTesting.addContact(nuevoContact);
    assertEquals(1, agendaTesting.getLimite() - agendaTesting.freeSpaces());
  }
  
  //Verificar que eliminar una tarea libera espacios
  @Test
  void testDeleteContact(){
    agendaTesting.addContact(nuevoContact);
    String contactToDelete = "Yineth";
    agendaTesting.deleteContact(contactToDelete);
    assertEquals(0, agendaTesting.getLimite() - agendaTesting.freeSpaces());
  }
  
  @Test
  void testContactExist(){
    agendaTesting.addContact(nuevoContact);
    String contactToTest = "Yineth";
    assertTrue(agendaTesting.contactExists(contactToTest));
  }
  
  @Test
  void testContactDoesntExist(){
    agendaTesting.addContact(nuevoContact);
    String contactToTest = "Sara";
    assertFalse(agendaTesting.contactExists(contactToTest));
  }
  
}
