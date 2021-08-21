package com.apisw.swtrap

import org.eclipse.jface.window.ApplicationWindow
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Shell

object MainApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val window = MainWindow()
        window.setBlockOnOpen(true)
        window.open()
        Display.getCurrent().dispose()
    }
}

class MainWindow() : ApplicationWindow(null) {
    private lateinit var view: MainView

    override fun createContents(parent: Composite): Control {
        //super.createContents(parent)
        view = MainView(parent)
        return parent
    }

    override fun configureShell(shell: Shell) {
        super.configureShell(shell)
        shell.text = "Swtrap"
        shell.shell.forceActive()
    }
}
