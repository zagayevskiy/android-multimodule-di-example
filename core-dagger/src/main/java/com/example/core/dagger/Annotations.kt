package com.example.core.dagger


import com.example.core.Dependencies
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class DependenciesKey(val value: KClass<out Dependencies>)
