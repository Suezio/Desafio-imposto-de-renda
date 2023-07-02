import java.util.Locale;
import java.util.Scanner;

public class CalculadoraImpostoDeRenda {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        double impostoSalario = 0, abatimento = 0;

        System.out.print("Renda anual com salário: ");
        double rendaSalarioAnual = scanner.nextDouble();

        System.out.print("Renda anual com prestação de serviço: ");
        double rendaPrestacaoServicoAnual = scanner.nextDouble();

        System.out.print("Renda anual com ganho de capital: ");
        double rendaGanhoCapitalAnual = scanner.nextDouble();

        System.out.print("Gastos médicos: ");
        double gastosMedicos = scanner.nextDouble();

        System.out.print("Gastos educacionais: ");
        double gastosEducacionais = scanner.nextDouble();

        // Transforma renda anual em mensal
        double rendaSalarioMensal = rendaSalarioAnual / 12;

        // Calcula o imposto sobre o salário
        if (rendaSalarioMensal >= 3000.00 && rendaSalarioMensal <= 5000.00) {
            impostoSalario = rendaSalarioAnual * 0.1;
        } else if (rendaSalarioMensal > 5000.00) {
            impostoSalario = rendaSalarioAnual * 0.2;
        }

        // Calcula o imposto sobre os serviços
        double impostoServico = rendaPrestacaoServicoAnual * 0.15;

        // Calcula o imposto sobre o ganho de capital
        double impostoGanhoCapital = rendaGanhoCapitalAnual * 0.2;

        // Calcula o total dos impostos
        double impostoTotal = impostoSalario + impostoServico + impostoGanhoCapital;

        // Calcula o máximo dedutível
        double maximoDedutivel = impostoTotal * 0.3;

        // Calcula os gastos dedutíveis
        double gastosDedutiveis = gastosMedicos + gastosEducacionais;

        // Verifica se os gastos dedutíveis são menores que o máximo dedutível
        if (gastosDedutiveis < maximoDedutivel) {
            abatimento = gastosDedutiveis;
        }  else abatimento = maximoDedutivel;

        // Calcula o imposto devido
        double impostoDevido = impostoTotal - abatimento;

        // Imprime o relatório de imposto de renda
        System.out.println("\nRELATÓRIO DE IMPOSTO DE RENDA");
        System.out.println("\nCONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: %.2f\n", impostoSalario);
        System.out.printf("Imposto sobre serviços: %.2f\n", impostoServico);
        System.out.printf("Imposto sobre ganho de capital: %.2f\n", impostoGanhoCapital);
        System.out.println("\nDEDUÇÕES:");
        System.out.printf("Máximo dedutível: %.2f\n", maximoDedutivel);
        System.out.printf("Gastos dedutíveis: %.2f\n", gastosDedutiveis);
        System.out.println("\nRESUMO:");
        System.out.printf("Imposto bruto total: %.2f\n", impostoTotal);
        System.out.printf("Abatimento: %.2f\n", abatimento);
        System.out.printf("Imposto devido: %.2f\n", impostoDevido);

        scanner.close();
    }

}
