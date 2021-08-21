package com.apisw.swtrap

import org.eclipse.rap.rwt.application.AbstractEntryPoint
import org.eclipse.swt.widgets.Composite

class MainEntry : AbstractEntryPoint() {
    private lateinit var view: MainView

    override fun createContents(parent: Composite) {
        view = MainView(parent)
    }
}
