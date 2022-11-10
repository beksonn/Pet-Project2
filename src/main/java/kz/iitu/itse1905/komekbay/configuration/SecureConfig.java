package kz.iitu.itse1905.komekbay.configuration;

import kz.iitu.itse1905.komekbay.security.EntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class SecureConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;
    private EntryPoint entryPoint;

    @Autowired
    public SecureConfig(DataSource dataSource, EntryPoint entryPoint) {
        this.dataSource = dataSource;
        this.entryPoint = entryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/**").hasRole("ADMIN")
                .and().formLogin()
                .and()
                .httpBasic()
                .authenticationEntryPoint(entryPoint)
                .and().logout().deleteCookies("JSESSIONID")
                .and().rememberMe().rememberMeParameter("remember-me-new")
                .and().cors()
                .and().csrf().disable();
        http.headers().xssProtection();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
       // http.oauth2ResourceServer().jwt();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception
    {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from admin where username=?")
                .authoritiesByUsernameQuery(
                        "select username,role from admin where username=?");
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
