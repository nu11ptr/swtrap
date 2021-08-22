package com.apisw.swtrap

import org.eclipse.rap.rwt.application.AbstractEntryPoint
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.graphics.ImageData
import org.eclipse.swt.graphics.PaletteData
import org.eclipse.swt.graphics.RGB
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.jfree.chart.JFreeChart
import java.awt.geom.Rectangle2D
import java.awt.image.BufferedImage
import java.awt.image.DirectColorModel
import java.awt.image.IndexColorModel

// Copied from: https://git.eclipse.org/c/platform/eclipse.platform.swt.git/tree/examples/org.eclipse.swt.snippets/src/org/eclipse/swt/snippets/Snippet156.java
// Translated from Java to Kotlin
// Licensed under EPL 2.0
fun convertToSWT(bufferedImage: BufferedImage): ImageData? {
    if (bufferedImage.colorModel is DirectColorModel) {
        val colorModel = bufferedImage.colorModel as DirectColorModel
        val palette = PaletteData(colorModel.redMask, colorModel.greenMask, colorModel.blueMask)
        val data = ImageData(bufferedImage.width, bufferedImage.height, colorModel.pixelSize, palette)
        for (y in 0 until data.height) {
            for (x in 0 until data.width) {
                val rgb = bufferedImage.getRGB(x, y)
                val pixel: Int = palette.getPixel(RGB(rgb shr 16 and 0xFF, rgb shr 8 and 0xFF, rgb and 0xFF))
                data.setPixel(x, y, pixel)
                if (colorModel.hasAlpha()) {
                    data.setAlpha(x, y, rgb shr 24 and 0xFF)
                }
            }
        }
        return data
    } else if (bufferedImage.colorModel is IndexColorModel) {
        val colorModel = bufferedImage.colorModel as IndexColorModel
        val size = colorModel.mapSize
        val reds = ByteArray(size)
        val greens = ByteArray(size)
        val blues = ByteArray(size)
        colorModel.getReds(reds)
        colorModel.getGreens(greens)
        colorModel.getBlues(blues)
        val rgbs: Array<RGB?> = arrayOfNulls(size)
        for (i in rgbs.indices) {
            rgbs[i] = RGB(
                reds[i].toInt() and 0xFF,
                greens[i].toInt() and 0xFF,
                blues[i].toInt() and 0xFF
            )
        }
        val palette = PaletteData(*rgbs)
        val data = ImageData(bufferedImage.width, bufferedImage.height, colorModel.pixelSize, palette)
        data.transparentPixel = colorModel.transparentPixel
        val raster = bufferedImage.raster
        val pixelArray = IntArray(1)
        for (y in 0 until data.height) {
            for (x in 0 until data.width) {
                raster.getPixel(x, y, pixelArray)
                data.setPixel(x, y, pixelArray[0])
            }
        }
        return data
    }
    return null
}

private fun addChart(chart: JFreeChart, parent: Composite) {
    val size = parent.size
    val buffImage = BufferedImage(size.x, size.y, BufferedImage.TYPE_INT_ARGB)

    buffImage.createGraphics().also {
        chart.draw(it, Rectangle2D.Double(0.0, 0.0, size.x.toDouble(), size.y.toDouble()))
        it.dispose()
    }

    val data = convertToSWT(buffImage)
    val image = Image(parent.display, data)
    Label(parent, SWT.NONE).also {
        it.image = image
    }
}

class MainEntry : AbstractEntryPoint() {
    private lateinit var view: MainView

    override fun createContents(parent: Composite) {
        view = MainView(parent, ::addChart)
    }
}
