package br.com.ifba.atividade17;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.ifba.atividade17.view.CursoListar;
import java.util.Collections;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class Atividade17Application {

	public static void main(String[] args) {
        ConfigurableApplicationContext context =
            new SpringApplicationBuilder(Atividade17Application.class)
                .headless(false)
                .properties(Collections.singletonMap(
                  "spring.application.name", Atividade17Application.class.getSimpleName()
                ))
                .run(args);

        CursoListar telaCursoSave = context.getBean(CursoListar.class);
        telaCursoSave.atualizarTabela();
        telaCursoSave.setVisible(true);
    }

}
