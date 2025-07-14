package br.com.ifba.atividade16;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.ifba.atividade16.view.CursoListar;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class Atividade16Application {

	public static void main(String[] args) {
        ConfigurableApplicationContext context =
            new SpringApplicationBuilder(Atividade16Application.class)
                .headless(false).run(args);

        CursoListar telaCursoSave = context.getBean(CursoListar.class);
        telaCursoSave.setVisible(true);
    }

}
