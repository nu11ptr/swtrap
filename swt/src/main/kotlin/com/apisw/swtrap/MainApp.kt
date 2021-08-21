package com.apisw.swtrap

import org.eclipse.jface.window.ApplicationWindow
import org.eclipse.swt.widgets.*

class MainWindow() : ApplicationWindow(null) {
    private lateinit var view: MainView

    // We will attach our own layout
    override fun getLayout(): Layout? = null

    // Don't need a toolbar
    override fun addToolBar(style: Int) {}

    override fun createContents(parent: Composite): Control {
        view = MainView(parent)
        return parent
    }

    override fun configureShell(shell: Shell) {
        super.configureShell(shell)
        shell.text = "Swtrap"
        shell.shell.forceActive()
    }
}

fun main(args: Array<String>) {
    val window = MainWindow()
    window.setBlockOnOpen(true)
    window.open()
    Display.getCurrent().dispose()
}
