
/*
 * Zalith Launcher 2
 * Copyright (C) 2025-2026 MovTery and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License.
 * This modified version is unofficial.
 */

package com.movtery.zalithlauncher.ui.screens.content.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.movtery.cardgrid.model.CardLimits
import com.movtery.cardgrid.model.CardType
import com.movtery.zalithlauncher.BuildConfig
import com.movtery.zalithlauncher.BuildKeys
import com.movtery.zalithlauncher.R
import com.movtery.zalithlauncher.ui.screens.content.home.server.ServerCardContent
import com.movtery.zalithlauncher.ui.screens.content.home.version.VersionCardContent

class SystemCard(val id: String, val content: @Composable () -> Unit)

val CardIconShape = RoundedCornerShape(percent = 28)

private val PremiumShape = RoundedCornerShape(22.dp)

private val PremiumBackground = Brush.verticalGradient(
    colors = listOf(
        Color(0xFF211333),
        Color(0xFF130D20),
        Color(0xFF0D0A16)
    )
)

private val PremiumBorder = Brush.linearGradient(
    colors = listOf(
        Color(0xFFBD78FF),
        Color(0x66FF55CE),
        Color(0x337B35FF)
    )
)

object HomeCards {

    const val VERSION_CARD_TYPE_ID = "version_card"
    const val SERVER_CARD_TYPE_ID = "server_card"

    private val versionCardType = CardType(
        typeId = VERSION_CARD_TYPE_ID,
        defaultSpan = IntOffset(10, 6),
        limits = CardLimits(
            minWidth = 10,
            minHeight = 4,
            maxHeight = 12
        ),
        content = { cardId ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(PremiumShape)
                    .background(PremiumBackground)
                    .border(1.dp, PremiumBorder, PremiumShape)
            ) {
                VersionCardContent(cardId)
            }
        }
    )

    private val serverCardType = CardType(
        typeId = SERVER_CARD_TYPE_ID,
        defaultSpan = IntOffset(10, 6),
        limits = CardLimits(
            minWidth = 10,
            minHeight = 4,
            maxHeight = 12
        ),
        content = { cardId ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(PremiumShape)
                    .background(PremiumBackground)
                    .border(1.dp, PremiumBorder, PremiumShape)
            ) {
                ServerCardContent(cardId)
            }
        }
    )

    fun versionCardType(): CardType = versionCardType

    fun serverCardType(): CardType = serverCardType

    val userCardTypes: List<CardType> =
        listOf(versionCardType, serverCardType)

    fun systemCards(): List<SystemCard> = buildList {
        if (BuildConfig.DEBUG) {
            add(debugWarningCard())
        }
    }

    private fun debugWarningCard() =
        SystemCard(id = "system_debug_warning") {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(PremiumShape)
                    .background(PremiumBackground)
                    .border(1.dp, PremiumBorder, PremiumShape)
                    .padding(18.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.generic_warning),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFFD8A7FF)
                    )

                    Text(
                        text = stringResource(
                            R.string.launcher_version_debug_warning,
                            BuildKeys.LAUNCHER_NAME
                        ),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFFE9DDF5)
                    )

                    Text(
                        modifier = Modifier
                            .alpha(0.75f)
                            .align(Alignment.End),
                        text = stringResource(
                            R.string.launcher_version_debug_warning_cant_close
                        ),
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFFFF8EDB)
                    )
                }
            }
        }
}
