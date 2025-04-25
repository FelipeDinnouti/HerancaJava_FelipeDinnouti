import java.util.Scanner;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class Main {
    static String DEFAULT_MENU = "Bem vindo ao sistema de gerenciamento de funcionários!\n1 - Cadastrar novo funcionário\n2 - Listar funcionários\n0 - Sair\n\nSelecione uma opção: ";

    public static ArrayList<Estagiario> estagiarios = new ArrayList<Estagiario>(); 
    public static ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
    public static ArrayList<Programador> programadores = new ArrayList<Programador>();
    
    public static Funcionario.Department[] IntDepartmentMap = {Funcionario.Department.LOGISTICS, Funcionario.Department.ADMINISTRATION, Funcionario.Department.HUMAN_RESOURCES};
    public static Scanner scanner = new Scanner(System.in);

    public static Date readDataNascimento() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimento = null;
        boolean validDate = false;

        while (!validDate) {
            System.out.print("\nInsira uma data de nascimento (dd//MM/aaaa): ");
            String dateString = scanner.nextLine();

            try {
                dataNascimento = dateFormat.parse(dateString);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("Data inválida. Use dd/MM/aaaa");
            }
        }

        return dataNascimento;
    }

    public static void listarEstagiarios() {
        System.out.println("\nListando estágiarios:\n\n");
        for (int i = 0; i < estagiarios.size(); i++) {
            estagiarios.get(i).mostrarDados();
        }
    }
    public static void listarGerentes() {
        System.out.println("\nListando gerentes:\n\n");
        for (int i = 0; i < gerentes.size(); i++) {
            gerentes.get(i).mostrarDados();
        }
        
    }
    public static void listarProgramadores() {
        System.out.println("\nListando programadores:\n\n");
        for (int i = 0; i < programadores.size(); i++) {
            programadores.get(i).mostrarDados();
        }
    }

    public static void listarFuncionarios() {
        listarEstagiarios();
        listarGerentes();
        listarProgramadores();
    }

    public static void registrarEstagiario() {        
        System.out.print("\n\nInsira o nome do estágiario: ");
        scanner.nextLine();

        String nome = scanner.nextLine();
        
        Date dataNascimento = readDataNascimento();

        System.out.print("\nDigite o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("\nDigite o Salário: ");
        float salario = scanner.nextFloat();

        System.out.print("\nSelecione departamento:\n1 - Logística\n2 - Administração\n3 - Recursos Humanos\n\nOpção: ");
        int op = scanner.nextInt();
        Funcionario.Department department = IntDepartmentMap[op-1];

        Estagiario estagario = new Estagiario(cpf, dataNascimento, nome, department, salario);

        estagiarios.add(estagario);
    }
    public static void registrarGerente() {
        System.out.print("\n\nInsira o nome do gerente: ");
        scanner.nextLine();

        String nome = scanner.nextLine();
        
        Date dataNascimento = readDataNascimento();

        System.out.print("\nDigite o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("\nDigite o Salário: ");
        float salario = scanner.nextFloat();

        System.out.print("\nSelecione departamento:\n1 - Logística\n2 - Administração\n3 - Recursos Humanos\n\nOpção: ");
        int op = scanner.nextInt();
        Funcionario.Department department = IntDepartmentMap[op-1];

        Gerente gerente = new Gerente(cpf, dataNascimento, nome, department, salario);

        gerentes.add(gerente);

    }
    public static void registrarProgramador() {
        System.out.print("\n\nInsira o nome do programador: ");
        scanner.nextLine();

        String nome = scanner.nextLine();
        
        Date dataNascimento = readDataNascimento();

        System.out.print("\nDigite o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("\nDigite o Salário: ");
        float salario = scanner.nextFloat();

        System.out.print("\nSelecione departamento:\n1 - Logística\n2 - Administração\n3 - Recursos Humanos\n\nOpção: ");
        int op = scanner.nextInt();
        Funcionario.Department department = IntDepartmentMap[op-1];

        Programador programador = new Programador(cpf, dataNascimento, nome, department, salario);

        programadores.add(programador);
    }

    public static void main(String[] args) {
        int op = 1;

        while (op != 0) {

            System.out.print(DEFAULT_MENU);
            op = scanner.nextInt();

            switch (op) {
                // Register a new employee
                case 1:
                    System.out.print("Escolha um tipo de funcionário:\n1 - Estágiario\n2 - Gerente\n3 - Programador\n\nOpção: ");
                    int type = scanner.nextInt();
                    System.out.println("");
                    switch (type) {
                        case 1:
                            registrarEstagiario();    
                            break;
                        case 2:
                            registrarGerente();
                            break;
                        case 3:
                            registrarProgramador();
                            break;
                    }
                    break;
                // Show reigstered employee's data
                case 2:
                    System.out.print("\nEscolha um tipo de filtragem para listar funcionários:\n1 - Todos\n2 - Estagiarios\n3 - Gerentes\n4 - Programadores\n\nOpção: ");
                    int filter = scanner.nextInt();
                    switch (filter) {
                        case 1:
                            listarFuncionarios();   
                            break;
                        case 2:
                            listarEstagiarios();
                            break;
                        case 3:
                            listarGerentes();
                            break;
                        case 4:
                            listarProgramadores();
                            break;
                    }
                    break;

                default:
                    System.out.println("\n\nOpção inválida\n\n");
                    break;
            }

        }
        
        scanner.close();
    }
}
