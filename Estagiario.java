import java.util.Date;

public class Estagiario extends Funcionario {
    
    Estagiario(String cpf, Date dataNascimento, String nome, Department departmento, float salario) {
        super(cpf, dataNascimento, nome, departmento, salario);

        System.out.println("Estagiario cadastrado!\n\n");
    }
    
    public void fazerTarefa() {
        System.out.println(String.format("Estagiário \"%s\" está realizando uma tarefa...", this.getNome()));
    }

    @Override
    public void mostrarDados() {
        System.out.println(String.format("Estágiario \"%s\":\n - Departamento: %s\n - Salário: %.2fR$\n - CPF: %s\n - Data de Nascimento: %s", this.getNome(), DepartmentTranslation.get(this.getDepartamento()), this.getSalario(), this.getCpf(), this.getdataNascimento()));
    }
}
