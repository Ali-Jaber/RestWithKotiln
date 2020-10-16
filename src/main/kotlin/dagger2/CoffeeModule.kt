package dagger2

import dagger.Module
import dagger.Provides

@Module
class CoffeeModule() {

    @Provides
    fun providerRiver(): River = River()
}