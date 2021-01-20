package com.gifgroen.components

import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel


class ApplicationSettingsComponent {

    private var myMainPanel: JPanel? = null

    private var myUserNameText: JBTextField = JBTextField()

    private var myIdeaUserStatus: JBCheckBox = JBCheckBox("Do you use IntelliJ IDEA? ")

    init {
        val nameLabel = JBLabel("Enter user name: ")
        myMainPanel = FormBuilder.createFormBuilder()
            .addLabeledComponent(nameLabel, myUserNameText, 1, false)
            .addComponent(myIdeaUserStatus, 1)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    fun getPanel(): JPanel? {
        return myMainPanel
    }

    fun getPreferredFocusedComponent(): JComponent {
        return myUserNameText
    }

    fun getUserNameText(): String {
        return myUserNameText.text
    }

    fun setUserNameText(newText: String?) {
        myUserNameText.text = newText
    }

    fun getIdeaUserStatus(): Boolean {
        return myIdeaUserStatus.isSelected
    }

    fun setIdeaUserStatus(newStatus: Boolean) {
        myIdeaUserStatus.isSelected = newStatus
    }

}