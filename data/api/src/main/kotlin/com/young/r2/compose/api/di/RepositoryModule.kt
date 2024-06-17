package com.young.r2.compose.api.di

import com.young.r2.compose.data.repositoryImpl.BarcodeRepositoryImpl
import com.young.r2.compose.data.repositoryImpl.ProductRepositoryImpl
import com.young.r2.compose.repository.BarcodeRepository
import com.young.r2.compose.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class) //TODO: @Bind인 경우에도 ViewModelComponent로 사용해도 상관없을까..?
internal abstract class RepositoryModule {

    @ViewModelScoped
    @Binds
    abstract fun bindProductRepository(
        repository: ProductRepositoryImpl
    ): ProductRepository

    @ViewModelScoped
    @Binds
    abstract fun bindBarcodeRepository(
        repository: BarcodeRepositoryImpl
    ): BarcodeRepository
}