import java.util.Date;

public class Programador extends Funcionario {

    Programador(String cpf, Date dataNascimento, String nome, Department departmento, float salario) {
        super(cpf, dataNascimento, nome, departmento, salario);

        System.out.println("Programador cadastrado!\n\n");
    }

    public void programar() {
        System.out.println(String.format("Programador \"%s\" está programando...", this.getNome()));
    }

    @Override
    public void mostrarDados() {
        System.out.println(String.format("Programador \"%s\":\n - Departamento: %s\n - Salário: %.2fR$\n - CPF: %s\n - Data de Nascimento: %s", this.getNome(), DepartmentTranslation.get(this.getDepartamento()), this.getSalario(), this.getCpf(), this.getdataNascimento()));
    }
}
