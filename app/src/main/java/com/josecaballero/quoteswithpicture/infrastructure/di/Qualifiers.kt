package com.josecaballero.quoteswithpicture.infrastructure.di

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class QuotableRetrofitQualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class PexelsRetrofitQualifier
