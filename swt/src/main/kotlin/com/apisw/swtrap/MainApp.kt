package com.apisw.swtrap

import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Shell

object MainApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val window = MainWindow()
        window.display()
    }
}
