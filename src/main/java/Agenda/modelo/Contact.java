package Agenda.modelo;

public class Contact {
  //Definición de variables
  private String name;
  private int phone;
  
  //Creación de constructores
  public Contact(){
  }
  
  public Contact(String name, int phone) {
    this.name = name;
    this.phone = phone;
  }
  
  //Métodos getter y setter
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getPhone() {
    return phone;
  }
  
  public void setPhone(int phone) {
    this.phone = phone;
  }
  
  //Métodos propios de la clase Agenda
  
}
