package com.mukha.smartmoney.config

import com.mukha.smartmoney.repository.UserRepository
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
@EnableCaching
class WebSecurityConfig {

    private val whitelist: List<String> = listOf(
        "/",
        "/login",
        "/register",
        "/swagger-ui/**",
        "/v3/api-docs/**",
        "/swagger-resources/**",
        "/swagger-resources"
    )

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity, customUserDetailsService: CustomUserDetailsService): SecurityFilterChain {
        http
            .csrf().disable()
            .cors().disable()
            .authorizeHttpRequests { requests ->
                requests
                    .requestMatchers(*whitelist.toTypedArray()).permitAll()
                    .requestMatchers(HttpMethod.POST,"/users").permitAll()
                    .requestMatchers(HttpMethod.GET, "/accounts", "/debts", "/loans", "/regular-payments", "/reminders", "/transactions", "/users").hasRole("ADMIN")
                    .anyRequest().authenticated()
            }
//            .httpBasic {  }
            .formLogin { form: FormLoginConfigurer<HttpSecurity?> ->
                form
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
            }
            .logout { logout ->
                logout
                    .logoutSuccessUrl("/login?logout=true")
                    .permitAll()
            }
            .userDetailsService(customUserDetailsService)

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

//    @Bean
//    fun userDetailsService(userRepository: UserRepository): UserDetailsService {
//        return CustomUserDetailsService(userRepository, passwordEncoder)
//    }

//    @Bean
//    fun userDetailsService(): UserDetailsService {
//        val users: User.UserBuilder = User.withDefaultPasswordEncoder()
//        val manager = InMemoryUserDetailsManager()
//        manager.createUser(users.username("user").password("password").roles("USER").build())
//        return manager
//    }

}