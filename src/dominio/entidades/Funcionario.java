package dominio.entidades;

import java.math.BigDecimal;

public class Funcionario {
    private String nome;
    private Integer horasTrabalhadas;
    private BigDecimal valorPorHora;

    public Funcionario(String nome, Integer horasTrabalhadas, BigDecimal valorPorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    public BigDecimal calcularSalario() {
        return valorPorHora.multiply(new BigDecimal(horasTrabalhadas));
    }
    public String getNome() {
        return nome;
    }

    public Integer getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Integer horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public BigDecimal getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(BigDecimal valorPorHora) {
        this.valorPorHora = valorPorHora;
    }
}
