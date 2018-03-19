/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.descriptors

import org.jetbrains.kotlin.fir.UnambiguousFqName
import org.jetbrains.kotlin.fir.declarations.FirResolvedClass
import org.jetbrains.kotlin.fir.descriptors.NewClassDescriptor
import org.jetbrains.kotlin.fir.descriptors.NewClassifierDescriptor
import org.jetbrains.kotlin.fir.descriptors.NewTypeParameterDescriptor
import org.jetbrains.kotlin.fir.types.NewKotlinType

class NewClassDescriptorImpl(
    override val typeParameters: List<NewTypeParameterDescriptor>,
    override val fqName: UnambiguousFqName,
    override val superTypes: List<NewKotlinType>,
    override val nestedClassifiers: List<NewClassifierDescriptor>
) : NewClassDescriptor, AbstractFirBasedDescriptor<FirResolvedClass>() {
}