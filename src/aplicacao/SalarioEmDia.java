package aplicacao;

import dominio.entidades.Funcionario;
import dominio.entidades.FuncionarioTercerizado;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalarioEmDia {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static Funcionario funcionario;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Este programa lhe ajudará a ficar em dia com o pagamento dos seus funcionários!");
        int numeroDeFuncionariosAAdicionar = Integer.parseInt(obterDados("Quantos funcionários deseja adicionar?"));
        adicionarFuncionarios(numeroDeFuncionariosAAdicionar);
        imprimirPagamentos();
    }

    private static void imprimirPagamentos() {
        System.out.println("Pagamentos:");
        for (Funcionario funcionario:funcionarios) {
            System.out.println(funcionario.getNome()+" - "+funcionario.calcularSalario());
        }
    }

    private static void adicionarFuncionarios(int numeroDeFuncionariosAAdicionar) {
        for (int i = 1; i <= numeroDeFuncionariosAAdicionar; i++) {
            System.out.println("Entre com os dados do " + i + "O funcionário");
            String nome = obterDados("Nome:");
            char tercerizadoOuNao = obterDados("Este funcionário é tercerizado?").charAt(0);
            Integer horasTrabalhadas = Integer.valueOf(obterDados("Quantas horas este funcionário trabalhou?"));
            BigDecimal valorPorHora = new BigDecimal(obterDados("Qual o valor por hora?")).setScale(2, RoundingMode.HALF_EVEN);
            if (tercerizadoOuNao == 's') {
                BigDecimal despesasAdicionais = new BigDecimal(obterDados("Despesas adicionais:")).setScale(2, RoundingMode.HALF_EVEN);
                funcionario = new FuncionarioTercerizado(nome, horasTrabalhadas, valorPorHora, despesasAdicionais);
            } else {
                funcionario = new Funcionario(nome, horasTrabalhadas, valorPorHora);
            }
            funcionarios.add(funcionario);
            System.out.println("Funcionário adicionado com sucesso!");
        }
    }

    private static String obterDados(String mensagemAoUsuario) {
        System.out.println(mensagemAoUsuario);
        return scanner.nextLine();
    }

}
