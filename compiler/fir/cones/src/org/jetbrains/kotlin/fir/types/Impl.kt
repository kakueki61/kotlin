/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.types

import org.jetbrains.kotlin.fir.UnambiguousFqName

class NewClassTypeImpl(
    override val fqName: UnambiguousFqName,
    override val typeArguments: List<NewKotlinTypeProjection>
) : NewClassType {

}


class NewKotlinErrorType(val reason: String) : NewKotlinType {
    override val typeArguments: List<NewKotlinTypeProjection>
        get() = emptyList()

    override fun toString(): String {
        return "<ERROR TYPE: $reason>"
    }
}