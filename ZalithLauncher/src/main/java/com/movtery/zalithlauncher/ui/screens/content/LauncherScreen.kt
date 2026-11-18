// ================================================
// NEORALLY CYBER THEME
// LauncherScreen.kt
// ================================================

// 1. FUNDO PRINCIPAL
// Dentro do BoxWithConstraints, substitua o .background original por:

.background(
    brush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF030711),
            Color(0xFF071729),
            Color(0xFF0A2038),
            Color(0xFF050B16)
        )
    )
)

// ================================================
// 2. PAINEL LATERAL
// Na função ActionMenuContent,
// substitua o modificador .background original por:
.background(
    brush = Brush.linearGradient(
        colors = listOf(
            Color(0xEE10243A),
            Color(0xF5081425),
            Color(0xEE10243A)
        )
    ),
    shape = MaterialTheme.shapes.extraLarge
)
.border(
    width = 1.2.dp,
    brush = Brush.linearGradient(
        colors = listOf(
            Color(0xFF00E5FF),
            Color(0xFF2875C7),
            Color(0xFF00A8FF)
        )
    ),
    shape = MaterialTheme.shapes.extraLarge
)

// ================================================
// 3. SELO NEORALLY
// Substitua a função UnofficialBadge inteira:
@Composable
private fun UnofficialBadge(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .background(
                Color(0xFF0A1929),
                CircleShape
            )
            .border(
                1.dp,
                Color(0xFF00D9FF).copy(alpha = 0.7f),
                CircleShape
            )
            .padding(
                horizontal = 12.dp,
                vertical = 5.dp
            ),
        text = "NEORALLY  •  CYBER EDITION",
        style = MaterialTheme.typography.labelSmall,
        color = Color(0xFF55E5FF),
        maxLines = 1
    )
}

// ================================================
// 4. BOTÃO DE JOGAR
// Em VersionsContent, altere a cor do ícone:
tint = Color(0xFF00D9FF)

// ================================================
// 5. DESTAQUE DO PAINEL
// Em ActionMenuContent, no Brush.radialGradient,
// substitua as cores por:
colors = listOf(
    Color(0x5500D9FF),
    Color(0x22005AFF),
    Color(0x00000000)
)

// ================================================
// 6. CORES DOS ÍCONES
// Use estas cores nos ícones de destaque:
val NeoCyan = Color(0xFF00D9FF)
val NeoBlue = Color(0xFF2875FF)
val NeoDark = Color(0xFF050B16)
val NeoPanel = Color(0xFF10243A)
val NeoWhite = Color(0xFFEAF7FF)