package com.apisw.swtrap

import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label

class MainView(parent: Composite) {
    init {
        parent.layout = GridLayout(1, false)
        Label(parent, SWT.NONE).also {
            it.text = "Hello World!"
            it.layoutData = GridData(
                SWT.CENTER, SWT.CENTER, true, true
            )
        }
    }
}
