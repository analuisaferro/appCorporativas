public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, CorsConfigurationSource corsConfigurationSource)
            throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .csrf(csrf -> csrf.disable()) // IMPORTANTE: Desabilita CSRF para APIs
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/auth/**")
                        .permitAll()
                        .anyRequest().authenticated())
                // SE Não Fosse restful.oauth2Login(oauth -> oauth.loginPage("/login"))

                .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()));
        // .logout(logout -> logout.logoutSuccessUrl("/").permitAll());

        return http.build();
    }
}