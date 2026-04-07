package io.github.aaalest.flashcards.data

// data/Flashcard.kt
data class Flashcard(
    val word: String,
    val definition: String
)

// sampleData.kt (or keep it near the main composable for simplicity)
val sampleCards = listOf(
    Flashcard("Ephemeral", "Lasting for a very short time."),
    Flashcard("Mellifluous", "Sweet and smooth sounding; pleasing to the ear."),
    Flashcard("Ubiquitous", "Present, appearing, or found everywhere.")
)
