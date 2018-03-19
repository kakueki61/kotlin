/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.types

import org.jetbrains.kotlin.fir.UnambiguousFqName

interface NewKotlinType : NewKotlinTypeProjection {
    override val kind: ProjectionKind
        get() = ProjectionKind.INVARIANT
    val typeArguments: List<NewKotlinTypeProjection>
}

interface NewClassType : NewKotlinType {
    val fqName: UnambiguousFqName
}

interface NewKotlinTypeProjection {
    val kind: ProjectionKind
}

enum class ProjectionKind {
    STAR, IN, OUT, INVARIANT
}


object StarProjection : NewKotlinTypeProjection {
    override val kind: ProjectionKind
        get() = ProjectionKind.STAR
}

interface NewKotlinTypeProjectionIn : NewKotlinTypeProjection {
    val type: NewKotlinType

    override val kind: ProjectionKind
        get() = ProjectionKind.IN
}

interface NewKotlinTypeProjectionOut : NewKotlinTypeProjection {
    val type: NewKotlinType

    override val kind: ProjectionKind
        get() = ProjectionKind.OUT
}


