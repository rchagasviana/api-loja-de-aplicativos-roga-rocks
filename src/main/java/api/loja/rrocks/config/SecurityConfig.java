package api.loja.rrocks.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Configuração para liberar o h2
    @Autowired
    private Environment env;

    //Armazena a lista de caminhos que são públicos dentro da aplicação
    private static final String[] LISTA_URLS_PUBLICAS = {
            "/h2-console/*"
    };

    private static final String[] LISTA_URLS_PUBLICAS_GET = {
            "/categorias/*",
            "/estados/*",
            "/cidades/*",
            "/aplicativos/*"
    };

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //Configuração para liberar o H2 e os perfis que desejarmos
        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }
        http.cors().and().csrf().disable(); //implementação pra desabilitar o CSRF //Opcional
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, LISTA_URLS_PUBLICAS_GET).permitAll()//só libera o get nas seguintes rotas
                .antMatchers(LISTA_URLS_PUBLICAS).permitAll()
                .anyRequest().authenticated();//Para todas as outras requisições autenticação é exigida
        //Opcional
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //garante que a API não vai criar sessão
    }

    //Método utilizado para permitir requisições de múltiplas fontes (desabilita o CSRF)
    /*
     * Como API não usa sessão, então ataques CSRF não são preocupações
     *
     * */
    //Opcional
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

}
