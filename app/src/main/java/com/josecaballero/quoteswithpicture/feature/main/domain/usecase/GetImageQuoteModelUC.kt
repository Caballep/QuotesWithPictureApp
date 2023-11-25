package com.josecaballero.quoteswithpicture.feature.main.domain.usecase

import com.josecaballero.quoteswithpicture.feature.main.domain.model.ImageQuoteModel
import javax.inject.Inject
import kotlin.random.Random

class GetImageQuoteModelUC @Inject constructor() {
    private lateinit var nextQuote: ImageQuoteModel
    suspend operator fun invoke(): ImageQuoteModel {
        // Always have an ImageQuoteModel object (nextQuote) in the cache
        if (!::nextQuote.isInitialized) {
            nextQuote = getNewImageQuoteModel()
        }
        val quote = nextQuote
        nextQuote = getNewImageQuoteModel()
        return quote
    }

    //TODO: All of the following code is just temporal.
    private fun getNewImageQuoteModel(): ImageQuoteModel {
        val randomIndex = Random.nextInt(temporalList.size)
        return temporalList[randomIndex]
    }

    private val temporalList = listOf(
        ImageQuoteModel(
            quote = "This is a temporal quote",
            imageUrl = "https://wallpapercave.com/wp/0eMcvL2.jpg",
            author = "Bojack Horseman"
        ),
        ImageQuoteModel(
            quote = "Heroes never die!",
            imageUrl = "https://images.template.net/97656/free-pretty-yellow-background-vpini.jpg",
            author = "Mercy"
        ),
        ImageQuoteModel(
            quote = "Send them to hell Artanis",
            imageUrl = "https://png.pngtree.com/background/20220714/original/pngtree-cute-pastel-background-aesthetic-picture-image_1603835.jpg",
            author = "Jim Raynor"
        ),
        ImageQuoteModel(
            quote = "What's up dock?",
            imageUrl = "https://images.rawpixel.com/image_800/czNmcy1wcml2YXRlL3Jhd3BpeGVsX2ltYWdlcy93ZWJzaXRlX2NvbnRlbnQvbHIvdjkzNS1hdW0tMDRfM18xLmpwZw.jpg",
            author = "Buggs Bunny"
        ),
        ImageQuoteModel(
            quote = "Holy Molly Guacamole",
            imageUrl = "https://images.unsplash.com/photo-1484542603127-984f4f7d14cb?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8MXx8fGVufDB8fHx8fA%3D%3D",
            author = "???"
        ),
        ImageQuoteModel(
            quote = "This is a very long long long quote, some words here and there, bla bla bla bla, taco",
            imageUrl = "https://e0.pxfuel.com/wallpapers/639/639/desktop-wallpaper-pretty-beach-background-for-your.jpg",
            author = "Who knows"
        ),
        ImageQuoteModel(
            quote = "When you make changes to the build configuration files in your project, Android Studio requires that you sync your project files so that it can import your build configuration changes and run some checks to make sure your configuration doesn't create build errors.",
            imageUrl = "https://media.istockphoto.com/id/1161394969/photo/autumn-background.webp?b=1&s=170667a&w=0&k=20&c=Niqpzd-ppa_eo5BHD34nWRo-FVEOXy5_O07fdtXDthc=",
            author = "Dev 123"
        ),
        ImageQuoteModel(
            quote = "Sync project with Gradle files",
            imageUrl = "https://getwallpapers.com/wallpaper/full/6/9/c/1097838-cool-pretty-background-pictures-2560x1440-for-mac.jpg",
            author = "Googli"
        ),
    )
}
