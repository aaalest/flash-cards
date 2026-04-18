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

import androidx.compose.foundation.clickable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import io.github.aaalest.flashcards.data.AppDatabase
import io.github.aaalest.flashcards.data.sampleCards
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = AppDatabase.getDatabase(applicationContext)
        val dao = db.flashcardDao()

        enableEdgeToEdge()
        setContent {
            FlashCardsTheme {
                val cards by dao.getAllFlashcards().collectAsState(initial = emptyList())
                val scope = rememberCoroutineScope()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val flashCardVisibilityController = VisibilityController()

                    Box(Modifier.padding(innerPadding)) {
                        if (cards.isNotEmpty()) {
                            FlashCardView(
                                cards.first(),
                                isFlipped = flashCardVisibilityController
                            )
                        } else {
                            Text(
                                "No cards. Tap to add sample data.",
                                modifier = Modifier.padding(16.dp).clickable {
                                    scope.launch {
                                        sampleCards.forEach { dao.upsertFlashcard(it) }
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
