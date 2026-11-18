import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CryogenicLauncherUI()
            }
        }
    }
}

// Cores baseadas na imagem
val BgDarkPurple = Color(0xFF0D0714)
val CardPurple = Color(0xFF22132E)
val NeonPink = Color(0xFFE07AF7)
val NeonBlue = Color(0xFF7FDBFF)
val TextGray = Color(0xFFA89FAB)

@Composable
fun CryogenicLauncherUI() {
    // Simulando o fundo com a arte de anime
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFF2A0D45), Color(0xFF0D0714), Color(0xFF1A0B2E))
                )
            )
    ) {
        // Aqui você colocaria a imagem de fundo real: 
        // Image(painter = painterResource(id = R.drawable.seu_fundo), contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // SIDEBAR ESQUERDA
            Sidebar(modifier = Modifier.width(220.dp).fillMaxHeight())

            // CONTEÚDO PRINCIPAL
            Column(modifier = Modifier.weight(1f).fillMaxHeight()) {
                TopBar()
                Spacer(modifier = Modifier.height(16.dp))
                MainContent()
            }

            // SIDEBAR DIREITA (VERSÃO E JOGAR)
            RightPanel(modifier = Modifier.width(260.dp).fillMaxHeight())
        }
    }
}

@Composable
fun Sidebar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0x88000000))
            .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(24.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Logo e Título
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 16.dp)) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Brush.linearGradient(listOf(NeonBlue, NeonPink)))
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text("Cryogenic", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("LAUNCHE r1.6.0", color = TextGray, fontSize = 10.sp)
            }
        }

        // Menu Items
        MenuItem("Início", Icons.Default.Home, isSelected = true)
        MenuItem("Versões", Icons.Default.List, isSelected = false)
        MenuItem("Download", Icons.Default.ArrowDropDown, isSelected = false)
        MenuItem("Contas", Icons.Default.Person, isSelected = false)
        MenuItem("Configs", Icons.Default.Settings, isSelected = false)
        
        Spacer(modifier = Modifier.weight(1f))
        
        MenuItem("WebPage", Icons.Default.Language, isSelected = false)
        MenuItem("Doação", Icons.Default.Favorite, isSelected = false)
    }
}

@Composable
fun MenuItem(text: String, icon: ImageVector, isSelected: Boolean) {
    val bgBrush = if (isSelected) {
        Brush.horizontalGradient(listOf(Color(0xFF9C4DF4), NeonPink))
    } else {
        Brush.horizontalGradient(listOf(Color.Transparent, Color.Transparent))
    }
    
    val borderStroke = if (isSelected) null else androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(alpha = 0.1f))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(bgBrush)
            .then(if (borderStroke != null) Modifier.border(borderStroke, RoundedCornerShape(16.dp)) else Modifier)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Text(text, color = Color.White, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal)
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Botão Início
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0x881A1A1A))
                .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(24.dp))
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Star, contentDescription = null, tint = NeonPink)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Início", color = Color.White, fontWeight = FontWeight.Bold)
        }

        // Ícones à direita
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(0x88E07AF7))
                    .padding(8.dp)
            ) {
                Icon(Icons.Default.Visibility, contentDescription = null, tint = Color.White)
            }
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(0x881A1A1A))
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Folder, contentDescription = null, tint = NeonPink)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Arquivos", color = Color.White)
            }
        }
    }
}

@Composable
fun MainContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // CARD PRINCIPAL (Bem-vindo)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f) // Ocupa 60% do espaço vertical
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0xCC1A0B2E)) // Cor de fundo simulando a arte
                .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(24.dp))
                .padding(24.dp)
        ) {
            Column {
                Text("Bem-vindo de volta,", color = Color.White, fontSize = 20.sp)
                Text(
                    "Minecraft Java", 
                    color = Color.White, 
                    fontSize = 32.sp, 
                    fontWeight = FontWeight.Bold
                )
                Text("Sua nova jornada começa aqui!", color = TextGray, fontSize = 14.sp)
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Tags de versão
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Tag(text = "• 1.21.8 FABRIC 0.20.1", color = Color(0xFFE07AF7))
                    Tag(text = "• FABRIC", color = Color(0xFFE07AF7))
                }

                Spacer(modifier = Modifier.weight(1f))

                // Botão Jogar Agora
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.horizontalGradient(listOf(Color(0xFF9C4DF4), NeonPink)),
                                RoundedCornerShape(25.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.Black)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Jogar Agora", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        }
                    }
                }
            }
        }

        // CARD INFERIOR (Suas Versões e Conta)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Versões
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(0x881A1A1A))
                    .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(24.dp))
                    .padding(16.dp)
            ) {
                Column {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Suas versões", color = Color.White, fontWeight = FontWeight.Bold)
                        Text("Ver todas >", color = NeonPink, fontSize = 12.sp)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White.copy(alpha = 0.05f))
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.size(32.dp).background(Color.Gray, RoundedCornerShape(8.dp)))
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("1.21.8 Fabric 0....", color = Color.White, maxLines = 1, overflow = TextOverflow.Ellipsis)
                            Text("1.21.8 • Fabric", color = TextGray, fontSize = 12.sp)
                        }
                        Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.White)
                    }
                }
            }

            // Conta
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(0x881A1A1A))
                    .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(24.dp))
                    .padding(16.dp)
            ) {
                Column {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Conta", color = Color.White, fontWeight = FontWeight.Bold)
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .background(NeonPink)
                                .padding(horizontal = 12.dp, vertical = 4.dp)
                        ) {
                            Text("Skins", color = Color.White, fontSize = 12.sp)
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        // Avatar
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.Gray)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text("crnx_own", color = Color.White, fontWeight = FontWeight.Bold)
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(modifier = Modifier.size(8.dp).clip(CircleShape).background(Color.Green))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Conta offline", color = Color.Green, fontSize = 12.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RightPanel(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0x881A1A1A))
            .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(24.dp))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Versão do Minecraft", color = Color.White, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.Start))
        
        Spacer(modifier = Modifier.weight(0.3f))
        
        // Ícone da versão (simulado)
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color(0x33FFFFFF), RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))
        
        Text("1.21.8 Fabr...", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("1.21.8 • Fabric", color = TextGray, fontSize = 14.sp)
        
        Spacer(modifier = Modifier.weight(1f))

        // Botão Jogar
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(listOf(Color(0xFF9C4DF4), NeonPink)),
                        RoundedCornerShape(28.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.Black)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("JOGAR", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Botão Configurações
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0x33FFFFFF))
                .border(1.dp, Color.White.copy(alpha = 0.2f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Outlined.Settings, contentDescription = null, tint = Color.White)
        }
    }
}

@Composable
fun Tag(text: String, color: Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, color.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
            .background(color.copy(alpha = 0.1f))
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(text, color = color, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}