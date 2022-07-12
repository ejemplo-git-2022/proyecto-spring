package edu.curso.java.spring.proyectospring;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import edu.curso.java.spring.proyectospring.bo.CategoriaProducto;
import edu.curso.java.spring.proyectospring.mvc.ProductosController;
import edu.curso.java.spring.proyectospring.service.ProductoService;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableCaching
public class ProyectoSpringApplication extends SpringBootServletInitializer implements CommandLineRunner  {

	private static  Logger log = LoggerFactory.getLogger(ProyectoSpringApplication.class);

	@Autowired
	private ProductoService productoService;
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ProyectoSpringApplication.class);
    }
    
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(5);
        //other proeprties to be set here
        executor.setThreadNamePrefix("ASYNC-");
        executor.initialize();
        System.out.println("Listo cargo el taskExecutor");
        return executor;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(ProyectoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Cargando la app de consola......");
		for (String parametro : args) {
			log.info("Parametro: " + parametro);
		}
		
		if(args.length >= 3) {
			if(args[0].equals("alta")) {
				if(args[1].equals("categoria")) {
					log.info("Dando de alta una categoria por consola: " + args[2]);
					CategoriaProducto categoriaProducto = new CategoriaProducto();
					categoriaProducto.setNombre(args[2]);
					productoService.guardarNuevaCategoria(categoriaProducto);
				}
			}
		}
		
	}

}
