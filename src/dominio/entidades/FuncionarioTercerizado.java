package dominio.entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FuncionarioTercerizado extends Funcionario {
    private BigDecimal despesasAdicionais;

    public FuncionarioTercerizado(String nome, Integer horasTrabalhadas, BigDecimal valorPorHora, BigDecimal despesasAdicionais) {
        super(nome, horasTrabalhadas, valorPorHora);
        this.despesasAdicionais = despesasAdicionais;
    }

    @Override
    public BigDecimal calcularSalario() {
        BigDecimal bonos = despesasAdicionais.multiply(new BigDecimal(1.1)).setScale(2, RoundingMode.HALF_EVEN);
        return super.calcularSalario().add(bonos);
    }

    public BigDecimal getDespesasAdicionais() {
        return despesasAdicionais;
    }

    public void setDespesasAdicionais(BigDecimal despesasAdicionais) {
        this.despesasAdicionais = despesasAdicionais;
    }
}
