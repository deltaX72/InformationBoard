package com.deltax72.informationboard.di.annotations

import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Scope
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Scope
@MustBeDocumented
annotation class ActivityScope

@Scope
@MustBeDocumented
annotation class FragmentScope