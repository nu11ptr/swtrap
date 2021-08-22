package com.apisw.swtrap

import org.eclipse.swt.widgets.Composite
import org.jfree.chart.ChartFactory
import org.jfree.chart.JFreeChart
import org.jfree.chart.plot.PiePlot
import org.jfree.data.general.DefaultPieDataset
import org.jfree.data.general.PieDataset
import java.awt.Font

private fun createDataset(): PieDataset {
    return DefaultPieDataset().also {
        it.setValue("One", 43.2)
        it.setValue("Two", 10.0)
        it.setValue("Three", 27.5)
        it.setValue("Four", 17.5)
        it.setValue("Five", 11.0)
        it.setValue("Six", 19.4)
    }
}

private fun createChart(dataset: PieDataset): JFreeChart {
    val chart = ChartFactory.createPieChart(
        "Pie Chart Demo 1",  // chart title
        dataset,  // data
        true,  // include legend
        true,
        false
    )

    val plot = chart.plot as PiePlot
    with(plot) {
        sectionOutlinesVisible = false
        labelFont = Font("SansSerif", Font.PLAIN, 12)
        noDataMessage = "No data available"
        isCircular = false
        labelGap = 0.02
    }
    return chart
}

class MainView(parent: Composite, func: (JFreeChart, Composite) -> Unit) {
    init {
        func(createChart(createDataset()), parent)
    }
}
