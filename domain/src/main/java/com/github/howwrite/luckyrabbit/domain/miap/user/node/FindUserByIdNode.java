package com.github.howwrite.luckyrabbit.domain.miap.user.node;


import com.github.howwrite.luckyrabbit.domain.miap.user.context.FindUserByIdContext;
import com.github.howwrite.luckyrabbit.domain.miap.user.model.User;
import com.github.howwrite.luckyrabbit.domain.miap.user.repository.UserRepository;
import com.github.howwrite.miap.def.MiapBook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FindUserByIdNode implements MiapBook<FindUserByIdContext> {
    private final UserRepository userRepository;

    @Override
    public void execute(FindUserByIdContext context) {
        User user = userRepository.findUser(context.getUserQuery());
        context.setUser(user);
    }
}

