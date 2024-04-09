package hhplusw3.ecommerce;

import hhplusw3.ecommerce.api.user.useCase.GetUserUseCase;
import hhplusw3.ecommerce.domain.component.UserModifier;
import hhplusw3.ecommerce.domain.component.UserReader;
import hhplusw3.ecommerce.domain.reository.UserRepository;
import hhplusw3.ecommerce.infrastructure.UserRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public GetUserUseCase getUserUseCase() {
        return new GetUserUseCase(this.userReader(), this.userModifier());
    }

    @Bean
    public UserReader userReader() {
        return new UserReader(this.userRepository());
    }

    @Bean
    public UserModifier userModifier() {
        return new UserModifier(this.userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryJpa();
    }
}
