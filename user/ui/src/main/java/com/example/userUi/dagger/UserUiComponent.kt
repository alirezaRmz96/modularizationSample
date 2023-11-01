package com.example.userUi.dagger

import com.example.user.domainpovider.UserComponent
import com.example.userDomain.UserRepository
import com.example.userUi.UserFragment
import com.example.userUi.UserInjector
import dagger.Component

@UserUiScope
@Component(
    modules = [UserViewModelModule::class],
    dependencies = [UserComponent::class]
)
interface UserUiComponent : UserInjector {




    @Component.Factory
    interface Factory {
        fun create(
            userComponent: UserComponent
        ): UserUiComponent
    }
}