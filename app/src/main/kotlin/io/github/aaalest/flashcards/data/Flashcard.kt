package io.github.aaalest.flashcards.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flashcards")
data class Flashcard(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val word: String,
    val definition: String,
)

val sampleCards = listOf(
    Flashcard(word = "Ephemeral", definition = "Lasting for a very short time."),
    Flashcard(word = "Mellifluous", definition = "Sweet and smooth sounding; pleasing to the ear."),
    Flashcard(word = "Ubiquitous", definition = "Present, appearing, or found everywhere.")
)
