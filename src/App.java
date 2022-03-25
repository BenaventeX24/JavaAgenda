import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static ArrayList<Contacto> agenda = new ArrayList<Contacto>();

    public static void main(String[] args) throws Exception {
        while (agenda.size() < 256) {
            menu();
        }
    }

    public static void registrar() {
        Scanner s = new Scanner(System.in);
        boolean mailCorrecto = false;
        int counterArroba = 0;
        int counterPunto = 0;
        int num = 0;

        System.out.println("Ingrese el nombre: ");
        String nombre = s.nextLine();
        try {
            System.out.println("Ingrese su numero: ");
            String numS = s.nextLine();
            num = Integer.parseInt(numS);
        } catch (NumberFormatException e) {
            System.out.println("Numero erroneo, porfavor intente nuevamente");
            System.out.println("");
            registrar();
        }

        System.out.println("Ingrese su mail (presione enter si no desesa ingresar un mail): ");
        String mail = s.nextLine();

        while (mailCorrecto != true && mail.isBlank() != true) {
            for (int i = 0; i < mail.length(); i++) {
                if (i == '@') {
                    counterArroba++;
                }
                if (i == '.') {
                    counterPunto++;
                }
            }

            if (counterArroba == 1 && counterPunto > 0) {
                mailCorrecto = true;
                Contacto contact = new Contacto(nombre, num, mail);
                agenda.add(contact);
            } else {
                System.out.println("");
                System.out.println("Email no válido, intente nuevamente o presione enter para saltar este paso");
                System.out.println("");
                System.out.println("Ingrese su mail (presione enter si no desesa ingresar un mail): ");
                mail = s.nextLine();
                if (mail.isBlank()) {
                    Contacto contact = new Contacto(nombre, num, mail);
                    agenda.add(contact);
                }

            }
        }
    }

    public static void consultar() {
        Scanner s = new Scanner(System.in);
        boolean existe = false;
        String consulta = "";

        System.out.println("Contacto a buscar: ");
        consulta = s.nextLine();

        for (Contacto c : agenda) {
            if (c.getNombre().equals(consulta)) {
                existe = true;
                System.out.println(c.getNombre() + " " + c.getNum() + " " + c.getMail());
            }
        }

        if (existe == false) {
            System.out.println("No se encontró contacto con ese nombre");
        }

    }

    public static void menu() {
        Scanner s = new Scanner(System.in);
        int opc = 0;

        try {
            System.out.println("1) Registrar contacto");
            System.out.println("2) Consultar contacto");
            opc = s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Solo carácteres alfabéticos :)");
            menu();
        }

        switch (opc) {

            case 1:
                registrar();
                break;

            case 2:
                consultar();
                break;
        }

    };
}
