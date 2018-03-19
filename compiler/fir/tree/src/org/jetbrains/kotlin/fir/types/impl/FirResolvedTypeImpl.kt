/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.types.impl

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.expressions.FirAnnotationCall
import org.jetbrains.kotlin.fir.types.FirResolvedType
import org.jetbrains.kotlin.fir.types.NewKotlinType

class FirResolvedTypeImpl(
    override val session: FirSession,
    override val psi: PsiElement?,
    override val type: NewKotlinType,
    override val isNullable: Boolean,
    override val annotations: List<FirAnnotationCall>
) : FirResolvedType {

}