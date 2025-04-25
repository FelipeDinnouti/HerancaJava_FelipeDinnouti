import java.util.Date;

public class Gerente extends Funcionario{

    Gerente(String cpf, Date dataNascimento, String nome, Department departmento, float salario) {
        super(cpf, dataNascimento, nome, departmento, salario);
        
        System.out.println("Gerente cadastrado!\n\n");
    }

    public void realizarReuniao() {
        System.out.println(String.format("Gerente \"%s\" está realizando reunião...", this.getNome()));
    }
    
    @Override
    public void mostrarDados() {
        System.out.println(String.format("Gerente \"%s\":\n - Departamento: %s\n - Salário: %.2fR$\n - CPF: %s\n - Data de Nascimento: %s", this.getNome(), DepartmentTranslation.get(this.getDepartamento()), this.getSalario(), this.getCpf(), this.getdataNascimento()));
    }

}