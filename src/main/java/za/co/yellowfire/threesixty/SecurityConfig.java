package za.co.yellowfire.threesixty;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

/**
 * @author Mark P Ashworth
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");
        return repository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**", "/css/**", "/img/*", "/js/*", "/js/**", "/static/css/**").permitAll()
                .anyRequest().fullyAuthenticated().and()
                .formLogin()
                .loginPage("/login").failureUrl("/login?error").permitAll().and()
                .logout().permitAll();

        http.csrf().csrfTokenRepository(csrfTokenRepository());
    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        ActiveDirectoryLdapAuthenticationProvider provider =
//                new ActiveDirectoryLdapAuthenticationProvider(
//                        "jse.co.za",
//                        "ldap://VYDCADS01/");
//
//        provider.setUserDetailsContextMapper(
//                new ExtendedLdapUserDetailsMapper(
//                        lendingPartyUserRepository,
//                        lendingPartyRepository,
//                        userPermissionRepository));
//
//        /* Configure the Active Directory authentication virtual */
//        auth.authenticationProvider(provider);
//    }
}
