package com.apisw.swtrap

import org.eclipse.swt.SWT
import org.eclipse.swt.layout.FillLayout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Shell
import org.jfree.chart.JFreeChart
import org.jfree.chart.swt.ChartComposite

private fun addChart(chart: JFreeChart, parent: Composite) {
    ChartComposite(parent, SWT.NONE, chart, true)
}

fun main(args: Array<String>) {
    val display = Display()

    val shell = Shell(display).also {
        it.setSize(640, 480)
        it.layout = FillLayout()
        it.text = "Swtrap"
        MainView(it, ::addChart)
        it.forceActive()
        it.open()
    }

    while (!shell.isDisposed) {
        if (!display.readAndDispatch()) {
            display.sleep()
        }
    }
    display.dispose()
}
