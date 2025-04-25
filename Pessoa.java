import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {
    // Private members
    private String cpf;
    private Date dataNascimento;

    public Pessoa(String cpf, Date dataNascimento) {
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    // Getters and setters
    public String getCpf() {
        return this.cpf;
    }
    public void setCpf(String new_cpf) {
        this.cpf = new_cpf;
    }

    public String getdataNascimento() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(this.dataNascimento);
    }
    public void setdataNascimento(Date new_dataNascimento) {
        this.dataNascimento = new_dataNascimento;
    }
}
