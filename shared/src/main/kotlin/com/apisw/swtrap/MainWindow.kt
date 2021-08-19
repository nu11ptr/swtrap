package com.apisw.swtrap

import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Shell

class MainWindow(parent: Composite? = null) {
    private val display = Display()

    private val shell = Shell(display).also {
        it.layout = GridLayout(1, false)
        it.text = "SWT Demo"
        it.setSize(300, 200)
        if (parent != null) it.parent = parent
    }

    init {
        Label(shell, SWT.NONE).also {
            it.text = "Hello World!"
            it.layoutData = GridData(
                SWT.CENTER, SWT.CENTER, true, true
            )
        }
    }

    fun display() {
        shell.open()
        shell.forceActive()

        while (!shell.isDisposed) {
            if (!display.readAndDispatch()) {
                display.sleep()
            }
        }
        display.dispose()
    }
}
