package dagger2

import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(modules = [CoffeeModule::class])
interface CoffeeComponent {

    fun getCoffee(): Coffee

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun sugar(@Named("sugar") sugar: Int): Builder

        @BindsInstance
        fun milk(@Named("milk") milk: Int): Builder

        fun build(): CoffeeComponent
    }
}