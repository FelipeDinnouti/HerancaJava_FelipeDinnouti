import java.util.HashMap; 
import java.util.Date;

public class Funcionario extends Pessoa {
    public static enum Department {
        LOGISTICS,
        ADMINISTRATION,
        HUMAN_RESOURCES
    }
    public static HashMap<Department, String> DepartmentTranslation = new HashMap<Department, String>();
    
    static {
        DepartmentTranslation.put(Department.LOGISTICS, "Logística");
        DepartmentTranslation.put(Department.ADMINISTRATION, "Administração");
        DepartmentTranslation.put(Department.HUMAN_RESOURCES, "Recursos Humanos");
    } 

    // Private members
    private String DATA_FORMAT = "Funcionário \"%s\":\n - Departamento: %s\n - Salário: %.2fR$";
    private String CLOCKIN_FORMAT = "Funcionário: \"%s\" bateu ponto!";

    private Department departamento;
    private String nome;
    private float salario;


    // Constructor
    public Funcionario(String cpf, Date dataNascimento, String nome, Department departmento, float salario) {
        super(cpf, dataNascimento);
        this.nome = nome;
        this.departamento = departmento;
        this.salario = salario;
    }

    // Methods
    public void mostrarDados() {
        System.out.println(String.format(DATA_FORMAT, this.nome, DepartmentTranslation.get(this.departamento), this.salario));
    }

    public void baterPonto() {
        System.out.println(String.format(CLOCKIN_FORMAT, this.nome));
    }

    // Getters and setters
    public float getSalario() {
        return this.salario;
    }
    public void setSalario(float new_salario) {
        this.salario = new_salario;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String new_nome) {
        this.nome = new_nome;
    }

    public Department getDepartamento() {
        return this.departamento;
    }
    public void setDepartamento(Department new_department) {
        this.departamento = new_department;
    }
}
