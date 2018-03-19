/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.resolve

import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.UnambiguousFqName
import org.jetbrains.kotlin.fir.types.*
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.types.Variance

class FirQualifierResolverImpl(val session: FirSession) : FirQualifierResolver {
    override fun resolveType(parts: List<FirQualifierPart>): NewKotlinType? {
        val firProvider = FirProvider.getInstance(session)

        if (parts.isNotEmpty()) {
            val lastPart = mutableListOf<FirQualifierPart>()
            val firstPart = parts.toMutableList()

            while (firstPart.isNotEmpty()) {
                lastPart.add(0, firstPart.last())
                firstPart.removeAt(firstPart.lastIndex)

                val fqName = UnambiguousFqName(firstPart.toFqNameUnsafe(), lastPart.toFqName())
                val foundClassifier = firProvider.getFirClassifierByFqName(fqName)

                if (foundClassifier != null) {
                    return NewClassTypeImpl(fqName, parts.flatMap {
                        it.typeArguments.map {
                            when (it) {
                                is FirStarProjection -> StarProjection
                                is FirTypeProjectionWithVariance -> {
                                    val type = (it.type as FirResolvedType).type
                                    when (it.variance) {
                                        Variance.INVARIANT -> type
                                        Variance.IN_VARIANCE -> NewKotlinTypeProjectionInImpl(type)
                                        Variance.OUT_VARIANCE -> NewKotlinTypeProjectionOutImpl(type)
                                    }
                                }
                                else -> error("!")
                            }
                        }
                    })
                }
            }
            return null
        } else {
            return null
        }
    }

    private fun List<FirQualifierPart>.toFqNameUnsafe() = toFqName().toUnsafe()
    private fun List<FirQualifierPart>.toFqName() = fold(FqName.ROOT) { a, b -> a.child(b.name) }


}