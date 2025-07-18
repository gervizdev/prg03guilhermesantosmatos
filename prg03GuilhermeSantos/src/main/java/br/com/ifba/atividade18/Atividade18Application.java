package br.com.ifba.atividade18;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.ifba.atividade18.view.*;
import java.util.Collections;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class Atividade18Application {

	public static void main(String[] args) {
        ConfigurableApplicationContext context =
            new SpringApplicationBuilder(Atividade18Application.class)
                .headless(false)
                .properties(Collections.singletonMap("spring.application.name", Atividade18Application.class.getSimpleName()
                ))
                .run(args);

        CursoListar telaCursoListar = context.getBean(CursoListar.class);
        AlunoListar telaAlunoListar = context.getBean(AlunoListar.class);
        telaCursoListar.atualizarTabela();
        telaAlunoListar.atualizarTabela();
        HomeForm telaInicial = context.getBean(HomeForm.class);
        telaInicial.setVisible(true);
    }

}
