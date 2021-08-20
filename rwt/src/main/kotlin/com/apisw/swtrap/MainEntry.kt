package com.apisw.swtrap

import org.eclipse.rap.rwt.application.AbstractEntryPoint
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label

class MainEntry : AbstractEntryPoint() {
    override fun createContents(parent: Composite) {
        Label(parent, SWT.NONE).also {
            it.text = "Hello RAP World"
        }
    }
}
