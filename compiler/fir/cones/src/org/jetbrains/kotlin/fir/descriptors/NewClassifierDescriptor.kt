/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.descriptors

import org.jetbrains.kotlin.fir.UnambiguousFqName
import org.jetbrains.kotlin.fir.types.NewKotlinType


interface NewDescriptor

interface NewClassifierDescriptor : NewDescriptor {

}



interface NewClassifierDescriptorWithTypeParameters : NewClassifierDescriptor {
    val typeParameters: List<NewTypeParameterDescriptor>

    val fqName: UnambiguousFqName
}


interface NewTypeParameterDescriptor : NewClassifierDescriptor {

}

interface NewTypeAliasDescriptor : NewClassifierDescriptorWithTypeParameters {
    val expandedType: NewKotlinType
}


interface NewClassDescriptor : NewClassifierDescriptorWithTypeParameters {
    val superTypes: List<NewKotlinType>
    val nestedClassifiers: List<NewClassifierDescriptor>
}
