/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.resolve

import org.jetbrains.kotlin.fir.types.*

class FirTypeResolverImpl : FirTypeResolver {
    override fun resolveType(type: FirType): NewKotlinType {
        return when (type) {
            is FirResolvedType -> type.type
            is FirUserType -> {
                val qualifierResolver = FirQualifierResolver.getInstance(type.session)
                // TODO: Imports
                qualifierResolver.resolveType(type.qualifier) ?: NewKotlinErrorType("Failed to resolve qualified type")
            }
            is FirErrorType -> {
                NewKotlinErrorType(type.reason)
            }
            is FirFunctionType, is FirDynamicType, is FirImplicitType, is FirDelegatedType -> {
                NewKotlinErrorType("Not supported: $type")
            }
            else -> error("!")
        }
    }
}