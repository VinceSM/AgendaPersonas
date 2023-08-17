package menu;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Persona> agenda;

    public Menu() {
        agenda = new ArrayList<>();
    }
    
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mostrarMenu();
    }
    
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("------ Menu ------");
            System.out.println("1. Leer los datos de una persona y guardarla en la agenda");
            System.out.println("2. Buscar una persona por su documento");
            System.out.println("3. Listar todas las personas");
            System.out.println("4. Terminar el programa");
            System.out.print("Ingrese la opcion deseada: ");
            opcion = Consola.leerEntero();
            
            switch (opcion) {
                case 1:
                    try 
                    {
                        leerDatosPersona();
                    } catch (DocumentoDuplicado e) 
                    {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    buscarPersonaPorDocumento();
                    break;
                case 3:
                    listarPersonas();
                    break;
                case 4:
                    System.out.println("Programa terminado.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion != 4);
    }
    
   private void leerDatosPersona() throws DocumentoDuplicado {
    System.out.println("\n--- Ingrese los datos de la persona ---");

    System.out.print("Nombre: ");
    String nombre = Consola.leerCadena();

    System.out.print("Apellido: ");
    String apellido = Consola.leerCadena();

    System.out.print("Documento: ");
    String documento = Consola.leerCadena();
    
    if (documentoExistente(documento)) {
        System.out.println("Error: El número de documento ya existe en la agenda.");
        return; // Salir sin agregar la persona
    }

    System.out.print("Fecha de nacimiento: ");
    String fechaNacimiento = Consola.leerCadena();

    // Agregar la persona a la agenda
    agenda.add(new Persona(nombre, apellido, documento, fechaNacimiento));
    
    System.out.println("¡Persona agregada a la agenda!\n");
}

private boolean documentoExistente(String documento) {
    for (Persona persona : agenda) {
        if (persona.getDocumento().equals(documento)) {
            return true; // El documento ya existe en la agenda
        }
    }
    return false; // El documento no existe en la agenda
}
    private void buscarPersonaPorDocumento() {
        System.out.println("\n--- Buscar persona por documento ---");
        
        System.out.print("Ingrese el número de documento: ");
        String documento = Consola.leerCadena();
        
        for (Persona persona : agenda) {
            if (persona.getDocumento().equals(documento)) {
                System.out.println("Persona encontrada:");
                System.out.println(persona);
                return;
            }
        }
        
        System.out.println("No se encontró ninguna persona con ese documento.\n");
    }
    
    private void listarPersonas() {
        System.out.println("\n--- Lista de personas ---");
        
        if (agenda.isEmpty()) {
            System.out.println("No hay personas en la agenda.\n");
            return;
        }
        
        for (Persona persona : agenda) {
            System.out.println(persona);
        }
        
        System.out.println();
    }
}
