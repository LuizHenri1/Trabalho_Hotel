public abstract class Pessoas implements Pessoa {
    protected String nome;
    protected String cpf;
    protected String endereco;
    protected String telefone;

    public Pessoas(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public void validarCPF() throws ValidacaoException {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new ValidacaoException("CPF inválido. Deve conter exatamente 11 dígitos numéricos.");
        }
    }

    @Override
    public boolean validar() throws ValidacaoException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ValidacaoException("Nome não pode ser vazio");
        }
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new ValidacaoException("Endereço não pode ser vazio");
        }
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new ValidacaoException("Telefone não pode ser vazio");
        }
        validarCPF();
        return true;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}