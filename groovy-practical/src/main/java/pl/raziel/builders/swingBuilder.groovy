package pl.raziel.builders

import groovy.swing.SwingBuilder

import javax.swing.WindowConstants as WC
import java.awt.BorderLayout as BL

new SwingBuilder().edt {
    frame(title: 'Hello Groovy!', visible: true, size: [200, 100], defaultCloseOperation: WC.EXIT_ON_CLOSE) {
        panel(layout: new BL()) {
            def txt = textField(constraints: BL.NORTH, 'Enter text here')
            def lab = label(constraints: BL.CENTER, 'Text')
            button(constraints: BL.SOUTH, 'Move Text', actionPerformed: {
                lab.text = txt.text
            })
            txt.actionPerformed = { lab.text = txt.text }
        }
    }
}