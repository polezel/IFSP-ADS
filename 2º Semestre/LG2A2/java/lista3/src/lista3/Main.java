package lista3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Servicos
        Servico servico1 = new Servico(12345, "Troca de Pneu", 150.0);
        Servico servico2 = new Servico(12346, "Troca de ?leo", 567.15);
        Servico servico3 = new Servico(12347, "Martelinho de ouro", 1200.00);

        //CLientes
        Cliente cliente1 = new Cliente("111.111.111-11", "Lucas", "(11)1111-1111");
        Cliente cliente2 = new Cliente("222.222.222-22", "Matheus", "(22)2222-2222");
        Cliente cliente3 = new Cliente("333.333.333-33", "Marcelo", "(33)3333-3333");

        //Mecanicos
        Mecanico mecanico1 = new Mecanico("444.444.444-44", "Augusto", "trocar pneu rapidamente");
        Mecanico mecanico2 = new Mecanico("555.555.555-55", "Giovani", "troca ?leo como ningu?m antes");
        Mecanico mecanico3 = new Mecanico("666.666.666-66", "Carlos Bife", "desamassa carro no soco");

        //OrdensDeServico
        OrdemDeServico os1 = new OrdemDeServico(111, cliente1);
        os1.adicionaServico(servico1);
        os1.adicionaServico(servico2);

        os1.adicionaMecanico(mecanico1);
        os1.adicionaMecanico(mecanico2);

        OrdemDeServico os2 = new OrdemDeServico(222, cliente2);
        os2.adicionaServico(servico1);
        os2.adicionaServico(servico3);

        os2.adicionaMecanico(mecanico1);
        os2.adicionaMecanico(mecanico3);

        OrdemDeServico os3 = new OrdemDeServico(333, cliente3);
        os3.adicionaServico(servico2);
        os3.adicionaServico(servico3);

        os3.adicionaMecanico(mecanico2);
        os3.adicionaMecanico(mecanico3);

        OrdemDeServico os4 = new OrdemDeServico(444, cliente3);
        os4.adicionaServico(servico1);
        os4.adicionaServico(servico2);
        os4.adicionaServico(servico3);

        os4.adicionaMecanico(mecanico1);
        os4.adicionaMecanico(mecanico2);
        os4.adicionaMecanico(mecanico3);

        //Oficina
        Oficina oficina = new Oficina();
        oficina.adicionaOS(os1);
        oficina.adicionaOS(os2);
        oficina.adicionaOS(os3);
        oficina.adicionaOS(os4);

        //Busca uma ordem de servico pelo codigo e imprime o valor total
        System.out.println("Valor da ordem de Servi?o de c?digo 444: " + oficina.buscaOSCodigo(444).calculaValorTotal());

        //Busca ordens de servico pelo CPF na oficina
        System.out.println("Ordens de servi?o em que o Mec?nico de CPF 666.666.666-66 trabalhou: ");
        List<OrdemDeServico> os_carlos = oficina.buscasOSCPF("666.666.666-66");

        for(OrdemDeServico os: os_carlos){
            System.out.println(os);
        }

        //Busca ordens de servico pelo servico na oficina
        System.out.println("Ordens de servico que possuem o servico3");
        List<OrdemDeServico> os_servico3 = oficina.buscaOSServico(12347);

        for(OrdemDeServico os: os_servico3){
            System.out.println(os);
        }

        //Faturamento total da oficina:
        System.out.println("Faturamento total da Oficina: " + oficina.calculaFaturamentoTotal());
    }
}