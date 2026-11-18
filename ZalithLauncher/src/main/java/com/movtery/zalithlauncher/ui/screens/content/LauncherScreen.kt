import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ==========================================
// PALETA DE CORES CRYOGENIC UI (PREMIUM)
// ==========================================
val BgTop = Color(0xFF1A0B2E)
val BgBottom = Color(0xFF090410)
val GlassSurface = Color(0x33FFFFFF) // Branco com 20% de opacidade
val GlassBorder = Color(0x4DFFFFFF) // Branco com 30% de opacidade
val NeonPink = Color(0xFFE07AF7)
val NeonPurple = Color(0xFF9C4DF4)
val NeonCyan = Color(0xFF7FDBFF)
val TextPrimary = Color(0xFFFFFFFF)
val TextSecondary = Color(0xFFB0A8B9)
val WarningRed = Color(0xFFFF6B6B)

@Composable
fun CryogenicPremiumUI() {
    // Fundo principal com gradiente profundo
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = listOf(BgTop, BgBottom)))
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            
            // 1. TOP BAR (Header Premium)
            CryogenicTopBar()
            
            Spacer(modifier = Modifier.height(24.dp))

            // 2. CONTEÚDO PRINCIPAL (Dividido em Row)
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                
                // COLUNA ESQUERDA (Aviso e Info)
                Column(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    
                    // AVISO DE TESTE (Glassmorphism Card)
                    GlassCard(
                        modifier = Modifier.fillMaxWidth(),
                        borderColor = WarningRed.copy(alpha = 0.5f)
                    ) {
                        Column(modifier = Modifier.padding(20.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Warning, contentDescription = null, tint = WarningRed)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Aviso de Desenvolvimento", color = WarningRed, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                "Você está usando uma versão de testes do Cryogenic Launcher! Esta versão não tem garantia de ser estável no longo prazo. Se você encontrar algum problema, crie uma nova Issue no GitHub.",
                                color = TextSecondary,
                                fontSize = 14.sp,
                                lineHeight = 22.sp
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomEnd) {
                                Text(
                                    "ESTE AVISO NÃO PODE SER IGNORADO",
                                    color = WarningRed.copy(alpha = 0.8f),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 1.sp
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.weight(1f)) // Empurra o badge para baixo

                    // BADGE NEORALLY (Embaixo à esquerda)
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(NeonCyan.copy(alpha = 0.1f))
                            .border(1.dp, NeonCyan.copy(alpha = 0.5f), RoundedCornerShape(20.dp))
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(
                            "Neorally Launcher · versão não oficial modificada do Zalith Launcher 2",
                            color = NeonCyan,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                // COLUNA DIREITA (Painel do Jogador)
                Column(
                    modifier = Modifier.width(280.dp).fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    
                    // CARD DO JOGADOR (Skin 3D)
                    GlassCard(
                        modifier = Modifier.weight(1f).fillMaxWidth(),
                        borderColor = NeonPink.copy(alpha = 0.4f)
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            // AQUI ENTRA O SEU COMPONENTE DE SKIN 3D (PetModelView)
                            // Exemplo de placeholder:
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    Icons.Default.Person, 
                                    contentDescription = "Skin", 
                                    modifier = Modifier.size(80.dp), 
                                    tint = GlassBorder
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text("Player 3D View", color = TextSecondary, fontSize = 12.sp)
                            }
                        }
                    }

                    // PAINEL INFERIOR (Botões de Ação)
                    GlassCard(
                        modifier = Modifier.fillMaxWidth(),
                        borderColor = GlassBorder
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            // Botão Adicionar Conta
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .clickable { /* Ação */ }
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(Icons.Default.Add, contentDescription = null, tint = NeonPink)
                                Spacer(modifier = Modifier.width(12.dp))
                                Text("Adicionar Conta", color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                            }
                            
                            Divider(color = GlassBorder, thickness = 1.dp)

                            // Botão Versões (Alerta)
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .clickable { /* Ação */ }
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    "Nenhuma versão instalada", 
                                    color = TextPrimary, 
                                    fontWeight = FontWeight.Bold, 
                                    fontSize = 14.sp
                                )
                                Icon(Icons.Default.ArrowForwardIos, contentDescription = null, tint = NeonPink, modifier = Modifier.size(14.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

// ==========================================
// COMPONENTES REUTILIZÁVEIS
// ==========================================

@Composable
fun CryogenicTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth().height(60.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Logo Título
        Text(
            text = "Cryogenic",
            color = TextPrimary,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 1.sp
        )

        // Ícones à direita
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp), verticalAlignment = Alignment.CenterVertically) {
            TopBarIcon(Icons.Default.Menu)
            TopBarIcon(Icons.Default.People)
            TopBarIcon(Icons.Default.Download)
            TopBarIcon(Icons.Default.Settings)
        }
    }
}

@Composable
fun TopBarIcon(icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = TextSecondary,
        modifier = Modifier
            .size(28.dp)
            .clickable { /* Ação */ }
    )
}

// COMPONENTE DE CARD COM EFEITO DE VIDRO (GLASSMORPHISM)
@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    borderColor: Color = GlassBorder,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(24.dp),
                ambientColor = NeonPurple.copy(alpha = 0.2f),
                spotColor = NeonPurple.copy(alpha = 0.2f)
            )
            .clip(RoundedCornerShape(24.dp))
            .background(
                // Efeito de gradiente sutil no fundo do vidro
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0x22FFFFFF),
                        Color(0x05FFFFFF)
                    )
                )
            )
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(
                    colors = listOf(borderColor, borderColor.copy(alpha = 0.1f))
                ),
                shape = RoundedCornerShape(24.dp)
            )
    ) {
        content()
    }
}