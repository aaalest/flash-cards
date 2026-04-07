package io.github.aaalest.flashcards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import io.github.aaalest.flashcards.ui.theme.FlashCardsTheme
import io.github.aaalest.flashcards.components.FlashCardView
import io.github.aaalest.flashcards.utils.VisibilityController
import io.github.aaalest.flashcards.data.Flashcard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlashCardsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val flashCardVisibilityController = VisibilityController()

                    Box(Modifier.padding(innerPadding)) {
                        FlashCardView(
                            Flashcard("Ephemeral", "Lasting for a very short time."),
                            isFlipped = flashCardVisibilityController
                        )
                    }
                }
            }
        }
    }
}
